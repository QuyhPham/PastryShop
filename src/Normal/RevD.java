package Normal;

public class RevD {
	public String NameD, DateD;
	public long MoneyD;
	public int IDBD;
	
	public RevD(){
		
	}

	public RevD(String nameD, String dateD, long moneyD, int iDBD) {
		
		NameD = nameD;
		DateD = dateD;
		MoneyD = moneyD;
		IDBD = iDBD;
	}

	public String getNameD() {
		return NameD;
	}

	public void setNameD(String nameD) {
		NameD = nameD;
	}

	public String getDateD() {
		return DateD;
	}

	public void setDateD(String dateD) {
		DateD = dateD;
	}

	public long getMoneyD() {
		return MoneyD;
	}

	public void setMoneyD(long moneyD) {
		MoneyD = moneyD;
	}

	public int getIDBD() {
		return IDBD;
	}

	public void setIDBD(int iDBD) {
		IDBD = iDBD;
	}
	
	

}
