import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

	private ArrayList<BrandInventory> inventory;
	private Scanner grin;
	private BrandInventory stock;
	private CoinBox depositCoins;
	private CoinBox change;
	private BillBox bills;
	private CoinBox returnChange;
	private String id;
	private float price;
	private int number;
	private Display display;

	public VendingMachine() {
		inventory = new ArrayList<>();
		display = new Display();
		try {
			grin = new Scanner(new FileReader("config.dat"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (grin.hasNextLine()) {
			String line = grin.nextLine();
			String[] contents = line.split(" ");
			id = contents[0];
			try {
				price = Float.parseFloat(contents[1]);
				number = Integer.parseInt(contents[2]);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

			stock = new BrandInventory(id, price, number);
			inventory.add(stock);
		}

		this.bills = new BillBox();
		this.depositCoins = new CoinBox();
		this.change = new CoinBox();
		change.setDimes(10);
		change.setNickles(10);
		change.setQuarters(10);
		returnChange = new CoinBox();
		grin.close();

	}

	public boolean isAvailable(String purchaseID) {

		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).getID().equalsIgnoreCase(purchaseID)) {
				if (inventory.get(i).getCount() != 0)
					return true;
				else
					return false;
			}
		}
		return false;
	}

	public double getAmtDeposited() {
		return depositCoins.currentAmt() + bills.getCurrentBills();

	}

	public void acceptBill() {
		bills.depositBill();
	}

	public void acceptQuarter() {
		depositCoins.depositQuarter(1);
	}

	public void acceptDime() {
		depositCoins.depositDime(1);
	}

	public void acceptNickle() {
		depositCoins.depositNickle(1);
	}

	public boolean makeChange(double dollar_amount) {

		while (dollar_amount > 0) {
			while (dollar_amount >= 0.25 && change.getQuarterCount() > 0) {
				dollar_amount -= 0.25;
				returnChange.depositQuarter(1);
				change.decrementQuarter();
			}

			while (dollar_amount >= 0.10 && change.getDimeCount() > 0) {
				dollar_amount -= 0.10;
				returnChange.depositDime(1);
				change.decrementDime();
			}

			while (dollar_amount >= 0.05 && change.getNickleCount() > 0) {
				dollar_amount -= 0.05;
				returnChange.depositNickle(1);
				change.decrementNickle();
			}

			if (change.currentAmt() == 0.0)
				break;
		}

		if (dollar_amount == 0)
			return true;
		else
			return false;
	}

	public void printInventory() {
		for (int i = 0; i < inventory.size(); i++)
			display.show(
					"ID: " + inventory.get(i).getID() + " Price: $" + String.format("%.2f", inventory.get(i).getPrice())
							+ " Number: " + inventory.get(i).getCount());
	}

	public void printChoices() {
		display.show("\n\n\tValid Choices\t\t");
		for (int i = 0; i < inventory.size(); i++)
			if (inventory.get(i).getCount() != 0)
				display.show("ID: " + inventory.get(i).getID());
	}

	public void completeSale() {
		change.transferCoinsFrom(depositCoins);
		depositCoins.resetBox();

		for (int i = 0; i < bills.getCurrentBills(); i++)
			bills.depositBill();
		returnChange.resetBox();
		bills.resetBills();
	}

	public CoinBox depositCoins() {
		return depositCoins;
	}

	public BillBox bills() {
		return bills;
	}

	public BillBox dollars() {
		return bills;
	}

	public CoinBox change() {
		return change;
	}

	public CoinBox returnChange() {
		return returnChange;
	}

	public List<BrandInventory> inventory() {
		return inventory;
	}

	public int size() {
		return inventory.size();
	}

	public BrandInventory get(int i) {
		return inventory.get(i);
	}

}
