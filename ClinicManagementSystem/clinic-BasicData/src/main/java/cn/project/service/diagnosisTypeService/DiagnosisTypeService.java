package cn.project.service.diagnosisTypeService;

import cn.project.entity.DiagnosisType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DiagnosisTypeService {
    List<DiagnosisType> getAllDiagnosisType();

    int addDiagnosisType(Integer prescriptionId, String diagnosisType);
}
