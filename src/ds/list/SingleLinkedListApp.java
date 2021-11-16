package ds.list;

class Person{
	public int id;
	public String name;
	public Person next;
	
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
		
	}
	
	public void display() {
		System.out.println( " Person ID :"+id+ " Person name :"+name);
	}
	
}
class PersonList{
	private Person first;
	
	public PersonList() {
		first = null;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public void displayList() {
		System.out.println(" Displaying List");
		Person current = first;
		while(current != null) {
			current.display();
			current = current.next;
		}
	}
	
	public void insertFIrst(Person person) {
		Person newPerson = person;
		newPerson.next = first;
		first = newPerson;
		
	}
	
	public Person deleteFirst() {
		Person temp = first;
		first = first.next;
		return temp;
		
	}
	
	public Person find(int id) {
		Person current = first;
		while(current.id != id) {
			if(current.next == null)
				return null;
			else
				current = current.next;
		}
		return current;
		}
	
	public Person delete(int id) {
		Person current = first;
		Person previous = first;
		while(current.id != id) {
			if(current.next == null)
				return null;
			else
				previous = current;
				current = current.next;
				
						
		}
		if(current == first)
			previous = first.next;
		else
			previous.next = current.next;
		
		return current;
	}
	
	
}
public class SingleLinkedListApp{
	public static void main(String[] args) {
		Person person1 = new Person(1, "madhu");
		Person person2 = new Person(2, "sudhan");
		Person person3 = new Person(3, "valli");
		Person person4 = new Person(4, "nipun");
		Person person5 = new Person(5, "ruthu");
		
		PersonList personList = new PersonList();
		personList.insertFIrst(person1);
		personList.insertFIrst(person2);
		personList.insertFIrst(person3);
		personList.insertFIrst(person4);
		personList.insertFIrst(person5);
		
		personList.displayList();
		
		if(personList.find(3) != null)
			System.out.println(" person found");
		else 
			System.out.println("not found");
		
		
		if(personList.delete(3) != null)
			System.out.println(" person deleted");
		else 
			System.out.println("not deleted");
		
		personList.displayList();
		
		
		
		
		
	}
	
}
