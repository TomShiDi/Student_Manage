package resultVO;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.ClassChangeInfo;
import entity.PunishmentInfo;
import entity.StudentInfo;
import service.ChangeInfoService;
import service.PunishmentService;
import serviceImpl.ChangeInfoServiceImpl;
import serviceImpl.PunishmentServiceImpl;

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
import java.awt.BorderLayout;

public class ChangeInfoJPanel extends JPanel {
	private JTable changeInfoTable;
	
	String SelectQueryFieldStr = "��¼��";
	private JTextField textField;
	private JTextField JTFChangeId;
	private JTextField JTFStudentId;
	private JTextField JTFChangeCode;
	private JTextField JTFRecTime;
	private JTextField JTFDescription;
	
	JScrollPane changeInfoJScollPane = null;
	
	Vector titleVector = new Vector<>();
	Vector punishmentVector = new Vector<>();
	
	/**
	 * Create the panel.
	 */
	ChangeInfoService changeInfoService = new ChangeInfoServiceImpl();
	JComboBox<String> jCBSelectQueryField=null;
	
	public ChangeInfoJPanel() {
		// TODO Auto-generated constructor stub
		
		titleVector.add("��¼��");
		titleVector.add("ѧ��");
		titleVector.add("�������");
		titleVector.add("��¼ʱ��");
		titleVector.add("����");
		
		
		
		this.setLayout(new GridLayout(2, 1, 0, 0));
		
		
		JPanel JPTop = new JPanel();
		this.add(JPTop);
		JPTop.setLayout(new BorderLayout());
//		JPTop.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		
		panel_1.setLayout(new BorderLayout());
		
		changeInfoTable = new JTable(punishmentVector,titleVector);
		
		changeInfoTable.setPreferredScrollableViewportSize(new Dimension(450,160));
		changeInfoJScollPane = new JScrollPane(changeInfoTable);
		changeInfoJScollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		changeInfoJScollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		changeInfoTable.addMouseListener(new MouseAdapter()
		{ 
			public void mouseClicked(MouseEvent e) 
			{ 
				int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // �����λ��
				System.out.println("mouseClicked(). row = " + row);
				Vector v = new Vector();
				v = (Vector) punishmentVector.get(row);

				JTFChangeId.setText((String) v.get(0));// ��¼��
				JTFStudentId.setText((String) v.get(1));// ѧ��
				JTFChangeCode.setText((String) v.get(2));// �������
				JTFRecTime.setText((String) v.get(3).toString());// ��¼ʱ��
				JTFDescription.setText((String) v.get(4));// ����
			}
		});
		
		panel_1.add(changeInfoJScollPane);
		JPTop.add(panel_1);
		JPanel panel_2 = new JPanel();
//		panel_2.add(changeInfoJScollPane);
//		JPTop.add(panel_2);
		
		JPanel JPBottom = new JPanel();
		this.add(JPBottom);
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
				System.out.println("������ѯ��¼");
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
//		
		JTFChangeId = new JTextField();
		JTFChangeId.setEditable(false);
		panel_4.add(JTFChangeId);
		JTFChangeId.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5B66\u53F7");
		panel_4.add(label_2);
		
		JTFStudentId = new JTextField();
		panel_4.add(JTFStudentId);
		JTFStudentId.setColumns(10);
		
		JLabel label_3 = new JLabel("\u7EA7\u522B\u4EE3\u7801");
		panel_4.add(label_3);
		
		JTFChangeCode = new JTextField();
		panel_4.add(JTFChangeCode);
		JTFChangeCode.setColumns(10);
		
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
				System.out.println("��������");
				insertProcess();
			}
		});
		
		panel_6.add(insertButton);
		
		JButton updateButton = new JButton("\u66F4\u65B0");
		updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("���¼�¼");
				updateProcess();
			}
		});
		
		panel_6.add(updateButton);
		
		JButton deleteButton = new JButton("\u5220\u9664\u5F53\u524D\u8BB0\u5F55");
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("ɾ����ǰ��¼");
				deleteCurrentRecordProcess();
			}
		});
		
		panel_6.add(deleteButton);
		
		JButton deleteAllButton = new JButton("\u5220\u9664\u6240\u6709\u8BB0\u5F55");
		deleteAllButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("ɾ�����м�¼");
				deleteAllRecordsProcess();
			}
		});
		
		panel_6.add(deleteAllButton);
		
		this.setVisible(true);
		

	}
	
	
	public void queryProcess(String sQueryField)
	{
		String queryFieldStr = jCBSelectQueryFieldTransfer(SelectQueryFieldStr);
		List<ClassChangeInfo> classChangeInfoList = new ArrayList<ClassChangeInfo>();
		
		
		try{
			switch(queryFieldStr)
			{
			case "sNo": classChangeInfoList = changeInfoService.findByStudentId(sQueryField);break;
			case "changeId": classChangeInfoList = changeInfoService.findByClassChangeInfoId(sQueryField);break;
			case "changeCode": classChangeInfoList = changeInfoService.findByCode(sQueryField);break;
			case "recTime": classChangeInfoList = changeInfoService.findByRecTime(sQueryField);break;
			case "description": classChangeInfoList = changeInfoService.findByDescription(sQueryField);break;
			}
		}catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		
		punishmentVector.clear();
		
		for(ClassChangeInfo classChangeInfo:classChangeInfoList)
		{
			Vector v = new Vector();
			v.add(classChangeInfo.getId());
			v.add(classChangeInfo.getStudentId());
			v.add(classChangeInfo.getChangeCode());
			v.add(classChangeInfo.getRec_time());
			v.add(classChangeInfo.getDescription());
			punishmentVector.add(v);
		}
//		
		changeInfoTable.updateUI();
		
		
	}
	
	
	public void queryAllProcess()
	{
		try{
			List<ClassChangeInfo> classChangeInfoList = changeInfoService.findAll();
//			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
			punishmentVector.clear();

			for(ClassChangeInfo classChangeInfo:classChangeInfoList)
			{
				Vector v = new Vector();
				v.add(classChangeInfo.getId());
				v.add(classChangeInfo.getStudentId());
				v.add(classChangeInfo.getChangeCode());
				v.add(classChangeInfo.getRec_time());
				v.add(classChangeInfo.getDescription());
				punishmentVector.add(v);
			}
			changeInfoTable.updateUI();
		}catch (SQLException sqlException) {
			// TODO: handle exception
			sqlException.printStackTrace();
		}
	}
	
	
	public void insertProcess()
	{
//		String changeId = JTFChangeId.getText().trim();
		String studentId= JTFStudentId.getText().trim();
		String changeCode = JTFChangeCode.getText().trim();
		String description = JTFDescription.getText().trim();
		
		ClassChangeInfo changeInfo = new ClassChangeInfo(null, studentId, changeCode, description);

		try{
			changeInfoService.addClassChangeInfo(changeInfo);
		}catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
		}

		queryAllProcess();
	}
	
	
	public void updateProcess()
	{
		String changeId = JTFChangeId.getText().trim();
		String studentId= JTFStudentId.getText().trim();
		String changeCode = JTFChangeCode.getText().trim();
		String recTime = JTFRecTime.getText().trim();
		String description = JTFDescription.getText().trim();
		
		ClassChangeInfo changeInfo = new ClassChangeInfo(changeId, studentId, changeCode, description);
		
		System.out.println("updateProcess()");
		try{
			changeInfoService.updateClassChangeInfo(changeInfo);
		}catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		queryAllProcess();
	}
	
	public void deleteCurrentRecordProcess()
	{
		String changeId = JTFChangeId.getText().trim();
//		
		
		try{
			changeInfoService.deleteClassChangeInfoById(changeId);
		}catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
		}

		queryAllProcess();
	}
	
	
	public void deleteAllRecordsProcess()
	{

		try{
			changeInfoService.deleteAll(); 
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
			outputStr = "changeId";
		}else if(InputStr.equals("�������")){
			outputStr = "changeCode";
		}else if(InputStr.equals("��¼ʱ��")){
			outputStr = "recTime";
		}else if(InputStr.equals("����")){
			outputStr = "description";
		}
		System.out.println("jCBSelectQueryFieldTransfer(). outputStr = " + outputStr);
		return outputStr;
	}
}
