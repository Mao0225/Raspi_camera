package com.youlai.boot.detect.service.impl;

import cn.hutool.core.lang.UUID;
import com.youlai.boot.common.exception.BusinessException;
import com.youlai.boot.common.model.Option;
import com.youlai.boot.detect.model.vo.RaspiOptionVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.detect.mapper.RaspiMapper;
import com.youlai.boot.detect.service.RaspiService;
import com.youlai.boot.detect.model.entity.Raspi;
import com.youlai.boot.detect.model.form.RaspiForm;
import com.youlai.boot.detect.model.query.RaspiQuery;
import com.youlai.boot.detect.model.vo.RaspiPageVO;
import com.youlai.boot.detect.converter.RaspiConverter;

import java.util.Arrays;
import java.util.List;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 树莓派设备服务实现类
 *
 * @author youlaitech
 * @since 2025-03-31 20:47
 */
@Service
@RequiredArgsConstructor
public class RaspiServiceImpl extends ServiceImpl<RaspiMapper, Raspi> implements RaspiService {

    private final RaspiConverter raspiConverter;

    /**
    * 获取树莓派设备分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage< RaspiPageVO >} 树莓派设备分页列表
    */
    @Override
    public IPage<RaspiPageVO> getRaspiPage(RaspiQuery queryParams) {
        Page<RaspiPageVO> pageVO = this.baseMapper.getRaspiPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }

    /**
     * 获取树莓派设备下拉列表数据
     *
     * @return List<Option<Long>> value 为 id
     */
    @Override
    public List<Option<Long>> listRaspiOptions() {
        // 查询数据
//        List<Raspi> raspiList = this.list(new LambdaQueryWrapper<Raspi>().select(Raspi::getId, Raspi::getSerialNumber));
            // 查询数据
        List<RaspiOptionVO> raspiList = this.baseMapper.listRaspiOptions();
        // 实体转换
        return raspiConverter.toOptions(raspiList);
    }

    /**
     * 获取树莓派设备表单数据
     *
     * @param id 树莓派设备ID
     * @return
     */
    @Override
    public RaspiForm getRaspiFormData(Long id) {
        Raspi entity = this.getById(id);
        return raspiConverter.toForm(entity);
    }
    
    /**
     * 新增树莓派设备
     *
     * @param formData 树莓派设备表单对象
     * @return
     */
//    @Override
//    public boolean saveRaspi(RaspiForm formData) {
//        Raspi entity = raspiConverter.toEntity(formData);
//        return this.save(entity);
//    }
    @Override
    public boolean saveRaspi(RaspiForm formData) {
        // 1. 唯一性校验（设备编号）
        boolean exists = lambdaQuery()
                .eq(Raspi::getSerialNumber, formData.getSerialNumber())
                .exists();
        if (exists) {
            throw new BusinessException("设备编号已存在");
        }

        // 2. 转换实体并生成UUID
        Raspi entity = raspiConverter.toEntity(formData);
        entity.setRaspiUuid(UUID.randomUUID().toString()); // 生成UUID并设置
        // 3. 保存到数据库
        return this.save(entity);
    }
    
    /**
     * 更新树莓派设备
     *
     * @param id   树莓派设备ID
     * @param formData 树莓派设备表单对象
     * @return
     */
    @Override
    public boolean updateRaspi(Long id, RaspiForm formData) {
//        // 1. 唯一性校验（排除当前记录）
//        boolean exists = lambdaQuery()
//                .eq(Raspi::getSerialNumber, formData.getSerialNumber())
//                .ne(Raspi::getId, id)  // 关键点：排除自身
//                .exists();
//
//        if (exists) {
//            throw new BusinessException("设备编号已存在");
//        }

        // 2. 转换并更新
        Raspi entity = raspiConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除树莓派设备
     *
     * @param ids 树莓派设备ID，多个以英文逗号(,)分割
     * @return
     */
    @Override
    public boolean deleteRaspis(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的树莓派设备数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

}
