package service;

import java.sql.SQLException;
import java.util.List;

import entity.DepartmentInfo;

public interface DepartmentInfoService {
	
	List<DepartmentInfo> findBYDepartmentId(String departmentId)throws SQLException;

}
