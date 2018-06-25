package service;

import java.sql.SQLException;
import java.util.List;

import entity.ClassChangeInfo;
import entity.PunishmentInfo;

public interface ChangeInfoService {
	
	List<ClassChangeInfo> findAll()throws SQLException;
	List<ClassChangeInfo> findByStudentId(String studentId)throws SQLException;
	List<ClassChangeInfo> findByCode(String code)throws SQLException;
//	List<StudentInfo> findByClass(String classNum);
	List<ClassChangeInfo> findByRecTime(String recTime)throws SQLException;
	List<ClassChangeInfo> findByDescription(String description)throws SQLException;
	List<ClassChangeInfo> findByClassChangeInfoId(String changeId)throws SQLException;
	void addClassChangeInfo(ClassChangeInfo changeInfo)throws SQLException;
	void deleteClassChangeInfoById(String changeId)throws SQLException;
	void updateClassChangeInfo(ClassChangeInfo classChangeInfo)throws SQLException;
	void deleteAll() throws SQLException;
}
