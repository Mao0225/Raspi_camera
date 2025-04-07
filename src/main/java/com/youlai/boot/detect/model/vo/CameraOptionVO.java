package com.youlai.boot.detect.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * 摄像头设备视图对象
 *
 * @author youlaitech
 * @since 2025-03-31 20:47
 */
@Getter
@Setter
@Schema( description = "摄像头设备视图对象")
public class CameraOptionVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "uuid唯一编码")
    private String CameraUuid;
    @Schema(description = "编号")
    private String deviceNumber;
}
