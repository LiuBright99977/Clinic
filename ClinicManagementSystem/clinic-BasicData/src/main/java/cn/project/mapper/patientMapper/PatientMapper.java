package cn.project.mapper.patientMapper;

import cn.project.entity.Patient;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
public interface PatientMapper {
    Patient getPatientById(Integer id);
    List<Patient> getAllPatient();
}
