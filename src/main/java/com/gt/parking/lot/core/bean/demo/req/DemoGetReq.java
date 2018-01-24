package com.gt.parking.lot.core.bean.demo.req;

import com.gt.parking.lot.common.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author psr
 * Created by psr on 2018/1/24 0024.
 */
@ApiModel(value = "查询")
public class DemoGetReq {

    @ApiModelProperty(value = "demo名称")
    @NotNull(message = "demo名称不能为空")
    private String demoName;

    public String getDemoName() {
        return demoName;
    }

    public void setDemoName(String demoName) {
        this.demoName = demoName;
    }
}
