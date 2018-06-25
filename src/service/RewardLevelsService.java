package service;

import java.sql.SQLException;
import java.util.List;

import entity.RewardLevelsInfo;

public interface RewardLevelsService {

	List<RewardLevelsInfo> findByRewardLevelsId(Integer rewardLevelsId)throws SQLException; 
}
