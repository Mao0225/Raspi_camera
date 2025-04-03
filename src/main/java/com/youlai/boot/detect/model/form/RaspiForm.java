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
 * 树莓派设备表单对象
 *
 * @author youlaitech
 * @since 2025-03-31 20:47
 */
@Getter
@Setter
@Schema(description = "树莓派设备表单对象")
public class RaspiForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;

    @Schema(description = "编号")
    @NotBlank(message = "编号不能为空")
    @Size(max=50, message="编号长度不能超过50个字符")
    private String serialNumber;

    @Schema(description = "所属部门id")
    @NotNull(message = "所属部门id不能为空")
    private Integer deptId;

    @Schema(description = "放置地点")
    @NotBlank(message = "放置地点不能为空")
    @Size(max=100, message="放置地点长度不能超过100个字符")
    private String location;

    @Schema(description = "上传间隔时间(秒)")
    @NotNull(message = "上传间隔时间(秒)不能为空")
    private Integer uploadInterval;

    @Schema(description = "报警词汇")
    @Size(max=65535, message="报警词汇长度不能超过65535个字符")
    private String alertKeywords;


}
