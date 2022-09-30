public class BillBox {

	private int bills;
	private int totalBills;

	public BillBox() {
		this.bills = 0;
	}

	public void depositBill() {
		this.bills++;
	}

	public void resetBills() {
		this.bills = 0;
	}

	public int getCurrentBills() {
		return bills;
	}

	public int getTotalBills() {
		return totalBills;
	}

}
