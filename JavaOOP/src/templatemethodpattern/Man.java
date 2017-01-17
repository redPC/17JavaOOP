package templatemethodpattern;

import java.util.ArrayList;
import java.util.Random;

public class Man {

	public void dress(){
		System.out.println("옷을 입는다.");
	}
	
	public void searchWoman(){
		System.out.println("여자를 찾는다.");
	}
	
	public void doActionMan(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("선물을 산다");
		list.add("꽃을 산다.");
		list.add("부모님의 선물을 산다.");
		list.add("얘기를 잘 들어준다");
		int num=(new Random()).nextInt(list.size());
		System.out.println(list.get(num));
	}
	
	public void confess(){
		System.out.println("고백을 한다.");
	}
	
	public void makeFriends(){
		dress();
		searchWoman();
		doActionMan();
		
	}
}
