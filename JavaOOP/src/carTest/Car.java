package carTest;

public class Car extends Object {
	
	private String owner;
	private int fuel;
	private int speed;
	
	public boolean equals(Object obj){
		
		boolean result = false;
		
		if (obj instanceof Car){
			Car tmp=(Car) obj;
			if(this.owner.equals(tmp.owner)){
				result=true;
			}else{
				result=false;
			}
		}
		else{
			result=false;
		}
		return result;
		
	}
	
	public String toString(){
		return "이것은 홍길동의 차입니다";
	}
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getFuel() {
		return fuel;
	}
	public void setFuel(int fuel) {
		this.fuel = fuel;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}
