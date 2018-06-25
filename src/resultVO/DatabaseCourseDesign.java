
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DatabaseCourseDesign extends JFrame implements ActionListener {
	// �������
	JLabel jLStudentInfoTable = null;//ѧ����Ϣ��
	JLabel jLSelectQueryField = null;//ѡ���ѯ�ֶ�
	JLabel jLEqual = null;//=
	JLabel jLSNo = null;//ѧ��
	JLabel jLSName = null;//����
	JLabel jLSSex = null;//�Ա�
	JLabel jLSClass = null;//�༶
	JLabel jLSDepartment = null;//Ժϵ
	JLabel jLSAddress = null;//����
	JLabel jLSBirthday = null;//����
	
	JTextField jTFQueryField = null;//��ѯ�ֶ�
	JTextField jTFSNo = null;//ѧ��
	JTextField jTFSName = null;//����
	JTextField jTFSSex = null;//�Ա�
	JTextField jTFSClass = null;//�༶
	JTextField jTFSDepartment = null;//Ժϵ
	JTextField jTFSAddress = null;//����
	JTextField jTFSBirthday = null;//����
	
	JButton jBQuery = null;//��ѯ
	JButton jBQueryAll = null;//��ѯ���м�¼
	JButton jBInsert = null;//����
	JButton jBUpdate = null;//����
	JButton jBDeleteCurrentRecord = null;//ɾ����ǰ��¼
	JButton jBDeleteAllRecords = null;//ɾ�����м�¼
	
	//JComboBox jCBSelectQueryField = null;
	JComboBox<String> jCBSelectQueryField = null;//��ѯ�ֶ�
	JPanel jP1, jP2,jP3,jP4,jP5,jP6 = null;
	JPanel jPTop, jPBottom = null;
	DefaultTableModel studentTableModel = null;
	JTable studentJTable = null;
	JScrollPane studentJScrollPane = null;
	Vector studentVector = null;
	Vector titleVector = null;
	
//	private static DbProcess dbProcess;
	String SelectQueryFieldStr = "ѧ��";
	private StudentManageService studentManageService=new StudentManageServiceImpl();
	
	
	// ���캯��
	public DatabaseCourseDesign() {
		// �������	
		jLStudentInfoTable = new JLabel("ѧ����Ϣ��");
		jLSelectQueryField = new JLabel("ѡ���ѯ�ֶ�");
		jLEqual = new JLabel(" = ");
		jLSNo = new JLabel("ѧ��");
		jLSName = new JLabel("����");
		jLSSex = new JLabel("�Ա�");
		jLSClass = new JLabel("�༶");
		jLSDepartment = new JLabel("Ժϵ");
		jLSAddress = new JLabel("����");
		jLSBirthday = new JLabel("����");
		
		jTFQueryField = new JTextField(10);//��ѯ�ֶ�
		jTFSNo = new JTextField(10);//ѧ��
		jTFSName = new JTextField(10);//����
		jTFSSex = new JTextField(10);//�Ա�
		jTFSClass = new JTextField(10);//�༶
		jTFSDepartment = new JTextField(10);//Ժϵ
		jTFSAddress = new JTextField(10);//����
		jTFSBirthday = new JTextField(10);//����
		
		jBQuery = new JButton("��ѯ");
		jBQueryAll = new JButton("��ѯ���м�¼");
		jBInsert = new JButton("����");
		jBUpdate = new JButton("����");
		jBDeleteCurrentRecord = new JButton("ɾ����ǰ��¼");
		jBDeleteAllRecords = new JButton("ɾ�����м�¼");
		// ���ü���
		jBQuery.addActionListener(this);
		jBQueryAll.addActionListener(this);
		jBInsert.addActionListener(this);
		jBUpdate.addActionListener(this);
		jBDeleteCurrentRecord.addActionListener(this);
		jBDeleteAllRecords.addActionListener(this);
		
		jCBSelectQueryField = new JComboBox<String>();//��ѯ�ֶ�
		jCBSelectQueryField.addItem("ѧ��");  
		jCBSelectQueryField.addItem("����");  
		jCBSelectQueryField.addItem("�Ա�");
		jCBSelectQueryField.addItem("�༶");
		jCBSelectQueryField.addItem("Ժϵ");
		jCBSelectQueryField.addItem("����");
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
	
		studentVector = new Vector();
		titleVector = new Vector();
		
		// �����ͷ
		titleVector.add("ѧ��");
		titleVector.add("����");
		titleVector.add("�Ա�");
		titleVector.add("�༶");
		titleVector.add("Ժϵ");
		titleVector.add("����");
		titleVector.add("����");
		//studentTableModel = new DefaultTableModel(tableTitle, 15);
		studentJTable = new JTable(studentVector, titleVector);
		studentJTable.setPreferredScrollableViewportSize(new Dimension(450,160));
		studentJScrollPane = new JScrollPane(studentJTable);
		//�ֱ�����ˮƽ�ʹ�ֱ�������Զ�����
		studentJScrollPane.setHorizontalScrollBarPolicy(                
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		studentJScrollPane.setVerticalScrollBarPolicy(                
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		//Ϊ�����Ӽ����� 
		studentJTable.addMouseListener(new MouseAdapter()
		{ 
			public void mouseClicked(MouseEvent e) 
			{ 
				int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // �����λ��
				System.out.println("mouseClicked(). row = " + row);
				Vector v = new Vector();
				v = (Vector) studentVector.get(row);

				jTFSNo.setText((String) v.get(0));// ѧ��
				jTFSName.setText((String) v.get(1));// ����
				jTFSSex.setText((String) v.get(2));// �Ա�
				jTFSClass.setText((String) v.get(3));// �༶
				jTFSDepartment.setText((String) v.get(4));//Ժϵ
				jTFSAddress.setText((String) v.get(6));// ����
				jTFSBirthday.setText((String) v.get(5));//����
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
		
		jP1.add(jLStudentInfoTable,BorderLayout.SOUTH);
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
		
		jPTop.add(jP1);
		jPTop.add(jP2);
		
		jPBottom.setLayout(new GridLayout(4, 1));
		jPBottom.add(jP3);
		jPBottom.add(jP4);
		jPBottom.add(jP5);
		jPBottom.add(jP6);
		
		this.add("North", jPTop);
		this.add("South", jPBottom);
	
		this.setLayout(new GridLayout(2, 1));
		this.setTitle("ѧ������ϵͳ");
		this.setSize(650, 500);
		this.setLocation(150, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(true);
		
//		dbProcess = new DbProcess();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("��ѯ")  
			&& !jTFQueryField.getText().isEmpty()){
			System.out.println("actionPerformed(). ��ѯ");
			String sQueryField = jTFQueryField.getText().trim();
			queryProcess(sQueryField);
			jTFQueryField.setText("");
		}else if(e.getActionCommand().equals("��ѯ���м�¼")) {
			System.out.println("actionPerformed(). ��ѯ���м�¼");
			queryAllProcess();
		}else if(e.getActionCommand().equals("����")
				&& !jTFSNo.getText().isEmpty()
				&& !jTFSName.getText().isEmpty()
				&& !jTFSSex.getText().isEmpty()
				&& !jTFSClass.getText().isEmpty()
				&& !jTFSDepartment.getText().isEmpty()
				&& !jTFSAddress.getText().isEmpty()){
			System.out.println("actionPerformed(). ����");
			insertProcess();
		}else if(e.getActionCommand().equals("����")
				&& !jTFSNo.getText().isEmpty()
				&& !jTFSName.getText().isEmpty()
				&& !jTFSSex.getText().isEmpty()
				&& !jTFSClass.getText().isEmpty()
				&& !jTFSDepartment.getText().isEmpty()
				&& !jTFSAddress.getText().isEmpty()){
			System.out.println("actionPerformed(). ����");
			updateProcess();
		}else if(e.getActionCommand().equals("ɾ����ǰ��¼")){
			System.out.println("actionPerformed(). ɾ����ǰ��¼");
			deleteCurrentRecordProcess();
		}else if(e.getActionCommand().equals("ɾ�����м�¼")){
			System.out.println("actionPerformed(). ɾ�����м�¼");
			deleteAllRecordsProcess();
		}
	}
	
//	public static void main(String[] args) {
//        // TODO Auto-generated method stub
//		DatabaseCourseDesign getcon = new  DatabaseCourseDesign();
//    }
	
	public void queryProcess(String sQueryField)
	{
//		try{
			// ������ѯ����
			String sql = "select * from student_info where ";
			String queryFieldStr = jCBSelectQueryFieldTransfer(SelectQueryFieldStr);
			List<StudentInfo> studentInfoList = new ArrayList<StudentInfo>();
			StudentInfo studentInfo=null;
//			if(queryFieldStr.equals("sAge")){//int sAge.
//				sql = sql + queryFieldStr;
//				sql = sql + " = " + sQueryField;
//			}else{
				sql = sql + queryFieldStr;
				sql = sql + " = ";
				sql = sql + "'" + sQueryField + "';";
//			}
			
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
			//TODO
//			dbProcess.connect();
//			ResultSet rs = dbProcess.executeQuery(sql);
	
			
			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
			studentVector.clear();
//			while(rs.next()){
//				Vector v = new Vector();
//				v.add(rs.getString("sNo"));
//				v.add(rs.getString("sName"));
//				v.add(rs.getString("sSex"));
//				v.add(Integer.valueOf(rs.getInt("sAge")));
//				v.add(rs.getString("sSpecialty"));
//				v.add(rs.getString("sAddress"));
//				studentVector.add(v);
//			}
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
//			dbProcess.disconnect();
//		}catch(SQLException sqle){
//			System.out.println("sqle = " + sqle);
//			JOptionPane.showMessageDialog(null,
//				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
//		}catch(Exception e){
//			System.out.println("e = " + e);
//			JOptionPane.showMessageDialog(null,
//				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
//		}
	}
	
	public void queryAllProcess()
	{
//			 ������ѯ����
//			String sql = "select * from student;";
//			System.out.println("queryAllProcess(). sql = " + sql);
		try{
//			dbProcess.connect();
//			ResultSet rs = dbProcess.executeQuery(sql);
//
			List<StudentInfo> studentInfoList = studentManageService.findAll();
//			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
			studentVector.clear();
//			while(rs.next()){
//				Vector v = new Vector();
//				v.add(rs.getString("sNo"));
//				v.add(rs.getString("sName"));
//				v.add(rs.getString("sSex"));
//				v.add(Integer.valueOf(rs.getInt("sAge")));
//				v.add(rs.getString("sSpecialty"));
//				v.add(rs.getString("sAddress"));
//				studentVector.add(v);
//			}
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
//			dbProcess.disconnect();
//		}catch(SQLException sqle){
//			System.out.println("sqle = " + sqle);
//			JOptionPane.showMessageDialog(null,
//				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
//		}
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
		
		// ������������
//		String sql = "insert into student values('";
//		sql = sql + sNo + "','";
//		sql = sql + sName + "','";
//		sql = sql + sSex + "',";
//		sql = sql + sAge + ",'";
//		sql = sql + sSpecialty + "','";
//		sql = sql + sAddress + "');";

		try{
			studentManageService.addStudentInfo(studentInfo);
		}catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
//		System.out.println("insertProcess(). sql = " + sql);
//		try{
//			if (dbProcess.executeUpdate(sql) < 1) {
//				System.out.println("insertProcess(). insert database failed.");
//			}
//		}catch(Exception e){
//			System.out.println("e = " + e);
//			JOptionPane.showMessageDialog(null,
//				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
//		}
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
		
		// ������������
//		String sql = "update student set sName = '";
//		sql = sql + sName + "', sSex = '";
//		sql = sql + sSex + "', sAge = ";
//		sql = sql + sClass + ", sSpecialty = '";
//		sql = sql + sSpecialty + "', sAddress = '";
//		sql = sql + sAddress + "'";
//		sql = sql + " WHERE sNo = '" + sNo + "';";
//		System.out.println("updateProcess(). sql = " + sql);
		System.out.println("updateProcess()");
		try{
			studentManageService.updateStudentInfo(studentInfo);
		}catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
//		try{
//			if (dbProcess.executeUpdate(sql) < 1) {
//				System.out.println("updateProcess(). update database failed.");
//			}
//		}catch(Exception e){
//			System.out.println("e = " + e);
//			JOptionPane.showMessageDialog(null,
//				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
//		}
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
//		// ����ɾ������
//		String sql = "delete from student where sNo = '" + sNo + "';";
//		System.out.println("deleteCurrentRecordProcess(). sql = " + sql);
//		try{
//			if (dbProcess.executeUpdate(sql) < 1) {
//				System.out.println("deleteCurrentRecordProcess(). delete database failed.");
//			}
//		}catch(Exception e){
//			System.out.println("e = " + e);
//			JOptionPane.showMessageDialog(null,
//				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
//		}
		queryAllProcess();
	}

	public void deleteAllRecordsProcess()
	{
		// ����ɾ������
//		String sql = "delete from student;";
//		System.out.println("deleteAllRecordsProcess(). sql = " + sql);
//		try{
//			if (dbProcess.executeUpdate(sql) < 1) {
//				System.out.println("deleteAllRecordsProcess(). delete database failed.");
//			}
//		}catch(Exception e){
//			System.out.println("e = " + e);
//			JOptionPane.showMessageDialog(null,
//				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
//		}
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
		
		if(InputStr.equals("ѧ��")){
			outputStr = "sNo";
		}else if(InputStr.equals("����")){
			outputStr = "sName";
		}else if(InputStr.equals("�Ա�")){
			outputStr = "sSex";
		}else if(InputStr.equals("�༶")){
			outputStr = "sClass";
		}else if(InputStr.equals("Ժϵ")){
			outputStr = "sDepartment";
		}else if(InputStr.equals("����")){
			outputStr = "sNativePlace";
		}else if(InputStr.equals("����"))
		{
			outputStr = "sBirthday";
		}
		System.out.println("jCBSelectQueryFieldTransfer(). outputStr = " + outputStr);
		return outputStr;
	}
}
