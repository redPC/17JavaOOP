package adapterpattern;

public class Medic implements MedicInterface{

	@Override
	public void heal() {
		// TODO Auto-generated method stub
		System.out.println("치료한다.");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("메딕이 걷는다~");
	}

	
}
