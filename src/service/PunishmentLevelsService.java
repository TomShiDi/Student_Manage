package service;

import java.sql.SQLException;
import java.util.List;

import entity.PunishmentLevelsInfo;

public interface PunishmentLevelsService {

	List<PunishmentLevelsInfo> findByPunishmentLevelsId(Integer punishmentLevelsId)throws SQLException;
}
