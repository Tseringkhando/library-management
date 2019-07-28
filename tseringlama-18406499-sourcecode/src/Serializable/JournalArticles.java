package Serializable;

import java.io.Serializable;
public class JournalArticles implements Serializable{
	private static final long serialVersionUID = 1L;
	private String ID, title, journalTitle,publicationYear, volume, issue, author, page;
	//constructor
	public JournalArticles() {}
	//parameterized
	public JournalArticles(String ID, String title, String  jtitle, String publicationYear, String  volume, String  issue, String  author, String page)
	{
		this.ID= ID;
		this.title=title;
		this.author= author;
		this.publicationYear= publicationYear;
		this.volume= volume;
		this.issue= issue;
		this.journalTitle= jtitle;
		this.page = page;
	}

	//accessors
	public String getId() { return this.ID; }
	public String getTitle() { return this.title; }
	public String getAuthor() { return this.author; }
	public String getVolume() { return this.volume; }
	public String getIssue() { return this.issue; }
	public String getYear() { return this.publicationYear; }
	public String getJournalTitle() { return this.journalTitle; }
	public String getPage() { return this.page; }

}
