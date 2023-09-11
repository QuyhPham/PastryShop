package Normal;

public class Cookie {
	
	public String Name, MainIngredients;
	public byte[] Image;
	public long Price;
	public int ID;
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Cookie() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Cookie(String name, String mainIngredients, byte[] image, long price, int iD) {
		
		Name = name;
		MainIngredients = mainIngredients;
		Image = image;
		Price = price;
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getMainIngredients() {
		return MainIngredients;
	}

	public void setMainIngredients(String mainIngredients) {
		MainIngredients = mainIngredients;
	}

	public byte[] getImage() {
		return Image;
	}

	public void setImage(byte[] image) {
		Image = image;
	}

	public long getPrice() {
		return Price;
	}

	public void setPrice(long price) {
		Price = price;
	}

}
