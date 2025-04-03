package com.youlai.boot.detect.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.detect.model.entity.Snapshot;
import com.youlai.boot.detect.model.form.SnapshotForm;

/**
 * 摄像头抓拍记录对象转换器
 *
 * @author Mao
 * @since 2025-04-01 17:17
 */
@Mapper(componentModel = "spring")
public interface SnapshotConverter{

    SnapshotForm toForm(Snapshot entity);

    Snapshot toEntity(SnapshotForm formData);
}