package resultVO;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.PunishmentInfo;
import entity.RewardInfo;
import entity.StudentInfo;
import service.PunishmentService;
import service.RewardInfoService;
import serviceImpl.PunishmentServiceImpl;
import serviceImpl.RewardInfoServiceImpl;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RewardInfoJPanel extends JPanel {
	private JTable rewardInfoTable;
	
	String SelectQueryFieldStr = "��¼��";
	private JTextField textField;
	private JTextField JTFRewardId;
	private JTextField JTFStudentId;
	private JTextField JTFLevel;
	private JTextField JTFRecTime;
	private JTextField JTFDescription;
	
	JScrollPane rewardJScollPane = null;
	
	Vector titleVector = null;
	Vector rewardVector = null;
	
	
	
	/**
	 * Create the panel.
	 */
	RewardInfoService rewardInfoService = new RewardInfoServiceImpl();
	
	JComboBox<String> jCBSelectQueryField=null;
	
	
	public RewardInfoJPanel() {
		
		titleVector = new Vector<>();
		rewardVector = new Vector<>();
		
		
		titleVector.add("��¼��");
		titleVector.add("ѧ��");
		titleVector.add("�������");
		titleVector.add("��¼ʱ��");
		titleVector.add("����");
		
		
		
		
		
		this.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel JPTop = new JPanel();
		add(JPTop);
//		JPTop.setLayout(new GridLayout(1, 0, 0, 0));
		JPTop.setLayout(new BorderLayout());
		
		JPanel panel_1 = new JPanel();
		
//		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		panel_1.setLayout(new BorderLayout());
		
		rewardInfoTable = new JTable(rewardVector,titleVector);
		
		rewardInfoTable.setPreferredScrollableViewportSize(new Dimension(450,160));
		rewardJScollPane = new JScrollPane(rewardInfoTable);
		rewardJScollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		rewardJScollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		rewardInfoTable.addMouseListener(new MouseAdapter()
		{ 
			public void mouseClicked(MouseEvent e) 
			{ 
				int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // �����λ��
				System.out.println("mouseClicked(). row = " + row);
				Vector v = new Vector();
				v = (Vector) rewardVector.get(row);

				JTFRewardId.setText((String) v.get(0));// ��¼��
				JTFStudentId.setText((String) v.get(1));// ѧ��
				JTFLevel.setText((String) v.get(2));// �������
				JTFRecTime.setText(v.get(3).toString());// ��¼ʱ��
				JTFDescription.setText((String)v.get(4));// ����
			}
		});
		
		
		panel_1.add(rewardJScollPane);
		
		JPanel panel_2 = new JPanel();
//		panel_2.add(punishmentJScollPane);
//		JPTop.add(panel_2);
		JPTop.add(panel_1);
		JPanel JPBottom = new JPanel();
		add(JPBottom);
		JPBottom.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		JPBottom.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("ѡ���ѯ�ֶ�");
		
		jCBSelectQueryField = new JComboBox<String>();//��ѯ�ֶ�
		jCBSelectQueryField.addItem("��¼��");  
		jCBSelectQueryField.addItem("ѧ��");  
		jCBSelectQueryField.addItem("�������");
		jCBSelectQueryField.addItem("��¼ʱ��");
		jCBSelectQueryField.addItem("����");
		jCBSelectQueryField.addItemListener(new ItemListener() {//�������¼�����  
            public void itemStateChanged(ItemEvent event) {  
                switch (event.getStateChange()) {  
                case ItemEvent.SELECTED:  
                	SelectQueryFieldStr = (String) event.getItem();  
                    System.out.println("ѡ�У�" + SelectQueryFieldStr);  
                    break;  
                case ItemEvent.DESELECTED:  
                    System.out.println("ȡ��ѡ�У�" + event.getItem());  
                    break;  
                }  
            }  
        });
		
		
		panel_3.add(lblNewLabel);
		panel_3.add(jCBSelectQueryField);
		
		JLabel label = new JLabel("=");
		panel_3.add(label);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JButton queryButton = new JButton("\u67E5\u8BE2");
		queryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ִ�в�ѯ����");
				queryProcess(textField.getText().trim());
			}
		});
		panel_3.add(queryButton);
		
		JButton queryAllButton = new JButton("\u67E5\u8BE2\u6240\u6709\u8BB0\u5F55");
		queryAllButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("��ѯ���м�¼");
				queryAllProcess();
			}
		});
		
		panel_3.add(queryAllButton);
		
		JPanel panel_4 = new JPanel();
		JPBottom.add(panel_4);
		
		JLabel label_1 = new JLabel("\u8BB0\u5F55\u53F7");
		panel_4.add(label_1);
		
		JTFRewardId = new JTextField();
		JTFRewardId.setEditable(false);
		panel_4.add(JTFRewardId);
		JTFRewardId.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5B66\u53F7");
		panel_4.add(label_2);
		
		JTFStudentId = new JTextField();
		panel_4.add(JTFStudentId);
		JTFStudentId.setColumns(10);
		
		JLabel label_3 = new JLabel("\u7EA7\u522B\u4EE3\u7801");
		panel_4.add(label_3);
		
		JTFLevel = new JTextField();
		panel_4.add(JTFLevel);
		JTFLevel.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		JPBottom.add(panel_5);
		
//		JLabel label_4 = new JLabel("\u8BB0\u5F55\u65F6\u95F4");
//		panel_5.add(label_4);
		
		JTFRecTime = new JTextField();
//		panel_5.add(JTFRecTime);
//		JTFRecTime.setColumns(10);
		
