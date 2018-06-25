package resultVO;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import dto.AllInfomationDTO;
import entity.PunishmentInfo;
import service.PunishmentService;
import serviceImpl.AllInfomationServiceImpl;
import serviceImpl.PunishmentServiceImpl;

public class AllInfomationJPanel extends JPanel{
	
	private JTable allInfoMationTable;
	
	String SelectQueryFieldStr = "学号";
	private JTextField textField;
	private JTextField JTFPunishmentId;
	private JTextField JTFStudentId;
	private JTextField JTFLevel;
	private JTextField JTFRecTime;
	private JTextField JTFEnable;
	private JTextField JTFDescription;
	
	private AllInfomationServiceImpl allInfomationServiceImpl = new AllInfomationServiceImpl();
	
	JScrollPane allInfomationJScollPane = null;
	
	Vector titleVector = null;
	Vector allInfomationVector = null;
	
	
	
	/**
	 * Create the panel.
	 */
	PunishmentService punishmentService = new PunishmentServiceImpl();
	
	JComboBox<String> jCBSelectQueryField=null;
	
	
	public AllInfomationJPanel() {

		
		titleVector = new Vector<>();
		allInfomationVector = new Vector<>();
		
		
		titleVector.add("学号");
		titleVector.add("姓名");
		titleVector.add("性别");
		titleVector.add("班级");
		titleVector.add("院系");
		titleVector.add("生日");
		titleVector.add("籍贯");
		titleVector.add("学籍变更代码");
		titleVector.add("学籍变更记录时间");
		titleVector.add("学籍变更描述");
		titleVector.add("奖励级别代码");
		titleVector.add("奖励记录时间");
		titleVector.add("奖励描述");
		titleVector.add("处罚级别代码");
		titleVector.add("处罚记录时间");
		titleVector.add("处罚是否生效");
		titleVector.add("处罚描述");
		
		
		
		this.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel JPTop = new JPanel();
		add(JPTop);
//		JPTop.setLayout(new GridLayout(1, 0, 0, 0));
		JPTop.setLayout(new BorderLayout());
		
		JPanel panel_1 = new JPanel();
		
//		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		panel_1.setLayout(new BorderLayout());
		
		allInfoMationTable = new JTable(allInfomationVector,titleVector);
		
		allInfoMationTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableColumnModel tableColumnModel = allInfoMationTable.getColumnModel();
		Enumeration<TableColumn> enumeration = tableColumnModel.getColumns();
		while(enumeration.hasMoreElements())
		{
			enumeration.nextElement().setWidth(200);
		}
		
		allInfoMationTable.setPreferredScrollableViewportSize(new Dimension(450,400));
		allInfomationJScollPane = new JScrollPane(allInfoMationTable);
		allInfomationJScollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		allInfomationJScollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

//		allInfoMationTable.addMouseListener(new MouseAdapter()
//		{ 
//			public void mouseClicked(MouseEvent e) 
//			{ 
//				int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // 获得行位置
//				System.out.println("mouseClicked(). row = " + row);
//				Vector v = new Vector();
//				v = (Vector) allInfomationVector.get(row);
//
//				JTFPunishmentId.setText((String) v.get(0));// 记录号
//				JTFStudentId.setText((String) v.get(1));// 学号
//				JTFLevel.setText((String) v.get(2));// 级别代码
//				JTFRecTime.setText( v.get(3).toString());// 记录时间
//				JTFEnable.setText((String) v.get(4));//是否生效
//				JTFDescription.setText((String) v.get(5));// 描述
//			}
//		});
		
		
		panel_1.add(allInfomationJScollPane);
		
		JPanel panel_2 = new JPanel();
//		panel_2.add(punishmentJScollPane);
//		JPTop.add(panel_2);
		JPTop.add(panel_1);
		JPanel JPBottom = new JPanel();
		add(JPBottom);
		JPBottom.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		JPBottom.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("选择查询字段");
		
		jCBSelectQueryField = new JComboBox<String>();//查询字段
		jCBSelectQueryField.addItem("学号");
		jCBSelectQueryField.addItemListener(new ItemListener() {//下拉框事件监听  
            public void itemStateChanged(ItemEvent event) {  
                switch (event.getStateChange()) {  
                case ItemEvent.SELECTED:  
                	SelectQueryFieldStr = (String) event.getItem();  
                    System.out.println("选中：" + SelectQueryFieldStr);  
                    break;  
                case ItemEvent.DESELECTED:  
                    System.out.println("取消选中：" + event.getItem());  
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
				System.out.println("执行查询操作");
				queryProcess(textField.getText().trim());
			}
		});
		panel_3.add(queryButton);
		
//		JButton queryAllButton = new JButton("\u67E5\u8BE2\u6240\u6709\u8BB0\u5F55");
//		queryAllButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println("查询所有记录");
//				queryAllProcess();
//			}
//		});
//		
//		panel_3.add(queryAllButton);
		
		JPanel panel_4 = new JPanel();
		JPBottom.add(panel_4);
		
//		JLabel label_1 = new JLabel("\u8BB0\u5F55\u53F7");
//		panel_4.add(label_1);
		
//		JTFPunishmentId = new JTextField();
//		JTFPunishmentId.setEnabled(false);
//		panel_4.add(JTFPunishmentId);
//		JTFPunishmentId.setColumns(10);
//		
//		JLabel label_2 = new JLabel("\u5B66\u53F7");
//		panel_4.add(label_2);
//		
//		JTFStudentId = new JTextField();
//		panel_4.add(JTFStudentId);
//		JTFStudentId.setColumns(10);
//		
//		JLabel label_3 = new JLabel("\u7EA7\u522B\u4EE3\u7801");
//		panel_4.add(label_3);
//		
//		JTFLevel = new JTextField();
//		panel_4.add(JTFLevel);
//		JTFLevel.setColumns(10);
//		
//		JPanel panel_5 = new JPanel();
//		JPBottom.add(panel_5);
//		
////		JLabel label_4 = new JLabel("\u8BB0\u5F55\u65F6\u95F4");
////		panel_5.add(label_4);
//		
//		JTFRecTime = new JTextField();
////		panel_5.add(JTFRecTime);
////		JTFRecTime.setColumns(10);
//		
//		JLabel label_5 = new JLabel("\u662F\u5426\u751F\u6548");
//		panel_5.add(label_5);
//		
//		JTFEnable = new JTextField();
//		panel_5.add(JTFEnable);
//		JTFEnable.setColumns(10);
//		
//		JLabel label_6 = new JLabel("\u63CF\u8FF0");
//		panel_5.add(label_6);
//		
//		JTFDescription = new JTextField();
//		panel_5.add(JTFDescription);
//		JTFDescription.setColumns(20);
//		
//		JPanel panel_6 = new JPanel();
//		JPBottom.add(panel_6);
//		
//		JButton insertButton = new JButton("插入");
//		insertButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println("执行插入操作");
//				insertProcess();
//			}
//		});
//		
//		panel_6.add(insertButton);
//		
//		JButton updateButton = new JButton("\u66F4\u65B0");
//		updateButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println("执行更新操作");
//				updateProcess();
//			}
//		});
//		
//		panel_6.add(updateButton);
//		
//		JButton deleteButton = new JButton("\u5220\u9664\u5F53\u524D\u8BB0\u5F55");
//		deleteButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println("执行删除操作");
//				deleteCurrentRecordProcess();
//			}
//		});
//		
//		panel_6.add(deleteButton);
//		
//		JButton deleteAllButton = new JButton("\u5220\u9664\u6240\u6709\u8BB0\u5F55");
//		deleteAllButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println("执行删除所有记录操作");
//				deleteAllRecordsProcess();
//			}
//		});
//		
//		panel_6.add(deleteAllButton);
//		
////		this.setVisible(true);
////		this.add("north",JPTop);
////		this.add("south", JPBottom);
//
	}
	
	
	public void queryProcess(String sQueryField)
	{
		String queryFieldStr = jCBSelectQueryFieldTransfer(SelectQueryFieldStr);
		List<AllInfomationDTO> allInfomationDTOList = new ArrayList<>();
		
		
		try{
			switch(queryFieldStr)
			{
			case "sNo": 
				{
					allInfomationDTOList = allInfomationServiceImpl.findByStudentId(textField.getText().trim());
				}
			}
		}catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		
		allInfomationVector.clear();
		
		for(AllInfomationDTO allInfomationDTO: allInfomationDTOList)
		{
			Vector v = new Vector();
			v.add(allInfomationDTO.getStudentId());
			v.add(allInfomationDTO.getName());
			v.add(allInfomationDTO.getSex());
			v.add(allInfomationDTO.getClassNum());
			v.add(allInfomationDTO.getDepartment());
			v.add(allInfomationDTO.getBirthday());
			v.add(allInfomationDTO.getNative_place());
			v.add(allInfomationDTO.getChangeCode());
			v.add(allInfomationDTO.getChangeRecTime());
			v.add(allInfomationDTO.getChangeDescription());
			v.add(allInfomationDTO.getRewardLevels());
			v.add(allInfomationDTO.getRewardDescription());
			v.add(allInfomationDTO.getRewardRecTime());
			v.add(allInfomationDTO.getPunishmentLevels());
			v.add(allInfomationDTO.getPunishmentEnable());
			v.add(allInfomationDTO.getPunishmentDiscription());
			v.add(allInfomationDTO.getPunishmentRecTime());
			
			allInfomationVector.add(v);
		}
//		
		allInfoMationTable.updateUI();
		
		
	}
	
	
	public void queryAllProcess()
	{
		try{
			List<AllInfomationDTO> allInfomationDTOList = allInfomationServiceImpl.findAll();
//			// 将查询获得的记录数据，转换成适合生成JTable的数据形式
			allInfomationVector.clear();

			for(AllInfomationDTO allInfomationDTO: allInfomationDTOList)
			{
				Vector v = new Vector();
				v.add(allInfomationDTO.getStudentId());
				v.add(allInfomationDTO.getName());
				v.add(allInfomationDTO.getSex());
				v.add(allInfomationDTO.getClassNum());
				v.add(allInfomationDTO.getDepartment());
				v.add(allInfomationDTO.getBirthday());
				v.add(allInfomationDTO.getNative_place());
				v.add(allInfomationDTO.getChangeCode());
				v.add(allInfomationDTO.getChangeRecTime());
				v.add(allInfomationDTO.getChangeDescription());
				v.add(allInfomationDTO.getRewardLevels());
				v.add(allInfomationDTO.getRewardDescription());
				v.add(allInfomationDTO.getRewardRecTime());
				v.add(allInfomationDTO.getPunishmentLevels());
				v.add(allInfomationDTO.getPunishmentEnable());
				v.add(allInfomationDTO.getPunishmentDiscription());
				v.add(allInfomationDTO.getPunishmentRecTime());
				
				allInfomationVector.add(v);
			}
//			
			allInfoMationTable.updateUI();
		}catch (SQLException sqlException) {
			// TODO: handle exception
			sqlException.printStackTrace();
		}
	}
	
	
//	public void insertProcess()
//	{
////		String punishmentId = JTFPunishmentId.getText().trim();
//		String studentId= JTFStudentId.getText().trim();
//		String level = JTFLevel.getText().trim();
//		String enable = JTFEnable.getText().trim();
//		String description = JTFDescription.getText().trim();
//		
//		PunishmentInfo punishmentInfo = new PunishmentInfo(null, studentId, level, enable, description);
//
//		try{
//			punishmentService.addPunishmentInfo(punishmentInfo);
//		}catch(SQLException sqlException)
//		{
//			sqlException.printStackTrace();
//		}
//
//		queryAllProcess();
//	}
//	
//	public void updateProcess()
//	{
//		String punishmentId = JTFPunishmentId.getText().trim();
//		String studentId= JTFStudentId.getText().trim();
//		String level = JTFLevel.getText().trim();
//		String enable = JTFEnable.getText().trim();
//		String description = JTFDescription.getText().trim();
//		
//		PunishmentInfo punishmentInfo = new PunishmentInfo(punishmentId, studentId, level,enable, description);
//		
//		System.out.println("updateProcess()");
//		try{
//			punishmentService.updatePunishimentInfo(punishmentInfo);
//		}catch(SQLException sqlException)
//		{
//			sqlException.printStackTrace();
//		}
//		queryAllProcess();
//	}
//	
//	public void deleteCurrentRecordProcess()
//	{
//		String punishmentId = JTFPunishmentId.getText().trim();
////		
//		
//		try{
//			punishmentService.deletePunishimentInfoById(punishmentId);
//		}catch(SQLException sqlException)
//		{
//			sqlException.printStackTrace();
//		}
//
//		queryAllProcess();
//	}
//	
//	
//	public void deleteAllRecordsProcess()
//	{
//
//		try{
//			punishmentService.deleteAll();
//		}catch(SQLException sqlException)
//		{
//			sqlException.printStackTrace();
//		}
//		
//		queryAllProcess();
//	}
	
	public String jCBSelectQueryFieldTransfer(String InputStr)
	{
		String outputStr = "";
		System.out.println("jCBSelectQueryFieldTransfer(). InputStr = " + InputStr);
		
		if(InputStr.equals("学号")){
			outputStr = "sNo";
		}
		System.out.println("jCBSelectQueryFieldTransfer(). outputStr = " + outputStr);
		return outputStr;
	}

}
