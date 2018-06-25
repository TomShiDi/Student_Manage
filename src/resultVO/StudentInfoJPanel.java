package resultVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import entity.StudentInfo;
import service.StudentManageService;
import serviceImpl.StudentManageServiceImpl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class StudentInfoJPanel extends JPanel{
	// 定义组件
	JLabel jLStudentInfoTable = null;//学生信息表
	JLabel jLSelectQueryField = null;//选择查询字段
	JLabel jLEqual = null;//=
	JLabel jLSNo = null;//学号
	JLabel jLSName = null;//姓名
	JLabel jLSSex = null;//性别
	JLabel jLSClass = null;//班级
	JLabel jLSDepartment = null;//院系
	JLabel jLSAddress = null;//籍贯
	JLabel jLSBirthday = null;//生日
	
	JTextField jTFQueryField = null;//查询字段
	JTextField jTFSNo = null;//学号
	JTextField jTFSName = null;//姓名
	JTextField jTFSSex = null;//性别
	JTextField jTFSClass = null;//班级
	JTextField jTFSDepartment = null;//院系
	JTextField jTFSAddress = null;//籍贯
	JTextField jTFSBirthday = null;//生日
	
	JButton jBQuery = null;//查询
	JButton jBQueryAll = null;//查询所有记录
	JButton jBInsert = null;//插入
	JButton jBUpdate = null;//更新
	JButton jBDeleteCurrentRecord = null;//删除当前记录
	JButton jBDeleteAllRecords = null;//删除所有记录
	
	//JComboBox jCBSelectQueryField = null;
	JComboBox<String> jCBSelectQueryField = null;//查询字段
	JPanel jP1, jP2,jP3,jP4,jP5,jP6 = null;
	JPanel jPTop, jPBottom = null;
	DefaultTableModel studentTableModel = null;
	JTable studentJTable = null;
	JScrollPane studentJScrollPane = null;
	Vector studentVector = null;
	Vector titleVector = null;
	
//	private static DbProcess dbProcess;
	String SelectQueryFieldStr = "学号";
	private StudentManageService studentManageService=new StudentManageServiceImpl();
	
	public StudentInfoJPanel() {
		// TODO Auto-generated constructor stub 
		// 创建组件	
		jLStudentInfoTable = new JLabel("学生信息表");
		jLSelectQueryField = new JLabel("选择查询字段");
		jLEqual = new JLabel(" = ");
		jLSNo = new JLabel("学号");
		jLSName = new JLabel("姓名");
		jLSSex = new JLabel("性别");
		jLSClass = new JLabel("班级");
		jLSDepartment = new JLabel("院系");
		jLSAddress = new JLabel("籍贯");
		jLSBirthday = new JLabel("生日");
		
		jTFQueryField = new JTextField(10);//查询字段
		jTFSNo = new JTextField(10);//学号
		jTFSName = new JTextField(10);//姓名
		jTFSSex = new JTextField(10);//性别
		jTFSClass = new JTextField(10);//班级
		jTFSDepartment = new JTextField(10);//院系
		jTFSAddress = new JTextField(10);//籍贯
		jTFSBirthday = new JTextField(10);//生日
		
		jBQuery = new JButton("查询");
		jBQuery.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("执行查询操作");
				queryProcess(jTFQueryField.getText().trim());
			}
		});
		jBQueryAll = new JButton("查询所有记录");
		jBQueryAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("查询所有记录");
				queryAllProcess();
			}
		});
		
		jBInsert = new JButton("插入");
		jBInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				insertProcess();
			}
		});
		jBUpdate = new JButton("更新");
		jBUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("更新操作");
				updateProcess();
			}
		});
		jBDeleteCurrentRecord = new JButton("删除当前记录");
		jBDeleteCurrentRecord.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("删除当前记录");
				deleteCurrentRecordProcess();
			}
		});
		jBDeleteAllRecords = new JButton("删除所有记录");
		jBDeleteAllRecords.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("删除所有记录");
				deleteAllRecordsProcess();
			}
		});
		// 设置监听
