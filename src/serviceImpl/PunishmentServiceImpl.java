package serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.PunishmentInfo;
import resultException.StudentManageExceptionEnums;
import resultException.StudentResultException;
import service.PunishmentLevelsService;
import service.PunishmentService;
import service.StudentManageService;

public class PunishmentServiceImpl implements PunishmentService {
	

	private StudentManageService studentManageService = new StudentManageServiceImpl();
	PunishmentLevelsService punishmentLevelsService =new PunishmentLevelsServiceImpl();
	
	@Override
	public List<PunishmentInfo> findAll() throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		String sql = "select * from punishment_info";
		List<PunishmentInfo> punishmentInfoList = new ArrayList<PunishmentInfo>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			connection = StudentManageServiceImpl.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				PunishmentInfo punishmentInfo = new PunishmentInfo();
				punishmentInfo.setId(resultSet.getString("id"));
				punishmentInfo.setStudentid(resultSet.getString("student_id"));
				punishmentInfo.setLevels(resultSet.getString("levels"));
				punishmentInfo.setEnable(resultSet.getString("enable"));
				punishmentInfo.setDiscription(resultSet.getString("description"));
				punishmentInfo.setRec_time(resultSet.getDate("rec_time"));
				punishmentInfoList.add(punishmentInfo);
			}
		}catch(Exception e)
		{
			if(punishmentInfoList.size() == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.QUERY_ERROR);
			}
		}
		return punishmentInfoList;
	}

	@Override
	public List<PunishmentInfo> findByStudentId(String studentId) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		String sql =String.format("select * from punishment_info where student_id = '%s'", studentId);
		List<PunishmentInfo> punishmentInfoList = new ArrayList<PunishmentInfo>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			connection = StudentManageServiceImpl.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				PunishmentInfo punishmentInfo = new PunishmentInfo();
				punishmentInfo.setId(resultSet.getString("id"));
				punishmentInfo.setStudentid(resultSet.getString("student_id"));
				punishmentInfo.setLevels(resultSet.getString("levels"));
				punishmentInfo.setEnable(resultSet.getString("enable"));
				punishmentInfo.setDiscription(resultSet.getString("description"));
				punishmentInfo.setRec_time(resultSet.getDate("rec_time"));
				punishmentInfoList.add(punishmentInfo);
			}
		}catch(Exception e)
		{
			if(punishmentInfoList.size() == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.QUERY_ERROR);
			}
		}
		return punishmentInfoList;
	}

	@Override
	public List<PunishmentInfo> findByLevel(String level) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		String sql = String.format("select * from punishment_info where levels = '%s'", level);
		List<PunishmentInfo> punishmentInfoList = new ArrayList<PunishmentInfo>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			connection = StudentManageServiceImpl.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				PunishmentInfo punishmentInfo = new PunishmentInfo();
				punishmentInfo.setId(resultSet.getString("id"));
				punishmentInfo.setStudentid(resultSet.getString("student_id"));
				punishmentInfo.setLevels(resultSet.getString("levels"));
				punishmentInfo.setEnable(resultSet.getString("enable"));
				punishmentInfo.setDiscription(resultSet.getString("description"));
				punishmentInfo.setRec_time(resultSet.getDate("rec_time"));
				punishmentInfoList.add(punishmentInfo);
			}
		}catch(Exception e)
		{
			if(punishmentInfoList.size() == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.QUERY_ERROR);
			}
		}
		return punishmentInfoList;
	}

	@Override
	public List<PunishmentInfo> findByRecTime(String recTime) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		String sql = String.format("select * from punishment_info where rectime = '%s'", recTime);
		List<PunishmentInfo> punishmentInfoList = new ArrayList<PunishmentInfo>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			connection = StudentManageServiceImpl.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				PunishmentInfo punishmentInfo = new PunishmentInfo();
				punishmentInfo.setId(resultSet.getString("id"));
				punishmentInfo.setStudentid(resultSet.getString("student_id"));
				punishmentInfo.setLevels(resultSet.getString("levels"));
				punishmentInfo.setEnable(resultSet.getString("enable"));
				punishmentInfo.setDiscription(resultSet.getString("description"));
				punishmentInfo.setRec_time(resultSet.getDate("rec_time"));
				punishmentInfoList.add(punishmentInfo);
			}
		}catch(Exception e)
		{
			if(punishmentInfoList.size() == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.QUERY_ERROR);
			}
		}
		return punishmentInfoList;
	}

	@Override
	public List<PunishmentInfo> findByEnable(String enable) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		String sql = String.format("select * from punishment_info where enable = '%s'", enable);
		List<PunishmentInfo> punishmentInfoList = new ArrayList<PunishmentInfo>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			connection = StudentManageServiceImpl.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				PunishmentInfo punishmentInfo = new PunishmentInfo();
				punishmentInfo.setId(resultSet.getString("id"));
				punishmentInfo.setStudentid(resultSet.getString("student_id"));
				punishmentInfo.setLevels(resultSet.getString("levels"));
				punishmentInfo.setEnable(resultSet.getString("enable"));
				punishmentInfo.setDiscription(resultSet.getString("description"));
				punishmentInfo.setRec_time(resultSet.getDate("rec_time"));
				punishmentInfoList.add(punishmentInfo);
			}
		}catch(Exception e)
		{
			if(punishmentInfoList.size() == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.QUERY_ERROR);
			}
		}
		return punishmentInfoList;
	}

	@Override
	public List<PunishmentInfo> findByDescription(String description) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		String sql = String.format("select * from punishment_info where description = '%s'", description);
		List<PunishmentInfo> punishmentInfoList = new ArrayList<PunishmentInfo>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			connection = StudentManageServiceImpl.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				PunishmentInfo punishmentInfo = new PunishmentInfo();
				punishmentInfo.setId(resultSet.getString("id"));
				punishmentInfo.setStudentid(resultSet.getString("student_id"));
				punishmentInfo.setLevels(resultSet.getString("levels"));
				punishmentInfo.setEnable(resultSet.getString("enable"));
				punishmentInfo.setDiscription(resultSet.getString("description"));
				punishmentInfo.setRec_time(resultSet.getDate("rec_time"));
				punishmentInfoList.add(punishmentInfo);
			}
		}catch(Exception e)
		{
			if(punishmentInfoList.size() == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.QUERY_ERROR);
			}
		}
		return punishmentInfoList;
	}

	@Override
	public List<PunishmentInfo> findByPunishimentInfoId(String punishmentId) throws SQLException{
		// TODO Auto-generated method stub
		Connection connection = null;
		String sql = String.format("select * from punishment_info where id = '%s'", punishmentId);
		List<PunishmentInfo> punishmentInfoList = new ArrayList<PunishmentInfo>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			connection = StudentManageServiceImpl.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				PunishmentInfo punishmentInfo = new PunishmentInfo();
				punishmentInfo.setId(resultSet.getString("id"));
				punishmentInfo.setStudentid(resultSet.getString("student_id"));
				punishmentInfo.setLevels(resultSet.getString("levels"));
				punishmentInfo.setEnable(resultSet.getString("enable"));
				punishmentInfo.setDiscription(resultSet.getString("description"));
				punishmentInfo.setRec_time(resultSet.getDate("rec_time"));
				punishmentInfoList.add(punishmentInfo);
			}
		}catch(Exception e)
		{
			if(punishmentInfoList.size() == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.QUERY_ERROR);
			}
		}
		return punishmentInfoList;
	}

	@Override
	public void addPunishmentInfo(PunishmentInfo punishmentInfo) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=StudentManageServiceImpl.getConnection();
		punishmentLevelsService.findByPunishmentLevelsId(Integer.valueOf(punishmentInfo.getLevels()));
		String sql=String.format("insert into punishment_info(student_id,levels,enable,description) values('%s','%s','%s','%s')",
					punishmentInfo.getStudentid(),
					punishmentInfo.getLevels(),
					punishmentInfo.getEnable(),
					punishmentInfo.getDiscription());
		
		studentManageService.findByStudentId(punishmentInfo.getStudentid());
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
//			e.printStackTrace();
		}
		connection.commit();
	}

	@Override
	public void deletePunishimentInfoById(String punishmentId) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=StudentManageServiceImpl.getConnection();
		PreparedStatement preparedStatement=null;
		String sql = String.format("delete from punishment_info where id='%s'", punishmentId);
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
	public void updatePunishimentInfo(PunishmentInfo punishmentInfo) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=StudentManageServiceImpl.getConnection();
		punishmentLevelsService.findByPunishmentLevelsId(Integer.valueOf(punishmentInfo.getLevels()));
		PreparedStatement preparedStatement=null;
