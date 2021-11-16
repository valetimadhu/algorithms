package domain;

public class Person {
	private String id;
	private String firstName;
	private String lastName;
	private Long mobile;
	private Address homeAddr;
	private Address workAddr;
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String id, String firstName, String lastName, Long mobile, Address homeAddr, Address workAddr) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.homeAddr = homeAddr;
		this.workAddr = workAddr;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public Address getHomeAddr() {
		return homeAddr;
	}
	public void setHomeAddr(Address homeAddr) {
		this.homeAddr = homeAddr;
	}
	public Address getWorkAddr() {
		return workAddr;
	}
	public void setWorkAddr(Address workAddr) {
		this.workAddr = workAddr;
	}
	
	
}
