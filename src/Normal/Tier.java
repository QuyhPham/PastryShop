package Normal;

public class Tier {
	public String Tier;
	public long Price; 
	public int IDti; 
	
	public Tier() {
		
	}

	

	public Tier(String tier, long price, int iDti) {
		
		Tier = tier;
		Price = price;
		IDti = iDti;
	}



	public String getTier() {
		return Tier;
	}

	public void setTier(String tier) {
		Tier = tier;
	}

	public long getPrice() {
		return Price;
	}

	public void setPrice(long price) {
		Price = price;
	}

	public int getIDti() {
		return IDti;
	}

	public void setIDti(int iDti) {
		IDti = iDti;
	}
	
	
	
	

	
	
}
