package service;

import java.sql.SQLException;
import java.util.List;

import entity.ChangeCodeInfo;

public interface ChangeLevelsService {

	List<ChangeCodeInfo> findByChangeCodeId(Integer changeCodeId)throws SQLException;
}
