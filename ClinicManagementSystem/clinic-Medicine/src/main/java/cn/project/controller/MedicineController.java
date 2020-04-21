package cn.project.controller;

import cn.project.service.MedicineService;
import cn.project.utils.HttpClientHelper;
import cn.project.utils.Response;
import cn.project.utils.ResponseEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(tags = "药品控制器")
@RequestMapping("medicine")
public class MedicineController {
    @Resource
    MedicineService medicineService;

    @GetMapping("getMedicines")
    @ApiOperation(value = "获取所有药品", notes = "根据药品类型、药瓶名称/拼音来筛选药品并进行分页显示")
    public Response getMedicines(Integer prescriptionTypeId, Integer medicineTypeId, String nameOrPinYin, Integer pageNo, Integer pageSize) {
        return (prescriptionTypeId == 1 || prescriptionTypeId == 2) ? new Response(ResponseEnum.SUCCESS).setResponseBody(medicineService.getAllMedicine(prescriptionTypeId, medicineTypeId, nameOrPinYin, pageNo, pageSize)) :
                new Response(ResponseEnum.SUCCESS).setResponseBody(medicineService.getAllCheckItem(medicineTypeId, nameOrPinYin, pageNo, pageSize));
    }

    @GetMapping("/getMedicineType")
    @ApiOperation(value = "获取所有药品类型")
    public Response getMedicineType(Integer prescriptionTypeId) {
        return (prescriptionTypeId == 1 || prescriptionTypeId == 2) ? new Response(ResponseEnum.SUCCESS).setResponseBody(medicineService.getAllMedicineType())
                : new Response(ResponseEnum.SUCCESS).setResponseBody(medicineService.getAllCheckItemType());
    }
}
