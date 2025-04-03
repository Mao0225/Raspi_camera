package com.youlai.boot.detect.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.common.annotation.DataPermission;
import com.youlai.boot.detect.model.entity.Raspi;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.detect.model.query.RaspiQuery;
import com.youlai.boot.detect.model.vo.RaspiVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 树莓派设备Mapper接口
 *
 * @author youlaitech
 * @since 2025-03-31 20:47
 */
@Mapper
public interface RaspiMapper extends BaseMapper<Raspi> {

    /**
     * 获取树莓派设备分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return
     */
    @DataPermission
    Page<RaspiVO> getRaspiPage(Page<RaspiVO> page, RaspiQuery queryParams);

}
