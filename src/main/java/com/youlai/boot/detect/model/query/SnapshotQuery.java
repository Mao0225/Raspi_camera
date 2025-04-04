package com.youlai.boot.detect.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 摄像头抓拍记录分页查询对象
 *
 * @author Mao
 * @since 2025-04-01 17:17
 */
@Schema(description ="摄像头抓拍记录查询对象")
@Getter
@Setter
public class SnapshotQuery extends BasePageQuery {


    @Schema(description = "抓取时间")
    private List<String> grabTime;
    @Schema(description="监控Uuid")
    private String cameraUuid;
    @Schema(description="识别目标集合")
    private String detectInfo;

}
