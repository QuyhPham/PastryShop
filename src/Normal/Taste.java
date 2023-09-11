package Normal;

public class Taste {
	public String Taste;
	public long Price; 
	public int IDta; 
	
	public Taste() {
		
	}

	

	public Taste(String taste, long price, int iDta) {
		
		Taste = taste;
		Price = price;
		IDta = iDta;
	}



	public String getTaste() {
		return Taste;
	}

	public void setTaste(String taste) {
		Taste = taste;
	}

	public long getPrice() {
		return Price;
	}

	public void setPrice(long price) {
		Price = price;
	}

	public int getIDta() {
		return IDta;
	}

	public void setIDta(int iDta) {
		IDta = iDta;
	}
	
	
	
	

	
}
