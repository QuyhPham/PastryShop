package Normal;

public class Employee {
	
//	String Name, Date, Sex, Shifts, Note;
//    long CCCD, Phone, Salary;
//    int ID;
	
	public String Name, Date, Sex, Shifts, Note;
	public long CCCD, Phone, Salary;
	public int ID;
	
	public Employee(){
		
	}
	

	


	public Employee(String name, String date, String sex, String shifts, String note, long cCCD, long phone,
			long salary, int iD) {
		
		Name = name;
		Date = date;
		Sex = sex;
		Shifts = shifts;
		Note = note;
		CCCD = cCCD;
		Phone = phone;
		Salary = salary;
		ID = iD;
	}





	





	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public String getShifts() {
		return Shifts;
	}

	public void setShifts(String shifts) {
		Shifts = shifts;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public long getCCCD() {
		return CCCD;
	}

	public void setCCCD(long cCCD) {
		CCCD = cCCD;
	}

	public long getPhone() {
		return Phone;
	}

	public void setPhone(long phone) {
		Phone = phone;
	}

	public long getSalary() {
		return Salary;
	}

	public void setSalary(long salary) {
		Salary = salary;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	
	
	
	

}
