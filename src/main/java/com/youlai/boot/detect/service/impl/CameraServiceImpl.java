package com.youlai.boot.detect.service.impl;

import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.youlai.boot.common.model.Option;
import com.youlai.boot.detect.service.RaspiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.detect.mapper.CameraMapper;
import com.youlai.boot.detect.service.CameraService;
import com.youlai.boot.detect.model.entity.Camera;
import com.youlai.boot.detect.model.form.CameraForm;
import com.youlai.boot.detect.model.query.CameraQuery;
import com.youlai.boot.detect.model.vo.CameraVO;
import com.youlai.boot.detect.converter.CameraConverter;

import java.util.Arrays;
import java.util.List;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import org.springframework.transaction.annotation.Transactional;

/**
 * 摄像头设备管理服务实现类
 *
 * @author Mao
 * @since 2025-04-01 15:43
 */
@Service
@RequiredArgsConstructor
public class CameraServiceImpl extends ServiceImpl<CameraMapper, Camera> implements CameraService {

    private final CameraConverter cameraConverter;
    private final RaspiService raspiService;

    /**
    * 获取摄像头设备管理分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<CameraVO>} 摄像头设备管理分页列表
    */
    @Override
    public IPage<CameraVO> getCameraPage(CameraQuery queryParams) {
        Page<CameraVO> pageVO = this.baseMapper.getCameraPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }

    /**
     * 获取摄像头设备下拉列表数据
     *
     * @return List<Option<Long>> value 为 camera_uuid
     */
    @Override
    public List<Option<String>> listCameraOptions() {
        // 查询数据
        List<Camera> cameraList = this.list(new LambdaQueryWrapper<Camera>().select(Camera::getCameraUuid, Camera::getDeviceNumber));

        // 实体转换
        return cameraConverter.toOptions(cameraList);
    }
    
    /**
     * 获取摄像头设备管理表单数据
     *
     * @param id 摄像头设备管理ID
     * @return
     */
    @Override
    public CameraForm getCameraFormData(Long id) {
        Camera entity = this.getById(id);
        return cameraConverter.toForm(entity);
    }
    
    /**
     * 新增摄像头设备管理
     *
     * @param formData 摄像头设备管理表单对象
     * @return
     */
    @Override
    @Transactional
    public boolean saveCamera(CameraForm formData) {
        // 2. 转换实体并设置关联信息
        Camera entity = cameraConverter.toEntity(formData);
        entity.setCameraUuid(UUID.randomUUID().toString()); // 生成摄像头UUID
        // 3. 保存到数据库
        return this.save(entity);
    }
    
    /**
     * 更新摄像头设备管理
     *
     * @param id   摄像头设备管理ID
     * @param formData 摄像头设备管理表单对象
     * @return
     */
    @Override
    public boolean updateCamera(Long id,CameraForm formData) {
        Camera entity = cameraConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除摄像头设备管理
     *
     * @param ids 摄像头设备管理ID，多个以英文逗号(,)分割
     * @return
     */
    @Override
    public boolean deleteCameras(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的摄像头设备管理数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

}
