package cn.project.service;

import cn.project.entity.CheckItem;
import cn.project.entity.CheckItemType;
import cn.project.entity.Medicine;
import cn.project.entity.MedicineType;
import cn.project.mapper.MedicineMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@CacheConfig(cacheNames = "MedicineCache")
public class MedicineServiceImpl implements MedicineService {
    @Resource
    MedicineMapper medicineMapper;

    @Override
    @Cacheable(keyGenerator = "mykeyGenerator")
    public List<MedicineType> getAllMedicineType() {
        return medicineMapper.getAllMedicineType();
    }

    @Override
    @Cacheable(keyGenerator = "mykeyGenerator")
    public List<CheckItemType> getAllCheckItemType() {
        return medicineMapper.getAllCheckItemType();
    }

    @Override
    @Cacheable(keyGenerator = "mykeyGenerator")
    public PageInfo<Medicine> getAllMedicine(Integer prescriptionTypeId, Integer medicineTypeId, String nameOrPinYin, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Medicine> list = medicineMapper.getAllMedicine(prescriptionTypeId, medicineTypeId, nameOrPinYin, pageNo, pageSize);
        PageInfo<Medicine> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    @Cacheable(keyGenerator = "mykeyGenerator")
    public PageInfo<CheckItem> getAllCheckItem(Integer itemTypeId, String nameOrPinYin, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        //这个pageNo,pageSize传过去只是用到缓存的key中并没有做查询
        List<CheckItem> list = medicineMapper.getAllCheckItem(itemTypeId, nameOrPinYin, pageNo, pageSize);
        PageInfo<CheckItem> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
