package com.youlai.boot.detect.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 摄像头抓拍记录视图对象
 *
 * @author Mao
 * @since 2025-04-01 17:17
 */
@Getter
@Setter
@Schema( description = "摄像头抓拍记录视图对象")
public class SnapshotVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    private Long id;
    @Schema(description = "摄像头设备编号")
    private String deviceNumber;
    @Schema(description = "部门名称")
    private String deptName;
    @Schema(description = "湿度")
    private String wet;
    @Schema(description = "温度")
    private String tem;
    @Schema(description = "照片描述信息")
    private String info;
    @Schema(description = "烟雾浓度")
    private String smoke;
    @Schema(description = "图片存储路径")
    private String imagePath;
    @Schema(description = "抓取时间")
    private LocalDateTime grabTime;
    @Schema(description = "识别出来的目标列表")
    private String detectInfo;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
    @Schema(description = "逻辑删除标记(0:未删除 1:已删除)")
    private Integer isDeleted;
}
