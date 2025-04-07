package com.youlai.boot.detect.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.common.annotation.DataPermission;
import com.youlai.boot.detect.model.entity.Camera;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.detect.model.query.CameraQuery;
import com.youlai.boot.detect.model.vo.CameraOptionVO;
import com.youlai.boot.detect.model.vo.CameraPageVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 摄像头设备管理Mapper接口
 *
 * @author Mao
 * @since 2025-04-01 15:43
 */
@Mapper
public interface CameraMapper extends BaseMapper<Camera> {

    /**
     * 获取摄像头设备管理分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return
     */
    @DataPermission(deptAlias = "r")
    Page<CameraPageVO> getCameraPage(Page<CameraPageVO> page, CameraQuery queryParams);
    @DataPermission(deptAlias = "r")
    List<CameraOptionVO> listCameraOptions();
}
