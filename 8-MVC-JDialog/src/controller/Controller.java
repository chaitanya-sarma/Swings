package controller;

import gui.FormEvent;
import model.AgeCategory;
import model.DataBase;
import model.Person;

public class Controller {
	DataBase db = new DataBase();
	public void addPerson(FormEvent e){
		String name = e.getName();
		String occ = e.getOccu();
		String age = e.getAge();
		
		Person p = new Person();
		p.setName(name);
		p.setOccu(occ);
		p.setAge(ageCategory(age));
		db.addPerson(p);
	}

	private AgeCategory ageCategory(String age) {
		if(age.equalsIgnoreCase("Below 18")) return AgeCategory.child;
		if(age.equalsIgnoreCase("18 and 65")) return AgeCategory.adult;
		else return AgeCategory.senior;
	}
}
