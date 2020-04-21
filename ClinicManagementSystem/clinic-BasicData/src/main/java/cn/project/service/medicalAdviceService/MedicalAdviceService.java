package cn.project.service.medicalAdviceService;

import cn.project.entity.MedicalAdvice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MedicalAdviceService {
    List<MedicalAdvice> getAllMedicalAdvice();

    int addMedicalAdvice(Integer prescriptionId, String medicalAdvice);
}
