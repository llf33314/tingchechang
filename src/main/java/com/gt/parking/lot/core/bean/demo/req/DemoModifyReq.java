package com.gt.parking.lot.core.bean.demo.req;

import com.gt.parking.lot.common.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author psr
 *         Created by psr on 2018/1/24 0024.
 */
@ApiModel(value = "修改Demo")
public class DemoModifyReq extends PageReq {

    @ApiModelProperty(value = "demo的ID")
    @NotNull(message = "demo的ID不能为空")
    private Integer demoId;

    @ApiModelProperty(value = "demo名称")
    @NotNull(message = "demo名称不能为空")
    @Size(min = 2, max = 10, message = "长度需在2到10之间")
    private String demoName;

    @ApiModelProperty(value = "demo描述[选填]")
    private String demoRemark;

    public String getDemoName() {
        return demoName;
    }

    public void setDemoName(String demoName) {
        this.demoName = demoName;
    }

    public String getDemoRemark() {
        return demoRemark;
    }

    public void setDemoRemark(String demoRemark) {
        this.demoRemark = demoRemark;
    }

    public Integer getDemoId() {
        return demoId;
    }

    public void setDemoId(Integer demoId) {
        this.demoId = demoId;
    }
}
