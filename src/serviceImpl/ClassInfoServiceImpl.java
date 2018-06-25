package serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.ClassInfo;
import resultException.StudentManageExceptionEnums;
import resultException.StudentResultException;
import service.ClassInfoService;

public class ClassInfoServiceImpl implements ClassInfoService {

	@Override
	public List<ClassInfo> findByClassId(String classId) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		String sql =String.format("select * from class_info where id = '%s'", classId);
		List<ClassInfo> classInfoList = new ArrayList<ClassInfo>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ClassInfo result = null;
		try{
			connection = StudentManageServiceImpl.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				ClassInfo classInfo = new ClassInfo();
				classInfo.setId(resultSet.getString("id"));
				classInfo.setName(resultSet.getString("name"));
				classInfo.setMonitorId(resultSet.getString("monitor_id"));
				result = classInfo;
				classInfoList.add(classInfo);
			}
		}catch(Exception e)
		{
			if(classInfoList.size() == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.QUERY_ERROR);
			}
		}
		
		if(result == null)
		{
			JOptionPane.showMessageDialog(null, "班级信息不存在","错误提示",JOptionPane.ERROR_MESSAGE);
			throw new StudentResultException(StudentManageExceptionEnums.CLASS_INFO_DONOT_EXIST);
		}
		return classInfoList;
	}

}
