import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class FormEvent {
	private String name;
	private String occu;
	
	public FormEvent(String name, String occu) {
		super();
		this.name = name;
		this.occu = occu;
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

}
