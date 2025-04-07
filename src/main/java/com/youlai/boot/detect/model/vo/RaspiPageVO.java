package com.youlai.boot.detect.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 树莓派设备视图对象
 *
 * @author youlaitech
 * @since 2025-03-31 20:47
 */
@Getter
@Setter
@Schema( description = "树莓派设备视图对象")
public class RaspiPageVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    @Schema(description = "编号")
    private String serialNumber;
    @Schema(description = "所属部门id")
    private Integer deptId;
    @Schema(description = "终端链接")
    private String terminalLink;
    @Schema(description = "桌面链接")
    private String desktopLink;
    @Schema(description = "用户名")
    private String username;
    @Schema(description = "密码")
    private String password;
    @Schema(description="部门名称")
    private String deptName;
    @Schema(description="UUID")
    private String raspiUuid;
    @Schema(description = "放置地点")
    private String location;
    @Schema(description = "上传间隔时间(秒)")
    private Integer uploadInterval;
    @Schema(description = "报警词汇")
    private String alertKeywords;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
    @Schema(description = "删除标记(0-未删除,1-已删除)")
    private Integer isDeleted;
}
