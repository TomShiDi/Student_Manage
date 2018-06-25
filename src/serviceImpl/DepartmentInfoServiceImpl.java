package serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.ClassInfo;
import entity.DepartmentInfo;
import resultException.StudentManageExceptionEnums;
import resultException.StudentResultException;
import service.DepartmentInfoService;

public class DepartmentInfoServiceImpl implements DepartmentInfoService {

	@Override
	public List<DepartmentInfo> findBYDepartmentId(String departmentId) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		String sql =String.format("select * from department_info where id = '%s'", departmentId);
		List<DepartmentInfo> departmentInfoList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DepartmentInfo result = null;
		try{
			connection = StudentManageServiceImpl.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				DepartmentInfo departmentInfo = new DepartmentInfo();
				departmentInfo.setId(resultSet.getString("id"));
				departmentInfo.setName(resultSet.getString("name"));
				result = departmentInfo;
				departmentInfoList.add(departmentInfo);
			}
		}catch(Exception e)
		{
			if(departmentInfoList.size() == 0)
			{
				connection.close();
				throw new StudentResultException(StudentManageExceptionEnums.QUERY_ERROR);
			}
		}
		
		if(result == null)
		{
			JOptionPane.showMessageDialog(null, "院系信息不存在","错误提示",JOptionPane.ERROR_MESSAGE);
			throw new StudentResultException(StudentManageExceptionEnums.DEPARTMENT_INFO_DONOT_EXIST);
		}
		return departmentInfoList;
	}

}
