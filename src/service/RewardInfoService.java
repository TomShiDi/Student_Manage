package service;

import java.sql.SQLException;
import java.util.List;

import entity.RewardInfo;

public interface RewardInfoService {
	
	List<RewardInfo> findAll()throws SQLException;
	List<RewardInfo> findByStudentId(String studentId)throws SQLException;
	List<RewardInfo> findByLevel(String level)throws SQLException;

	List<RewardInfo> findByRecTime(String recTime)throws SQLException;
	List<RewardInfo> findByDescription(String description)throws SQLException;
	List<RewardInfo> findByRewardInfoId(String rewardInfoId)throws SQLException;
	void addRewardInfo(RewardInfo rewardInfo)throws SQLException;
	void deleteRewardInfoById(String rewardInfoId)throws SQLException;
	void updateRewardInfo(RewardInfo rewardInfo)throws SQLException;
	void deleteAll() throws SQLException;
}
