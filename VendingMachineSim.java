import java.util.Scanner;

// Name : Deepit Chandgothia, 
// Project: Vending Machine

public class VendingMachineSim {

	public static void main(String[] args) {
		Display display = new Display();
		boolean runSim = true;
		Scanner grin = new Scanner(System.in);
		int flag = 0;
		int pos = 0;
		String response = "";

		// remember to give some introduction to the simulation
		display.show("Welcome to the Soda Shack!!");

		// create the Vending Machine object itself
		VendingMachine noyce = new VendingMachine();

		while (runSim) {
			display.show("Do you want to buy a beverage? (yes or no)");
			flag = 0;
			if (grin.hasNextLine())
				response = grin.nextLine();

			if (response.equalsIgnoreCase("yes")) {

				String id;

				do {
					display.show("\tTOTAL INVENTORY\t\t");
					noyce.printInventory();
					noyce.printChoices();
					display.show("\n\nEnter the ID of Brand Inventory: ");
					id = grin.nextLine();
					for (int i = 0; i < noyce.size(); i++) {
						if (noyce.get(i).getID().equals(id) && noyce.get(i).getCount() > 0) {
							flag++;
							pos = i;
							break;
						}

					}

					if (flag == 0)
						display.wrongInput();
				} while (flag == 0);

				if (flag == 1) {
					while (noyce.get(pos).getPrice() > noyce.getAmtDeposited()) {
						display.request();
						response = grin.nextLine();
						if (response.equals("bill")) {
							noyce.dollars().depositBill();
						} else if (response.equals("quarter")) {
							noyce.depositCoins().depositQuarter(1);
						} else if (response.equals("dime")) {
							noyce.depositCoins().depositDime(1);
						} else if (response.equals("nickle")) {
							noyce.depositCoins().depositNickle(1);
						} else
							display.wrongInput();

					}

					if (noyce.makeChange((noyce.getAmtDeposited() - noyce.get(pos).getPrice())))
						display.show("Exact Change Available");
					else
						display.notExactChange();

					display.takeChange(noyce.returnChange().getQuarterCount(), noyce.returnChange().getDimeCount(),
							noyce.returnChange().getNickleCount());

					noyce.inventory().get(pos).reduceOnHand();

					noyce.completeSale();
				}

			} // if "yes"
			else {
				runSim = false;
				display.show("Thank you for visiting the Soda Shack!");
			}

		} // while

		grin.close();
	} // main

}
