package com.youlai.boot.detect.controller;

import com.youlai.boot.common.model.Option;
import com.youlai.boot.detect.service.CameraService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.detect.model.form.CameraForm;
import com.youlai.boot.detect.model.query.CameraQuery;
import com.youlai.boot.detect.model.vo.CameraPageVO;
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

import java.util.List;

/**
 * 摄像头设备管理前端控制层
 *
 * @author Mao
 * @since 2025-04-01 15:43
 */
@Slf4j
@Tag(name = "摄像头设备管理接口")
@RestController
@RequestMapping("/api/v1/cameras")
@RequiredArgsConstructor
public class CameraController  {

    private final CameraService cameraService;

    @Operation(summary = "摄像头设备管理分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('detect:camera:query')")
    public PageResult<CameraPageVO> getCameraPage(CameraQuery queryParams ) {
        IPage<CameraPageVO> result = cameraService.getCameraPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增摄像头设备管理")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('detect:camera:add')")
    public Result<Void> saveCamera(@RequestBody @Valid CameraForm formData ) {
        boolean result = cameraService.saveCamera(formData);
        return Result.judge(result);
    }

    @Operation(summary = "监控设备下拉列表")
    @GetMapping("/options")
    public Result<List<Option<String>>> listCameraOptions() {
        List<Option<String>> list = cameraService.listCameraOptions();
        return Result.success(list);
    }

    @Operation(summary = "获取摄像头设备管理表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('detect:camera:edit')")
    public Result<CameraForm> getCameraForm(
        @Parameter(description = "摄像头设备管理ID") @PathVariable Long id
    ) {
        CameraForm formData = cameraService.getCameraFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改摄像头设备管理")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('detect:camera:edit')")
    public Result<Void> updateCamera(
            @Parameter(description = "摄像头设备管理ID") @PathVariable Long id,
            @RequestBody @Validated CameraForm formData
    ) {
        boolean result = cameraService.updateCamera(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除摄像头设备管理")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('detect:camera:delete')")
    public Result<Void> deleteCameras(
        @Parameter(description = "摄像头设备管理ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = cameraService.deleteCameras(ids);
        return Result.judge(result);
    }
}
