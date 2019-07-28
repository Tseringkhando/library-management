package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;
import View.*;
import Login.*;
import Model.*;

public class AdminController 
{
	AdminView adminview;
	AdminModel adminmodel;
	LoginView loginview;
	DataReader reader = new DataReader();

	//constructor
	public AdminController(AdminView adv) { this.adminview = adv; }

	//adding functions
	public void activateButtons()
	{
		adminview.getmntmSignOut().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{ 
				adminview.dispose();
				loginview = new LoginView();
				loginview.setVisible(true);
				LoginModel log= new LoginModel();
				LoginController operator = new LoginController(log, loginview);
				operator.userSignIn();
			}
		});

		//buttons
		adminview.getbtnAddResearcher().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {adminview.addResearcher();}
		});

		adminview.getbtnViewResearcher().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {adminview.displayResearchers();}
		});

		adminview.getbtnAddBookChapter().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {adminview.addBook();}
		});

		adminview.getbtnAddConferenceArticle().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {adminview.addConference();}
		});

		adminview.getbtnAddJournalArticle().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {adminview.addJournalArticle();}
		});

		adminview.getbtnViewBookChapter().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {adminview.displayBookChapter();}
		});

		adminview.getbtnViewJournalArticle().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {adminview.displayJournalArticles();}
		});

		adminview.getbtnViewConferenceArticle().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {adminview.displayConferenceArticle();}
		});

		adminview.getbtnViewIssuedArticles().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {adminview.displayIssuedPanel();}
		});


	}
	//validate email
	//reference from https://www.tutorialspoint.com/validate-email-address-in-java
	public boolean isValidEmail(String e) {
		   String type = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		   return e.matches(type); }
	
	//validate contact
	//reference from https://howtodoinjava.com/regex/java-regex-validate-international-phone-numbers/
	public boolean isvalidContact(String c)
	{
		String type = "^\\+(?:[0-9] ?){6,14}[0-9]$";
		   return c.matches(type);
	}
	//adding methods
	public void addResearcher()
	{	adminview.getbtnAddResearcher().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(adminview.gettfTitle().getText().isEmpty()) { 
				JOptionPane.showMessageDialog(null, "Enter complete information");}
		
			else if(!isvalidContact(adminview.gettfContact().getText())) {
				JOptionPane.showMessageDialog(null, "Enter valid contact (+977 98888888)");}
			else if(!isValidEmail(adminview.gettfEmail().getText())) {
				JOptionPane.showMessageDialog(null, "Enter Valid Email Address (example@email.com)");}
			else {
				adminmodel = new AdminModel();
				adminmodel.enterNewReseacher(adminview);
				adminview.addResearcher();
			}
		}
	});
	}

	public void addBookChapter()
	{
		adminview.getbtnAddBook().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(adminview.gettfTitle().getText().isEmpty() || adminview.gettfYear().getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Enter complete information");
				else {
					adminmodel = new AdminModel();
					adminmodel.enterNewBookChapter(adminview);
					adminview.addBook();}}
		});
	}

	public void addJournalArticle()
	{
		adminview.getbtnAddJArticle().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(adminview.gettfArticleTitle().getText().isEmpty() || adminview.gettfYear().getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Enter complete information");
				else {
					adminmodel = new AdminModel();
					adminmodel.enterNewJournalArticle(adminview);
					adminview.addJournalArticle();}
			}
		});
	}

	public void addConferenceArticle()
	{
		adminview.getbtnAddCArticle().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(adminview.gettfTitle().getText().isEmpty() || adminview.gettfYear().getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Enter complete information");
				else {
					adminmodel = new AdminModel();
					adminmodel.enterNewConferenceArticle(adminview);
					adminview.addConference(); }
			}
		});
	}

	/**
	 * View Table  
	 */
	public void viewResearchers() {
		adminmodel= new AdminModel();
		JScrollPane rejsp = adminmodel.getrScrollPane();
		adminview.setTable(adminmodel.getresearcherTable());
		adminview.setScrollPane(rejsp); }

	public void viewBookChapters() {
		adminmodel= new AdminModel();
		JScrollPane rejsp = adminmodel.getbScrollPane();
		adminview.setBookTable(adminmodel.getBookTable());
		adminview.setBookScrollPane(rejsp); }

	public void viewJournalAricles() {
		adminmodel= new AdminModel();
		JScrollPane rejsp = adminmodel.getjScrollPane();
		adminview.setJournalTable(adminmodel.getJournalTable());
		adminview.setJournalScrollPane(rejsp); }

	public void viewConferenceArticles() {
		adminmodel= new AdminModel();
		JScrollPane rejsp = adminmodel.getcScrollPane();
		adminview.setConferenceTable(adminmodel.getConferenceTable());
		adminview.setConferenceScrollPane(rejsp); }

	public void viewHires() {
		adminmodel= new AdminModel();
		JScrollPane rejsp = adminmodel.gethScrollPane();
		adminview.setHireTable(adminmodel.getHireTable());
		adminview.setHireScrollPane(rejsp); }

	/**
	 ******* modify********
	 */
	//researcher
	public void editResearcher() 
	{
		adminview.getbtnSave().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminmodel = new AdminModel();
				if(adminview.gettfID().getText().isEmpty()) {showSelectRowtoEdit(); }else {
					try {
						adminmodel.editResearcherInfo(adminview,adminview.getEditIndex());
					} catch (FileNotFoundException e1) {e1.printStackTrace();} 
					catch (IOException e1) {e1.printStackTrace();	}
					JOptionPane.showMessageDialog(null, "Changes Saved");
					adminview.displayResearchers();
				}
			}
		});
	}
	//book chapters
	public void editBookChapters() 
	{
		adminview.getbtnSave().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminmodel = new AdminModel();
				if(adminview.gettfID().getText().isEmpty()){showSelectRowtoEdit(); }else {
					try {
						adminmodel.editBookChapterInfo(adminview,adminview.getEditIndex());
					} catch (FileNotFoundException e1) {e1.printStackTrace();} 
					catch (IOException e1) {e1.printStackTrace();	}
					JOptionPane.showMessageDialog(null, "Changes Saved");
					adminview.displayBookChapter();
				}
			}
		});
	}

	//journal articles
	public void editJournalArticles() 
	{
		adminview.getbtnSave().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminmodel = new AdminModel();
				if(adminview.gettfID().getText().isEmpty()){showSelectRowtoEdit(); 
				}else {
					try {
						adminmodel.editJournalInfo(adminview,adminview.getEditIndex());
					} catch (FileNotFoundException e1) {e1.printStackTrace();} 
					catch (IOException e1) {e1.printStackTrace();	}
					JOptionPane.showMessageDialog(null, "Changes Saved");
					adminview.displayJournalArticles();
				}
			}
		});
	}

	//conference
	public void editConfernceArticles() 
	{
		adminview.getbtnSave().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminmodel = new AdminModel();
				if(adminview.gettfID().getText().isEmpty()){
					showSelectRowtoEdit(); 
				}else {
					try {
						adminmodel.editConferenceArticle(adminview,adminview.getEditIndex());
					} catch (FileNotFoundException e1) {e1.printStackTrace();} 
					catch (IOException e1) {e1.printStackTrace();	}
					JOptionPane.showMessageDialog(null, "Changes Saved");
					adminview.displayConferenceArticle();
				}
			}
		});
	}

	/**
	 * *****delete*************
	 */

	//researchers
	public void deleteResearcher() 
	{
		adminview.getbtnDelete().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(adminview.gettfID().getText().isEmpty()){ showSelectRow(); }
				else {
					adminmodel = new AdminModel();
					try {
						adminmodel.deleteResearcherInfo(adminview, adminview.getEditIndex());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					adminview.displayResearchers();
				}
			}
		});
	}

	//bookchapter
	public void deleteBookChapters() 
	{
		adminview.getbtnDelete().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(adminview.gettfID().getText().isEmpty()) {
					showSelectRow();
				}else {
					adminmodel = new AdminModel();
					try {
						adminmodel.deleteBookChapterInfo(adminview, adminview.getEditIndex());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					adminview.displayBookChapter();}
			}
		});
	}

	//journal
	public void deleteJournalArticles()
	{
		adminview.getbtnDelete().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(adminview.gettfID().getText().isEmpty()){
					showSelectRow();
				}else {
					adminmodel = new AdminModel();
					try {
						adminmodel.deleteJournalArticle(adminview, adminview.getEditIndex());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					adminview.displayJournalArticles();
				}}
		});
	}

	//conference
	public void deleteConferenceArticles()
	{
		adminview.getbtnDelete().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(adminview.gettfID().getText().isEmpty()) {
					showSelectRow();
				}else {
					adminmodel = new AdminModel();
					try {
						adminmodel.deleteConferenceArticle(adminview, adminview.getEditIndex());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					adminview.displayConferenceArticle();
				}
			}
		});
	}
	//search
	public void searchResearcher()
	{
		adminview.getbtnSearch().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(adminview.gettfSearch().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter ID to search!!");}
				else {
					if(adminmodel.searchResearcher(adminview.gettfSearch().getText())) {
						adminview.searchResearcherPanel();
						adminview.getlblId().setText(adminmodel.getstr1());
						adminview.getlbl2().setText(adminmodel.getstr2());
						adminview.getlbl3().setText(adminmodel.getstr3());
						adminview.getlbl4().setText(adminmodel.getstr4());
						adminview.getlbl5().setText(adminmodel.getstr5());
						adminview.getlbl6().setText(adminmodel.getstr6());
						adminview.getlbl7().setText(adminmodel.getstr7());
						adminview.getlbl9().setText(adminmodel.getstr8());
					}
					else{showNotFound();}
				}
			}});
	}

	public void searchBook()
	{
		adminview.getbtnSearch().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(adminview.gettfSearch().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter Chapter Title to search!!");}
				else {
					if(adminmodel.searchBook(adminview.gettfSearch().getText())) {
						adminview.bookDetailPanel();
						adminview.getlblId().setText(adminmodel.getstr1());
						adminview.getlbl2().setText(adminmodel.getstr2());
						adminview.getlbl3().setText(adminmodel.getstr3());
						adminview.getlbl4().setText(adminmodel.getstr4());
						adminview.getlbl5().setText(adminmodel.getstr5());
						adminview.getlbl6().setText(adminmodel.getstr6());
						adminview.getlbl7().setText(adminmodel.getstr7());
						adminview.getlbl8().setText(adminmodel.getstr8());
					}else{showNotFound();}
				}
			}
		});
	}

	public void searchJournalArticle()
	{
		adminview.getbtnSearch().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(adminview.gettfSearch().getText().isEmpty()) {
					showEnterTitleMsg();}
				else {
					if(adminmodel.searchJournal(adminview.gettfSearch().getText())) {
						adminview.searchJournalPanel();
						adminview.getlblId().setText(adminmodel.getstr1());
						adminview.getlbl2().setText(adminmodel.getstr2());
						adminview.getlbl3().setText(adminmodel.getstr3());
						adminview.getlbl4().setText(adminmodel.getstr4());
						adminview.getlbl5().setText(adminmodel.getstr5());
						adminview.getlbl6().setText(adminmodel.getstr6());
						adminview.getlbl7().setText(adminmodel.getstr7());
						adminview.getlbl8().setText(adminmodel.getstr8());
					}else{showNotFound();}}
			}
		});
	}

	public void searchConferenceArticle()
	{
		adminview.getbtnSearch().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(adminview.gettfSearch().getText().isEmpty()) {
					showEnterTitleMsg();}
				else {
					if(adminmodel.searchConference(adminview.gettfSearch().getText())) {
						adminview.searchConferencePanel();
						adminview.getlblId().setText(adminmodel.getstr1());
						adminview.getlbl2().setText(adminmodel.getstr2());
						adminview.getlbl3().setText(adminmodel.getstr3());
						adminview.getlbl4().setText(adminmodel.getstr4());
						adminview.getlbl5().setText(adminmodel.getstr5());
						adminview.getlbl6().setText(adminmodel.getstr6());
						adminview.getlbl7().setText(adminmodel.getstr7());
					}else{showNotFound();}
				}
			}
		});
	}

	public void issuebook() {
		adminview.getbtnIssue().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean issued = false;
				if(adminview.gettfID().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Select a row first.");}
				else {
					if(reader.readHireDetails()!=null) {
					for(int i=0; i<reader.readHireDetails().size();i++)
					{
						if(reader.readHireDetails().get(i).getAid().equals(adminview.gettfID().getText())) {
							showIssueErrorMessage();
							issued = true;
							break;
						}}}	
					if(issued==false) adminmodel.enterHireEntry(adminview);
				}
			}});
	}
	//return hires
	public void returnHire()
	{
		adminview.getbtnReturn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(adminview.gettfID().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Select a row to return.");
				}else {
					adminmodel = new AdminModel();
					try {
						adminmodel.returnHire(adminview, adminview.getEditIndex());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					adminview.displayIssuedPanel();
				}
			}
		});
	}

	//error messages method
	public void showIssueErrorMessage() {JOptionPane.showMessageDialog(null, "Article cannot be issued to more than one resesarcher.");}
	public void showNotFound() { JOptionPane.showMessageDialog(null, "NOT FOUND"); };
	public void showEnterTitleMsg() { 	JOptionPane.showMessageDialog(null, "Enter Article's Title to search!!");}
	public void showSelectRow() { 	JOptionPane.showMessageDialog(null, "Select a row to delete."); }
	public void showSelectRowtoEdit() { JOptionPane.showMessageDialog(null, "Select a row to edit."); }
}

