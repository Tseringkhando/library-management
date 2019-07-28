package Model;

import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Serializable.*;
import View.*;
public class AdminModel {
	//table
	private DefaultTableModel researchertableView = new DefaultTableModel(0, 9);
	private DefaultTableModel bookTableView = new DefaultTableModel(0, 9);
	private DefaultTableModel journalTableView = new DefaultTableModel(0, 9);
	private DefaultTableModel conferenceTableView = new DefaultTableModel(0, 8);
	private DefaultTableModel hireTableView = new DefaultTableModel(0, 3);

	private JTable researcherTable=new JTable(researchertableView);
	private JTable bookTable=new JTable(bookTableView);
	private JTable journalTable= new JTable(journalTableView);
	private JTable conferencetable= new JTable(conferenceTableView);
	private JTable hiretable= new JTable(hireTableView);

	private JScrollPane rScrollPane = new JScrollPane(researcherTable);
	private JScrollPane bScrollPane = new JScrollPane(bookTable);
	private JScrollPane jScrollPane = new JScrollPane(journalTable);
	private JScrollPane cScrollPane = new JScrollPane(conferencetable);
	private JScrollPane hScrollPane = new JScrollPane(hiretable);
	
	private String str1,str2,str3,str4,str5,str6,str7,str8;

	//array
	private ArrayList <Researchers> reserchersArray  = new ArrayList<Researchers>();
	private ArrayList <BookChapters> bookChapterArray  = new ArrayList<BookChapters>();
	private ArrayList <JournalArticles> journalArray  = new ArrayList<JournalArticles>();
	private ArrayList <ConferenceArticles> conferenceArray  = new ArrayList<ConferenceArticles>();
	private ArrayList <IssueRecords> issueArray = new ArrayList<IssueRecords>();

	Researchers researcherModel;
	BookChapters bookModel;
	JournalArticles journalModel;
	ConferenceArticles conferenceModel;
	IssueRecords issueModel;
	
	//this will load the serialisable objects into arrays
	DataReader reader = new DataReader();

	//constructor
	public AdminModel() 
	{ 
		showResearcherTable(); 
		showBookChapterTable();
		showJournalArticles();
		showConferenceArticles();
		showHires();
	}


	/** 
	 * *****creating new records
	 */
	//researchers
	public void enterNewReseacher(AdminView adminview)
	{
		researcherModel = new Researchers(adminview.gettfID().getText(),
				adminview.gettfTitle().getText(),
				adminview.gettfAddress().getText(), adminview.gettfContact().getText(),
				adminview.gettfEmail().getText(), 
				adminview.gettfUser().getText(), adminview.gettfPassword().getText());
		if(reader.readData()!=null) 
		{
			reserchersArray= reader.readData();
			reserchersArray.add(researcherModel);
			newData(); 
			JOptionPane.showMessageDialog(null, "Researcher Added");
		}
		else 
		{
			reserchersArray.add(researcherModel);
			newData(); 
			JOptionPane.showMessageDialog(null, "Researcher Added");
		}
	}

	//bookchapters
	public void enterNewBookChapter(AdminView adminview)
	{
		bookModel = new BookChapters(adminview.gettfID().getText(),
				adminview.gettfTitle().getText(),
				adminview.gettfAuthor().getText(), adminview.gettfYear().getText(),
				adminview.gettfEditor().getText(), 
				adminview.gettfPlace().getText(), adminview.gettfPublisher().getText(),adminview.gettfPage().getText());
		if(reader.readBookData()!=null) 
		{
			bookChapterArray= reader.readBookData();
			bookChapterArray.add(bookModel);
			newBookData(); 
			JOptionPane.showMessageDialog(null, "Book Chapter Added");
		}
		else 
		{
			bookChapterArray.add(bookModel);
			newBookData(); 
			JOptionPane.showMessageDialog(null, "Book Chapter Added");
		}
	}

	//journal articles
	public void enterNewJournalArticle(AdminView adminview)
	{
		journalModel = new JournalArticles(adminview.gettfID().getText(),
				adminview.gettfArticleTitle().getText(),
				adminview.gettfJTitle().getText(), adminview.gettfYear().getText(),
				adminview.gettfVolume().getText(), 
				adminview.gettfIssue().getText(), adminview.gettfAuthor().getText(),adminview.gettfPage().getText());
		if(reader.readJournalData()!=null) 
		{
			journalArray= reader.readJournalData();
			journalArray.add(journalModel);
			newJournalData(); 
			JOptionPane.showMessageDialog(null, "Journal Article Added");
		}
		else 
		{
			journalArray.add(journalModel);
			newJournalData(); 
			JOptionPane.showMessageDialog(null, "Journal Article Added");
		}
	}

