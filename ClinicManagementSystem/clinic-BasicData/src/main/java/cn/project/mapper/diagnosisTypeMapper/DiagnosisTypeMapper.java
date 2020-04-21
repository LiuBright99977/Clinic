package cn.project.mapper.diagnosisTypeMapper;

import cn.project.entity.DiagnosisType;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface DiagnosisTypeMapper {
    List<DiagnosisType> getAllDiagnosisType();

    int addDiagnosisType(@Param("prescriptionId") Integer prescriptionId, @Param("diagnosisTypeId") Integer diagnosisTypeId);
}
