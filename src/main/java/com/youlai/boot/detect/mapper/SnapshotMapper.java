package com.youlai.boot.detect.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.common.annotation.DataPermission;
import com.youlai.boot.detect.model.entity.Snapshot;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.detect.model.query.SnapshotQuery;
import com.youlai.boot.detect.model.vo.SnapshotVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 摄像头抓拍记录Mapper接口
 *
 * @author Mao
 * @since 2025-04-01 17:17
 */
@Mapper
public interface SnapshotMapper extends BaseMapper<Snapshot> {

    /**
     * 获取摄像头抓拍记录分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return
     */
    @DataPermission(deptAlias = "r")
    Page<SnapshotVO> getSnapshotPage(Page<SnapshotVO> page, SnapshotQuery queryParams);

}
