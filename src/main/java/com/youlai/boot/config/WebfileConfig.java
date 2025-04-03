package com.youlai.boot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebfileConfig implements WebMvcConfigurer {

    @Value("${oss.local.storage-path}") // 从配置读取存储路径
    private String storagePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 映射物理存储路径到虚拟URL路径
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:" + storagePath + "/");

        // 如果还需要访问项目根目录下的uploads文件夹
        String projectUploads = System.getProperty("user.dir") + "/uploads/";
        registry.addResourceHandler("/project-uploads/**")
                .addResourceLocations("file:" + projectUploads);
    }
}