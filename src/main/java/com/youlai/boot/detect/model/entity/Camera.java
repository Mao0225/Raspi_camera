package com.youlai.boot.detect.model.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 摄像头设备管理实体对象
 *
 * @author Mao
 * @since 2025-04-01 15:43
 */
@Getter
@Setter
@TableName("detect_camera")
public class Camera extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 视频流地址
     */
    private String videoUrl;
    /**
     * 摄像头编号
     */
    private String deviceNumber;
    /**
     * 摄像头UUID
     */
    private String cameraUuid;
    /**
     * 所属树莓派ID
     */
    private Integer raspberryPiId;
    /**
     * 放置地点
     */
    private String location;
    /**
     * 删除标记(0:未删除 1:已删除)
     */
    private Integer isDeleted;
}
