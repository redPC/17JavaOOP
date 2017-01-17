package bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bank.dto.BankDTO;

public class BankDAO {
	
	/*public boolean deposit(String name, String amount){
		boolean result = false;
		int tmp=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String id="java";
			String pw="java";
			String url="jdbc:mysql://localhost:3306/library";
			Connection con = DriverManager.getConnection(url,id,pw);
			String sql="select balance from bank where name like ?";
			PreparedStatement pstmt =con.prepareStatement(sql);
			pstmt.setString(1,name);  
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String balance = rs.getString("balance");			
				int deposit = Integer.parseInt(balance)+Integer.parseInt(amount);
				sql="update bank set balance = ? where name = ?"; 
				pstmt =con.prepareStatement(sql);
				pstmt.setString(1,String.valueOf(deposit));
				pstmt.setString(2, name);
				tmp =pstmt.executeUpdate();
			}
			if(tmp==1){
				result = true;
			}
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
			
		return result;
	}
	
	public boolean withdraw(String name, String amount){
		boolean result = false;
		int tmp=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String id="java";
			String pw="java";
			String url="jdbc:mysql://localhost:3306/library";
			Connection con = DriverManager.getConnection(url,id,pw);
			String sql="select balance from bank where name like ?";
			PreparedStatement pstmt =con.prepareStatement(sql);
			pstmt.setString(1,name);  
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String balance = rs.getString("balance");			
				int withdraw = Integer.parseInt(balance)+Integer.parseInt(amount);
				if(withdraw<0){
					break;
				}
				sql="update bank set balance = ? where name = ?"; 
				pstmt =con.prepareStatement(sql);
				pstmt.setString(1,String.valueOf(withdraw));
				pstmt.setString(2, name);
				tmp =pstmt.executeUpdate();
			}
			if(tmp==1){
				result = true;
			}
			pstmt.close();
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}		
		return result;
	}

	public boolean transfer(String sender,String receiver, String amount){
		boolean result = false;
		boolean send=false;
		boolean receive=false;
		send=withdraw(sender,amount);
		receive=deposit(receiver,amount);
		result=send&receive;
		/*try{
			Class.forName("com.mysql.jdbc.Driver");
			String id="java";
			String pw="java";
			String url="jdbc:mysql://localhost:3306/library";
			Connection con = DriverManager.getConnection(url,id,pw);
			String sql="select balance from bank where name like ?";
			PreparedStatement pstmt =con.prepareStatement(sql);
			pstmt.setString(1,sender);  
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String balance = rs.getString("balance");			
				withdraw = Integer.parseInt(balance)-Integer.parseInt(amount);
				if(withdraw<0){
					break;
				}
				sql="update bank set balance = ? where name = ?"; 
				pstmt =con.prepareStatement(sql);
				pstmt.setString(1,String.valueOf(withdraw));
				pstmt.setString(2, sender);
				tmp =pstmt.executeUpdate();
				
				sql="select balance from bank where name like ?";
				pstmt =con.prepareStatement(sql);
				pstmt.setString(1,receiver);  
				ResultSet rsd = pstmt.executeQuery();
				while(rs.next()){
					balance = rs.getString("balance");			
					deposit = Integer.parseInt(balance)+Integer.parseInt(amount);
					sql="update bank set balance = ? where name = ?"; 
					pstmt =con.prepareStatement(sql);
					pstmt.setString(1,String.valueOf(deposit));
					pstmt.setString(2, receiver);
					tmp =pstmt.executeUpdate();
				}
				rsd.close();
			}
			
			
			if(tmp==1){
				result = true;
			}
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
			
		return result;
	}
	*/
	
	private Connection con;
	
	public BankDAO(){
		
	}
	
	public BankDAO(Connection con){
		this.con=con;
	}
	
	public BankDTO select(BankDTO dto) {
		BankDTO result= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			String sql="select name,balance from bank where name=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			rs = pstmt.executeQuery(); //여기서 exception이 발생하면 자원해제가 안됨
			if(rs.next()){
				result = new BankDTO();
				result.setName(rs.getString("name"));
				result.setBalance(rs.getInt("balance"));				
			}

		}catch(Exception e){
			System.out.println(e);
		}finally{ //exception이 뜨던 안뜨던 무조건 수행이 됨.
			try{ //close라는 method가 try catch를 강제한다.
				rs.close();
				pstmt.close();
			}catch(Exception e1){
				System.out.println(e1);
			}
		}
		return result;
	}

	public BankDTO updateDeposit(BankDTO dto) {
		
		BankDTO result= null;
		PreparedStatement pstmt = null;
		try{
			String sql="update bank set balance=balance+? where name=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBalance());
			pstmt.setString(2, dto.getName());
			int count = pstmt.executeUpdate(); 
			if(count==1){
				result = select(dto);
			}
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{ 
				pstmt.close();
			}catch(Exception e1){
				System.out.println(e1);
			}
		}
		return result;
	}

	public BankDTO updateWithdraw(BankDTO dto) {
		BankDTO result= null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			
			String id="java";
			String pw="java";
			String url="jdbc:mysql://localhost:3306/library";
			con = DriverManager.getConnection(url,id, pw);
			con.setAutoCommit(false);
			String sql="update bank set balance=balance-? where name=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBalance());
			pstmt.setString(2, dto.getName());
			int count = pstmt.executeUpdate(); 
			if(count==1){
				con.commit();
				result = select(dto);				
			}else{
				con.rollback();
			}

		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{ 
				pstmt.close();
				con.close();
			}catch(Exception e1){
				System.out.println(e1);
			}
		}
		return result;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
}
