package exercise3;

import java.util.Random;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		//1부터 100까지 난수를 10개 발생(random class)
		Random r = new Random();
		//이렇게 발생된 난ㅅ수를 hashmap에 저장(hashmap class)
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=1;i<11;i++){
			map.put(i, r.nextInt(100)+1);
		}
		//저장된 데이터의 합계와 평균을 출력
		int sum=0;
		for(int i=1; i<11; i++){
			sum +=map.get(i);
		}
		float avg=sum/10;
		
		System.out.println(sum);
	}

}
