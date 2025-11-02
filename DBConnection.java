class DBConnection{
	private static final String url="jdbc:mysql://localhost:3306/bankdb";
	private static final String un="root";
	private static final String pwd="root";
	public static Connection getConnection() {
		Connection con=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,un,pwd);
	}
	catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return con;
	}
	}
