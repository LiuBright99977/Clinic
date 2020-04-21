package cn.project.mapper.employeeMapper;

import cn.project.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
public interface EmployeeMapper {
    List<Employee> getAllEmployee(@Param("id") Integer id);
}
