package exercise8;

import java.util.HashMap;

public class Company {

	public static void main(String[] args) {
		
		HashMap<Integer,Employee> map= new HashMap<Integer,Employee>();
		
		map.put(1, new Secretary("Hilery",1,"secretary",800));
		map.put(2, new Sales("Clinten",2,"sales",1200));
		
		
		for(int i=1; i<3; i++){
			System.out.println(map.get(i));
		}
	}

}
