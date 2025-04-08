package com.youlai.boot.detect.service;

import com.youlai.boot.common.model.Option;
import com.youlai.boot.detect.model.entity.Camera;
import com.youlai.boot.detect.model.form.CameraForm;
import com.youlai.boot.detect.model.query.CameraQuery;
import com.youlai.boot.detect.model.vo.CameraPageVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.boot.detect.model.vo.VideoPreviewVO;

import java.util.List;

/**
 * 摄像头设备管理服务类
 *
 * @author Mao
 * @since 2025-04-01 15:43
 */
public interface CameraService extends IService<Camera> {

    /**
     *摄像头设备管理分页列表
     *
     * @return
     */
    IPage<CameraPageVO> getCameraPage(CameraQuery queryParams);

    /**
     * 获取摄像头设备管理表单数据
     *
     * @param id 摄像头设备管理ID
     * @return
     */
     CameraForm getCameraFormData(Long id);

    /**
     * 新增摄像头设备管理
     *
     * @param formData 摄像头设备管理表单对象
     * @return
     */
    boolean saveCamera(CameraForm formData);

    /**
     * 修改摄像头设备管理
     *
     * @param id   摄像头设备管理ID
     * @param formData 摄像头设备管理表单对象
     * @return
     */
    boolean updateCamera(Long id, CameraForm formData);

    /**
     * 删除摄像头设备管理
     *
     * @param ids 摄像头设备管理ID，多个以英文逗号(,)分割
     * @return
     */
    boolean deleteCameras(String ids);
    /**
     * 视频预览及最新信息查看
     *
     * @param raspiId 树莓派id
     * @return
     */
    List<VideoPreviewVO> vedioPreviewList(Long raspiId);

    /**
     * 摄像头设备管理下拉列表
     *
     * @return
     */
    List<Option<String>> listCameraOptions();
}
