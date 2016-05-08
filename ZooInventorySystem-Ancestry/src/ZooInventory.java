
public class ZooInventory {

	private String zoo;
	private String food;
	public String getZoo() {
		return zoo;
	}
	public void setZoo(String zoo) {
		this.zoo = zoo;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	@Override
	public String toString() {
		return "ZooInventory [zoo=" + zoo + ", food=" + food + "]";
	}
	
	
}
