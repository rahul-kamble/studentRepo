package modelclass;

public class StudentModel {

	private int rollNo;
	private String name;
	private String address;
	private int marks;
	private String age;
	private int gender;

	public StudentModel(int rollNo, String name, String address, int marks, String age, int gender) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.address = address;
		this.marks = marks;
		this.age = age;
		this.gender = gender;
	}
	public StudentModel() {
		// TODO Auto-generated constructor stub
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
