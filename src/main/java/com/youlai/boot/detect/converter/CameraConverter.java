package com.youlai.boot.detect.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.detect.model.entity.Camera;
import com.youlai.boot.detect.model.form.CameraForm;

/**
 * 摄像头设备管理对象转换器
 *
 * @author Mao
 * @since 2025-04-01 15:43
 */
@Mapper(componentModel = "spring")
public interface CameraConverter{

    CameraForm toForm(Camera entity);

    Camera toEntity(CameraForm formData);
}