//		JLabel label_5 = new JLabel("\u662F\u5426\u751F\u6548");
//		panel_5.add(label_5);
		
//		JTFEnable = new JTextField();
//		panel_5.add(JTFEnable);
//		JTFEnable.setColumns(10);
		
		JLabel label_6 = new JLabel("\u63CF\u8FF0");
		panel_5.add(label_6);
		
		JTFDescription = new JTextField();
		panel_5.add(JTFDescription);
		JTFDescription.setColumns(20);
		
		JPanel panel_6 = new JPanel();
		JPBottom.add(panel_6);
		
		JButton insertButton = new JButton("����");
		insertButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("ִ�в������");
				insertProcess();
			}
		});
		
		panel_6.add(insertButton);
		
		JButton updateButton = new JButton("\u66F4\u65B0");
		updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("ִ�и��²���");
				updateProcess();
			}
		});
		
		panel_6.add(updateButton);
		
		JButton deleteButton = new JButton("\u5220\u9664\u5F53\u524D\u8BB0\u5F55");
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("ִ��ɾ������");
				deleteCurrentRecordProcess();
			}
		});
		
		panel_6.add(deleteButton);
		
		JButton deleteAllButton = new JButton("\u5220\u9664\u6240\u6709\u8BB0\u5F55");
		deleteAllButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("ִ��ɾ�����м�¼����");
				deleteAllRecordsProcess();
			}
		});
		
		panel_6.add(deleteAllButton);
		


	}
	
	
	public void queryProcess(String sQueryField)
	{
		String queryFieldStr = jCBSelectQueryFieldTransfer(SelectQueryFieldStr);
		List<RewardInfo> rewardInfoList = new ArrayList<RewardInfo>();
		
		
		try{
			switch(queryFieldStr)
			{
			case "sNo": rewardInfoList = rewardInfoService.findByStudentId(sQueryField);break;
			case "rewardId": rewardInfoList = rewardInfoService.findByRewardInfoId(sQueryField);break;
			case "level": rewardInfoList = rewardInfoService.findByLevel(sQueryField);break;
			case "recTime": rewardInfoList = rewardInfoService.findByRecTime(sQueryField);break;
			case "description": rewardInfoList = rewardInfoService.findByDescription(sQueryField);break;
			}
		}catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		
		rewardVector.clear();
		
		for(RewardInfo rewardInfo: rewardInfoList)
		{
			Vector v = new Vector();
			v.add(rewardInfo.getId());
			v.add(rewardInfo.getStudentId());
			v.add(rewardInfo.getLevels());
			v.add(rewardInfo.getRec_time());
			v.add(rewardInfo.getDescription());
			rewardVector.add(v);
		}
//		
		rewardInfoTable.updateUI();
		
		
	}
	
	
	public void queryAllProcess()
	{
		try{
			List<RewardInfo> rewardInfoList = rewardInfoService.findAll();
//			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
			rewardVector.clear();

			for(RewardInfo rewardInfo: rewardInfoList)
			{
				Vector v = new Vector();
				v.add(rewardInfo.getId());
				v.add(rewardInfo.getStudentId());
				v.add(rewardInfo.getLevels());
				v.add(rewardInfo.getRec_time());
				v.add(rewardInfo.getDescription());
				rewardVector.add(v);
			}
			rewardInfoTable.updateUI();
		}catch (SQLException sqlException) {
			// TODO: handle exception
			sqlException.printStackTrace();
		}
	}
	
	
	public void insertProcess()
	{
		String rewardId = JTFRewardId.getText().trim();
		String studentId= JTFStudentId.getText().trim();
		String level = JTFLevel.getText().trim();
		String recTime = JTFRecTime.getText().trim();
		String description = JTFDescription.getText().trim();
		
		RewardInfo rewardInfo = new RewardInfo(rewardId, studentId, level, description);

		try{
			rewardInfoService.addRewardInfo(rewardInfo);
		}catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
		}

		queryAllProcess();
	}
	
	public void updateProcess()
	{
		String rewardId = JTFRewardId.getText().trim();
		String studentId= JTFStudentId.getText().trim();
		String level = JTFLevel.getText().trim();
		String recTime = JTFRecTime.getText().trim();
		String description = JTFDescription.getText().trim();
		
		RewardInfo rewardInfo = new RewardInfo(rewardId, studentId, level, description);

		
		System.out.println("updateProcess()");
		try{
			rewardInfoService.updateRewardInfo(rewardInfo);
		}catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		queryAllProcess();
	}
	
	public void deleteCurrentRecordProcess()
	{
		String rewardId = JTFRewardId.getText().trim();
//		
		
		try{
			rewardInfoService.deleteRewardInfoById(rewardId);
		}catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
		}

		queryAllProcess();
	}
	
	
	public void deleteAllRecordsProcess()
	{

		try{
			rewardInfoService.deleteAll();
		}catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		
		queryAllProcess();
	}
	
	public String jCBSelectQueryFieldTransfer(String InputStr)
	{
		String outputStr = "";
		System.out.println("jCBSelectQueryFieldTransfer(). InputStr = " + InputStr);
		
		if(InputStr.equals("ѧ��")){
			outputStr = "sNo";
		}else if(InputStr.equals("��¼��")){
			outputStr = "rewardId";
		}else if(InputStr.equals("�������")){
			outputStr = "level";
		}else if(InputStr.equals("��¼ʱ��")){
			outputStr = "recTime";
		}else if(InputStr.equals("����")){
			outputStr = "description";
		}
		System.out.println("jCBSelectQueryFieldTransfer(). outputStr = " + outputStr);
		return outputStr;
	}
}
