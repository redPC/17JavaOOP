package excercise2;

import java.util.HashSet;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// main method내에서 로직처리를 한다는건 있을 수 없는 일.
		Random r = new Random();
		//generic 
		HashSet<Integer> set = new HashSet<Integer>();
		while(set.size() !=10){
			int k=r.nextInt(30)+1;
			//Integer i = new Integer(k);
			//set.add(i);
			set.add(k); //autoboxing
		}
		System.out.println(set);
		
		/*int k[]=new int[10];
		int i = 0;
		while(i<10){
			k[i]=(int) (r.nextInt(30)+1);
			int j=i-1;
			while(j==0)
			{
				while(k[i]!=k[j]){
					k[i]=(int) (r.nextInt(30)+1);
				}
				j--;
			}
			System.out.println(k[i]);
			i++;
		}*/
	}

}
