package service;

import java.sql.SQLException;
import java.util.List;

import entity.PunishmentInfo;

public interface PunishmentService {
	List<PunishmentInfo> findAll()throws SQLException;
	List<PunishmentInfo> findByStudentId(String studentId)throws SQLException;
	List<PunishmentInfo> findByLevel(String level)throws SQLException;
//	List<StudentInfo> findByClass(String classNum);
	List<PunishmentInfo> findByRecTime(String recTime)throws SQLException;
	List<PunishmentInfo> findByEnable(String enable)throws SQLException;
	List<PunishmentInfo> findByDescription(String description)throws SQLException;
	List<PunishmentInfo> findByPunishimentInfoId(String punishmentId)throws SQLException;
	void addPunishmentInfo(PunishmentInfo punishmentInfo)throws SQLException;
	void deletePunishimentInfoById(String punishmentId)throws SQLException;
	void updatePunishimentInfo(PunishmentInfo punishimentInfo)throws SQLException;
	void deleteAll() throws SQLException;
}
