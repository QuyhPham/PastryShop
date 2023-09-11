package Normal;

public class Bill {
	
	public String DateOrder, DatePay, Good, Item;
	public long Price;
	public int IDB, IDC;
	
	public Bill(){
		
	}

	public Bill(String dateOrder, String datePay, String good, long price,
			int iDB, int iDC) {
		
		
		DateOrder = dateOrder;
		DatePay = datePay;
		
		Good = good;
		Price = price;
		IDB = iDB;
		IDC = iDC;
	}

	

	public String getDateOrder() {
		return DateOrder;
	}

	public void setDateOrder(String dateOrder) {
		DateOrder = dateOrder;
	}

	public String getDatePay() {
		return DatePay;
	}

	public void setDatePay(String datePay) {
		DatePay = datePay;
	}

	

	public String getGood() {
		return Good;
	}

	public void setGood(String good) {
		Good = good;
	}

	public long getPrice() {
		return Price;
	}

	public void setPrice(long price) {
		Price = price;
	}

	public int getIDB() {
		return IDB;
	}

	public void setIDB(int iDB) {
		IDB = iDB;
	}

	public int getIDC() {
		return IDC;
	}

	public void setIDC(int iDC) {
		IDC = iDC;
	}
	
	public String getItem() {
		return Item;
	}

	public void setItem(String item) {
		Item = item;
	}
	
	

}
