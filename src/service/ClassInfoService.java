package service;

import java.sql.SQLException;
import java.util.List;

import entity.ClassInfo;

public interface ClassInfoService {
	List<ClassInfo> findByClassId(String classId)throws SQLException;

}
