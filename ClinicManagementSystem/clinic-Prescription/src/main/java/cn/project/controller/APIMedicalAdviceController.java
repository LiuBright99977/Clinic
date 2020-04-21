package cn.project.controller;

import cn.project.utils.HttpClientHelper;
import cn.project.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(tags = "负责调用医嘱控制器")
@RequestMapping("api")
public class APIMedicalAdviceController {
    @Resource
    HttpClientHelper httpClientHelper;

    @GetMapping("getAllMedicalAdvice")
    @ApiOperation(value = "负责调用基础数据模块中的医嘱控制器(获取所有医嘱信息)")
    public Response getAllMedicalAdvice(){
        return httpClientHelper.get("http://localhost:8082/medicalAdvice/getAllMedicalAdvice");
    }

    @GetMapping("addMedicalAdvice")
    @ApiOperation(value = "负责调用基础数据模块中的医嘱控制器(新增医嘱)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "prescriptionId",value = "处方ID",required = true),
            @ApiImplicitParam(name = "medicalAdvice",value = "医嘱(多个医嘱ID)",required = true)
    })
    public Response addDiagnosis(@RequestParam Integer prescriptionId,@RequestParam String medicalAdvice){
        return httpClientHelper.get("http://localhost:8082/medicalAdvice/addMedicalAdvice?prescriptionId="+prescriptionId+"&medicalAdvice="+medicalAdvice);
    }
}
