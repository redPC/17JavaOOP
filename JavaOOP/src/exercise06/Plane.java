package exercise06;

public abstract class Plane {
	
	private String planeName;
	private int fuelSize;
	
	public Plane(){
		
	}
	
	public Plane(String planeName,int fuelSize){
		super();
		this.planeName=planeName;
		this.fuelSize=fuelSize;
	}
	
	public void refuel(int fuel){
		fuelSize += fuel;
	}
	
	public abstract void flight(int distance);
	public String getPlainName() {
		return planeName;
	}

	public void setPlainName(String plainName) {
		this.planeName = plainName;
	}

	public int getFuelSize() {
		return fuelSize;
	}

	public void setFuelSize(int fuelSize) {
		this.fuelSize = fuelSize;
	}
}
