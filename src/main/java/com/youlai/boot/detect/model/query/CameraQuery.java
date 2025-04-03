package com.youlai.boot.detect.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 摄像头设备管理分页查询对象
 *
 * @author Mao
 * @since 2025-04-01 15:43
 */
@Schema(description ="摄像头设备管理查询对象")
@Getter
@Setter
public class CameraQuery extends BasePageQuery {

}
