package cn.project.service.employeeService;

import cn.project.entity.Department;
import cn.project.entity.Employee;
import cn.project.mapper.employeeMapper.EmployeeMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee(Integer id) {
        return employeeMapper.getAllEmployee(id);
    }
}
