package cn.project.service.additionalFeesService;

import cn.project.entity.AdditionalFees;
import cn.project.entity.Prescription_AdditionalFees;
import cn.project.mapper.additionalFees.AdditionalFeesMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@CacheConfig(cacheNames = "AdditionalFeesCache")
public class AdditionalFeesServiceImpl implements AdditionalFeesService {
    @Resource
    AdditionalFeesMapper additionalFeesMapper;

    @Override
    @Cacheable(keyGenerator = "mykeyGenerator")
    public List<AdditionalFees> getAllAdditionalFees() {
        return additionalFeesMapper.getAllAdditionalFees();
    }

    @Override
    public int addAdditionalFees(Prescription_AdditionalFees prescription_additionalFees) {
        return additionalFeesMapper.addAdditionalFees(prescription_additionalFees);
    }
}
