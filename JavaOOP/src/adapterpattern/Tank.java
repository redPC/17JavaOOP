package adapterpattern;

public class Tank implements TerranInterface {

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("포를쏜다.");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("느리게 움직인다.");
	}

}
