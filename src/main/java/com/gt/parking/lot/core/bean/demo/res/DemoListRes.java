package com.gt.parking.lot.core.bean.demo.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author psr
 *         Created by psr on 2018/1/24 0024.
 */
@ApiModel(value = "分页获取demo")
public class DemoListRes {

    @ApiModelProperty(value = "demo的ID")
    private Integer demoId;

    @ApiModelProperty(value = "demo名称")
    private String demoName;

    @ApiModelProperty(value = "demo描述")
    private String demoRemark;

    public Integer getDemoId() {
        return demoId;
    }

    public void setDemoId(Integer demoId) {
        this.demoId = demoId;
    }

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
}
