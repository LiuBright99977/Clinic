package cn.project.controller;

import cn.project.utils.HttpClientHelper;
import cn.project.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(tags = "负责调用员工控住器")
@RequestMapping("api")
public class APIEmployeeController {
    @Resource
    HttpClientHelper httpClientHelper;

    @GetMapping("/getAllEmployee")
    @ApiOperation(value = "负责调用基本数据模块中的员工控制器(根据科室ID获取该科室下的员工)")
    @ApiImplicitParam(name = "id",value = "科室ID",required = true)
    public Response getAllEmployee(@RequestParam Integer id){
        return httpClientHelper.get("http://localhost:8082/employee/getAllEmployee?id="+id);
    }
}