//		jBQuery.addActionListener(this);
//		jBQueryAll.addActionListener(this);
//		jBInsert.addActionListener(this);
//		jBUpdate.addActionListener(this);
//		jBDeleteCurrentRecord.addActionListener(this);
//		jBDeleteAllRecords.addActionListener(this);
		
		jCBSelectQueryField = new JComboBox<String>();//查询字段
		jCBSelectQueryField.addItem("学号");  
		jCBSelectQueryField.addItem("姓名");  
		jCBSelectQueryField.addItem("性别");
		jCBSelectQueryField.addItem("班级");
		jCBSelectQueryField.addItem("院系");
		jCBSelectQueryField.addItem("生日");
		jCBSelectQueryField.addItem("籍贯");
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
	
		studentVector = new Vector();
		titleVector = new Vector();
		
		// 定义表头
		titleVector.add("学号");
		titleVector.add("姓名");
		titleVector.add("性别");
		titleVector.add("班级");
		titleVector.add("院系");
		titleVector.add("生日");
		titleVector.add("籍贯");

		
//		this.setLayout(new GridLayout(2,1,0,0));
		studentJTable = new JTable(studentVector, titleVector);
		studentJTable.setPreferredScrollableViewportSize(new Dimension(650,300));
		studentJScrollPane = new JScrollPane(studentJTable);
		//分别设置水平和垂直滚动条自动出现
		studentJScrollPane.setHorizontalScrollBarPolicy(                
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		studentJScrollPane.setVerticalScrollBarPolicy(                
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		//为表格添加监听器 
		studentJTable.addMouseListener(new MouseAdapter()
		{ 
			public void mouseClicked(MouseEvent e) 
			{ 
				int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // 获得行位置
				System.out.println("mouseClicked(). row = " + row);
				Vector v = new Vector();
				v = (Vector) studentVector.get(row);

				jTFSNo.setText((String) v.get(0));// 学号
				jTFSName.setText((String) v.get(1));// 姓名
				jTFSSex.setText((String) v.get(2));// 性别
				jTFSClass.setText((String) v.get(3));// 班级
				jTFSDepartment.setText((String) v.get(4));//院系
				jTFSAddress.setText((String) v.get(6));// 籍贯
				jTFSBirthday.setText((String) v.get(5));//生日
			}
		});


		jP1 = new JPanel();
		jP2 = new JPanel();
		jP3 = new JPanel();
		jP4 = new JPanel();
		jP5 = new JPanel();
		jP6 = new JPanel();
		jPTop = new JPanel();
		jPBottom = new JPanel();
		
//		jP1.add(jLStudentInfoTable,BorderLayout.SOUTH);
//		jP2.setLayout(new BorderLayout());
		jP2.add(studentJScrollPane);
		
		jP3.add(jLSelectQueryField);
		jP3.add(jCBSelectQueryField);
		jP3.add(jLEqual);
		jP3.add(jTFQueryField);
		jP3.add(jBQuery);
		jP3.add(jBQueryAll);
		jP3.setLayout(new FlowLayout(FlowLayout.LEFT));
		jP3.setPreferredSize(new Dimension(20,20));
		
		jP4.add(jLSNo);
		jP4.add(jTFSNo);
		jP4.add(jLSName);
		jP4.add(jTFSName);
		jP4.add(jLSSex);
		jP4.add(jTFSSex);
		jP4.setLayout(new FlowLayout(FlowLayout.LEFT));
		jP4.setPreferredSize(new Dimension(20,20));
	
		jP5.add(jLSClass);
		jP5.add(jTFSClass);
		jP5.add(jLSDepartment);
		jP5.add(jTFSDepartment);
		jP5.add(jLSAddress);
		jP5.add(jTFSAddress);
		jP5.add(jLSBirthday);
		jP5.add(jTFSBirthday);
		jP5.setLayout(new FlowLayout(FlowLayout.LEFT));
//		jP5.setPreferredSize(new Dimension(20,20));
		
		jP6.add(jBInsert);
		jP6.add(jBUpdate);
		jP6.add(jBDeleteCurrentRecord);
		jP6.add(jBDeleteAllRecords);
		jP6.setLayout(new FlowLayout(FlowLayout.LEFT));
		jP6.setPreferredSize(new Dimension(20,20));
		
//		jPTop.add(jP1);
		jPTop.setLayout(new BorderLayout());
		jPTop.add(jP2);
		
		jPBottom.setLayout(new GridLayout(4, 1));
		jPBottom.add(jP3);
		jPBottom.add(jP4);
		jPBottom.add(jP5);
		jPBottom.add(jP6);
		
		this.add("North", jPTop);
		this.add("South", jPBottom);
		
	}
	
	
	public void queryProcess(String sQueryField)
	{
//		try{
			// 建立查询条件
			String sql = "select * from student_info where ";
			String queryFieldStr = jCBSelectQueryFieldTransfer(SelectQueryFieldStr);
			List<StudentInfo> studentInfoList = new ArrayList<StudentInfo>();
			StudentInfo studentInfo=null;

			System.out.println("queryProcess(). sql = " + sql);
			try{
				switch(queryFieldStr)
				{
				case "sNo": studentInfoList = studentManageService.findByStudentId(sQueryField);break;
				case "sName": studentInfoList = studentManageService.findByName(sQueryField);break;
				case "sSex": studentInfoList = studentManageService.findBySex(sQueryField);break;
				case "sClass": studentInfoList = studentManageService.findByClassNum(sQueryField);break;
				case "sDepartment": studentInfoList = studentManageService.findByDepartment(sQueryField);break;
				case "sNativePlace": studentInfoList = studentManageService.findByNativePlace(sQueryField);break;
				case "sBirthday": studentInfoList = studentManageService.findByBirthday(sQueryField);break;
				}
			}catch(SQLException sqlException)
			{
				sqlException.printStackTrace();
			}
			
			studentVector.clear();

			for(StudentInfo studentInfo2:studentInfoList)
			{
				Vector v = new Vector();
				v.add(studentInfo2.getStudentId());
				v.add(studentInfo2.getName());
				v.add(studentInfo2.getSex());
				v.add(studentInfo2.getClassNum());
				v.add(studentInfo2.getDepartment());
				v.add(studentInfo2.getBirthday());
				v.add(studentInfo2.getNative_place());
				studentVector.add(v);
			}
//			
			studentJTable.updateUI();
//

	}
	
	public void queryAllProcess()
	{
		try{
//
			List<StudentInfo> studentInfoList = studentManageService.findAll();
//			// 将查询获得的记录数据，转换成适合生成JTable的数据形式
			studentVector.clear();

//			
			for(StudentInfo studentInfo:studentInfoList)
			{
				Vector v = new Vector();
				v.add(studentInfo.getStudentId());
				v.add(studentInfo.getName());
				v.add(studentInfo.getSex());
				v.add(studentInfo.getClassNum());
				v.add(studentInfo.getDepartment());
				v.add(studentInfo.getBirthday());
				v.add(studentInfo.getNative_place());
				studentVector.add(v);
			}
			studentJTable.updateUI();
		}catch (SQLException sqlException) {
			// TODO: handle exception
			sqlException.printStackTrace();
		}

	}
	
	public void insertProcess()
	{
		String sNo = jTFSNo.getText().trim();
		String sName = jTFSName.getText().trim();
		String sSex = jTFSSex.getText().trim();
		String sClass = jTFSClass.getText().trim();
		String sDepartment = jTFSDepartment.getText().trim();
		String sBirthday = jTFSBirthday.getText().trim();
		String sAddress = jTFSAddress.getText().trim();
		
		StudentInfo studentInfo = new StudentInfo(sNo,sName,sSex,sClass,sDepartment,sBirthday,sAddress);
		

		try{
			studentManageService.addStudentInfo(studentInfo);
		}catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
		}

		queryAllProcess();
	}

	public void updateProcess()
	{
		String sNo = jTFSNo.getText().trim();
		String sName = jTFSName.getText().trim();
		String sSex = jTFSSex.getText().trim();
		String sClass = jTFSClass.getText().trim();
		String sDepartment = jTFSDepartment.getText().trim();
		String sBirthday = jTFSBirthday.getText().trim();
		String sAddress = jTFSAddress.getText().trim();
		
		StudentInfo studentInfo = new StudentInfo(sNo,sName,sSex,sClass,sDepartment,sBirthday,sAddress);
		

		System.out.println("updateProcess()");
		try{
			studentManageService.updateStudentInfo(studentInfo);
		}catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
		}

		queryAllProcess();
	}

	public void deleteCurrentRecordProcess()
	{
		String sNo = jTFSNo.getText().trim();
//		
		
		try{
			studentManageService.deleteStudentInfoById(sNo);
		}catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		queryAllProcess();
	}

	public void deleteAllRecordsProcess()
	{
		
		try{
			studentManageService.deleteAll();
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
		}else if(InputStr.equals("姓名")){
			outputStr = "sName";
		}else if(InputStr.equals("性别")){
			outputStr = "sSex";
		}else if(InputStr.equals("班级")){
			outputStr = "sClass";
		}else if(InputStr.equals("院系")){
			outputStr = "sDepartment";
		}else if(InputStr.equals("籍贯")){
			outputStr = "sNativePlace";
		}else if(InputStr.equals("生日"))
		{
			outputStr = "sBirthday";
		}
		System.out.println("jCBSelectQueryFieldTransfer(). outputStr = " + outputStr);
		return outputStr;
	}
	
}
	

