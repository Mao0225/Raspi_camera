package com.youlai.boot.detect.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 摄像头设备视图对象
 *
 * @author youlaitech
 * @since 2025-03-31 20:47
 */
@Getter
@Setter
@Schema( description = "视频预览视图对象")
public class VideoPreviewVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "摄像头设备编号")
    private String deviceNumber;
    @Schema(description = "视频流地址")
    private String videoUrl;
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
}
