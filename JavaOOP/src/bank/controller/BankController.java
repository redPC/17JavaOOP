package bank.controller;

import java.util.HashMap;
import java.util.Scanner;

import bank.dto.BankDTO;
import bank.service.BankService;

public class BankController {
				
		public BankController(){
			
			Scanner s = new Scanner(System.in);
			String menu = null;
			//String name;
			//String amount;
			
			do{
				System.out.println("===은행 시스템입니다. ===");
				System.out.println("1. 입금업무");
				System.out.println("2. 출금업무");
				System.out.println("3. 이체업무");
				System.out.println("4. 종료");
				System.out.println("메뉴를 입력해 주세요 : ");
				
				menu = s.nextLine();
				
				if(menu.equals("1")){
					//사용자로부터 입력받은 내용을 dto로 넘기고 dto로 service
					System.out.print("입금할 사람의 이름을 입력해주세요 : ");
					BankDTO dto = new BankDTO();
					//name=s.nextLine();
					dto.setName(s.nextLine());
					System.out.println("입금할 금액을 입력하세요 : ");
					//amount=s.nextLine();
					dto.setBalance(s.nextInt());
					s.nextLine(); //남아있는 enter부분 없앨려고 출력시킴
					BankService service = new BankService();
					dto = service.deposit(dto); 
					//service에서 나오는 method자체가 거의 하나의 transaction과 1:1매핑이됨					
					System.out.println(dto.getName()+"님의 잔액은"
							+dto.getBalance()+"입니다");
				}
				if(menu.equals("2")){
					System.out.print("출금할 사람의 이름을 입력해주세요 : ");
					BankDTO dto = new BankDTO();
					dto.setName(s.nextLine());
					System.out.println("출금할 금액을 입력하세요 : ");
					dto.setBalance(s.nextInt());
					s.nextLine();
					BankService service = new BankService();
					dto =service.withdraw(dto);
					System.out.println(dto.getName()+"님의 잔액은"
							+dto.getBalance()+"입니다");					
				}
				if(menu.equals("3")){
					BankDTO depositDTO = new BankDTO();
					BankDTO withdrawDTO = new BankDTO();
					System.out.print("입금할 사람의 이름을 입력해주세요 : ");
					depositDTO.setName(s.nextLine());
					System.out.print("출금할 사람의 이름을 입력해주세요 : ");
					withdrawDTO.setName(s.nextLine());
					System.out.println("이체할 금액을 입력하세요 : ");
					int money= s.nextInt();
					depositDTO.setBalance(money);
					withdrawDTO.setBalance(money);
					
					BankService service = new BankService();
					HashMap<String, BankDTO> map= service.transfer(depositDTO, withdrawDTO );
					depositDTO=map.get("deposit");
					withdrawDTO=map.get("withdraw");
					System.out.println("입금자의 이름은 : "+depositDTO.getName()+"이고 잔액은"
							+depositDTO.getBalance());
					System.out.println("출금자의 이름은 : "+withdrawDTO.getName()+
							"이고 잔액은 "+withdrawDTO.getBalance());
					}
				
			}while(!menu.equals("4"));
		}
}
