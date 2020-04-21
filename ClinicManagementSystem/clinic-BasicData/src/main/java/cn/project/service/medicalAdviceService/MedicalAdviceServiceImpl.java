package cn.project.service.medicalAdviceService;

import cn.project.entity.MedicalAdvice;
import cn.project.mapper.medicalAdviceMapper.MedicalAdviceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@CacheConfig(cacheNames = "MedicalAdviceCache")
public class MedicalAdviceServiceImpl implements MedicalAdviceService {
    @Resource
    MedicalAdviceMapper medicalAdviceMapper;
    private static final Logger logger = LoggerFactory.getLogger(MedicalAdviceServiceImpl.class);

    @Override
    @Cacheable(keyGenerator = "mykeyGenerator")
    public List<MedicalAdvice> getAllMedicalAdvice() {
        logger.warn("缓存医嘱");
        return medicalAdviceMapper.getAllMedicalAdvice();
    }

    @Transactional
    @Override
    public int addMedicalAdvice(Integer prescriptionId, String medicalAdvice) {
        String[] str = medicalAdvice.split(",");
        for (int i = 0; i < str.length; i++) {
            medicalAdviceMapper.addMedicalAdvice(prescriptionId, Integer.parseInt(str[i]));
        }
        return 1;
    }
}
