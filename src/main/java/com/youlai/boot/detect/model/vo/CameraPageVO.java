package com.youlai.boot.detect.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 摄像头设备管理视图对象
 *
 * @author Mao
 * @since 2025-04-01 15:43
 */
@Getter
@Setter
@Schema( description = "摄像头设备管理视图对象")
public class CameraPageVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    private Integer id;
    @Schema(description = "视频流地址")
    private String videoUrl;
    @Schema(description = "摄像头编号")
    private String deviceNumber;
    @Schema(description = "所属树莓派编号")
    private String raspiNumber;
    @Schema(description = "所属树莓派ID")
    private Integer raspberryPiId;
    @Schema(description = "所属部门名称")
    private String deptName;
    @Schema(description = "放置地点")
    private String location;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
    @Schema(description = "删除标记(0:未删除 1:已删除)")
    private Integer isDeleted;
}
