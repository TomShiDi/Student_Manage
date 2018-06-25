package serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.AllInfomationDTO;
import entity.ClassChangeInfo;
import entity.PunishmentInfo;
import entity.RewardInfo;
import entity.StudentInfo;
import resultException.StudentManageExceptionEnums;
import resultException.StudentResultException;
import service.ChangeInfoService;
import service.PunishmentService;
import service.RewardInfoService;
import service.StudentManageService;

public class AllInfomationServiceImpl {
	
	private StudentManageService studentManageService = new StudentManageServiceImpl();
	
	private ChangeInfoService changeInfoService = new ChangeInfoServiceImpl();
	
	private RewardInfoService rewardInfoService = new RewardInfoServiceImpl();
	
	private PunishmentService punishmentService = new PunishmentServiceImpl();
	
	public List<AllInfomationDTO> findByStudentId(String studentId)throws SQLException
	{
		Connection connection = StudentManageServiceImpl.getConnection();
		String sql = String.format("select * from student_info,change_info,reward_info,punishment_info where student_info.student_id = '%s' and change_info.student_id = student_info.student_id and reward_info.student_id = student_info.student_id and punishment_info.student_id = student_info.student_id", studentId);
//		String studentSql = String.format("select * from student_info where student_id = '%s'", studentId);
//		String changeInfoSql = String.format("select * from change_info where student_id = '%s'", studentId);
//		String rewardInfoSql = String.format("select * from reward_info where student_id = '%s'", studentId);
//		String punishmentInfoSql = String.format("select * from punishment_info where student_id = '%s'", studentId);
		PreparedStatement preparedStatement = null;
		ResultSet resultSet =null;
		AllInfomationDTO result = null;
		List<AllInfomationDTO> allInfomationDTOList = new ArrayList<>();
//		List<StudentInfo> studentInfoList = new ArrayList<>();
//		List<ClassChangeInfo> classChangeInfoList = new ArrayList<>();
//		List<RewardInfo> rewardInfoList = new ArrayList<>();
//		List<PunishmentInfo> punishmentInfoList = new ArrayList<>();
		try{
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				
				AllInfomationDTO allInfomationDTO = new AllInfomationDTO();
				allInfomationDTO.setStudentId(resultSet.getString("student_id"));
				allInfomationDTO.setName(resultSet.getString("name"));
				allInfomationDTO.setSex(resultSet.getString("sex"));
				allInfomationDTO.setClassNum(resultSet.getString("class"));
				allInfomationDTO.setDepartment(resultSet.getString("department"));
				allInfomationDTO.setBirthday(resultSet.getString("birthday"));
				allInfomationDTO.setNative_place(resultSet.getString("native_place"));
				allInfomationDTO.setChangeCode(resultSet.getString("change_code"));
				allInfomationDTO.setChangeRecTime(resultSet.getDate(11));
				allInfomationDTO.setChangeDescription(resultSet.getString(12));
				allInfomationDTO.setRewardLevels(resultSet.getString(15));
				allInfomationDTO.setRewardDescription(resultSet.getString(16));
				allInfomationDTO.setRewardRecTime(resultSet.getDate(17));
				allInfomationDTO.setPunishmentLevels(resultSet.getString(20));
				allInfomationDTO.setPunishmentEnable(resultSet.getString(21));
				allInfomationDTO.setPunishmentDiscription(resultSet.getString(22));
				allInfomationDTO.setPunishmentRecTime(resultSet.getDate(23));
				allInfomationDTOList.add(allInfomationDTO);
//				StudentInfo studentInfo = new StudentInfo();
//				studentInfo.setStudentId(resultSet.getString("student_id"));
//				studentInfo.setName(resultSet.getString("name"));
//				studentInfo.setSex(resultSet.getString("sex"));
//				studentInfo.setClassNum(resultSet.getString("class"));
//				studentInfo.setDepartment(resultSet.getString("department"));
//				studentInfo.setBirthday(resultSet.getString("birthday"));
//				studentInfo.setNative_place(resultSet.getString("native_place"));
//				studentInfoList.add(studentInfo);
			}
//			
//			for(StudentInfo studentInfo:studentInfoList)
//			{
//				String changeInfoSql = String.format("select * from change_info where student_id = '%s'", studentInfo.getStudentId());
//				preparedStatement = connection.prepareStatement(changeInfoSql);
//				resultSet = preparedStatement.executeQuery();
//				while(resultSet.next())
//				{
//					ClassChangeInfo classChangeInfo = new ClassChangeInfo();
//					classChangeInfo.setId(resultSet.getString("id"));
//					classChangeInfo.setStudentId(resultSet.getString("student_id"));
//					classChangeInfo.setChangeCode(resultSet.getString("change_code"));
//					classChangeInfo.setDescription(resultSet.getString("description"));
//					classChangeInfo.setRec_time(resultSet.getDate("rec_time"));
//					classChangeInfoList.add(classChangeInfo);
//				}
//				String rewardInfoSql = String.format("select * from reward_info where student_id = '%s'", studentInfo.getStudentId());
//				preparedStatement = connection.prepareStatement(rewardInfoSql);
//				resultSet = preparedStatement.executeQuery();
//				while(resultSet.next())
//				{
//					RewardInfo rewardInfo = new RewardInfo();
//					rewardInfo.setId(resultSet.getString("id"));
//					rewardInfo.setStudentId(resultSet.getString("student_id"));
//					rewardInfo.setLevels(resultSet.getString("levels"));
//					rewardInfo.setDescription(resultSet.getString("description"));
//					rewardInfo.setRec_time(resultSet.getDate("rec_time"));
//					rewardInfoList.add(rewardInfo);
//				}
//				
//				String punishmentInfoSql = String.format("select * from punishment_info where student_id = '%s'", studentInfo.getStudentId());
//				preparedStatement = connection.prepareStatement(punishmentInfoSql);
//				resultSet = preparedStatement.executeQuery();
//				while(resultSet.next())
//				{
//					PunishmentInfo punishmentInfo = new PunishmentInfo();
//					punishmentInfo.setId(resultSet.getString("id"));
//					punishmentInfo.setStudentid(resultSet.getString("student_id"));
//					punishmentInfo.setLevels(resultSet.getString("levels"));
//					punishmentInfo.setEnable(resultSet.getString("enable"));
//					punishmentInfo.setDiscription(resultSet.getString("description"));
//					punishmentInfo.setRec_time(resultSet.getDate("rec_time"));
//					punishmentInfoList.add(punishmentInfo);
//				}
//			}
//			
//			for(StudentInfo studentInfo:studentInfoList)
//			{
//				for(ClassChangeInfo classChangeInfo:classChangeInfoList)
//				{
//					
//				}
//				AllInfomationDTO allInfomationDTO = new AllInfomationDTO();
//				
//			}
//			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
//			for(int i = 1;i < resultSetMetaData.getColumnCount()+1;i++)
//			{
//				System.out.println(resultSetMetaData.getColumnLabel(i));
//			}
		}catch(Exception e)
		{
			if(allInfomationDTOList.size() == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.QUERY_ERROR);
			}
		}
		return allInfomationDTOList;
	}
	
	public List<AllInfomationDTO> findAll()throws SQLException
	{
		Connection connection = StudentManageServiceImpl.getConnection();
		String sql = "select * from student_info,change_info,reward_info,punishment_info where change_info.student_id = student_info.student_id and reward_info.student_id = student_info.student_id and punishment_info.student_id = student_info.student_id";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet =null;
		AllInfomationDTO result = null;
		List<AllInfomationDTO> allInfomationDTOList = new ArrayList<>();
		try{
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				AllInfomationDTO allInfomationDTO = new AllInfomationDTO();
				allInfomationDTO.setStudentId(resultSet.getString("student_id"));
				allInfomationDTO.setName(resultSet.getString("name"));
				allInfomationDTO.setSex(resultSet.getString("sex"));
				allInfomationDTO.setClassNum(resultSet.getString("class"));
				allInfomationDTO.setDepartment(resultSet.getString("department"));
				allInfomationDTO.setBirthday(resultSet.getString("birthday"));
				allInfomationDTO.setNative_place(resultSet.getString("native_place"));
				allInfomationDTO.setChangeCode(resultSet.getString("change_code"));
				allInfomationDTO.setChangeRecTime(resultSet.getDate(11));
				allInfomationDTO.setChangeDescription(resultSet.getString(12));
				allInfomationDTO.setRewardLevels(resultSet.getString(15));
				allInfomationDTO.setRewardDescription(resultSet.getString(16));
				allInfomationDTO.setRewardRecTime(resultSet.getDate(17));
				allInfomationDTO.setPunishmentLevels(resultSet.getString(20));
				allInfomationDTO.setPunishmentEnable(resultSet.getString(21));
				allInfomationDTO.setPunishmentDiscription(resultSet.getString(22));
				allInfomationDTO.setPunishmentRecTime(resultSet.getDate(23));
				allInfomationDTOList.add(allInfomationDTO);
			}
//			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
//			for(int i = 1;i < resultSetMetaData.getColumnCount()+1;i++)
//			{
//				System.out.println(resultSetMetaData.getColumnLabel(i));
//			}
		}catch(Exception e)
		{
			if(allInfomationDTOList.size() == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.QUERY_ERROR);
			}
		}
		return allInfomationDTOList;
	}

}
