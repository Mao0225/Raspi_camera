package com.youlai.boot.detect.converter;

import com.youlai.boot.common.model.Option;
import com.youlai.boot.detect.model.entity.Raspi;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.detect.model.entity.Camera;
import com.youlai.boot.detect.model.form.CameraForm;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

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

    @Mappings({
            @Mapping(target = "value", source = "cameraUuid"), // cameraUuid是String/UUID
            @Mapping(target = "label", source = "deviceNumber")
    })
    Option<String> toOption(Camera camera);

    List<Option<String>> toOptions(List<Camera> cameras);
}