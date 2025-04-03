package com.youlai.boot.detect.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import org.checkerframework.common.aliasing.qual.Unique;

/**
 * 摄像头抓拍记录表单对象
 *
 * @author Mao
 * @since 2025-04-01 17:17
 */
@Getter
@Setter
@Schema(description = "摄像头抓拍记录表单对象")
public class SnapshotForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    private Long id;

    @Schema(description = "摄像头Uuid")
    private String cameraUuid;

    @Schema(description = "湿度")
    @Size(max=255, message="湿度长度不能超过255个字符")
    private String wet;

    @Schema(description = "温度")
    @Size(max=255, message="温度长度不能超过255个字符")
    private String tem;

    @Schema(description = "照片描述信息")
    @Size(max=500, message="照片描述信息长度不能超过500个字符")
    private String info;

    @Schema(description = "烟雾浓度")
    @Size(max=255, message="烟雾浓度长度不能超过255个字符")
    private String smoke;

    @Schema(description = "图片存储路径")
    @Size(max=255, message="图片存储路径长度不能超过255个字符")
    private String imagePath;

    @Schema(description = "抓取时间")
    @NotNull(message = "抓取时间不能为空")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime grabTime;

    @Schema(description = "识别出来的目标列表")
    @Size(max=65535, message="识别出来的目标列表长度不能超过65535个字符")
    private String detectInfo;


}
