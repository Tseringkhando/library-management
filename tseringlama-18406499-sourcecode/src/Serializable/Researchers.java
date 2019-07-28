package Serializable;

import java.io.Serializable;
import java.util.ArrayList;

public class Researchers implements Serializable {

	private static final long serialVersionUID = 1L;
	private String ID, name, address,contact, email, username, password;
	//constructor
	public Researchers() {}
	//parameterized
	public Researchers(String ID, String name, String  address, String contact, String  email, String  username, String  password)
	{
		this.ID= ID;
		this.name=name;
		this.address= address;
		this.contact= contact;
		this.email= email;
		this.username= username;
		this.password = password;
	}
	//accessors
	
	public String getId() { return this.ID; }
	public String getName() { return this.name; }
	public String getAddress() { return this.address; }
	public String getEmail() { return this.email; }
	public String getContact() { return this.contact; }
	public String getUserName() { return this.username; }
	public String getPassword() { return this.password; }
	
}
