package cn.project.controller;

import cn.project.utils.HttpClientHelper;
import cn.project.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(tags = "负责调用患者控住器")
@RequestMapping("api")
public class APIPatientController {
    @Resource
    HttpClientHelper httpClientHelper;

    @GetMapping("/getPatientById")
    @ApiOperation(value = "负责调用基本数据模块中的患者控制器(根据ID查询患者信息)")
    @ApiImplicitParam(value = "患者ID",name = "id",required = true)
    public Response getPatientById(Integer id){
        return httpClientHelper.get("http://localhost:8082/patient/getPatientById?id="+id);
    }

    @GetMapping("/getAllPatient")
    @ApiOperation(value = "负责调用基本数据模块中的患者控制器(查询所有患者信息)")
    public Response getAllPatient(){
        return httpClientHelper.get("http://localhost:8082/patient/getAllPatient");
    }
}
