package com.youlai.boot.detect.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 摄像头抓拍记录实体对象
 *
 * @author Mao
 * @since 2025-04-01 17:17
 */
@Getter
@Setter
@TableName("detect_snapshot")
public class Snapshot extends BaseEntity {

    private static final long serialVersionUID = 1L;


    /**
     * 摄像头UUID
     */
    private String cameraUuid;
    /**
     * 湿度
     */
    private String wet;
    /**
     * 温度
     */
    private String tem;
    /**
     * 照片描述信息
     */
    private String info;
    /**
     * 烟雾浓度
     */
    private String smoke;
    /**
     * 图片存储路径
     */
    private String imagePath;
    /**
     * 抓取时间
     */
    private LocalDateTime grabTime;
    /**
     * 识别出来的目标列表
     */
    private String detectInfo;
    /**
     * 逻辑删除标记(0:未删除 1:已删除)
     */
    private Integer isDeleted;
}
