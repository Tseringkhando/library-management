package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import Serializable.BookChapters;
import Serializable.ConferenceArticles;
import Serializable.IssueRecords;
import Serializable.JournalArticles;
import Serializable.Researchers;

public class DataReader {
	/** 
	 * *****Reading files ******************
	 */
	//researchers
	@SuppressWarnings("unchecked")
	public  ArrayList<Researchers> readData()
	{
		ArrayList<Researchers> researchersList = null;
		try{
			FileInputStream fileinput = new FileInputStream("../src/files/researchers.dat");
			ObjectInputStream objectinput = new ObjectInputStream(fileinput);
			Object objR= objectinput.readObject();
			researchersList = (ArrayList<Researchers>)objR;
			objectinput.close();
		}
		catch (FileNotFoundException e){e.printStackTrace();}
		catch (IOException e){}
		catch (ClassNotFoundException e){e.printStackTrace();}
		return researchersList;
	}
	//book chapters
	@SuppressWarnings("unchecked")
	public  ArrayList<BookChapters> readBookData()
	{
		ArrayList<BookChapters> bookChapterLists = null;
		try{
			FileInputStream fileinput = new FileInputStream("../src/files/bookchapters.dat");
			ObjectInputStream objectinput = new ObjectInputStream(fileinput);
			Object objR= objectinput.readObject();
			bookChapterLists = (ArrayList<BookChapters>)objR;
			objectinput.close();
		}
		catch (FileNotFoundException e){e.printStackTrace();}
		catch (IOException e){}
		catch (ClassNotFoundException e){e.printStackTrace();}
		return bookChapterLists;
	}

	//journal Articles
	@SuppressWarnings("unchecked")
	public  ArrayList<JournalArticles> readJournalData()
	{
		ArrayList<JournalArticles> journalLists = null;
		try{
			FileInputStream fileinput = new FileInputStream("../src/files/journalArticles.dat");
			ObjectInputStream objectinput = new ObjectInputStream(fileinput);
			Object objR= objectinput.readObject();
			journalLists = (ArrayList<JournalArticles>)objR;
			objectinput.close();
		}
		catch (FileNotFoundException e){e.printStackTrace();}
		catch (IOException e){}
		catch (ClassNotFoundException e){e.printStackTrace();}
		return journalLists;
	}

	//conference articles
	@SuppressWarnings("unchecked")
	public  ArrayList<ConferenceArticles> readConferenceData()
	{
		ArrayList<ConferenceArticles> journalLists = null;
		try{
			FileInputStream fileinput = new FileInputStream("../src/files/conferenceArticles.dat");
			ObjectInputStream objectinput = new ObjectInputStream(fileinput);
			Object objR= objectinput.readObject();
			journalLists = (ArrayList<ConferenceArticles>)objR;
			objectinput.close();
		}
		catch (FileNotFoundException e){e.printStackTrace();}
		catch (IOException e){}
		catch (ClassNotFoundException e){e.printStackTrace();}
		return journalLists;
	}

	@SuppressWarnings("unchecked")
	public  ArrayList<IssueRecords> readHireDetails()
	{
		ArrayList<IssueRecords> hirelists = null;
		try{
			FileInputStream fileinput = new FileInputStream("../src/files/issueRecords.dat");
			ObjectInputStream objectinput = new ObjectInputStream(fileinput);
			Object objR= objectinput.readObject();
			hirelists = (ArrayList<IssueRecords>)objR;
			objectinput.close();
		}
		catch (FileNotFoundException e){e.printStackTrace();}
		catch (IOException e){}
		catch (ClassNotFoundException e){e.printStackTrace();}
		return hirelists;
	}
	
	public void deleteFile(String filename) throws IOException
	{
		 File file = new File(filename);
		 file.delete();
		 file.createNewFile();
	}
}
