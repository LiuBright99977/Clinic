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
@Api(tags = "负责调用模板接口")
@RequestMapping("/api")
public class APITemplateController {
    @Resource
    HttpClientHelper httpClientHelper;

    @ApiOperation(value = "负责调用基本数据模块中的模板控制器(根据条件查询所有模板并分页)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "prescriptionTypeId", value = "处方类型ID(表示该药品属于(西药、中药、检查项目中的哪一种))"),
            @ApiImplicitParam(paramType = "query", name = "templatePermission", value = "模板权限(0:私有,1:公有)"),
            @ApiImplicitParam(paramType = "query", name = "templateNoOrName", value = "模板编号或名称"),
            @ApiImplicitParam(paramType = "query", name = "pageNo", value = "当前页", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页显示大小", required = true)
    })
    @GetMapping("/getAllTemplate")
    public Response getAllTemplate(@RequestParam(required = false) Integer prescriptionTypeId, @RequestParam(required = false) Integer templatePermission, @RequestParam(required = false) String templateNoOrName, @RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "3") Integer pageSize) {
        StringBuffer buffer = new StringBuffer("?").append("pageNo=").append(pageNo).append("&pageSize=").append(pageSize);
        if (prescriptionTypeId != null) {
            buffer.append("&prescriptionTypeId=").append(prescriptionTypeId);
        }
        if (templatePermission != null) {
            buffer.append("&templatePermission=").append(templatePermission);
        }
        if (templateNoOrName != null) {
            buffer.append("&templateNoOrName=").append(templateNoOrName);
        }
        return httpClientHelper.get("http://localhost:8082/template/getAllTemplate" + buffer);
    }

    @GetMapping("/getTemplateDetails")
    @ApiOperation(value = "负责调用基本数据模块中的模板控制器(根据模板ID获取模板下的处方详情)")
    @ApiImplicitParam(paramType = "query", value = "模板ID", name = "id", required = true)
    public Response getTemplateDetails(@RequestParam Integer id) {
        return httpClientHelper.get("http://localhost:8082/template/" + id);
    }

}
