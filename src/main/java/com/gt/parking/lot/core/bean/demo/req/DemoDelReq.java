package com.gt.parking.lot.core.bean.demo.req;

import com.gt.parking.lot.common.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author psr
 * Created by psr on 2018/1/24 0024.
 */
@ApiModel(value = "删除Demo")
public class DemoDelReq {

    @ApiModelProperty(value = "demo的Id")
    @NotNull(message = "demo的ID不能为空")
    private String demoId;

    public String getDemoId() {
        return demoId;
    }

    public void setDemoId(String demoId) {
        this.demoId = demoId;
    }
}
