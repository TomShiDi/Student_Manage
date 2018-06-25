package serviceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.swing.JOptionPane;

import entity.StudentInfo;
import resultException.StudentManageExceptionEnums;
import resultException.StudentResultException;
import service.ClassInfoService;
import service.DepartmentInfoService;
import service.StudentManageService;

public class StudentManageServiceImpl implements StudentManageService {
	
	private ClassInfoService classInfoService = new ClassInfoServiceImpl();
	
	private DepartmentInfoService departmentInfoService = new DepartmentInfoServiceImpl();
	
	private static String username="root";
	private static String password="15576123138";
	private static String url="jdbc:mysql://localhost:3306/student_manage?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
	
	
	public static Connection getConnection() {
		// TODO Auto-generated method stub
//		ResultSet resultSet=null;
		Connection connection=null;
		try{
			connection=DriverManager.getConnection(url,username,password);
		}catch(Exception e)
		{
			if(connection==null) 
				throw new StudentResultException(StudentManageExceptionEnums.CONNECTION_OPEN_ERROR);
		}
		return connection;
	}

	
	public static void disConnection(Connection connection)
	{
		try{
			connection.close();
		}catch(Exception e)
		{
			throw new StudentResultException(StudentManageExceptionEnums.CONNECTION_CLOSE_ERROR);
		}
	}

	
	

	@Override
	public List<StudentInfo> findAll() throws SQLException {
		// TODO Auto-generated method stub
		String sql= "select * from student_info";
		Connection connection=StudentManageServiceImpl.getConnection();
		List<StudentInfo> studentInfoList=new ArrayList<>();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try{
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				StudentInfo studentInfo=new StudentInfo();
				studentInfo.setStudentId(resultSet.getString("student_id"));
				studentInfo.setName(resultSet.getString("name"));
				studentInfo.setSex(resultSet.getString("sex"));
				studentInfo.setClassNum(resultSet.getString("class"));
				studentInfo.setDepartment(resultSet.getString("department"));
				studentInfo.setBirthday(resultSet.getString("birthday"));
				studentInfo.setNative_place(resultSet.getString("native_place"));
				studentInfoList.add(studentInfo);
			}
		}catch(Exception e)
		{
			connection.close();
			e.printStackTrace();
		}
		return studentInfoList;
	}


	@Override
	public List<StudentInfo> findByStudentId(String studentId) {
		// TODO Auto-generated method stub
		String sql=String.format("select * from student_info where student_id='%s'", studentId);
		Connection connection=StudentManageServiceImpl.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		List<StudentInfo> studentInfoList=new ArrayList<>();
		StudentInfo result=null;
		try{
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			resultSet.next();
			StudentInfo studentInfo=new StudentInfo();
			studentInfo.setStudentId(resultSet.getString("student_id"));
			studentInfo.setName(resultSet.getString("name"));
			studentInfo.setSex(resultSet.getString("sex"));
			studentInfo.setClassNum(resultSet.getString("class"));
			studentInfo.setDepartment(resultSet.getString("department"));
			studentInfo.setBirthday(resultSet.getString("birthday"));
			studentInfo.setNative_place(resultSet.getString("native_place"));
			studentInfoList.add(studentInfo);
			result=studentInfo;
			
		}catch(Exception e)
		{
			if(result==null)
			{
				JOptionPane.showMessageDialog(null, "学号不存在","错误提示",JOptionPane.ERROR_MESSAGE);
				throw new StudentResultException(StudentManageExceptionEnums.STUDENT_NOT_EXIST);
			}
		}
		StudentManageServiceImpl.disConnection(connection);
		return studentInfoList;
	}
	
	
	public void addStudentInfo(StudentInfo studentInfo)throws SQLException
	{
		Connection connection=StudentManageServiceImpl.getConnection();
		classInfoService.findByClassId(studentInfo.getClassNum());
		departmentInfoService.findBYDepartmentId(studentInfo.getDepartment());
		String sql=String.format("insert into student_info values('%s','%s','%s','%s','%s','%s','%s')",
					studentInfo.getStudentId(),
					studentInfo.getName(),
					studentInfo.getSex(),
					studentInfo.getClassNum(),
					studentInfo.getDepartment(),
					studentInfo.getBirthday(),
					studentInfo.getNative_place());
		
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
				JOptionPane.showMessageDialog(null, "学生数据插入失败，请检查学号是否已经存在","错误提示",JOptionPane.ERROR_MESSAGE);
				throw new StudentResultException(StudentManageExceptionEnums.INSERT_ERROR);
			}
		}
		connection.commit();
	}


	@Override
	public List<StudentInfo> findByClassNum(String classNum)throws SQLException {
		// TODO Auto-generated method stub
		String sql=String.format("select * from student_info where class='%s'", classNum);
		Connection connection=StudentManageServiceImpl.getConnection();
		List<StudentInfo> studentInfoList=new ArrayList<>();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try{
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				StudentInfo studentInfo=new StudentInfo();
				studentInfo.setStudentId(resultSet.getString("student_id"));
				studentInfo.setName(resultSet.getString("name"));
				studentInfo.setSex(resultSet.getString("sex"));
				studentInfo.setClassNum(resultSet.getString("class"));
				studentInfo.setDepartment(resultSet.getString("department"));
				studentInfo.setBirthday(resultSet.getString("birthday"));
				studentInfo.setNative_place(resultSet.getString("native_place"));
				studentInfoList.add(studentInfo);
			}
		}catch(Exception e)
		{
			connection.close();
			e.printStackTrace();
		}
		return studentInfoList;
	}


	@Override
	public void deleteStudentInfoById(String studentId) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=StudentManageServiceImpl.getConnection();
		PreparedStatement preparedStatement=null;
		String studentSql = String.format("delete from student_info where student_id = '%s'", studentId);
		String changeInfoSql = String.format("delete from change_info where student_id = '%s'", studentId);
		String rewardInfoSql = String.format("delete from reward_info where student_id = '%s'", studentId);
		String punishmentInfoSql = String.format("delete from punishment_info where student_id = '%s'", studentId);
		int result=0,result2=0,result3=0,result4=0;
		try{
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(studentSql);
			
			result=preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement(changeInfoSql);
			result2 = preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement(rewardInfoSql);
			result3 = preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement(punishmentInfoSql);
			result4 = preparedStatement.executeUpdate();
		}catch(Exception e)
		{
			if(result==0||result2==0||result3==0||result4==0)
			{
				connection.rollback();
				connection.close();
				//throw new StudentResultException(StudentManageExceptionEnums.DELETE_STUDENTINFO_ERROR);
				e.printStackTrace();
				
			}
		}
		connection.commit();
		connection.close();
	}


	@Override
	public void updateStudentInfo(StudentInfo studentInfo) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=StudentManageServiceImpl.getConnection();
		PreparedStatement preparedStatement=null;
