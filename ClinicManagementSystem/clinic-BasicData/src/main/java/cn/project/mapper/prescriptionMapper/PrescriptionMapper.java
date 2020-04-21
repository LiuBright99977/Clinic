package cn.project.mapper.prescriptionMapper;

import cn.project.entity.PrescriptionType;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface PrescriptionMapper {
    List<PrescriptionType> getAllPrescriptionType();
}
