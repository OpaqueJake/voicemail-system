// Jacob Fisher

import java.util.*;

public class Caller {
	
	private String ownerName;
	private String password;
	private int ext;
	private String greeting;
	
	// Allows creation of a new caller setting the name, password and extention, and gives a generic greeting for that caller
	public Caller(String name, String pw, int ext) {
		this.setOwnerName(name);
		this.password = pw;
		this.ext = ext;
		setGreeting("\sYou have reached the Voicemail box of " + this.getOwnerName() + "! Please leave me message and I will get back to you as soon as I can!");
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getExt() {
		return ext;
	}
	public void setExt(int ext) {
		this.ext = ext;
	}
	
	public String getGreeting() {
		return greeting;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String toString() {
		return String.format("%s, Password: %s Extention#: %s", getOwnerName(), getPassword(), getExt());
	}
		
}
