package serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.ClassChangeInfo;
import entity.PunishmentInfo;
import entity.StudentInfo;
import resultException.StudentManageExceptionEnums;
import resultException.StudentResultException;
import service.ChangeInfoService;
import service.ChangeLevelsService;
import service.StudentManageService;

public class ChangeInfoServiceImpl implements ChangeInfoService {

	private StudentManageService studentManageService = new StudentManageServiceImpl();
	private ChangeLevelsService changeLevelsService = new ChangeLevelsServiceImpl();
	
	@Override
	public List<ClassChangeInfo> findAll() throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		String sql = "select * from change_info";
		List<ClassChangeInfo> classChangeInfoList = new ArrayList<ClassChangeInfo>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			connection = StudentManageServiceImpl.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				ClassChangeInfo classChangeInfo = new ClassChangeInfo();
				classChangeInfo.setId(resultSet.getString("id"));
				classChangeInfo.setStudentId(resultSet.getString("student_id"));
				classChangeInfo.setChangeCode(resultSet.getString("change_code"));
				classChangeInfo.setDescription(resultSet.getString("description"));
				classChangeInfo.setRec_time(resultSet.getDate("rec_time"));
				classChangeInfoList.add(classChangeInfo);
			}
		}catch(Exception e)
		{
			if(classChangeInfoList.size() == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.QUERY_ERROR);
			}
		}
		return classChangeInfoList;
	}

	@Override
	public List<ClassChangeInfo> findByStudentId(String studentId) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		String sql =String.format("select * from change_info where student_id = '%s'", studentId);
		List<ClassChangeInfo> classChangeInfoList = new ArrayList<ClassChangeInfo>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			connection = StudentManageServiceImpl.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				ClassChangeInfo classChangeInfo = new ClassChangeInfo();
				classChangeInfo.setId(resultSet.getString("id"));
				classChangeInfo.setStudentId(resultSet.getString("student_id"));
				classChangeInfo.setChangeCode(resultSet.getString("change_code"));
				classChangeInfo.setRec_time(resultSet.getDate("rec_time"));
				classChangeInfo.setDescription(resultSet.getString("description"));
				classChangeInfoList.add(classChangeInfo);
			}
		}catch(Exception e)
		{
			if(classChangeInfoList.size() == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.QUERY_ERROR);
			}
		}
		return classChangeInfoList;
	}

	@Override
	public List<ClassChangeInfo> findByCode(String code) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		String sql = String.format("select * from change_info where change_code = '%s'", code);
		List<ClassChangeInfo> classChangeInfoList = new ArrayList<ClassChangeInfo>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			connection = StudentManageServiceImpl.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				ClassChangeInfo classChangeInfo = new ClassChangeInfo();
				classChangeInfo.setId(resultSet.getString("id"));
				classChangeInfo.setStudentId(resultSet.getString("student_id"));
				classChangeInfo.setChangeCode(resultSet.getString("change_code"));
				classChangeInfo.setRec_time(resultSet.getDate("rec_time"));
				classChangeInfo.setDescription(resultSet.getString("description"));
				classChangeInfoList.add(classChangeInfo);
			}
		}catch(Exception e)
		{
			if(classChangeInfoList.size() == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.QUERY_ERROR);
			}
		}
		return classChangeInfoList;
	}

	@Override
	public List<ClassChangeInfo> findByRecTime(String recTime) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		String sql = String.format("select * from change_info where rectime = '%s'", recTime);
		List<ClassChangeInfo> classChangeInfoList = new ArrayList<ClassChangeInfo>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			connection = StudentManageServiceImpl.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				ClassChangeInfo classChangeInfo = new ClassChangeInfo();
				classChangeInfo.setId(resultSet.getString("id"));
				classChangeInfo.setStudentId(resultSet.getString("student_id"));
				classChangeInfo.setChangeCode(resultSet.getString("change_code"));
				classChangeInfo.setRec_time(resultSet.getDate("rec_time"));
				classChangeInfo.setDescription(resultSet.getString("description"));
				classChangeInfoList.add(classChangeInfo);
			}
		}catch(Exception e)
		{
			if(classChangeInfoList.size() == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.QUERY_ERROR);
			}
		}
		return classChangeInfoList;
	}

	
	@Override
	public List<ClassChangeInfo> findByDescription(String description) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		String sql = String.format("select * from change_info where description = '%s'", description);
		List<ClassChangeInfo> classChangeInfoList = new ArrayList<ClassChangeInfo>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			connection = StudentManageServiceImpl.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				ClassChangeInfo classChangeInfo = new ClassChangeInfo();
				classChangeInfo.setId(resultSet.getString("id"));
				classChangeInfo.setStudentId(resultSet.getString("student_id"));
				classChangeInfo.setChangeCode(resultSet.getString("change_code"));
				classChangeInfo.setRec_time(resultSet.getDate("rec_time"));
				classChangeInfo.setDescription(resultSet.getString("description"));
				classChangeInfoList.add(classChangeInfo);
			}
		}catch(Exception e)
		{
			if(classChangeInfoList.size() == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.QUERY_ERROR);
			}
		}
		return classChangeInfoList;
	}

	@Override
	public List<ClassChangeInfo> findByClassChangeInfoId(String changeId) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		String sql = String.format("select * from change_info where id = '%s'", changeId);
		List<ClassChangeInfo> classChangeInfoList = new ArrayList<ClassChangeInfo>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			connection = StudentManageServiceImpl.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				ClassChangeInfo classChangeInfo = new ClassChangeInfo();
				classChangeInfo.setId(resultSet.getString("id"));
				classChangeInfo.setStudentId(resultSet.getString("student_id"));
				classChangeInfo.setChangeCode(resultSet.getString("change_code"));
				classChangeInfo.setRec_time(resultSet.getDate("rec_time"));
				classChangeInfo.setDescription(resultSet.getString("description"));
				classChangeInfoList.add(classChangeInfo);
			}
		}catch(Exception e)
		{
			if(classChangeInfoList.size() == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.QUERY_ERROR);
			}
		}
		return classChangeInfoList;
	}

	@Override
	public void addClassChangeInfo(ClassChangeInfo changeInfo) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=StudentManageServiceImpl.getConnection();
		List<StudentInfo> studentInfoList = new ArrayList<>();
		studentInfoList = studentManageService.findByStudentId(changeInfo.getStudentId());
		changeLevelsService.findByChangeCodeId(Integer.valueOf(changeInfo.getChangeCode()));
		
		
		String sql=String.format("insert into change_info(student_id,change_code,description) values('%s','%s','%s')",
					changeInfo.getStudentId(),
					changeInfo.getChangeCode(),
					changeInfo.getDescription());
		
		PreparedStatement preparedStatement=null;
		int result=0;
		try{
			connection.setAutoCommit(false);
			preparedStatement=connection.prepareStatement(sql);
			result=preparedStatement.executeUpdate();
		}catch(Exception e) 
		{
			if(result==0)
			{
				connection.rollback();
				throw new StudentResultException(StudentManageExceptionEnums.INSERT_ERROR);
			}
		}
		connection.commit();
	}

	@Override
	public void deleteClassChangeInfoById(String changeId) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=StudentManageServiceImpl.getConnection();
		PreparedStatement preparedStatement=null;
		String sql = String.format("delete from change_info where id='%s'", changeId);
		int result=0;
		try{
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sql);
			result=preparedStatement.executeUpdate();
		}catch(Exception e)
		{
			if(result==0)
			{
				connection.rollback();
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.DELETE_STUDENTINFO_ERROR);
				
			}
		}
		connection.commit();
		connection.close();
	}

	@Override
	public void updateClassChangeInfo(ClassChangeInfo classChangeInfo) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=StudentManageServiceImpl.getConnection();
		PreparedStatement preparedStatement=null;
