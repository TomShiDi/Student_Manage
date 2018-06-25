package serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.ChangeCodeInfo;
import resultException.StudentManageExceptionEnums;
import resultException.StudentResultException;
import service.ChangeLevelsService;

public class ChangeLevelsServiceImpl implements ChangeLevelsService {

	@Override
	public List<ChangeCodeInfo> findByChangeCodeId(Integer changeCodeId) throws SQLException {
		// TODO Auto-generated method stub
		String sql=String.format("select * from change_code_info where code=%s", changeCodeId.toString());
		Connection connection=StudentManageServiceImpl.getConnection();
		PreparedStatement preparedStatement=null;
		List<ChangeCodeInfo> changeCodeInfoList=new ArrayList<>();
		ResultSet resultSet=null;
		ChangeCodeInfo result=null;
		try{
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			resultSet.next();
			ChangeCodeInfo changeCodeInfo = new ChangeCodeInfo();
			changeCodeInfo.setCode(resultSet.getInt("code"));
			changeCodeInfo.setDescription(resultSet.getString("description"));
			changeCodeInfoList.add(changeCodeInfo);
			result=changeCodeInfo;
			
		}catch(Exception e)
		{
			if(result==null)
			{
				JOptionPane.showMessageDialog(null, "学籍变更等级不存在","错误提示",JOptionPane.ERROR_MESSAGE);
				throw new StudentResultException(StudentManageExceptionEnums.CHANGE_CODE_DONOT_EXIST);
			}
		}
		StudentManageServiceImpl.disConnection(connection);
		return changeCodeInfoList;
	}

	

}
