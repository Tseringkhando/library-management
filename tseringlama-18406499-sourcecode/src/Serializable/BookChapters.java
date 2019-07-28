package Serializable;

import java.io.Serializable;
import java.util.ArrayList;

public class BookChapters implements Serializable{
	private static final long serialVersionUID = 1L;
	private String ID, title, author,publicationYear, bookEditor, place, publisher, page;
	//constructor
	public BookChapters() {}
	//parameterized
	public BookChapters(String ID, String title, String  author, String publicationYear, String  bookEditor, String  place, String  publisher, String page)
	{
		this.ID= ID;
		this.title=title;
		this.author= author;
		this.publicationYear= publicationYear;
		this.bookEditor= bookEditor;
		this.place= place;
		this.publisher = publisher;
		this.page = page;
	}
	//accessors

	public String getId() { return this.ID; }
	public String getTitle() { return this.title; }
	public String getAuthor() { return this.author; }
	public String getBookEditor() { return this.bookEditor; }
	public String getPublicationPlace() { return this.place; }
	public String getYear() { return this.publicationYear; }
	public String getPublisher() { return this.publisher; }
	public String getPage() { return this.page; }
	

}
