import korea.mypackage.Car;

public class Main {
	//field,method
	
	//program의 entry 역할을 하는 특수한 method가 존재 => main method(항상 똑같음)
	
	public static void main(String args[]){
		int a=100;	
		Car b=new Car();   //b : reference variable
		Car c=new Car();

		b.refuel(100); 		// . :dot operator
	}
}
