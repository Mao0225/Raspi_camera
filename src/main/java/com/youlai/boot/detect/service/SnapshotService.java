package com.youlai.boot.detect.service;

import com.youlai.boot.detect.model.entity.Snapshot;
import com.youlai.boot.detect.model.form.SnapshotForm;
import com.youlai.boot.detect.model.query.SnapshotQuery;
import com.youlai.boot.detect.model.vo.SnapshotVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 摄像头抓拍记录服务类
 *
 * @author Mao
 * @since 2025-04-01 17:17
 */
public interface SnapshotService extends IService<Snapshot> {

    /**
     *摄像头抓拍记录分页列表
     *
     * @return
     */
    IPage<SnapshotVO> getSnapshotPage(SnapshotQuery queryParams);

    /**
     * 获取摄像头抓拍记录表单数据
     *
     * @param id 摄像头抓拍记录ID
     * @return
     */
     SnapshotForm getSnapshotFormData(Long id);

    /**
     * 新增摄像头抓拍记录
     *
     * @param formData 摄像头抓拍记录表单对象
     * @return
     */
    boolean saveSnapshot(SnapshotForm formData);

    /**
     * 修改摄像头抓拍记录
     *
     * @param id   摄像头抓拍记录ID
     * @param formData 摄像头抓拍记录表单对象
     * @return
     */
    boolean updateSnapshot(Long id, SnapshotForm formData);

    /**
     * 删除摄像头抓拍记录
     *
     * @param ids 摄像头抓拍记录ID，多个以英文逗号(,)分割
     * @return
     */
    boolean deleteSnapshots(String ids);

}
