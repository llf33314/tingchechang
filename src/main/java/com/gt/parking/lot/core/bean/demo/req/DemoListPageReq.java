package com.gt.parking.lot.core.bean.demo.req;

import com.gt.parking.lot.common.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author psr
 * Created by psr on 2018/1/24 0024.
 */
@ApiModel(value = "分页查询")
public class DemoListPageReq extends PageReq {

    @ApiModelProperty(value = "demo名称[选填]")
    private String demoName;

    public String getDemoName() {
        return demoName;
    }

    public void setDemoName(String demoName) {
        this.demoName = demoName;
    }
}
