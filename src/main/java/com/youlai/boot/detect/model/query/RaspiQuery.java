package com.youlai.boot.detect.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 树莓派设备分页查询对象
 *
 * @author youlaitech
 * @since 2025-03-31 20:47
 */
@Schema(description ="树莓派设备查询对象")
@Getter
@Setter
public class RaspiQuery extends BasePageQuery {

}
