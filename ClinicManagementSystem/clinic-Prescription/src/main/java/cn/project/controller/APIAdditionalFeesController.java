package cn.project.controller;

import cn.project.entity.Prescription_AdditionalFees;
import cn.project.utils.HttpClientHelper;
import cn.project.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "负责调用附加费用控住器")
@RequestMapping("api")
public class APIAdditionalFeesController {
    @Resource
    HttpClientHelper httpClientHelper;

    @GetMapping("/getAdditionalFees")
    @ApiOperation(value = "负责调用基本数据模块中的附加费用控制器")
    public Response getAdditionalFees(){
        return httpClientHelper.get("http://localhost:8082/additionalFees/getAllAdditionalFees");
    }

    @GetMapping("/addAdditionalFees")
    @ApiOperation(value = "新增附加费用")
    public Response addAdditionalFees(Prescription_AdditionalFees prescription_additionalFees){
        Map<String,Object> map = new HashMap<>();
        map.put("prescriptionId",prescription_additionalFees.getPrescriptionId());
        map.put("additionfeesId",prescription_additionalFees.getAdditionfeesId());
        map.put("prescriptionTypeId",prescription_additionalFees.getPrescriptionTypeId());
        map.put("quantity",prescription_additionalFees.getQuantity());
        return null;//httpClientHelper.post("http://localhost:8082/additionalFees/addAdditionalFees",map);
    }
}
