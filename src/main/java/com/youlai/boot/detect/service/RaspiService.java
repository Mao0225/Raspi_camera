package com.youlai.boot.detect.service;

import com.youlai.boot.common.model.Option;
import com.youlai.boot.detect.model.entity.Raspi;
import com.youlai.boot.detect.model.form.RaspiForm;
import com.youlai.boot.detect.model.query.RaspiQuery;
import com.youlai.boot.detect.model.vo.RaspiVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 树莓派设备服务类
 *
 * @author youlaitech
 * @since 2025-03-31 20:47
 */
public interface RaspiService extends IService<Raspi> {

    /**
     *树莓派设备分页列表
     *
     * @return
     */
    IPage<RaspiVO> getRaspiPage(RaspiQuery queryParams);

    /**
     * 获取树莓派设备表单数据
     *
     * @param id 树莓派设备ID
     * @return
     */
     RaspiForm getRaspiFormData(Long id);

    /**
     * 新增树莓派设备
     *
     * @param formData 树莓派设备表单对象
     * @return
     */
    boolean saveRaspi(RaspiForm formData);

    /**
     * 修改树莓派设备
     *
     * @param id   树莓派设备ID
     * @param formData 树莓派设备表单对象
     * @return
     */
    boolean updateRaspi(Long id, RaspiForm formData);

    /**
     * 删除树莓派设备
     *
     * @param ids 树莓派设备ID，多个以英文逗号(,)分割
     * @return
     */
    boolean deleteRaspis(String ids);

    /**
     * 获取树莓派设备下拉列表
     *
     * @return
     */
    List<Option<Long>> listRaspiOptions();
}
