package serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.ChangeCodeInfo;
import entity.RewardLevelsInfo;
import resultException.StudentManageExceptionEnums;
import resultException.StudentResultException;
import service.RewardLevelsService;

public class RewardLevelsServiceImpl implements RewardLevelsService {

	@Override
	public List<RewardLevelsInfo> findByRewardLevelsId(Integer rewardLevelsId) throws SQLException {
		// TODO Auto-generated method stub
		String sql=String.format("select * from reward_levels_info where code=%s", rewardLevelsId.toString());
		Connection connection=StudentManageServiceImpl.getConnection();
		PreparedStatement preparedStatement=null;
		List<RewardLevelsInfo> rewardLevelsInfoList=new ArrayList<>();
		ResultSet resultSet=null;
		RewardLevelsInfo result=null;
		try{
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			resultSet.next();
			RewardLevelsInfo rewardLevelsInfo = new RewardLevelsInfo();
			rewardLevelsInfo.setCode(resultSet.getInt("code"));
			rewardLevelsInfo.setDescription(resultSet.getString("description"));
			rewardLevelsInfoList.add(rewardLevelsInfo);
			result=rewardLevelsInfo;
			
		}catch(Exception e)
		{
			if(result==null)
			{
				JOptionPane.showMessageDialog(null, "奖励等级不存在","错误提示",JOptionPane.ERROR_MESSAGE);
				throw new StudentResultException(StudentManageExceptionEnums.CHANGE_CODE_DONOT_EXIST);
			}
		}
		StudentManageServiceImpl.disConnection(connection);
		return rewardLevelsInfoList;
	}

}
