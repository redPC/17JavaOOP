package exercise06;

public class Airplane extends Plane{
	
	public Airplane(){
		
	}
	
	public Airplane(String planeName,int fuelSize){
		super(planeName,fuelSize);
	}
	
	@Override
	public void flight(int distance){
		int currentFuel=getFuelSize();
		setFuelSize(currentFuel -(distance*3));
	}
}
