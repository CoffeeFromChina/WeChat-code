package Lambda;

public class Person {
	private String firstName;
	private String lastName;
	private String job;
	private String gender;//性别
	private int salary;
	private int age;
	public Person(String firstName,String lastName,String job,String gender,int age,int salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.job = job;
		this.gender = gender;
		this.firstName = firstName;
		this.salary = salary;
		this.age = age;
	}
	public Person() {
		
	}
	//私有域的Getter和Setter
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
