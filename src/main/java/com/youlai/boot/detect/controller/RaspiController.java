package com.youlai.boot.detect.controller;

import com.youlai.boot.common.model.Option;
import com.youlai.boot.detect.service.RaspiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.detect.model.form.RaspiForm;
import com.youlai.boot.detect.model.query.RaspiQuery;
import com.youlai.boot.detect.model.vo.RaspiVO;
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
 * 树莓派设备前端控制层
 *
 * @author youlaitech
 * @since 2025-03-31 20:47
 */
@Tag(name = "树莓派设备接口")
@RestController
@RequestMapping("/api/v1/raspis")
@RequiredArgsConstructor
public class RaspiController  {

    private final RaspiService raspiService;

    @Operation(summary = "树莓派设备分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('detect:raspi:query')")
    public PageResult<RaspiVO> getRaspiPage(RaspiQuery queryParams ) {
        IPage<RaspiVO> result = raspiService.getRaspiPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "树莓派设备下拉列表")
    @GetMapping("/options")
    public Result<List<Option<Long>>> listRaspiOptions() {
        List<Option<Long>> list = raspiService.listRaspiOptions();
        return Result.success(list);
    }

    @Operation(summary = "新增树莓派设备")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('detect:raspi:add')")
    public Result<Void> saveRaspi(@RequestBody @Valid RaspiForm formData ) {
        boolean result = raspiService.saveRaspi(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取树莓派设备表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('detect:raspi:edit')")
    public Result<RaspiForm> getRaspiForm(
        @Parameter(description = "树莓派设备ID") @PathVariable Long id
    ) {
        RaspiForm formData = raspiService.getRaspiFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改树莓派设备")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('detect:raspi:edit')")
    public Result<Void> updateRaspi(
            @Parameter(description = "树莓派设备ID") @PathVariable Long id,
            @RequestBody @Validated RaspiForm formData
    ) {
        boolean result = raspiService.updateRaspi(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除树莓派设备")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('detect:raspi:delete')")
    public Result<Void> deleteRaspis(
        @Parameter(description = "树莓派设备ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = raspiService.deleteRaspis(ids);
        return Result.judge(result);
    }
}
