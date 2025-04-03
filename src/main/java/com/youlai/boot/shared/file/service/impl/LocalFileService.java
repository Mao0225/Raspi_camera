package com.youlai.boot.shared.file.service.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import com.youlai.boot.shared.file.model.FileInfo;
import com.youlai.boot.shared.file.service.FileService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;

/**
 * 本地存储服务类
 *
 * @author Theo
 * @since 2024-12-09 17:11
 */
@Data
@Slf4j
@Component
@ConditionalOnProperty(value = "oss.type", havingValue = "local")
@ConfigurationProperties(prefix = "oss.local")
@RequiredArgsConstructor
public class LocalFileService implements FileService {

    @Value("${oss.local.storage-path}")
    private String storagePath;
    /**
     * 上传文件方法
     *
     * @param file 表单文件对象
     * @return 文件信息
     */

    @Override
    @SneakyThrows
    public FileInfo uploadFile(MultipartFile file) {
        // 1. 确保存储目录存在（使用配置的storagePath）
        Path storageRoot = Paths.get(storagePath).toAbsolutePath().normalize();
        if (!Files.exists(storageRoot)) {
            Files.createDirectories(storageRoot);
        }

        // 2. 生成文件名和子目录（按日期分类）
        String originalFilename = file.getOriginalFilename();
        String suffix = FileUtil.getSuffix(originalFilename);
        String fileName = IdUtil.simpleUUID() + "." + suffix;
        String folder = DateUtil.format(LocalDateTime.now(), DatePattern.PURE_DATE_PATTERN);

        // 3. 构建完整存储路径
        Path targetDir = storageRoot.resolve(folder);
        Files.createDirectories(targetDir);
        Path targetPath = targetDir.resolve(fileName);

        // 4. 写入文件
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, targetPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            log.error("文件上传失败", e);
            throw new RuntimeException("文件上传失败");
        }

        // 5. 返回统一格式的URL（/uploads/日期/文件名）
        String fileUrl = "/uploads/" + folder + "/" + fileName;  // 固定使用斜杠，避免平台差异
        FileInfo fileInfo = new FileInfo();
        fileInfo.setName(originalFilename);
        fileInfo.setUrl(fileUrl);
        return fileInfo;
    }

    @Override
    public boolean deleteFile(String fileUrl) {
        if (fileUrl == null || !fileUrl.startsWith("/uploads/")) {
            return false;
        }

        // 移除URL前缀，得到相对路径
        String relativePath = fileUrl.substring("/uploads/".length());
        Path filePath = Paths.get(storagePath, relativePath).normalize();

        // 安全校验：防止路径穿越攻击
        if (!filePath.startsWith(Paths.get(storagePath))) {
            return false;
        }

        return FileUtil.del(filePath.toString());
    }
}
