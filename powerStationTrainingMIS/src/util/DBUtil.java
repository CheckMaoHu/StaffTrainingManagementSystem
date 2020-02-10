package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	private String driver;
	private String url;
	private String user;
	private String pass;
	private Connection conn;
	Statement stmt;
	ResultSet rs;

	public  void initParam(String paramFile) throws Exception {
		// ʹ��Properties�������������ļ�
		Properties props = new Properties();
		String fullFileName = DBUtil.class.getResource(paramFile).getFile();
		props.load(new FileInputStream(fullFileName));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}
	public   Connection getConnection(){
		
		//��������
		try {
			initParam("mysql.ini");
			Class.forName(driver);
			conn = DriverManager.getConnection(url , user , pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void closeConn(Connection conn){
		if (conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void executeSql(String sql)throws Exception	{
		try	{
			//��������
			Class.forName(driver);
			//��ȡ���ݿ�����
			conn = DriverManager.getConnection(url , user , pass);
			//ʹ��Connection������һ��Statment����
			stmt = conn.createStatement();
			//ִ��SQL,����booleanֵ��ʾ�Ƿ����ResultSet
			boolean hasResultSet = stmt.execute(sql);
			//���ִ�к���ResultSet�����
			if (hasResultSet){
				//��ȡ�����
				rs = stmt.getResultSet();
				
				//ResultSetMetaData�����ڷ����������Ԫ���ݽӿ�
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				//�������ResultSet����
				while (rs.next()){
					//�������ÿ�е�ֵ
					for (int i = 0 ; i < columnCount ; i++ ){
						System.out.print(rs.getString(i + 1) + "\t");
					}
					System.out.print("\n");
				}
			}
			else {
				System.out.println("��SQL���Ӱ��ļ�¼��" + stmt.getUpdateCount() + "��");
			}
		}
		//ʹ��finally�����ر����ݿ���Դ
		finally	{
			if (rs != null)	{
				rs.close();
			}
			if (stmt != null){
				stmt.close();
			}
			if (conn != null){
				conn.close();
			}
		}
	}

}
