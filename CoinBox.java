public class CoinBox {

	private int dimes;
	private int nickles;
	private int quarters;

	public CoinBox() {
		dimes = 0;
		nickles = 0;
		quarters = 0;
	}

	public double currentAmt() {
		return dimes * 0.1 + quarters * 0.25 + nickles * 0.05;
	}

	public void depositQuarter(int quarters) {
		this.quarters += quarters;
	}

	public void depositDime(int dimes) {
		this.dimes += dimes;
	}

	public void depositNickle(int nickels) {
		this.nickles += nickels;
	}

	public int getQuarterCount() {
		return quarters;
	}

	public int getDimeCount() {
		return dimes;
	}

	public int getNickleCount() {
		return nickles;
	}

	public void setQuarters(int num_coins) {
		this.quarters = num_coins;
	}

	public void setDimes(int num_coins) {
		this.dimes = num_coins;
	}

	public void setNickles(int num_coins) {
		this.nickles = num_coins;
	}

	public void transferCoinsFrom(CoinBox other) {
		this.quarters += other.getQuarterCount();
		this.nickles += other.getNickleCount();
		this.dimes += other.getDimeCount();
	}

	public void decrementQuarter() {
		this.quarters--;
	}

	public void decrementDime() {
		this.dimes--;
	}

	public void decrementNickle() {
		this.nickles--;
	}

	public void resetBox() {
		this.quarters = 0;
		this.nickles = 0;
		this.dimes = 0;
	}
}