	//conference
	public void enterNewConferenceArticle(AdminView adminview)
	{
		conferenceModel = new ConferenceArticles(adminview.gettfID().getText(),
				adminview.gettfTitle().getText(),
				adminview.gettfAuthor().getText(), adminview.gettfYear().getText(),
				adminview.gettfEditor().getText(), 
				adminview.gettfPlace().getText(),adminview.gettfPage().getText());
		if(reader.readConferenceData()!=null) 
		{
			conferenceArray= reader.readConferenceData();
			conferenceArray.add(conferenceModel);
			newConferenceData(); 
			JOptionPane.showMessageDialog(null, "Conference Article Added");
		}
		else 
		{
			conferenceArray.add(conferenceModel);
			newConferenceData(); 
			JOptionPane.showMessageDialog(null, "Conference Article Added");
		}
	}

	/**
	 * **********writing to file **********
	 */
	public void newData() 
	{
		try 
		{
			File file = new File("../src/files/researchers.dat");
			FileOutputStream fileout = new FileOutputStream(file);
			ObjectOutputStream objectout = new ObjectOutputStream(fileout);
			objectout.writeObject(reserchersArray);
			objectout.close();
		}catch (Exception e) { }
	}

	//adding book chapter
	public void newBookData() 
	{
		try 
		{
			File file = new File("../src/files/bookchapters.dat");
			FileOutputStream fileout = new FileOutputStream(file);
			ObjectOutputStream objectout = new ObjectOutputStream(fileout);
			objectout.writeObject(bookChapterArray);
			objectout.close();
		}catch (Exception e) { }
	}

	//journal article
	public void newJournalData() 
	{
		try 
		{
			File file = new File("../src/files/journalArticles.dat");
			FileOutputStream fileout = new FileOutputStream(file);
			ObjectOutputStream objectout = new ObjectOutputStream(fileout);
			objectout.writeObject(journalArray);
			objectout.close();
		}catch (Exception e) { }
	}
	//conference
	public void newConferenceData()
	{
		try 
		{
			File file = new File("../src/files/conferenceArticles.dat");
			FileOutputStream fileout = new FileOutputStream(file);
			ObjectOutputStream objectout = new ObjectOutputStream(fileout);
			objectout.writeObject(conferenceArray);
			objectout.close();
		}catch (Exception e) { }
	}

	/** 
	 * *****display methods **********
	 */
	//researchers
	public void showResearcherTable() {
		int number=0;
		if(reader.readData()!=null) {
			reserchersArray =reader.readData();
			Researchers reObj = new Researchers();
			for(int i=0; i<reserchersArray.size(); i++)
			{
				number++;
				reObj=reserchersArray.get(i);
				Object[] data= {number,reObj.getId(),reObj.getName(),reObj.getAddress(),reObj.getContact(),reObj.getEmail(),reObj.getUserName(),reObj.getPassword()};
				researchertableView.addRow(data);		
			}}
			Object tableHead[]= {"SN","ID","Name","Address","Contact","Email","Username","Password"};
			researchertableView.setColumnIdentifiers(tableHead);
			researcherTable.setRowHeight(30);
			//reference from: https://stackoverflow.com/questions/953972/java-jtable-setting-column-width
			researcherTable.getColumnModel().getColumn(0).setPreferredWidth(3);
			researcherTable.getColumnModel().getColumn(1).setPreferredWidth(7);
			researcherTable.getColumnModel().getColumn(5).setPreferredWidth(100);
			researcherTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
	}

	//bookchapters
	public void showBookChapterTable() {
		int n =0;
		if(reader.readBookData()!=null) {
			bookChapterArray = reader.readBookData();
			BookChapters reObj = new BookChapters();
			for(int i=0; i<bookChapterArray.size(); i++)
			{
				n++;
				reObj=bookChapterArray.get(i);
				Object[] data= {n,reObj.getId(), reObj.getTitle(), reObj.getAuthor(), reObj.getYear(), reObj.getBookEditor(), reObj.getPublicationPlace(), reObj.getPublisher(), reObj.getPage()};
				bookTableView.addRow(data);		
			}}
			Object tableHead[]= {"SN","ID","Title","Author(s)","Publication Year","Book Editor","Place of Publication","Publisher","Page"};
			bookTableView.setColumnIdentifiers(tableHead);
			bookTable.setRowHeight(25);
			bookTable.getColumnModel().getColumn(0).setPreferredWidth(3);
			bookTable.getColumnModel().getColumn(1).setPreferredWidth(5);
			bookTable.getColumnModel().getColumn(2).setPreferredWidth(100);
			bookTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
	
	}

