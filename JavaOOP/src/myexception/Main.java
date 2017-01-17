package myexception;

import java.util.Random;

public class Main {

	public static void test() throws Exception{
		System.out.println("호출된다~");
		//만약 exception처리코드가 필요하다면?
		
		Class.forName("com.mysql.jdbc.Driver");
	}
	public static void main(String[] args) {
		
		//발생가능한 여러가지 예외상황들이 있다.
		try{
			//만약 강제로 Exception을 발생시키고 싶으면??
			test();
		}catch(Exception e){
			//이 부분은 발생한 exception을 처리해서 
			//프로그램이 원할하게 계속수행될수 있도록 처리하는 코드가 나와야한다.
			System.out.println(e);
		}finally{
				
		}
		
		System.out.println("잘 수행되나요?");
		

	}

}
