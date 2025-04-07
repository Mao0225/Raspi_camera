package com.youlai.boot.detect.converter;

import com.youlai.boot.common.model.Option;
import com.youlai.boot.detect.model.vo.RaspiOptionVO;
import org.mapstruct.Mapper;
import com.youlai.boot.detect.model.entity.Raspi;
import com.youlai.boot.detect.model.form.RaspiForm;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * 树莓派设备对象转换器
 *
 * @author youlaitech
 * @since 2025-03-31 20:47
 */
@Mapper(componentModel = "spring")
public interface RaspiConverter{

    RaspiForm toForm(Raspi entity);

    Raspi toEntity(RaspiForm formData);

    @Mappings({
            @Mapping(target = "value", source = "id"),
            @Mapping(target = "label", source = "serialNumber")
    })
    Option<Long> toOption(RaspiOptionVO raspis);

    List<Option<Long>> toOptions(List<RaspiOptionVO> raspis);
}