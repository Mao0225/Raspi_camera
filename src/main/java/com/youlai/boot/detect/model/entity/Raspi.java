package com.youlai.boot.detect.model.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 树莓派设备实体对象
 *
 * @author youlaitech
 * @since 2025-03-31 20:47
 */
@Getter
@Setter
@TableName("detect_raspi")
public class Raspi extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String serialNumber;
    /**
     * 所属部门id
     */
    private Integer deptId;

    /**
     * 放置地点
     */
    private String location;
    /**
     * uuid唯一标识
     */
    private String raspiUuid;
    /**
     * 上传间隔时间(秒)
     */
    private Integer uploadInterval;
    /**
     * 报警词汇
     */
    private String alertKeywords;
    /**
     * 删除标记(0-未删除,1-已删除)
     */
    private Integer isDeleted;
}
