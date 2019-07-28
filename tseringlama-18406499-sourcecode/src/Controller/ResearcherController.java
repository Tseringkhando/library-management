package Controller;
import View.*;
import java.awt.event.*;
import javax.swing.JScrollPane;
import Login.*;
import Model.*;

public class ResearcherController
{
	ResearcherView researcherview;
	ResearcherModel	researchermodel;
	LoginView loginview;
	String a ;
	public void settrying(String a) {this.a = a;}
	public String gettrying(){ return this.a; }
	public ResearcherController(ResearcherView researcherview){this.researcherview =researcherview; }
	
	public void operate()
	{
		researcherview.getmntmSignOut().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{ 
				researcherview.dispose();
				loginview = new LoginView();
				loginview.setVisible(true);
				LoginModel log= new LoginModel();
				LoginController operator = new LoginController(log, loginview);
				operator.userSignIn();
			}
		});
		
		//show
		researcherview.getbtnViewBookChapter().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {researcherview.displayBookChapter();}
		});
		researcherview.getbtnViewJournalArticle().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {researcherview.displayJournalArticles();}
		});
		researcherview.getbtnViewConferenceArticle().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {researcherview.displayConferenceArticle();}
		});
		researcherview.getbtnViewHired().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {researcherview.displayIssuedPanel();}
		});
	}
	
	public void viewBookChapters() {
		researchermodel= new ResearcherModel();
		JScrollPane rejsp = researchermodel.getbScrollPane();
		researcherview.setBookTable(researchermodel.getBookTable());
		researcherview.setBookScrollPane(rejsp); }

	public void viewJournalAricles() {
		researchermodel= new ResearcherModel();
		JScrollPane rejsp = researchermodel.getjScrollPane();
		researcherview.setJournalTable(researchermodel.getJournalTable());
		researcherview.setJournalScrollPane(rejsp); }

	public void viewConferenceArticles() {
		researchermodel= new ResearcherModel();
		JScrollPane rejsp = researchermodel.getcScrollPane();
		researcherview.setConferenceTable(researchermodel.getConferenceTable());
		researcherview.setConferenceScrollPane(rejsp); }
	
	public void viewHires() {
		researchermodel= new ResearcherModel(gettrying());
		JScrollPane rejsp = researchermodel.gethScrollPane();
		researcherview.setHireTable(researchermodel.getHireTable());
		researcherview.setHireScrollPane(rejsp); }

}
