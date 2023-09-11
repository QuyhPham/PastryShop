package Normal;

public class Part {
	public String Part;
	public long Price; 
	public int IDp; 
	
	public Part() {
		
	}

	

	public Part(String part, long price, int iDp) {
		
		Part = part;
		Price = price;
		IDp = iDp;
	}



	public String getPart() {
		return Part;
	}

	public void setPart(String part) {
		Part = part;
	}

	public long getPrice() {
		return Price;
	}

	public void setPrice(long price) {
		Price = price;
	}

	public int getIDp() {
		return IDp;
	}

	public void setIDp(int iDp) {
		IDp = iDp;
	}
	
	
	
	

	
}
