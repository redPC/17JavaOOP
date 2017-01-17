package exercise06;

public class Cargoplane extends Plane{
	
	public Cargoplane(){
		
	}
	
	public Cargoplane(String planeName,int fuelSize){
		super(planeName,fuelSize);
	}
	
	@Override
	public void flight(int distance){
		int currentFuel=getFuelSize();
		setFuelSize(currentFuel-(distance*5));
	}
}
