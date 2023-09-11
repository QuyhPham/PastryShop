package Normal;

public class Shape {
	public String Shape;
	public long Price; 
	public int IDs;
	
	public Shape() {
		
	}

	

	public Shape(String shape, long price, int iDs) {
		
		Shape = shape;
		Price = price;
		IDs = iDs;
	}



	public String getShape() {
		return Shape;
	}

	public void setShape(String shape) {
		Shape = shape;
	}

	public long getPrice() {
		return Price;
	}

	public void setPrice(long price) {
		Price = price;
	}

	public int getIDs() {
		return IDs;
	}

	public void setIDs(int iDs) {
		IDs = iDs;
	}
	

	
}
