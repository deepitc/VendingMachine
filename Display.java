public class Display {

	public Display() {

	}

	public void show(String message) {
		System.out.println(message);
	}

	public void error(String message) {
		System.out.println("Error: " + message);
	}

	public void takeChange(int q, int d, int n) {
		System.out.println("Please take your change:");
		System.out.println(q + " quarters " + d + " dimes " + n + " nickles.");
	}

	public void wrongInput() {
		System.out.println("Wrong Input - Try Again");
	}

	public void soldOut() {
		System.out.println("Sorry, that brand is sold out.");
	}

	public void allSoldOut() {
		System.out.println("Sorry, everything is sold out.");
	}

	public void request() {
		System.out.println("Do you insert bill, quarter, dime, or nickle? ");
	}

	public void sold() {
		System.out.println("Sale successful. Please take your beverage.");
	}

	public void notExactChange() {
		System.out.println("Sorry, cannot make exact change!");
	}

}