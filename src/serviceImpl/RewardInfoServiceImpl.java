package serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.PunishmentInfo;
import entity.RewardInfo;
import entity.StudentInfo;
import resultException.StudentManageExceptionEnums;
import resultException.StudentResultException;
import service.RewardInfoService;
import service.RewardLevelsService;
import service.StudentManageService;

public class RewardInfoServiceImpl implements RewardInfoService {

	private StudentManageService studentManageService = new StudentManageServiceImpl();
	
	private RewardLevelsService rewardLevelsService = new RewardLevelsServiceImpl();
	
	@Override
	public List<RewardInfo> findAll() throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		String sql = "select * from reward_info";
		List<RewardInfo> rewardInfoList = new ArrayList<RewardInfo>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			connection = StudentManageServiceImpl.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				RewardInfo rewardInfo = new RewardInfo();
				rewardInfo.setId(resultSet.getString("id"));
				rewardInfo.setStudentId(resultSet.getString("student_id"));
				rewardInfo.setLevels(resultSet.getString("levels"));
				rewardInfo.setDescription(resultSet.getString("description"));
				rewardInfo.setRec_time(resultSet.getDate("rec_time"));
				rewardInfoList.add(rewardInfo);
			}
		}catch(Exception e)
		{
			if(rewardInfoList.size() == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.QUERY_ERROR);
			}
		}
		return rewardInfoList;
	}

	@Override
	public List<RewardInfo> findByStudentId(String studentId) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		String sql =String.format("select * from reward_info where student_id = '%s'", studentId);
		List<RewardInfo> rewardInfoList = new ArrayList<RewardInfo>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			connection = StudentManageServiceImpl.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				RewardInfo rewardInfo = new RewardInfo();
				rewardInfo.setId(resultSet.getString("id"));
				rewardInfo.setStudentId(resultSet.getString("student_id"));
				rewardInfo.setLevels(resultSet.getString("levels"));
				rewardInfo.setDescription(resultSet.getString("description"));
				rewardInfo.setRec_time(resultSet.getDate("rec_time"));
				rewardInfoList.add(rewardInfo);
			}
		}catch(Exception e)
		{
			if(rewardInfoList.size() == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.QUERY_ERROR);
			}
		}
		return rewardInfoList;
	}

	@Override
	public List<RewardInfo> findByLevel(String level) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		String sql = String.format("select * from reward_info where levels = '%s'", level);
		List<RewardInfo> rewardInfoList = new ArrayList<RewardInfo>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			connection = StudentManageServiceImpl.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				RewardInfo rewardInfo = new RewardInfo();
				rewardInfo.setId(resultSet.getString("id"));
				rewardInfo.setStudentId(resultSet.getString("student_id"));
				rewardInfo.setLevels(resultSet.getString("levels"));
				rewardInfo.setDescription(resultSet.getString("description"));
				rewardInfo.setRec_time(resultSet.getDate("rec_time"));
				rewardInfoList.add(rewardInfo);
			}
		}catch(Exception e)
		{
			if(rewardInfoList.size() == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.QUERY_ERROR);
			}
		}
		return rewardInfoList;
	}

	
	
	@Override
	public List<RewardInfo> findByRecTime(String recTime) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public List<RewardInfo> findByDescription(String description) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		String sql = String.format("select * from reward_info where description = '%s'", description);
		List<RewardInfo> rewardInfoList = new ArrayList<RewardInfo>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			connection = StudentManageServiceImpl.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				RewardInfo rewardInfo = new RewardInfo();
				rewardInfo.setId(resultSet.getString("id"));
				rewardInfo.setStudentId(resultSet.getString("student_id"));
				rewardInfo.setLevels(resultSet.getString("levels"));
				rewardInfo.setDescription(resultSet.getString("description"));
				rewardInfo.setRec_time(resultSet.getDate("rec_time"));
				rewardInfoList.add(rewardInfo);
			}
		}catch(Exception e)
		{
			if(rewardInfoList.size() == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.QUERY_ERROR);
			}
		}
		return rewardInfoList;
	}

	@Override
	public List<RewardInfo> findByRewardInfoId(String rewardInfoId) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		String sql = String.format("select * from reward_info where id = '%s'", rewardInfoId);
		List<RewardInfo> rewardInfoList = new ArrayList<RewardInfo>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			connection = StudentManageServiceImpl.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				RewardInfo rewardInfo = new RewardInfo();
				rewardInfo.setId(resultSet.getString("id"));
				rewardInfo.setStudentId(resultSet.getString("student_id"));
				rewardInfo.setLevels(resultSet.getString("levels"));
				rewardInfo.setDescription(resultSet.getString("description"));
				rewardInfo.setRec_time(resultSet.getDate("rec_time"));
				rewardInfoList.add(rewardInfo);
			}
		}catch(Exception e)
		{
			if(rewardInfoList.size() == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.QUERY_ERROR);
			}
		}
		return rewardInfoList;
	}

	@Override
	public void addRewardInfo(RewardInfo rewardInfo) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=StudentManageServiceImpl.getConnection();
		
		rewardLevelsService.findByRewardLevelsId(Integer.valueOf(rewardInfo.getLevels()));
		List<StudentInfo> studentInfoList = new ArrayList<>();
		studentInfoList = studentManageService.findByStudentId(rewardInfo.getStudentId());
		
		String sql=String.format("insert into reward_info(student_id,levels,description) values('%s','%s','%s')",
					rewardInfo.getStudentId(),
					rewardInfo.getLevels(),
					rewardInfo.getDescription());
		
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
	public void deleteRewardInfoById(String rewardInfoId) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=StudentManageServiceImpl.getConnection();
		PreparedStatement preparedStatement=null;
		String sql = String.format("delete from reward_info where id='%s'", rewardInfoId);
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
	public void updateRewardInfo(RewardInfo rewardInfo) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=StudentManageServiceImpl.getConnection();
		rewardLevelsService.findByRewardLevelsId(Integer.valueOf(rewardInfo.getLevels()));
		
		PreparedStatement preparedStatement=null;
//		String selectSql=String.format("select * from student_info where student_id='%s'", args)
		String sql = String.format("delete from reward_info where id='%s'", rewardInfo.getId());
		String insertSql=String.format("insert into reward_info(student_id,levels,description) values('%s','%s','%s')",
				rewardInfo.getStudentId(),
				rewardInfo.getLevels(),
				rewardInfo.getDescription());
		
//		ResultSet resultSet=null;
		
		int result=0;
		int result2 = 0;
		try{
			connection.setAutoCommit(false);
			List<RewardInfo> punishmentInfoList=findByRewardInfoId(rewardInfo.getId());
			if(punishmentInfoList.size() == 0)
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
//				e.printStackTrace();
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
		String sql = "delete from reward_info";
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
