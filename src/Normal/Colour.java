package Normal;

public class Colour {
	public String Color;
	public long Price; 
	public int IDc; 
	
	public Colour() {
		
	}

	

	public Colour(String color, long price, int iDc) {
		
		Color = color;
		Price = price;
		IDc = iDc;
	}



	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public long getPrice() {
		return Price;
	}

	public void setPrice(long price) {
		Price = price;
	}

	public int getIDc() {
		return IDc;
	}

	public void setIDc(int iDc) {
		IDc = iDc;
	}

}
