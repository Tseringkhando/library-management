package Login;

import java.io.*;
import java.util.*;
import Serializable.*;
public class LoginModel {
	private String userId;
	private char[] password;

	ArrayList<Researchers> researchers = new ArrayList<Researchers>();
	public boolean passwordComparison(String userId, char[] password) {
		String uid= getUserId();
		char[] pwd = getPassword();
		if(uid.equals(userId)) {
			if(Arrays.equals(pwd,password)) {
				return true;
			}
			else 
				return false;
		}
		else
			return false;

	}
	
	@SuppressWarnings("unchecked")
	public boolean researcherVerified(LoginView entry)
	{
		boolean correct= false;
		ArrayList<Researchers> researcher = null;
		try {
			FileInputStream filein = new FileInputStream("../src/files/researchers.dat");
			ObjectInputStream objectin = new ObjectInputStream(filein);
			Object objdata= objectin.readObject();
			researcher = (ArrayList<Researchers>)objdata;
		
			for (int i = 0; i < researcher.size(); i++) {
				setUserId(researcher.get(i).getUserName());
				char[] pass =researcher.get(i).getPassword().toCharArray();
				setPassword(pass);
				if(correct=passwordComparison(entry.getUserId(),pass))
					break;	
			}
			objectin.close(); 

		}catch (Exception e) {
		}
	return correct;
	}

	public void setUserId(String userId) {
		this.userId= userId;
	}

	public void setPassword(char[] string) {
		this.password = string;
	}

	public String getUserId() {
		return this.userId;
	}

	public char[] getPassword() {
		return this.password;
	}



}
