package service;

import java.sql.SQLException;
import java.util.List;

import entity.StudentInfo;

public interface StudentManageService {

//	Connection getConnection(String urlMysql);
	List<StudentInfo> findAll()throws SQLException;
	List<StudentInfo> findByName(String name)throws SQLException;
	List<StudentInfo> findBySex(String sex)throws SQLException;
//	List<StudentInfo> findByClass(String classNum);
	List<StudentInfo> findByDepartment(String department)throws SQLException;
	List<StudentInfo> findByBirthday(String birthday)throws SQLException;
	List<StudentInfo> findByNativePlace(String nativePlace)throws SQLException;
	List<StudentInfo> findByStudentId(String studentId);
	void addStudentInfo(StudentInfo studentInfo)throws SQLException;
	List<StudentInfo> findByClassNum(String classNum)throws SQLException;
	void deleteStudentInfoById(String studentId)throws SQLException;
	void updateStudentInfo(StudentInfo studentInfo)throws SQLException;
	void deleteAll() throws SQLException;
}
