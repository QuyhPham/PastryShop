package Normal;

public class Drink {
	
	public String Name, Size, MainIngredients;
	public byte[] Image;
	public long Price;
	public int ID;
	
	public Drink() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	public Drink(String name, String size, String mainIngredients, byte[] image, long price, int iD) {
		
		Name = name;
		Size = size;
		MainIngredients = mainIngredients;
		Image = image;
		Price = price;
		ID = iD;
	}





	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSize() {
		return Size;
	}

	public void setSize(String size) {
		Size = size;
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