//		String selectSql=String.format("select * from student_info where student_id='%s'", args)
		String sql = String.format("delete from student_info where student_id='%s'", studentInfo.getStudentId());
		String insertSql = String.format("insert into student_info values('%s','%s','%s','%s','%s','%s','%s')",
				studentInfo.getStudentId(),
				studentInfo.getName(),
				studentInfo.getSex(),
				studentInfo.getClassNum(),
				studentInfo.getDepartment(),
				studentInfo.getBirthday(),
				studentInfo.getNative_place());
//		ResultSet resultSet=null;
		
		int result=0;
		try{
			connection.setAutoCommit(false);
			List<StudentInfo> studentInfoList=findByStudentId(studentInfo.getStudentId());
			if(studentInfoList.size() == 0)
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
		}
		connection.commit();
		connection.close();
	}


	@Override
	public List<StudentInfo> findByName(String name) throws SQLException{
		// TODO Auto-generated method stub
		String sql=String.format("select * from student_info where name='%s'", name);
		Connection connection=StudentManageServiceImpl.getConnection();
		List<StudentInfo> studentInfoList=new ArrayList<>();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try{
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				StudentInfo studentInfo=new StudentInfo();
				studentInfo.setStudentId(resultSet.getString("student_id"));
				studentInfo.setName(resultSet.getString("name"));
				studentInfo.setSex(resultSet.getString("sex"));
				studentInfo.setClassNum(resultSet.getString("class"));
				studentInfo.setDepartment(resultSet.getString("department"));
				studentInfo.setBirthday(resultSet.getString("birthday"));
				studentInfo.setNative_place(resultSet.getString("native_place"));
				studentInfoList.add(studentInfo);
			}
		}catch(Exception e)
		{
			connection.close();
			e.printStackTrace();
		}
		return studentInfoList;
	}


	@Override
	public List<StudentInfo> findBySex(String sex) throws SQLException{
		// TODO Auto-generated method stub
		String sql=String.format("select * from student_info where sex='%s'", sex);
		Connection connection=StudentManageServiceImpl.getConnection();
		List<StudentInfo> studentInfoList=new ArrayList<>();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try{
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				StudentInfo studentInfo=new StudentInfo();
				studentInfo.setStudentId(resultSet.getString("student_id"));
				studentInfo.setName(resultSet.getString("name"));
				studentInfo.setSex(resultSet.getString("sex"));
				studentInfo.setClassNum(resultSet.getString("class"));
				studentInfo.setDepartment(resultSet.getString("department"));
				studentInfo.setBirthday(resultSet.getString("birthday"));
				studentInfo.setNative_place(resultSet.getString("native_place"));
				studentInfoList.add(studentInfo);
			}
		}catch(Exception e)
		{
			connection.close();
			e.printStackTrace();
		}
		return studentInfoList;
	}


	@Override
	public List<StudentInfo> findByDepartment(String department) throws SQLException{
		// TODO Auto-generated method stub
		String sql=String.format("select * from student_info where department='%s'", department);
		Connection connection=StudentManageServiceImpl.getConnection();
		List<StudentInfo> studentInfoList=new ArrayList<>();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try{
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				StudentInfo studentInfo=new StudentInfo();
				studentInfo.setStudentId(resultSet.getString("student_id"));
				studentInfo.setName(resultSet.getString("name"));
				studentInfo.setSex(resultSet.getString("sex"));
				studentInfo.setClassNum(resultSet.getString("class"));
				studentInfo.setDepartment(resultSet.getString("department"));
				studentInfo.setBirthday(resultSet.getString("birthday"));
				studentInfo.setNative_place(resultSet.getString("native_place"));
				studentInfoList.add(studentInfo);
			}
		}catch(Exception e)
		{
			connection.close();
			e.printStackTrace();
		}
		return studentInfoList;
	}


	@Override
	public List<StudentInfo> findByBirthday(String birthday) throws SQLException{
		// TODO Auto-generated method stub
		String sql=String.format("select * from student_info where birthday='%s'", birthday);
		Connection connection=StudentManageServiceImpl.getConnection();
		List<StudentInfo> studentInfoList=new ArrayList<>();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try{
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				StudentInfo studentInfo=new StudentInfo();
				studentInfo.setStudentId(resultSet.getString("student_id"));
				studentInfo.setName(resultSet.getString("name"));
				studentInfo.setSex(resultSet.getString("sex"));
				studentInfo.setClassNum(resultSet.getString("class"));
				studentInfo.setDepartment(resultSet.getString("department"));
				studentInfo.setBirthday(resultSet.getString("birthday"));
				studentInfo.setNative_place(resultSet.getString("native_place"));
				studentInfoList.add(studentInfo);
			}
		}catch(Exception e)
		{
			connection.close();
			e.printStackTrace();
		}
		return studentInfoList;
	}


	@Override
	public List<StudentInfo> findByNativePlace(String nativePlace) throws SQLException{
		// TODO Auto-generated method stub
		String sql=String.format("select * from student_info where native_place='%s'", nativePlace);
		Connection connection=StudentManageServiceImpl.getConnection();
		List<StudentInfo> studentInfoList=new ArrayList<>();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try{
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				StudentInfo studentInfo=new StudentInfo();
				studentInfo.setStudentId(resultSet.getString("student_id"));
				studentInfo.setName(resultSet.getString("name"));
				studentInfo.setSex(resultSet.getString("sex"));
				studentInfo.setClassNum(resultSet.getString("class"));
				studentInfo.setDepartment(resultSet.getString("department"));
				studentInfo.setBirthday(resultSet.getString("birthday"));
				studentInfo.setNative_place(resultSet.getString("native_place"));
				studentInfoList.add(studentInfo);
			}
		}catch(Exception e)
		{
			connection.close();
			e.printStackTrace();
		}
		return studentInfoList;
	}


	@Override
	public void deleteAll() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from student_info";
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
