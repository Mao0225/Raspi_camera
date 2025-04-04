package com.youlai.boot.detect.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.detect.mapper.SnapshotMapper;
import com.youlai.boot.detect.service.SnapshotService;
import com.youlai.boot.detect.model.entity.Snapshot;
import com.youlai.boot.detect.model.form.SnapshotForm;
import com.youlai.boot.detect.model.query.SnapshotQuery;
import com.youlai.boot.detect.model.vo.SnapshotVO;
import com.youlai.boot.detect.converter.SnapshotConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 摄像头抓拍记录服务实现类
 *
 * @author Mao
 * @since 2025-04-01 17:17
 */
@Service
@RequiredArgsConstructor
public class SnapshotServiceImpl extends ServiceImpl<SnapshotMapper, Snapshot> implements SnapshotService {

    private final SnapshotConverter snapshotConverter;

    /**
    * 获取摄像头抓拍记录分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<SnapshotVO>} 摄像头抓拍记录分页列表
    */
    @Override
    public IPage<SnapshotVO> getSnapshotPage(SnapshotQuery queryParams) {
        System.out.println("分页请求信息"+queryParams);

        Page<SnapshotVO> pageVO = this.baseMapper.getSnapshotPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        System.out.println("分页响应信息"+pageVO);
        return pageVO;
    }
    
    /**
     * 获取摄像头抓拍记录表单数据
     *
     * @param id 摄像头抓拍记录ID
     * @return
     */
    @Override
    public SnapshotForm getSnapshotFormData(Long id) {
        Snapshot entity = this.getById(id);
        return snapshotConverter.toForm(entity);
    }
    
    /**
     * 新增摄像头抓拍记录
     *
     * @param formData 摄像头抓拍记录表单对象
     * @return
     */
    @Override
    public boolean saveSnapshot(SnapshotForm formData) {
        Snapshot entity = snapshotConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新摄像头抓拍记录
     *
     * @param id   摄像头抓拍记录ID
     * @param formData 摄像头抓拍记录表单对象
     * @return
     */
    @Override
    public boolean updateSnapshot(Long id,SnapshotForm formData) {
        Snapshot entity = snapshotConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除摄像头抓拍记录
     *
     * @param ids 摄像头抓拍记录ID，多个以英文逗号(,)分割
     * @return
     */
    @Override
    public boolean deleteSnapshots(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的摄像头抓拍记录数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

}
