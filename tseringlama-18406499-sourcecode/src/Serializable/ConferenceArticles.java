package Serializable;
import java.io.Serializable;
public class ConferenceArticles implements Serializable{
	private static final long serialVersionUID = 1L;
	private String ID, title, author,publicationYear, bookEditor, place, page;
	//constructor
	public ConferenceArticles() {}
	//parameterized
	public ConferenceArticles(String ID, String title, String  author, String publicationYear, String  bookEditor, String  place, String page)
	{
		this.ID= ID;
		this.title=title;
		this.author= author;
		this.publicationYear= publicationYear;
		this.bookEditor= bookEditor;
		this.place= place;
		this.page = page;
	}
	//accessors

	public String getId() { return this.ID; }
	public String getTitle() { return this.title; }
	public String getAuthor() { return this.author; }
	public String getBookEditor() { return this.bookEditor; }
	public String getPublicationPlace() { return this.place; }
	public String getYear() { return this.publicationYear; }
	public String getPage() { return this.page; }
}