	//journalArticles
	public void showJournalArticles() {
		int n=0;
		if(reader.readJournalData()!=null) {
			
			journalArray = reader.readJournalData();
			JournalArticles reObj = new JournalArticles();
			for(int i=0; i<journalArray.size(); i++)
			{
				n++;
				reObj=journalArray.get(i);
				Object[] data= {n,reObj.getId(), reObj.getTitle(), reObj.getJournalTitle(), reObj.getYear(),reObj.getVolume(), reObj.getIssue(),reObj.getAuthor(),  reObj.getPage()};
				journalTableView.addRow(data);		
			}}
			Object tableHead[]= {"SN","ID","Title","Journal Title","Publication Year","Volume","Issue No.","Author(s)","Page"};
			journalTableView.setColumnIdentifiers(tableHead);
			journalTable.setRowHeight(25);
			journalTable.getColumnModel().getColumn(0).setPreferredWidth(3);
			journalTable.getColumnModel().getColumn(1).setPreferredWidth(5);
			journalTable.getColumnModel().getColumn(2).setPreferredWidth(100);
			journalTable.getColumnModel().getColumn(3).setPreferredWidth(100);
			journalTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
	}

	//conference Article
	public void showConferenceArticles() {
		int n =0;
		if(reader.readConferenceData()!=null) {
			
			conferenceArray = reader.readConferenceData();
			ConferenceArticles reObj = new ConferenceArticles();
			for(int i=0; i<conferenceArray.size(); i++)
			{
				n++;
				reObj=conferenceArray.get(i);
				Object[] data= {n,reObj.getId(), reObj.getTitle(), reObj.getAuthor(), reObj.getYear(), reObj.getBookEditor(), reObj.getPublicationPlace(), reObj.getPage()};
				conferenceTableView.addRow(data);		
			}}
			Object tableHead[]= {"SN","ID","Title","Author(s)","Publication Year","Editor(s)","Conference Location","Page"};
			conferenceTableView.setColumnIdentifiers(tableHead);
			conferencetable.setRowHeight(25);
			conferencetable.getColumnModel().getColumn(0).setPreferredWidth(3);
			conferencetable.getColumnModel().getColumn(1).setPreferredWidth(5);
			conferencetable.getColumnModel().getColumn(2).setPreferredWidth(100);
			conferencetable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
			
	}

	/**  
	 **********editing information*****
	 */
	//researchers
	public void editResearcherInfo(AdminView adminview, int i) throws FileNotFoundException, IOException {
		reserchersArray= reader.readData();
		researcherModel= new Researchers(adminview.gettfID().getText(),
				adminview.gettfTitle().getText(),
				adminview.gettfAddress().getText(), adminview.gettfContact().getText(),
				adminview.gettfEmail().getText(), 
				adminview.gettfUser().getText(), adminview.gettfPassword().getText());
		reserchersArray.set(i,researcherModel);
		newData();
	}

	//bookchapter
	public void editBookChapterInfo(AdminView adminview, int i) throws FileNotFoundException, IOException {
		bookChapterArray= reader.readBookData();
		bookModel= new BookChapters(adminview.gettfID().getText(),
				adminview.gettfTitle().getText(),
				adminview.gettfAuthor().getText(), adminview.gettfYear().getText(),
				adminview.gettfEditor().getText(), 
				adminview.gettfPlace().getText(), adminview.gettfPublisher().getText(),adminview.gettfPage().getText());
		bookChapterArray.set(i,bookModel);
		newBookData();
	}

	//journal 
	public void editJournalInfo(AdminView adminview, int i) throws FileNotFoundException, IOException {
		journalArray= reader.readJournalData();
		journalModel= new JournalArticles(adminview.gettfID().getText(),
				adminview.gettfTitle().getText(),adminview.gettfJTitle().getText(),
				adminview.gettfYear().getText(),
				adminview.gettfVolume().getText(), 
				adminview.gettfIssue().getText(), adminview.gettfAuthor().getText(),adminview.gettfPage().getText());
		journalArray.set(i,journalModel);
		newJournalData();
	}

