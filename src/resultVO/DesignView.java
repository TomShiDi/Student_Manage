package resultVO;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.PunishmentInfo;
import entity.StudentInfo;
import service.PunishmentService;
import serviceImpl.PunishmentServiceImpl;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class DesignView extends JPanel {
	private JTable punishmentInfoTable;
	
	String SelectQueryFieldStr = "学号";
	private JTextField textField;
	private JTextField JTFPunishmentId;
	private JTextField JTFStudentId;
	private JTextField JTFLevel;
	private JTextField JTFRecTime;
	private JTextField JTFEnable;
	private JTextField JTFDescription;
	
	Vector titleVector = new Vector<>();
	Vector punishmentVector = new Vector<>();
	
	/**
	 * Create the panel.
	 */
	PunishmentService punishmentService = new PunishmentServiceImpl();
	JComboBox<String> jCBSelectQueryField=null;
	
	public DesignView() {
		
		titleVector.add("记录号");
		titleVector.add("学号");
		titleVector.add("级别代码");
		titleVector.add("记录时间");
		titleVector.add("是否生效");
		titleVector.add("描述");
		
		
		
		setLayout(new GridLayout(2, 1, 0, 0));
		JScrollPane punishmentJScollPane = new JScrollPane(punishmentInfoTable);
		
		JPanel JPTop = new JPanel();
		add(JPTop);
		JPTop.setLayout(new BorderLayout(0, 0));
//		JPTop.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
//		JPTop.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 1, 0, 0));
		
		punishmentInfoTable = new JTable(punishmentVector,titleVector);
		
		punishmentInfoTable.setPreferredScrollableViewportSize(new Dimension(450,160));
		
		punishmentJScollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		punishmentJScollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		panel_1.add(punishmentInfoTable);
		
		JPanel panel_2 = new JPanel();
		panel_2.add(punishmentJScollPane);
		JPTop.add(panel_2);
		
		JPanel JPBottom = new JPanel();
		add(JPBottom);
		JPBottom.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		JPBottom.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("选择查询字段");
		
		jCBSelectQueryField = new JComboBox<String>();//查询字段
		jCBSelectQueryField.addItem("记录号");  
		jCBSelectQueryField.addItem("学号");  
		jCBSelectQueryField.addItem("级别");
		jCBSelectQueryField.addItem("记录时间");
		jCBSelectQueryField.addItem("是否生效");
		jCBSelectQueryField.addItem("描述");
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
				queryProcess(SelectQueryFieldStr);
			}
		});
		panel_3.add(queryButton);
		
		JButton queryAllButton = new JButton("\u67E5\u8BE2\u6240\u6709\u8BB0\u5F55");
		
		panel_3.add(queryAllButton);
		
		JPanel panel_4 = new JPanel();
		JPBottom.add(panel_4);
		
		JLabel label_1 = new JLabel("\u8BB0\u5F55\u53F7");
		panel_4.add(label_1);
		
		JTFPunishmentId = new JTextField();
		panel_4.add(JTFPunishmentId);
		JTFPunishmentId.setColumns(10);
		
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
		
		JLabel label_4 = new JLabel("\u8BB0\u5F55\u65F6\u95F4");
		panel_5.add(label_4);
		
		JTFRecTime = new JTextField();
		panel_5.add(JTFRecTime);
		JTFRecTime.setColumns(10);
		
		JLabel label_5 = new JLabel("\u662F\u5426\u751F\u6548");
		panel_5.add(label_5);
		
		JTFEnable = new JTextField();
		panel_5.add(JTFEnable);
		JTFEnable.setColumns(10);
		
		JLabel label_6 = new JLabel("\u63CF\u8FF0");
		panel_5.add(label_6);
		
		JTFDescription = new JTextField();
		panel_5.add(JTFDescription);
		JTFDescription.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		JPBottom.add(panel_6);
		
		JButton insertButton = new JButton("插入");
		
		panel_6.add(insertButton);
		
		JButton updateButton = new JButton("\u66F4\u65B0");
		
		panel_6.add(updateButton);
		
		JButton deleteButton = new JButton("\u5220\u9664\u5F53\u524D\u8BB0\u5F55");
		
		panel_6.add(deleteButton);
		
		JButton deleteAllButton = new JButton("\u5220\u9664\u6240\u6709\u8BB0\u5F55");
		
		panel_6.add(deleteAllButton);
		
		this.setVisible(true);
		

	}
	
	
	public void queryProcess(String sQueryField)
	{
		String queryFieldStr = jCBSelectQueryFieldTransfer(SelectQueryFieldStr);
		List<PunishmentInfo> punishmentInfoList = new ArrayList<PunishmentInfo>();
		
		
		try{
			switch(queryFieldStr)
			{
			case "sNo": punishmentInfoList = punishmentService.findByStudentId(sQueryField);break;
			case "punishmId": punishmentInfoList = punishmentService.findByPunishimentInfoId(sQueryField);break;
			case "level": punishmentInfoList = punishmentService.findByLevel(sQueryField);break;
			case "recTime": punishmentInfoList = punishmentService.findByRecTime(sQueryField);break;
			case "enable": punishmentInfoList = punishmentService.findByEnable(sQueryField);break;
			case "description": punishmentInfoList = punishmentService.findByDescription(sQueryField);break;
			}
		}catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		
		punishmentVector.clear();
		
		for(PunishmentInfo punishmentInfo: punishmentInfoList)
		{
			Vector v = new Vector();
			v.add(punishmentInfo.getId());
			v.add(punishmentInfo.getStudentid());
			v.add(punishmentInfo.getLevels());
			v.add(punishmentInfo.getRec_time());
			v.add(punishmentInfo.getEnable());
			v.add(punishmentInfo.getDiscription());
			punishmentVector.add(v);
		}
//		
		punishmentInfoTable.updateUI();
		
		
	}
	
	
	public void queryAllProcess()
	{
		try{
			List<PunishmentInfo> punishmentInfoList = punishmentService.findAll();
//			// 将查询获得的记录数据，转换成适合生成JTable的数据形式
			punishmentVector.clear();

			for(PunishmentInfo punishmentInfo:punishmentInfoList)
			{
				Vector v = new Vector();
				v.add(punishmentInfo.getId());
				v.add(punishmentInfo.getStudentid());
				v.add(punishmentInfo.getLevels());
				v.add(punishmentInfo.getRec_time());
				v.add(punishmentInfo.getEnable());
				v.add(punishmentInfo.getDiscription());
				punishmentVector.add(v);
			}
			punishmentInfoTable.updateUI();
		}catch (SQLException sqlException) {
			// TODO: handle exception
			sqlException.printStackTrace();
		}
	}
	
	
	public void insertProcess()
	{
		String punishmentId = JTFPunishmentId.getText().trim();
		String studentId= JTFStudentId.getText().trim();
		String level = JTFLevel.getText().trim();
		String recTime = JTFRecTime.getText().trim();
		String enable = JTFEnable.getText().trim();
		String description = JTFDescription.getText().trim();
		
		PunishmentInfo punishmentInfo = new PunishmentInfo(punishmentId, studentId, level, enable, description);

		try{
			punishmentService.addPunishmentInfo(punishmentInfo);
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
		
		if(InputStr.equals("学号")){
			outputStr = "sNo";
		}else if(InputStr.equals("记录号")){
			outputStr = "punishmId";
		}else if(InputStr.equals("级别代码")){
			outputStr = "level";
		}else if(InputStr.equals("记录时间")){
			outputStr = "recTime";
		}else if(InputStr.equals("是否生效")){
			outputStr = "enable";
		}else if(InputStr.equals("描述")){
			outputStr = "description";
		}
		System.out.println("jCBSelectQueryFieldTransfer(). outputStr = " + outputStr);
		return outputStr;
	}
}
