package model;

public class Person {
	private static int count = 0;
	private String name;
	private String occu;
	private AgeCategory age;
	private int id;
	
	public Person(String name, String occu, AgeCategory age) {
		super();
		this.name = name;
		this.occu = occu;
		this.age = age;
		id = count++;
	}
	public Person() {
		id = count++;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOccu() {
		return occu;
	}
	public void setOccu(String occu) {
		this.occu = occu;
	}
	public AgeCategory getAge() {
		return age;
	}
	public void setAge(AgeCategory age) {
		this.age = age;
	}
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
}
