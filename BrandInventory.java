public class BrandInventory {

	private String id;
	private int number = 0;
	private float price;

	public BrandInventory(String id, float price, int numItems) {
		this.id = id;
		this.number = numItems;
		this.price = price;
	}

	public String getID() {
		return id;
	}

	public float getPrice() {
		return price;
	}

	public int getCount() {
		return number;
	}

	public void reduceOnHand() {
		this.number--;
		
	}

	public boolean isSoldOut() {
		if (number == 0)
			return true;
		else
			return false;
	}

	public String toString() {
		return "ID: " + id + " \nPrice: $" + String.format("%.2f" , price);
	}

	public BrandInventory inventory() {
		return inventory();
	}

}
