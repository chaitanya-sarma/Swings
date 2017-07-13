package gui;
import java.io.File;

import javax.swing.filechooser.FileFilter;

public class PersonFilter extends FileFilter{

	@Override
	public boolean accept(File f) {
		String name = f.getName();
		int lastIndex = name.lastIndexOf(".");
		if(f.isDirectory())return true;
		
		if(lastIndex == -1 || lastIndex == name.length()-1)
		return false;
		
		else{
			if(name.substring(lastIndex+1, name.length()-1) == "jpeg")
				return true;
			else 
				return false;
		}
	}

	@Override
	public String getDescription() {
		return "PersonFie(*.jpeg)";
	}

}
