package cn.project.service.prescriptionService;

import cn.project.entity.PrescriptionType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrescriptionService {
    List<PrescriptionType> getAllPrescriptionType();
}
