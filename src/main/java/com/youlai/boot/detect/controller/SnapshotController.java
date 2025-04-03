package com.youlai.boot.detect.controller;

import com.youlai.boot.detect.service.SnapshotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.detect.model.form.SnapshotForm;
import com.youlai.boot.detect.model.query.SnapshotQuery;
import com.youlai.boot.detect.model.vo.SnapshotVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.youlai.boot.common.result.PageResult;
import com.youlai.boot.common.result.Result;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

/**
 * 摄像头抓拍记录前端控制层
 *
 * @author Mao
 * @since 2025-04-01 17:17
 */
@Tag(name = "摄像头抓拍记录接口")
@RestController
@RequestMapping("/api/v1/snapshots")
@RequiredArgsConstructor
public class SnapshotController  {

    private final SnapshotService snapshotService;

    @Operation(summary = "摄像头抓拍记录分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('detect:snapshot:query')")
    public PageResult<SnapshotVO> getSnapshotPage(SnapshotQuery queryParams ) {
        IPage<SnapshotVO> result = snapshotService.getSnapshotPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增摄像头抓拍记录")
    @PostMapping("/saveSnapshot")
//    @PreAuthorize("@ss.hasPerm('detect:snapshot:add')")
    public Result<Void> saveSnapshot(@RequestBody @Valid SnapshotForm formData ) {
        boolean result = snapshotService.saveSnapshot(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取摄像头抓拍记录表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('detect:snapshot:edit')")
    public Result<SnapshotForm> getSnapshotForm(
        @Parameter(description = "摄像头抓拍记录ID") @PathVariable Long id
    ) {
        SnapshotForm formData = snapshotService.getSnapshotFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改摄像头抓拍记录")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('detect:snapshot:edit')")
    public Result<Void> updateSnapshot(
            @Parameter(description = "摄像头抓拍记录ID") @PathVariable Long id,
            @RequestBody @Validated SnapshotForm formData
    ) {
        boolean result = snapshotService.updateSnapshot(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除摄像头抓拍记录")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('detect:snapshot:delete')")
    public Result<Void> deleteSnapshots(
        @Parameter(description = "摄像头抓拍记录ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = snapshotService.deleteSnapshots(ids);
        return Result.judge(result);
    }
}
