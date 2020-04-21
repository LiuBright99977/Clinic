package cn.project.service.diagnosisTypeService;

import cn.project.entity.DiagnosisType;
import cn.project.mapper.diagnosisTypeMapper.DiagnosisTypeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@CacheConfig(cacheNames = "DiagnosisTypeCache")
@Service
public class DiagnosisTypeServiceImpl implements DiagnosisTypeService {
    @Resource
    DiagnosisTypeMapper diagnosisTypeMapper;
    private static final Logger logger = LoggerFactory.getLogger(DiagnosisTypeServiceImpl.class);

    @Cacheable(keyGenerator = "mykeyGenerator")
    @Override
    public List<DiagnosisType> getAllDiagnosisType() {
        logger.warn("缓存诊断");
        return diagnosisTypeMapper.getAllDiagnosisType();
    }

    @Transactional
    @Override
    public int addDiagnosisType(Integer prescriptionId, String diagnosisType) {
        String[] str = diagnosisType.split(",");
        for (int i = 0; i < str.length; i++) {
            diagnosisTypeMapper.addDiagnosisType(prescriptionId, Integer.parseInt(str[i]));
        }
        return 1;
    }
}
