package korea.mypackage;

public class Car {

		//값-변수 -field
		//행동-함수-method
		//생성자 - constructor (마치 method처럼 생김)
		//생성자는 이름이 반드시 클래스 이름과 같아야함
		//리턴타입이 존재하지 않음
	
	private static int fuel;	//static field
						//class만 있어도 사용할 수 있는 member =>class member
	public int speed;	//field
						//instance가 있어야지 사용할 수 있는 member =>instance member
						//constructor (instance를 만드는게 목적)
	
	public int getFuel(){
		return fuel;
	}
	
	public void setFuel(int fuel){
		this.fuel=fuel;
	}
	
	public Car(){
		
	}
	
	public Car(int k){
		
	}
	
	public void refuel(int k){
		if(k<0){
			System.out.println("말도안됨");
		}
		fuel +=k;
		this.speed +=100;
		
	}
	
}
