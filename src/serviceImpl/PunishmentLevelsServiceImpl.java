package serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.ChangeCodeInfo;
import entity.PunishmentLevelsInfo;
import resultException.StudentManageExceptionEnums;
import resultException.StudentResultException;
import service.PunishmentLevelsService;

public class PunishmentLevelsServiceImpl implements PunishmentLevelsService {

	@Override
	public List<PunishmentLevelsInfo> findByPunishmentLevelsId(Integer punishmentLevelsId) throws SQLException {
		// TODO Auto-generated method stub
		String sql=String.format("select * from punish_levels_info where code=%s", punishmentLevelsId.toString());
		Connection connection=StudentManageServiceImpl.getConnection();
		PreparedStatement preparedStatement=null;
		List<PunishmentLevelsInfo> punishmentLevelsInfoList=new ArrayList<>();
		ResultSet resultSet=null;
		PunishmentLevelsInfo result=null;
		try{
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			resultSet.next();
			PunishmentLevelsInfo punishmentLevelsInfo = new PunishmentLevelsInfo();
			punishmentLevelsInfo.setCode(resultSet.getInt("code"));
			punishmentLevelsInfo.setDescription(resultSet.getString("description"));
			punishmentLevelsInfoList.add(punishmentLevelsInfo);
			result=punishmentLevelsInfo;
			
		}catch(Exception e)
		{
			if(result==null)
			{
				JOptionPane.showMessageDialog(null, "处罚等级不存在","错误提示",JOptionPane.ERROR_MESSAGE);
				throw new StudentResultException(StudentManageExceptionEnums.PUNISHMENT_LEVELS_DONOT_EXIST);
			}
		}
		StudentManageServiceImpl.disConnection(connection);
		return punishmentLevelsInfoList;
	}

}
