package bank.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

import bank.dao.BankDAO;
import bank.dto.BankDTO;

public class BankService {

	public BankService(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			System.out.println(e);
		}
	}
	public BankDTO deposit(BankDTO dto){
		//로직처리를 함
		//디비 처리를 함
		//Transaction처리를 위해서 Databaase Connection처리를 
		//Service에서 해줘야함
		
		/*Connection con= null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String id="java";
			String pw="java";
			String url="jdbc:mysql://localhost:3306/library";
			con = DriverManager.getConnection(id, pw, url);
			con.setAutoCommit(false); //transaction 잡는다.
		
		}catch(Exception e){
			System.out.println(e);
		}
		BankDAO dao = new BankDAO(con);		
		*/
		Connection con = null;
		try{
			String id="java";
			String pw="java";
		String url="jdbc:mysql://localhost:3306/library";
			con = DriverManager.getConnection(url,id, pw);
			con.setAutoCommit(false);
		
			BankDAO dao = new BankDAO(con);
			BankDTO result=dao.select(dto);
			
			if(result!=null){
				dao.updateDeposit(dto);
				if(dto!=null){
					con.commit();
				}else{
					con.rollback();
				}
			}
		}catch(Exception e){
				System.out.println(e);
		}finally{
			try{
				con.close();
			}catch(Exception e2){
				System.out.println(e2);
			}
		}
		
		return dto;
		//dao.deposit(dto); 
		//dao에서는 db처리만 하므로 유의미한 이름이 들어가면 안됨
		//return dao.deposit();
	}
	public BankDTO withdraw(BankDTO dto){
		Connection con = null;
		try{
			String id="java";
			String pw="java";
			String url="jdbc:mysql://localhost:3306/library";
			con = DriverManager.getConnection(url,id, pw);
			con.setAutoCommit(false);
		
			BankDAO dao = new BankDAO(con);
			BankDTO result=dao.select(dto);
			
			if((result!=null) && (result.getBalance()>=dto.getBalance())){
				dao.updateWithdraw(dto);
				if(dto!=null){
					con.commit();
				}else{
					con.rollback();
				}
			}
		}catch(Exception e){
				System.out.println(e);
		}finally{
			try{
				con.close();
			}catch(Exception e2){
				System.out.println(e2);
			}
		}
		
		
		return dto;
	 
	}
	
	/*public boolean transfer(String sender,String receiver, String amount){
		}
		BankDAO dao = new BankDAO();
		return dao.transfer(sender, receiver, amount);
		
	}*/
	public HashMap<String, BankDTO> transfer(BankDTO depositDTO, BankDTO withdrawDTO) {
		HashMap<String,BankDTO> result= new HashMap<String, BankDTO>();
		
		result.put("deposit",deposit(depositDTO));
		result.put("withdraw", withdraw(withdrawDTO));
		return result;
	}
}
