import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.mysql.jdbc.interceptors.ServerStatusDiffInterceptor;

import entity.StudentInfo;
import resultVO.AllInfomationJPanel;
import resultVO.ChangeInfoJPanel;
import resultVO.DatabaseCourseDesign;
import resultVO.PunishmentJPanel;
import resultVO.RewardInfoJPanel;
import resultVO.StudentInfoJPanel;
import serviceImpl.StudentManageServiceImpl;

public class ApplicationStart {
	public static void main(String args[])throws SQLException
	{
		
		JTabbedPane jTabbedPane = new JTabbedPane();
		PunishmentJPanel punishmentJPanel = new PunishmentJPanel();
		StudentInfoJPanel studentInfoJPanel = new StudentInfoJPanel();
		ChangeInfoJPanel changeInfoJPanel = new ChangeInfoJPanel();  
		RewardInfoJPanel rewardInfoJPanel = new RewardInfoJPanel();
		AllInfomationJPanel allInfomationJPanel = new AllInfomationJPanel();
		jTabbedPane.addTab("学生基本信息管理", studentInfoJPanel);
		jTabbedPane.addTab("学籍变更信息管理", changeInfoJPanel);
		jTabbedPane.addTab("奖励信息管理", rewardInfoJPanel);
		jTabbedPane.addTab("处罚信息管理", punishmentJPanel);
		jTabbedPane.addTab("学生个人全部信息查询", allInfomationJPanel);
		
		JFrame jFrame = new JFrame();
		jFrame.setSize(new Dimension(800,600));
		
		jFrame.setLayout(new GridLayout(1, 1));
		ImageIcon imageIcon = new ImageIcon("D:\\1.jpg");
		jFrame.add(jTabbedPane);
		jFrame.setTitle("学生管理系统");
		jFrame.setIconImage(imageIcon.getImage());
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
		
//		new AllInfomationServiceImpl().findByStudentId("3"); 
		
//		JFrame jFrame = new JFrame();
//		jFrame.setSize(600, 600);
//		jFrame.add(allInfomationJPanel);
//		jFrame.setVisible(true);
//		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
