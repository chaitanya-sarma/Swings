import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class FormEvent {
	private String name;
	private String occu;
	private String age;
	
	public FormEvent(String name, String occu, String age) {
		super();
		this.name = name;
		this.occu = occu;
		this.age = age;
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
}
