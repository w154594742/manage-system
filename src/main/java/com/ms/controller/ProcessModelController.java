package com.ms.controller;

import com.ms.response.DataGridView;
import com.ms.response.ResultObj;
import com.ms.service.IWorkFlowService;
import com.ms.vo.WorkFlowVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 流程模型控制器
 */
@RestController
@RequestMapping("promodel")
public class ProcessModelController {
    @Autowired
    private IWorkFlowService workFlowService;
    /**
     * 加载模型信息
     */
    @RequestMapping("loadAllProcessModel")
    public DataGridView loadAllProcessDefinition(WorkFlowVo vo) {
        return workFlowService.queryProcessModel(vo);
    }
    /**
     * 删除模型
     */
    @RequestMapping("deleteProcessModel")
    public ResultObj deleteProcessModel(Integer id) {
        try {
            this.workFlowService.deleteProcessModelById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
    /**
     * 批量删除模型
     */
    @RequestMapping("batchdeleteProcessModel")
    public ResultObj batchdeleteProcessModel(WorkFlowVo vo) {
        try {
            for (Integer id : vo.getIds()) {
                this.deleteProcessModel(id);
            }
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}