//		String selectSql=String.format("select * from student_info where student_id='%s'", args)
		String sql = String.format("delete from punishment_info where id='%s'", punishmentInfo.getId());
		String insertSql=String.format("insert into punishment_info(student_id,levels,enable,description) values('%s','%s','%s','%s')",
//				punishimentInfo.getId(),
				punishmentInfo.getStudentid(),
				punishmentInfo.getLevels(),
				punishmentInfo.getEnable(),
				punishmentInfo.getDiscription());
		
//		ResultSet resultSet=null;
		
		int result=0;
		int result2 = 0;
		try{
			connection.setAutoCommit(false);
			List<PunishmentInfo> punishmentInfoList=findByPunishimentInfoId(punishmentInfo.getId());
			if(punishmentInfoList.size() == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.STUDENT_NOT_EXIST);
			}
			preparedStatement=connection.prepareStatement(sql);
			result=preparedStatement.executeUpdate();
			preparedStatement=connection.prepareStatement(insertSql);
			result2 = preparedStatement.executeUpdate();
		}catch(Exception e)
		{
			if(result == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.DELETE_STUDENTINFO_ERROR);
			}
			
			if(result2 == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.INSERT_ERROR);
			}
		}
		connection.commit();
		connection.close();
	}

	@Override
	public void deleteAll() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from punishment_info";
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
