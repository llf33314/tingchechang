package com.gt.parking.lot.core.service.demo.impl;

import com.alibaba.fastjson.JSONObject;
import com.gt.parking.lot.common.dto.PageDTO;
import com.gt.parking.lot.common.dto.ResponseDTO;
import com.gt.parking.lot.core.bean.demo.req.*;
import com.gt.parking.lot.core.bean.demo.res.DemoListRes;
import com.gt.parking.lot.core.service.demo.DemoService;
import com.psr.tool.agile.AnalyticClass;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author psr
 *         Created by psr on 2018/1/24 0024.
 */
@Service
public class DemoServiceImpl implements DemoService {

    private static Logger logger = Logger.getLogger(DemoServiceImpl.class);

    /**
     * 新增demo
     *
     * @param demoAddReq
     */
    @Override
    public void addDemo(DemoAddReq demoAddReq) {
        logger.debug(JSONObject.toJSONString(demoAddReq));
    }

    /**
     * 删除demo
     *
     * @param demoDelReq
     */
    @Override
    public void delDemo(DemoDelReq demoDelReq) {
        logger.debug(JSONObject.toJSONString(demoDelReq));
    }

    /**
     * 编辑demo
     *
     * @param demoModifyReq
     */
    @Override
    public void modifyDemo(DemoModifyReq demoModifyReq) {
        logger.debug(JSONObject.toJSONString(demoModifyReq));
    }

    /**
     * 查询demo
     *
     * @param demoGetReq
     * @return
     */
    @Override
    public DemoListRes getDemo(DemoGetReq demoGetReq) {
        // 假数据生成类
        AnalyticClass<DemoListRes> analyticClass = new AnalyticClass<>();
        // 生成单条假数据
        DemoListRes demoListRes = analyticClass.build(DemoListRes.class);
        return demoListRes;
    }

    /**
     * 查询所有demo
     *
     * @param demoListReq
     * @return
     */
    @Override
    public List<DemoListRes> listAllDemo(DemoListReq demoListReq) {
        // 假数据生成类
        AnalyticClass<DemoListRes> analyticClass = new AnalyticClass<>();
        // 生成17条假数据
        List<DemoListRes> demoListResList = analyticClass.buildList(DemoListRes.class, 17);
        return demoListResList;
    }

    /**
     * 分页查询demo
     *
     * @param demoListReq
     * @return
     */
    @Override
    public ResponseDTO listDemoByPage(DemoListReq demoListReq) {
        // 假数据生成类
        AnalyticClass<DemoListRes> analyticClass = new AnalyticClass<>();
        // 生成10条假数据
        List<DemoListRes> demoListResList = analyticClass.buildList(DemoListRes.class, 10);
        // 分页数据类——共3页，共26条数据
        PageDTO pageDTO = new PageDTO(3, 30);
        return ResponseDTO.createBySuccessPage("分页查询demo成功", demoListResList, pageDTO);
    }
}
