package Normal;

public class Users {
	String name, sex, email, username;
	long cccd, phone;
	int ID;
	
	public Users(String name, String sex, String email, String username, long cccd, long phone, int iD) {
		
		this.name = name;
		this.sex = sex;
		this.email = email;
		this.username = username;
		this.cccd = cccd;
		this.phone = phone;
		ID = iD;
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public Users() {
		name = sex = email = username = null;
		cccd = phone = 0;
	}
	
	
	public Users(String name, String sex, String email, String username, long cccd, long phone) {
		
		this.name = name;
		this.sex = sex;
		this.email = email;
		this.username = username;
		this.cccd = cccd;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getCccd() {
		return cccd;
	}
	public void setCccd(long cccd) {
		this.cccd = cccd;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	

	
}
