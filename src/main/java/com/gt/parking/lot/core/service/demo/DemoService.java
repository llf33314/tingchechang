package com.gt.parking.lot.core.service.demo;

import com.gt.parking.lot.common.dto.ResponseDTO;
import com.gt.parking.lot.core.bean.demo.req.*;
import com.gt.parking.lot.core.bean.demo.res.DemoListRes;

import java.util.List;

/**
 * @author psr
 *         Created by psr on 2018/1/24 0024.
 */
public interface DemoService {
    /**
     * 新增demo
     *
     * @param demoAddReq
     */
    void addDemo(DemoAddReq demoAddReq);

    /**
     * 删除demo
     *
     * @param demoDelReq
     */
    void delDemo(DemoDelReq demoDelReq);

    /**
     * 编辑demo
     *
     * @param demoModifyReq
     */
    void modifyDemo(DemoModifyReq demoModifyReq);

    /**
     * 查询demo
     * @param demoGetReq
     * @return
     */
    DemoListRes getDemo(DemoGetReq demoGetReq);

    /**
     * 查询所有demo
     *
     * @param demoListReq
     * @return
     */
    List<DemoListRes> listAllDemo(DemoListReq demoListReq);

    /**
     * 分页查询demo
     *
     * @param demoListReq
     * @return
     */
    ResponseDTO listDemoByPage(DemoListReq demoListReq);
}
