package com.youlai.boot.detect.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

/**
 * 摄像头设备管理表单对象
 *
 * @author Mao
 * @since 2025-04-01 15:43
 */
@Getter
@Setter
@Schema(description = "摄像头设备管理表单对象")
public class CameraForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    private Integer id;

    @Schema(description = "视频流地址")
    @Size(max=255, message="视频流地址长度不能超过255个字符")
    private String videoUrl;

    @Schema(description = "摄像头编号")
    @NotBlank(message = "摄像头编号不能为空")
    @Size(max=50, message="摄像头编号长度不能超过50个字符")
    private String deviceNumber;

    @Schema(description = "所属树莓派ID")
    @NotNull(message = "所属树莓派ID不能为空")
    private Integer raspberryPiId;

    @Schema(description = "放置地点")
    @NotBlank(message = "放置地点不能为空")
    @Size(max=100, message="放置地点长度不能超过100个字符")
    private String location;


}
