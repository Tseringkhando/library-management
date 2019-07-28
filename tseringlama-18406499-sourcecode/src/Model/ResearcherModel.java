package Model;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Serializable.BookChapters;
import Serializable.ConferenceArticles;
import Serializable.IssueRecords;
import Serializable.JournalArticles;
import Serializable.Researchers;
import Login.*;

public class ResearcherModel {
	private DefaultTableModel bookTableView = new DefaultTableModel(0, 9);
	private DefaultTableModel journalTableView = new DefaultTableModel(0, 8);
	private DefaultTableModel conferenceTableView = new DefaultTableModel(0, 7);
	private DefaultTableModel hireTableView = new DefaultTableModel(0, 2);

	private JTable bookTable=new JTable(bookTableView);
	private JTable journalTable= new JTable(journalTableView);
	private JTable conferencetable= new JTable(conferenceTableView);
	private JTable hiretable= new JTable(hireTableView);

	private JScrollPane bScrollPane = new JScrollPane(bookTable);
	private JScrollPane jScrollPane = new JScrollPane(journalTable);
	private JScrollPane cScrollPane = new JScrollPane(conferencetable);
	private JScrollPane hScrollPane = new JScrollPane(hiretable);

	//array
	private ArrayList <Researchers> researcherArray = new ArrayList<Researchers>();
	private ArrayList <BookChapters> bookChapterArray  = new ArrayList<BookChapters>();
	private ArrayList <JournalArticles> journalArray  = new ArrayList<JournalArticles>();
	private ArrayList <ConferenceArticles> conferenceArray  = new ArrayList<ConferenceArticles>();
	private ArrayList <IssueRecords> issueArray = new ArrayList<IssueRecords>();

	BookChapters bookModel;
	JournalArticles journalModel;
	ConferenceArticles conferenceModel;
	IssueRecords issueModel;
	DataReader reader = new DataReader();

	public ResearcherModel() 
	{
		showBookChapterTable();
		showJournalArticles();
		showConferenceArticles();

	}

	//for viewing specific reseracher's hires
	public ResearcherModel(String a) { this.a = a; showHires(); }

	//bookchapters
	public void showBookChapterTable() {
		if(reader.readBookData()!=null) {
			boolean found =false;
			bookChapterArray = reader.readBookData();
			BookChapters reObj = new BookChapters();
			for(int i1=0; i1<bookChapterArray.size(); i1++)
			{
				if(reader.readHireDetails()!=null)
				{
					issueArray = reader.readHireDetails();
					IssueRecords check = new IssueRecords();
					for(int i=0; i<issueArray.size(); i++)
					{
						reObj=bookChapterArray.get(i1);
						check=issueArray.get(i);
						if(reObj.getId().equals(check.getAid()))
						{	found = true; break;}
						else {found = false;}
					}}
				if(found==false) {
					reObj=bookChapterArray.get(i1);
					Object[] data= {reObj.getId(), reObj.getTitle(), reObj.getAuthor(), reObj.getYear(), reObj.getBookEditor(), reObj.getPublicationPlace(), reObj.getPublisher(), reObj.getPage()};
					bookTableView.addRow(data);		
				}}}
		Object tableHead[]= {"ID","Title","Author(s)","Publication Year","Book Editor","Place of Publication","Publisher","Page"};
		bookTableView.setColumnIdentifiers(tableHead);
	}


	//	journalArticles
	public void showJournalArticles() {
		if(reader.readJournalData()!=null) {
			boolean found =false;
			journalArray = reader.readJournalData();
			JournalArticles reObj = new JournalArticles();
			for(int i1=0; i1<journalArray.size(); i1++)
			{
				if(reader.readHireDetails()!=null)
				{
					issueArray = reader.readHireDetails();
					IssueRecords check = new IssueRecords();
					for(int i=0; i<issueArray.size(); i++)
					{
						reObj=journalArray.get(i1);
						check=issueArray.get(i);
						if(!reObj.getId().equals(check.getAid()))
						{	found = false;
						} else {found = true; break;}
					}
				}
				if(found==false)
				{
					reObj=journalArray.get(i1);
					Object[] data= {reObj.getId(), reObj.getTitle(), reObj.getJournalTitle(), reObj.getYear(),reObj.getVolume(),reObj.getIssue(),reObj.getAuthor(),reObj.getPage()};
					journalTableView.addRow(data);	
				}}}
		Object tableHead[]= {"ID","Title","Journal Title","Publication Year","Volume","Issue No.","Author(s)","Page"};
		journalTableView.setColumnIdentifiers(tableHead);
	}


	//conference Article
	public void showConferenceArticles()
	{
		if(reader.readConferenceData()!=null)
		{
			boolean found = false;
			conferenceArray = reader.readConferenceData();
			ConferenceArticles reObj = new ConferenceArticles();
			for(int i1=0; i1<conferenceArray.size(); i1++)
			{
				if(reader.readHireDetails()!=null)
				{
					issueArray = reader.readHireDetails();
					IssueRecords check = new IssueRecords();
					for(int i=0; i<issueArray.size(); i++)
					{
						reObj=conferenceArray.get(i1);
						check=issueArray.get(i);
						if(!reObj.getId().equals(check.getAid()))
						{	found = false;}
						else 
						{found = true; 
						break;}
					}}
				if(found==false)
				{
					reObj=conferenceArray.get(i1);
					Object[] data= {reObj.getId(), reObj.getTitle(), reObj.getAuthor(), reObj.getYear(), reObj.getBookEditor(), reObj.getPublicationPlace(), reObj.getPage()};
					conferenceTableView.addRow(data);
				}}
		}
		Object tableHead[]= {"ID","Title","Author(s)","Publication Year","Editor(s)","Conference Location","Page"};
		conferenceTableView.setColumnIdentifiers(tableHead);}

	//articles
	public void showHires() {
		if(reader.readHireDetails()!=null)
		{
			issueArray = reader.readHireDetails();
			IssueRecords reObj = new IssueRecords();
			for(int i=0; i<issueArray.size(); i++)
			{
				reObj=issueArray.get(i);
				if(reObj.getRid().equals(getResearcherUsernamefromHire())) {
					Object[] data= {reObj.getAid(), reObj.getArticleName()};
					hireTableView.addRow(data);	
				}
			}}
		Object tableHead[]= {"Article No.","Title"};
		hireTableView.setColumnIdentifiers(tableHead);
	}

	//accessors
	public JScrollPane getbScrollPane()	{ return bScrollPane;	}
	public JScrollPane getjScrollPane()	{ return jScrollPane;	}
	public JScrollPane getcScrollPane() { return cScrollPane;   }
	public JScrollPane gethScrollPane() { return hScrollPane;   }

	public JTable getBookTable() { return bookTable; }
	public JTable getJournalTable() { return journalTable; }
	public JTable getConferenceTable() { return conferencetable; }
	public JTable getHireTable() { return hiretable; }

	//this method gives the username of the researcher currently logged in
	//it is further used to display the articles hired by that researcher only
	public String getResearcherUsernamefromHire() {
		String userid="";
		if(reader.readData()!=null) {
			researcherArray= reader.readData();
			Researchers reObj = new Researchers();
			for(int i=0; i<researcherArray.size(); i++)
			{
				reObj=researcherArray.get(i);
				if(reObj.getUserName().equals(getTrying())) {
					userid= reObj.getId();
					break;
				}}}
		return userid;
	}



	private String a;
	public void trying(String a) { a= this.a;}
	public String getTrying() {return this.a;}
}
