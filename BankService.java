class BankService{
	
	//Create New Account
	public static void createAccount(String name,String pin,double balance) {
		try(Connection con=DBConnection.getConnection()){
			String sql="INSERT INTO accounts(name,pin,balance) VALUES (?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pin);
			ps.setDouble(3, balance);
			ps.executeUpdate();
			System.out.println("Account created successfully!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Login validation
	public static boolean login(int accNo,String pin) {
		try(Connection con=DBConnection.getConnection()){
			String sql="SELECT * FROM accounts WHERE acc_no=? AND pin=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, accNo);
			ps.setString(2,pin);
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				System.out.println("Login successful! Welcome, "+res.getString("name"));
				return true;
				}else {
					System.out.println("Invalid account number or PIN.");
					return false;
				}
			}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//Deposit Money
	public static void deposit(int accNo,double amount) {
		try(Connection con=DBConnection.getConnection()){
			String sql="UPDATE accounts SET balance=balance+? WHERE acc_no=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setInt(2, accNo);
			ps.executeUpdate();
			System.out.println("Deposit successful!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//withdraw Money
	public static void withdraw(int accNo,double amount) {
		try(Connection con=DBConnection.getConnection()){
			String checksql="SELECT balance FROM accounts WHERE acc_no=?";
			PreparedStatement checkps=con.prepareStatement(checksql);
			checkps.setInt(1, accNo);
			ResultSet res=checkps.executeQuery();
			if(res.next()) {
				double balance=res.getDouble("balance");
				if(balance>=amount) {
					String sql="UPDATE accounts SET balance=balance-? WHERE acc_no=?";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setDouble(1, amount);
					ps.setInt(2,accNo);
					ps.executeUpdate();
					System.out.println("Withdrawal successful!");
				}else {
					System.out.println("Insufficient balance!");
				}
			}	
		}
		catch(SQLException e) {
			e.printStackTrace();
			}
	}
	
	//Check Balance
	public static void checkBalance(int accNo) {
		try(Connection con=DBConnection.getConnection()){
			String sql="SELECT balance FROM accounts WHERE acc_no=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, accNo);
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				System.out.println("Current Balance: "+res.getDouble("balance")+"rs.");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