	//conference article
	public void editConferenceArticle(AdminView adminview, int i) throws FileNotFoundException, IOException {
		conferenceArray= reader.readConferenceData();
		conferenceModel= new ConferenceArticles(adminview.gettfID().getText(),
				adminview.gettfTitle().getText(),
				adminview.gettfAuthor().getText(), adminview.gettfYear().getText(),
				adminview.gettfEditor().getText(), 
				adminview.gettfPlace().getText(),adminview.gettfPage().getText());
		conferenceArray.set(i,conferenceModel);
		newConferenceData();
	}

	/**  
	 **********delete information
	 * @throws IOException *****
	 */
	//researchers
	public void deleteResearcherInfo(AdminView adminview,int i) throws IOException {
		int choice = JOptionPane.showConfirmDialog(null, "Are you sure to delete information?", "Confirm",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (choice == JOptionPane.YES_OPTION) {
			reserchersArray=  reader.readData();
			reserchersArray.remove(i);
			if(i==0 && reserchersArray.isEmpty()) {
				reader.deleteFile("../src/files/researchers.dat");}
			else {
				newData();
			}
			
			JOptionPane.showMessageDialog(null, "Removed");
		}
	}
	//book chapters
	public void deleteBookChapterInfo(AdminView adminview,int i) throws IOException {
		int choice = JOptionPane.showConfirmDialog(null, "Are you sure to delete information?", "Confirm",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (choice == JOptionPane.YES_OPTION) {
			bookChapterArray=  reader.readBookData();
			bookChapterArray.remove(i);
			
		if(i==0 && bookChapterArray.isEmpty()) {
			reader.deleteFile("../src/files/bookchapters.dat");
		}
		else {
			newBookData();
		}
			
		JOptionPane.showMessageDialog(null, "Removed");
		}
	}
	//journal
	public void deleteJournalArticle(AdminView adminview,int i) throws IOException {
		int choice = JOptionPane.showConfirmDialog(null, "Are you sure to delete information?", "Confirm",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (choice == JOptionPane.YES_OPTION) {
			journalArray=  reader.readJournalData();
			journalArray.remove(i);
			if(i==0 && journalArray.isEmpty()) {
				reader.deleteFile("../src/files/journalArticles.dat");
			}
			else {
				newJournalData();
			}
			JOptionPane.showMessageDialog(null, "Removed");
		}
	}

	//conference article
	public void deleteConferenceArticle(AdminView adminview,int i) throws IOException {
		int choice = JOptionPane.showConfirmDialog(null, "Are you sure to delete information?", "Confirm",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (choice == JOptionPane.YES_OPTION) {
			conferenceArray=  reader.readConferenceData();
			conferenceArray.remove(i);
			if(i==0 && conferenceArray.isEmpty())
			{
				reader.deleteFile("../src/files/conferenceArticles.dat");
			}
			else {
				newConferenceData();
				}
			JOptionPane.showMessageDialog(null, "Removed");
		}
	}

	//accessors
	public JScrollPane getrScrollPane()	{ return rScrollPane;	}
	public JScrollPane getbScrollPane()	{ return bScrollPane;	}
	public JScrollPane getjScrollPane()	{ return jScrollPane;	}
	public JScrollPane getcScrollPane() { return cScrollPane;   }
	public JScrollPane gethScrollPane() { return hScrollPane;   }

	public JTable getresearcherTable() { return researcherTable;	}
	public JTable getBookTable() { return bookTable; }
	public JTable getJournalTable() { return journalTable; }
	public JTable getConferenceTable() { return conferencetable; }
	public JTable getHireTable() { return hiretable; }
	
	public String getstr1() { return str1; }
	public String getstr2() { return str2; }
	public String getstr3() { return str3; }
	public String getstr4() { return str4; }
	public String getstr5() { return str5; }
	public String getstr6() { return str6; }
	public String getstr7() { return str7; }
	public String getstr8() { return str8; }

	//search
	public boolean searchBook(String s)
	{
		bookChapterArray = reader.readBookData();		
		boolean a = false;
		for(int i=0; i<bookChapterArray.size(); i++)
		{
			if(bookChapterArray.get(i).getTitle().equalsIgnoreCase(s))
			{
				str1=bookChapterArray.get(i).getId();
				str2= bookChapterArray.get(i).getTitle();
				str3= bookChapterArray.get(i).getAuthor();
				str4 = bookChapterArray.get(i).getYear();
				str5=bookChapterArray.get(i).getBookEditor();
				str6=bookChapterArray.get(i).getPublicationPlace();
				str7=bookChapterArray.get(i).getPublisher();
				str8=bookChapterArray.get(i).getPage();
				a= true;
				break;
			}
			else {
				a= false;
			}
		}
		return a;
	}

	public boolean searchJournal(String s)
	{
		journalArray = reader.readJournalData();		
		boolean a = false;
		for(int i=0; i<journalArray.size(); i++)
		{
			if(journalArray.get(i).getTitle().equalsIgnoreCase(s))
			{
				str1= journalArray.get(i).getId();
				str2= journalArray.get(i).getTitle();
				str3= journalArray.get(i).getJournalTitle();
				str4 = journalArray.get(i).getYear();
				str5=journalArray.get(i).getVolume();
				str6=journalArray.get(i).getIssue();
				str7=journalArray.get(i).getAuthor();
				str8=journalArray.get(i).getPage();
				a= true;
				break;
			}
			else {a= false;}
		}
		return a;
	}

	public boolean searchConference(String s)
	{
		conferenceArray = reader.readConferenceData();		
		boolean a = false;
		for(int i=0; i<conferenceArray.size(); i++)
		{
			if(conferenceArray.get(i).getTitle().equalsIgnoreCase(s))
			{
				str1=conferenceArray.get(i).getId();
				str2= conferenceArray.get(i).getTitle();
				str3= conferenceArray.get(i).getAuthor();
				str4 = conferenceArray.get(i).getYear();
				str5=conferenceArray.get(i).getBookEditor();
				str6=conferenceArray.get(i).getPublicationPlace();
				str7=conferenceArray.get(i).getPage();
				a= true;
				break;
			}
			else {a= false;}
		}
		return a;
	}

	public boolean searchResearcher(String s)
	{
		reserchersArray = reader.readData();		
		boolean a = false;
		for(int i=0; i<reserchersArray.size(); i++)
		{
			if(reserchersArray.get(i).getId().equalsIgnoreCase(s))
			{
				str1=reserchersArray.get(i).getId();
				str2= reserchersArray.get(i).getName();
				str3= reserchersArray.get(i).getAddress();
				str4 = reserchersArray.get(i).getContact();
				str5=reserchersArray.get(i).getEmail();
				str6=reserchersArray.get(i).getUserName();
				str7=reserchersArray.get(i).getPassword();
				str8="";
				a= true;
				//hire checks
				if(reader.readHireDetails()!=null) {
				for(int i1=0; i1<reader.readHireDetails().size();i1++) { 
					if(s.equals(reader.readHireDetails().get(i1).getRid()))
					{
						str8 = str8+ reader.readHireDetails().get(i1).getAid()+",    ";
						
						str8=str8.replaceAll(", $","");
					}
				}}
				break;
			}
			else {a= false;}
		}
		return a;
	}

	/*
	 * ****hire articles
	 */
	@SuppressWarnings("unchecked")
	
	
	public void enterHireEntry(AdminView adminview)
	{
		issueModel = new IssueRecords(adminview.getReID().getSelectedItem().toString(), adminview.gettfID().getText(),adminview.gettfTitle().getText());
		if(reader.readHireDetails()!=null){issueArray= reader.readHireDetails();}
			issueArray.add(issueModel);
			newIssue(); 
			JOptionPane.showMessageDialog(null, "Article Issued");
	}
	
	public void newIssue() 
	{
		try 
		{
			File file = new File("../src/files/issueRecords.dat");
			FileOutputStream fileout = new FileOutputStream(file);
			ObjectOutputStream objectout = new ObjectOutputStream(fileout);
			objectout.writeObject(issueArray);
			objectout.close();
		}catch (Exception e) { }
	}
	
	//view hires
	public void showHires() {
		if(reader.readHireDetails()!=null) {
			issueArray = reader.readHireDetails();
			IssueRecords reObj = new IssueRecords();
			for(int i=0; i<issueArray.size(); i++)
			{
				
				reObj=issueArray.get(i);
				Object[] data= {reObj.getRid(), reObj.getAid(), reObj.getArticleName()};
				hireTableView.addRow(data);		
			}
			
		}
		Object tableHead[]= {"Researcher ID","Article No.","Article Title"};
		hireTableView.setColumnIdentifiers(tableHead);
	}
	//return
	public void returnHire(AdminView adminview,int i) throws IOException {
		int opt = JOptionPane.showConfirmDialog(null, "Confirm Return ?", "Confirm",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (opt == JOptionPane.YES_OPTION) {
			issueArray=  reader.readHireDetails();
			issueArray.remove(i);
			
			if(i==0 && issueArray.isEmpty())
			{
				reader.deleteFile("../src/files/issueRecords.dat");
			}
				
			else {
				newIssue();
			}		
			JOptionPane.showMessageDialog(null, "Article Returned");
		}
	}
}