//		String selectSql=String.format("select * from student_info where student_id='%s'", args)
		String sql = String.format("delete from change_info where id='%s'", classChangeInfo.getId());
		String insertSql=String.format("insert into change_info(student_id,change_code,description) values('%s','%s','%s')",
				classChangeInfo.getStudentId(),
				classChangeInfo.getChangeCode(),
				classChangeInfo.getDescription());
		
//		ResultSet resultSet=null;
		
		int result=0;
		try{
			connection.setAutoCommit(false);
			List<ClassChangeInfo> classChangeInfoList=findByClassChangeInfoId(classChangeInfo.getId());
			if(classChangeInfoList.size() == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.STUDENT_NOT_EXIST);
			}
			preparedStatement=connection.prepareStatement(sql);
			result=preparedStatement.executeUpdate();
			preparedStatement=connection.prepareStatement(insertSql);
			preparedStatement.executeUpdate();
		}catch(Exception e)
		{
			if(result == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.DELETE_STUDENTINFO_ERROR);
				
			}
//			e.printStackTrace();
		}
		connection.commit();
		connection.close();
	}

	@Override
	public void deleteAll() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from change_info";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try{
			connection = StudentManageServiceImpl.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sql);
			result = preparedStatement.executeUpdate();
		}catch(Exception e)
		{
			if(result == 0)
			{
				connection.rollback();
				connection.close();
				throw  new StudentResultException(StudentManageExceptionEnums.DATABASE_IS_NULL);
			}
		}
		connection.commit();
		connection.close();
	}

}
