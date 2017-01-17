package adapterpattern;

public class MedicAdapter implements TerranInterface{

	
	private MedicInterface medic;
	
	public MedicAdapter(MedicInterface medic){
		this.medic=medic;
	}
	
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		medic.heal();
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	

}
