package Login;

import javax.swing.JOptionPane;

import Model.ResearcherModel;

import java.awt.event.*;
import java.util.*;
import View.*;
public class LoginController{
	LoginView loginView;
	LoginModel loginModel;

	public LoginController(LoginModel log, LoginView screen) 
	{
		this.loginView= screen;
		this.loginModel=log;
	}

	public void userSignIn()
	{
		loginView.signIN(new ActionListener () {	
			public void actionPerformed(ActionEvent e)
			{
				char[] c= {'a','d','m','i','n'};
				if(loginView.getUserId().equals("admin")) {
					if( Arrays.equals(loginView.getUserPass(),c))
					{
						loginView.dispose();
						AdminView newView = new AdminView();
					}
					else {JOptionPane.showMessageDialog(null, "Password Incorrect!");}
				}
				else
				{
					if(loginModel.researcherVerified(loginView))
					{
						loginView.dispose();
						ResearcherView newview = new ResearcherView(loginModel.getUserId());
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Username or Password Incorrect!");
					}

				}

			}
		});
	}
}
