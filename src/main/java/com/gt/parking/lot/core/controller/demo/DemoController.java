package com.gt.parking.lot.core.controller.demo;

import com.alibaba.fastjson.JSONObject;
import com.gt.parking.lot.common.base.BaseController;
import com.gt.parking.lot.common.dto.ResponseDTO;
import com.gt.parking.lot.core.bean.demo.req.*;
import com.gt.parking.lot.core.bean.demo.res.DemoListRes;
import com.gt.parking.lot.core.exception.ParkingLotException;
import com.gt.parking.lot.core.service.demo.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author psr
 *         Created by psr on 2018/1/24 0024.
 */
@Api(value = "/app/demo", description = "项目配置Controller")
@RequestMapping(value = "/app/demo")
@RestController
public class DemoController extends BaseController {

    private static final Logger logger = Logger.getLogger(DemoController.class);

    @Autowired
    DemoService demoService;

    @ApiOperation(value = "新增demo")
    @RequestMapping(value = "/addDemo", method = RequestMethod.POST)
    public ResponseDTO addProject(@RequestBody @Valid DemoAddReq demoAddReq, BindingResult bindingResult) {
        // 数据校验
        InvalidParameter(bindingResult);
        try {
            logger.debug("addDemo --> " + JSONObject.toJSONString(demoAddReq));
            demoService.addDemo(demoAddReq);
            return ResponseDTO.createBySuccessMessage("新增demo成功");
        } catch (ParkingLotException e) {
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    @ApiOperation(value = "删除demo")
    @RequestMapping(value = "/delDemo", method = RequestMethod.POST)
    public ResponseDTO delDemo(@RequestBody @Valid DemoDelReq demoDelReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug("delDemo --> " + JSONObject.toJSONString(demoDelReq));
            demoService.delDemo(demoDelReq);
            return ResponseDTO.createBySuccessMessage("删除demo成功");
        } catch (ParkingLotException e) {
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    @ApiOperation(value = "编辑demo")
    @RequestMapping(value = "/modifyDemo", method = RequestMethod.POST)
    public ResponseDTO modifyDemo(@RequestBody @Valid DemoModifyReq demoModifyReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug("modifyDemo --> " + JSONObject.toJSONString(demoModifyReq));
            demoService.modifyDemo(demoModifyReq);
            return ResponseDTO.createBySuccessMessage("编辑demo成功");
        } catch (ParkingLotException e) {
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    @ApiOperation(value = "查询demo")
    @RequestMapping(value = "/getDemo", method = RequestMethod.POST)
    public ResponseDTO getDemo(@RequestBody @Valid DemoGetReq demoGetReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug("listAllDemo --> " + JSONObject.toJSONString(demoGetReq));
            DemoListRes demoListRes = demoService.getDemo(demoGetReq);
            return ResponseDTO.createBySuccess("查询demo成功", demoListRes);
        } catch (ParkingLotException e) {
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    @ApiOperation(value = "查询所有demo")
    @RequestMapping(value = "/listAllDemo", method = RequestMethod.POST)
    public ResponseDTO listAllDemo(@RequestBody @Valid DemoListReq demoListReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug("listAllDemo --> " + JSONObject.toJSONString(demoListReq));
            List<DemoListRes> demoListResList = demoService.listAllDemo(demoListReq);
            return ResponseDTO.createBySuccess("查询所有demo成功", demoListResList);
        } catch (ParkingLotException e) {
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    @ApiOperation(value = "分页查询demoByPage")
    @RequestMapping(value = "/listDemoByPage", method = RequestMethod.POST)
    public ResponseDTO listDemoByPage(@RequestBody @Valid DemoListReq demoListReq, BindingResult bindingResult) {
        InvalidParameter(bindingResult);
        try {
            logger.debug("listDemoByPage --> " + JSONObject.toJSONString(demoListReq));
            ResponseDTO responseDTO = demoService.listDemoByPage(demoListReq);
            return responseDTO;
        } catch (ParkingLotException e) {
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

}
