package model;

import java.util.ArrayList;

public class DataBase {
	private ArrayList<Person> people;

	public DataBase() {
		people = new ArrayList<>();
	}

	public void addPerson(Person person) {
		people.add(person);
	}

	public ArrayList<Person> getPersons() {
		return people;
	}
}
