package cn.project.controller;

import cn.project.utils.HttpClientHelper;
import cn.project.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("api")
@Api(tags = "负责调用药品控制器")
public class APIMedicineController {
    @Resource
    HttpClientHelper httpClientHelper;

    @ApiOperation(value = "负责调用药品数据模块中的药品控制器(根据条件查询所有药品并分页)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "prescriptionTypeId", value = "处方类型ID(表示该药品属于(西药、中药、检查项目中的哪一种))", required = true),
            @ApiImplicitParam(paramType = "query", name = "medicineTypeId", value = "药品类型ID"),
            @ApiImplicitParam(paramType = "query", name = "nameOrPinYin", value = "药品名称或拼音"),
            @ApiImplicitParam(paramType = "query", name = "pageNo", value = "当前页", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页显示大小", required = true)
    })
    @GetMapping("getMedicine")
    public Response getMedicine(@RequestParam Integer prescriptionTypeId, @RequestParam(required = false) Integer medicineTypeId, @RequestParam(required = false) String nameOrPinYin, @RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "2") Integer pageSize) {
        StringBuffer buffer = new StringBuffer("?").append("pageNo=").append(pageNo).append("&pageSize=").append(pageSize);
        if (prescriptionTypeId != null) {
            buffer.append("&prescriptionTypeId=").append(prescriptionTypeId);
        }
        if (medicineTypeId != null) {
            buffer.append("&medicineTypeId=").append(medicineTypeId);
        }
        if (nameOrPinYin != null) {
            buffer.append("&nameOrPinYin=").append(nameOrPinYin);
        }
        return httpClientHelper.get("http://localhost:8083/medicine/getMedicines" + buffer);
    }

    @GetMapping("getAllMedicineType")
    @ApiOperation(value = "调用药品模块中的药品控制器(根据条件查询所有药品类型)")
    @ApiImplicitParam(name = "prescriptionTypeId", value = "处方类型ID(西药、中药、检查项目)", required = true)
    public Response getAllMedicineType(@RequestParam Integer prescriptionTypeId) {
        return httpClientHelper.get("http://localhost:8083/medicine/getMedicineType?prescriptionTypeId=" + prescriptionTypeId);

    }

}
