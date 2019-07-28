package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controller.*;
import Login.*;
import Model.*;

public class ResearcherView extends JFrame{

	private static final long serialVersionUID = 1L;
	ResearcherController rec = new ResearcherController(this);
	//panel 
		JPanel bodyPanel, inbodyPanel;
		//menus
		private JMenu mnFile;
		private JMenuItem mntmSignOut;
		//buttons
		private JButton btnViewHired, btnViewBookChapter, btnViewJournalArticle, btnViewConferenceArticle;
		private JLabel tfID,tfPublisher,tfTitle, tfJTitle, tfYear, tfVolume, tfIssue, tfAuthor, tfPage, tfEditor, tfPlace;
		private JTable bookTable, journalTable, conferenceTable, hiresTable;
		private JScrollPane bookScrollPane, journalScrollPane, conferenceScrollPane, hireScrollPane;

		private String a;
		//public void trying(String a) { this.a= a;}
		public String getTrying() {return this.a;}
		
		public ResearcherView(String a)
		{
			this.a = a;
			setResizable(false);
			setTitle("Northampton Research Center - Researcher");
			setIconImage(new ImageIcon(LoginView.class.getResource("../imgs/ICON.jpg")).getImage());
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1080, 700);
			getContentPane().setBackground(Color.WHITE);
			getContentPane().setLayout(null);
			
			//body
			bodyPanel = new JPanel();
			bodyPanel.setBackground(Color.WHITE);
			bodyPanel.setBounds(177, 20, 890, 645);
			getContentPane().add(bodyPanel);
			bodyPanel.setLayout(null);

			inbodyPanel= new JPanel();

			JMenuBar menuBar = new JMenuBar();
			menuBar.setBackground(Color.LIGHT_GRAY);
			menuBar.setBounds(0, 0, 1066, 20);
			getContentPane().add(menuBar);

			mnFile = new JMenu("File");
			menuBar.add(mnFile);
			mntmSignOut = new JMenuItem("Sign Out");
			mnFile.add(mntmSignOut);

			JPanel menuPanel = new JPanel();
			menuPanel.setBackground(new Color(216, 191, 216));
			menuPanel.setBounds(0, 20, 180, 642);
			getContentPane().add(menuPanel);
			menuPanel.setLayout(null);

			JLabel sidelabel = new JLabel(new ImageIcon(AdminView.class.getResource("../imgs/menu.jpg")));
			sidelabel.setBounds(0, -15, 180, 669);
			menuPanel.add(sidelabel);

			btnViewHired = new JButton("View Hired Articles");
			sidelabel.add(btnViewHired);
			btnViewHired.setFont(new Font("Tahoma", Font.PLAIN, 9));
			btnViewHired.setBorderPainted(false);
			btnViewHired.setBackground(new Color(0, 191, 255));
			btnViewHired.setBounds(22, 89, 135, 34);

			btnViewBookChapter = new JButton("View Book Chapters");
			sidelabel.add(btnViewBookChapter);
			btnViewBookChapter.setFont(new Font("Tahoma", Font.PLAIN, 9));
			btnViewBookChapter.setBorderPainted(false);
			btnViewBookChapter.setBackground(new Color(0, 191, 255));
			btnViewBookChapter.setBounds(22, 133, 135, 34);

			btnViewJournalArticle = new JButton("View Journal Articles");
			sidelabel.add(btnViewJournalArticle);
			btnViewJournalArticle.setFont(new Font("Tahoma", Font.PLAIN, 9));
			btnViewJournalArticle.setBorderPainted(false);
			btnViewJournalArticle.setBackground(new Color(0, 191, 255));
			btnViewJournalArticle.setBounds(22, 177, 135, 34);

			btnViewConferenceArticle = new JButton("View Conference Articles");
			sidelabel.add(btnViewConferenceArticle);
			btnViewConferenceArticle.setFont(new Font("Tahoma", Font.PLAIN, 9));
			btnViewConferenceArticle.setBorderPainted(false);
			btnViewConferenceArticle.setBackground(new Color(0, 191, 255));
			btnViewConferenceArticle.setBounds(22, 221, 135, 34);
			
			JLabel lblwelcom= new JLabel("Welcome to the Northampton Research Center Library");
			lblwelcom.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblwelcom.setBounds(10,50,900,500);
			bodyPanel.add(lblwelcom);
			
			setVisible(true);
			rec.settrying(getTrying());
			rec.operate();
		}
		
		public void addPanel()
		{
			bodyPanel.removeAll();
			bodyPanel.add(inbodyPanel);
			bodyPanel.revalidate();
			inbodyPanel.repaint();
			bodyPanel.repaint();
		}
		public void inBodyProperty()
		{
			inbodyPanel.setBackground(Color.WHITE);
			inbodyPanel.setBounds(10, 20, 890, 645);
			inbodyPanel.setLayout(null);
			inbodyPanel.removeAll();
		}

		/* 
		 *View Book Chapters
		 * */
		public void setBookScrollPane(JScrollPane jsp) { this.bookScrollPane = jsp;}
		public void setBookTable(JTable tab) {	this.bookTable = tab;}
		public JTable getBookTable(){	return bookTable;}
		public JScrollPane getBookScrollPane(){	return bookScrollPane;}

		public void displayBookChapter()
		{
			inBodyProperty();
			JLabel l1 = new JLabel("Book Chapters");
			inbodyPanel.add(l1);
			l1.setBounds(8, 0, 150, 20);
			l1.setFont(new Font("Corbel Light", Font.PLAIN, 20));

			rec.viewBookChapters();
			inbodyPanel.add(getBookScrollPane());
			getBookScrollPane().setBounds(10, 30, 850, 200);

			JLabel label_7 = new JLabel("Details");
			label_7.setForeground(new Color(0, 0, 139));
			label_7.setFont(new Font("Corbel Light", Font.PLAIN, 20));
			label_7.setBounds(412, 231, 62, 30);
			inbodyPanel.add(label_7);

			JLabel label_8 = new JLabel("ID ");
			label_8.setFont(new Font("Calibri Light", Font.PLAIN, 15));
			label_8.setBounds(22, 260, 45, 15);
			inbodyPanel.add(label_8);

			JLabel label_6 = new JLabel("Title");
			label_6.setFont(new Font("Calibri Light", Font.PLAIN, 15));
			label_6.setBounds(22, 300, 45, 15);
			inbodyPanel.add(label_6);

			JLabel label_5 = new JLabel("Author(s)");
			label_5.setFont(new Font("Calibri Light", Font.PLAIN, 15));
			label_5.setBounds(22, 340, 111, 15);
			inbodyPanel.add(label_5);

			JLabel label_3 = new JLabel("Publication Year");
			label_3.setFont(new Font("Calibri Light", Font.PLAIN, 15));
			label_3.setBounds(22, 380, 111, 15);
			inbodyPanel.add(label_3);

			JLabel label_4 = new JLabel("Book Editor");
			label_4.setFont(new Font("Calibri Light", Font.PLAIN, 15));
			label_4.setBounds(22, 420, 111, 15);
			inbodyPanel.add(label_4);

			JLabel label_2 = new JLabel("Place of Publication");
			label_2.setFont(new Font("Calibri Light", Font.PLAIN, 15));
			label_2.setBounds(22, 460, 119, 15);
			inbodyPanel.add(label_2);

			JLabel label_1 = new JLabel("Publisher");
			label_1.setFont(new Font("Calibri Light", Font.PLAIN, 15));
			label_1.setBounds(22, 500, 119, 15);
			inbodyPanel.add(label_1);

			JLabel label = new JLabel("Page No.");
			label.setFont(new Font("Calibri Light", Font.PLAIN, 15));
			label.setBounds(22, 540, 119, 15);
			inbodyPanel.add(label);

			tfID = new JLabel();
			tfID.setBounds(192, 255, 369, 19);
			inbodyPanel.add(tfID);

			tfTitle = new JLabel();
			tfTitle.setBounds(192, 295, 369, 19);
			inbodyPanel.add(tfTitle);

			tfAuthor = new JLabel();
			tfAuthor.setBounds(192, 335, 369, 19);
			inbodyPanel.add(tfAuthor);

			tfYear = new JLabel();		
			tfYear.setBounds(192, 375, 369, 19);
			inbodyPanel.add(tfYear);

			tfEditor = new JLabel();
			tfEditor.setBounds(192, 415, 369, 19);
			inbodyPanel.add(tfEditor);

			tfPlace = new JLabel();
			tfPlace.setBounds(192, 455, 369, 19);
			inbodyPanel.add(tfPlace);

			tfPublisher = new JLabel();
			tfPublisher.setBounds(192, 495, 369, 19);
			inbodyPanel.add(tfPublisher);

			tfPage = new JLabel();
			tfPage.setBounds(192, 535, 369, 19);
			inbodyPanel.add(tfPage);	
			addPanel();
			showBookChapterRow();
		}
		
		/** ******************************************************************
		 * 					View Journal Articles
		 ************************************************* */
		public void setJournalScrollPane(JScrollPane jsp) { this.journalScrollPane = jsp;}
		public void setJournalTable(JTable tab) {	this.journalTable = tab;}
		public JTable getJournalTable(){	return journalTable;}
		public JScrollPane getJournalScrollPane(){	return journalScrollPane;}

		public void displayJournalArticles()
		{
			inBodyProperty();
			rec.viewJournalAricles();
			inbodyPanel.add(getJournalScrollPane());
			getJournalScrollPane().setBounds(10, 30, 850, 200);

			JLabel l1 = new JLabel("Journal Articles");
			inbodyPanel.add(l1);
			l1.setBounds(8, 0, 150, 20);
			l1.setFont(new Font("Corbel Light", Font.PLAIN, 20));

			JLabel label_7 = new JLabel("Details");
			label_7.setForeground(new Color(0, 0, 139));
			label_7.setFont(new Font("Corbel Light", Font.PLAIN, 20));
			label_7.setBounds(412, 231, 62, 30);
			inbodyPanel.add(label_7);

			JLabel label_8 = new JLabel("ID ");
			label_8.setFont(new Font("Calibri Light", Font.PLAIN, 15));
			label_8.setBounds(22, 260, 45, 15);
			inbodyPanel.add(label_8);

			JLabel label_6 = new JLabel("Article Title");
			label_6.setFont(new Font("Calibri Light", Font.PLAIN, 15));
			label_6.setBounds(22, 300, 80, 15);
			inbodyPanel.add(label_6);

			JLabel label_5 = new JLabel("Journal Title");
			label_5.setFont(new Font("Calibri Light", Font.PLAIN, 15));
			label_5.setBounds(22, 340, 111, 15);
			inbodyPanel.add(label_5);

			JLabel label_3 = new JLabel("Publication Year");
			label_3.setFont(new Font("Calibri Light", Font.PLAIN, 15));
			label_3.setBounds(22, 380, 111, 15);
			inbodyPanel.add(label_3);

			JLabel label_4 = new JLabel("Volume");
			label_4.setFont(new Font("Calibri Light", Font.PLAIN, 15));
			label_4.setBounds(22, 420, 111, 15);
			inbodyPanel.add(label_4);

			JLabel label_2 = new JLabel("Issue no.");
			label_2.setFont(new Font("Calibri Light", Font.PLAIN, 15));
			label_2.setBounds(22, 460, 119, 15);
			inbodyPanel.add(label_2);

			JLabel label_1 = new JLabel("Author(s)");
			label_1.setFont(new Font("Calibri Light", Font.PLAIN, 15));
			label_1.setBounds(22, 500, 119, 15);
			inbodyPanel.add(label_1);

			JLabel label = new JLabel("Page No.");
			label.setFont(new Font("Calibri Light", Font.PLAIN, 15));
			label.setBounds(22, 540, 119, 15);
			inbodyPanel.add(label);

			tfID = new JLabel();
			tfID.setBounds(192, 255, 369, 19);
			inbodyPanel.add(tfID);

			tfTitle = new JLabel();
			tfTitle.setBounds(192, 295, 369, 19);
			inbodyPanel.add(tfTitle);

			tfJTitle = new JLabel();
			tfJTitle.setBounds(192, 335, 369, 19);
			inbodyPanel.add(tfJTitle);

			tfYear = new JLabel();
			tfYear.setBounds(192, 375, 369, 19);
			inbodyPanel.add(tfYear);

			tfVolume = new JLabel();
			tfVolume.setBounds(192, 415, 369, 19);
			inbodyPanel.add(tfVolume);

			tfIssue = new JLabel();
			tfIssue.setBounds(192, 455, 369, 19);
			inbodyPanel.add(tfIssue);

			tfAuthor = new JLabel();
			tfAuthor.setBounds(192, 495, 369, 19);
			inbodyPanel.add(tfAuthor);

			tfPage = new JLabel();
			tfPage.setBounds(192, 535, 369, 19);
			inbodyPanel.add(tfPage);		
			addPanel();
			showJournalRow();
		}

		/** ******************************************************************
		 * 					View Conference Articles
		 ************************************************* */
		public void setConferenceScrollPane(JScrollPane jsp) { this.conferenceScrollPane = jsp;}
		public void setConferenceTable(JTable tab) {	this.conferenceTable = tab;}
		public JTable getconferenceTable(){	return conferenceTable;}
		public JScrollPane getconferenceScrollPane(){	return conferenceScrollPane;}

		@SuppressWarnings({ "rawtypes", "unchecked" })
		public void displayConferenceArticle()
		{
			inBodyProperty();
			JLabel l1 = new JLabel("Coference Articles");
			inbodyPanel.add(l1);
			l1.setBounds(8, 0, 150, 20);
			l1.setFont(new Font("Corbel Light", Font.PLAIN, 20));

			rec.viewConferenceArticles();
			inbodyPanel.add(getconferenceScrollPane());
			getconferenceScrollPane().setBounds(10, 30, 850, 200);

			JLabel label_7 = new JLabel("Details");
			label_7.setForeground(new Color(0, 0, 139));
			label_7.setFont(new Font("Corbel Light", Font.PLAIN, 20));
			label_7.setBounds(412, 231, 62, 30);
			inbodyPanel.add(label_7);

			JLabel label_8 = new JLabel("ID ");
			label_8.setFont(new Font("Calibri Light", Font.PLAIN, 15));
			label_8.setBounds(22, 260, 45, 15);
			inbodyPanel.add(label_8);

			JLabel label_6 = new JLabel("Title");
			label_6.setFont(new Font("Calibri Light", Font.PLAIN, 15));
			label_6.setBounds(22, 300, 45, 15);
			inbodyPanel.add(label_6);

			JLabel label_5 = new JLabel("Author(s)");
			label_5.setFont(new Font("Calibri Light", Font.PLAIN, 15));
			label_5.setBounds(22, 340, 111, 15);
			inbodyPanel.add(label_5);

			JLabel label_3 = new JLabel("Publication Year");
			label_3.setFont(new Font("Calibri Light", Font.PLAIN, 15));
			label_3.setBounds(22, 380, 111, 15);
			inbodyPanel.add(label_3);

			JLabel label_4 = new JLabel("Book Editor");
			label_4.setFont(new Font("Calibri Light", Font.PLAIN, 15));
			label_4.setBounds(22, 420, 111, 15);
			inbodyPanel.add(label_4);

			JLabel label_2 = new JLabel("Conference Location");
			label_2.setFont(new Font("Calibri Light", Font.PLAIN, 15));
			label_2.setBounds(22, 460, 140, 15);
			inbodyPanel.add(label_2);

			JLabel label = new JLabel("Page No.");
			label.setFont(new Font("Calibri Light", Font.PLAIN, 15));
			label.setBounds(22, 500, 119, 15);
			inbodyPanel.add(label);

			tfID = new JLabel();
			tfID.setBounds(192, 255, 369, 19);
			inbodyPanel.add(tfID);

			tfTitle = new JLabel();
			tfTitle.setBounds(192, 295, 369, 19);
			inbodyPanel.add(tfTitle);

			tfAuthor = new JLabel();
			tfAuthor.setBounds(192, 335, 369, 19);
			inbodyPanel.add(tfAuthor);

			tfYear = new JLabel();
			tfYear.setBounds(192, 375, 369, 19);
			inbodyPanel.add(tfYear);

			tfEditor = new JLabel();
			tfEditor.setBounds(192, 415, 369, 19);
			inbodyPanel.add(tfEditor);

			tfPlace = new JLabel();
			tfPlace.setBounds(192, 455, 369, 19);
			inbodyPanel.add(tfPlace);

			tfPage = new JLabel();
			tfPage.setBounds(192, 495, 369, 19);
			inbodyPanel.add(tfPage);

			addPanel();
			showConferenceRow();
		}
		//book chapter
		public void showBookcell(String id, String name, String author, String year, String editor, String place, String publisher, String page)
		{	
			this.tfID.setText(id);
			this.tfTitle.setText(name);
			this.tfAuthor.setText(author);
			this.tfYear.setText(year);
			this.tfEditor.setText(editor);
			this.tfPlace.setText(place);
			this.tfPublisher.setText(publisher);
			this.tfPage.setText(page);
		}

		//journal Article
		public void showJournalCell(String id, String name, String journalTitle, String year, String volume, String issue, String author, String page)
		{	
			this.tfID.setText(id);
			this.tfTitle.setText(name);
			this.tfAuthor.setText(author);
			this.tfYear.setText(year);
			this.tfVolume.setText(volume);
			this.tfIssue.setText(issue);
			this.tfJTitle.setText(journalTitle);
			this.tfPage.setText(page);
		}

		//conference article
		public void showConferenceCell(String id, String name, String author, String year, String editor, String place, String page)
		{	
			this.tfID.setText(id);
			this.tfTitle.setText(name);
			this.tfAuthor.setText(author);
			this.tfYear.setText(year);
			this.tfEditor.setText(editor);
			this.tfPlace.setText(place);
			this.tfPage.setText(page);
		}
		//details
		public void showBookChapterRow()
		{ 
			bookTable.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e)
				{
					int indexRow;
					String valID ,valName,valAuthor,valYear,valEditor,valPlace, valPublisher, valPage;
					DefaultTableModel bookMdl = (DefaultTableModel)bookTable.getModel();
					indexRow=bookTable.getSelectedRow();
					valID= bookMdl.getValueAt(indexRow, 0).toString();
					valName= bookMdl.getValueAt(indexRow,1).toString();
					valAuthor= bookMdl.getValueAt(indexRow,2).toString();
					valYear= bookMdl.getValueAt(indexRow,3).toString();
					valEditor= bookMdl.getValueAt(indexRow,4).toString();
					valPlace= bookMdl.getValueAt(indexRow,5).toString();
					valPublisher= bookMdl.getValueAt(indexRow,6).toString();
					valPage= bookMdl.getValueAt(indexRow,7).toString();
					showBookcell(valID, valName, valAuthor, valYear, valEditor, valPlace, valPublisher, valPage);
				}
			});
		}
		//journal articles table
		public void showJournalRow()
		{ 
			journalTable.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e)
				{
					int indexRow;
					String valID ,valName,valAuthor,valYear,valVolume,valIssue, valJournalTitle, valPage;
					DefaultTableModel jmodel = (DefaultTableModel)journalTable.getModel();
					indexRow=journalTable.getSelectedRow();
					valID= jmodel.getValueAt(indexRow, 0).toString();
					valName= jmodel.getValueAt(indexRow,1).toString();
					valJournalTitle= jmodel.getValueAt(indexRow,2).toString();
					valYear= jmodel.getValueAt(indexRow,3).toString();
					valVolume= jmodel.getValueAt(indexRow,4).toString();
					valIssue= jmodel.getValueAt(indexRow,5).toString();
					valAuthor= jmodel.getValueAt(indexRow,6).toString();
					valPage= jmodel.getValueAt(indexRow,7).toString();
					showJournalCell(valID, valName, valJournalTitle, valYear, valVolume, valIssue, valAuthor,  valPage);
				}
			});
		}
		//conference article
		public void showConferenceRow()
		{ 
			conferenceTable.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e)
				{
					int indexRow;
					String valID ,valName,valAuthor,valYear,valEditor,valPlace, valPage;
					DefaultTableModel bookMdl = (DefaultTableModel)conferenceTable.getModel();
					indexRow=conferenceTable.getSelectedRow();
					valID= bookMdl.getValueAt(indexRow, 0).toString();
					valName= bookMdl.getValueAt(indexRow,1).toString();
					valAuthor= bookMdl.getValueAt(indexRow,2).toString();
					valYear= bookMdl.getValueAt(indexRow,3).toString();
					valEditor= bookMdl.getValueAt(indexRow,4).toString();
					valPlace= bookMdl.getValueAt(indexRow,5).toString();
					valPage= bookMdl.getValueAt(indexRow,6).toString();
					showConferenceCell(valID, valName, valAuthor, valYear, valEditor, valPlace, valPage);
				}
			});
		}
		
		public void setHireScrollPane(JScrollPane jsp) { this.hireScrollPane = jsp;}
		public void setHireTable(JTable tab) {	this.hiresTable = tab;}
		public JTable getHireTable(){	return hiresTable;}
		public JScrollPane getHireScrollPane(){	return hireScrollPane;}

	public void displayIssuedPanel()
	{
		inBodyProperty();
		
		JLabel l1 = new JLabel("Hires");
		inbodyPanel.add(l1);
		l1.setBounds(8, 0, 150, 20);
		l1.setFont(new Font("Corbel Light", Font.PLAIN, 20));

		rec.viewHires();
		inbodyPanel.add(getHireScrollPane());
		getHireScrollPane().setBounds(10, 30, 850, 500);
		
		addPanel();
		issueRowSelect();
	}

	public void issueRowSelect()
	{ 
		hiresTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				int indexRow;
				String rid ,aid;
				DefaultTableModel jmodel = (DefaultTableModel)hiresTable.getModel();
				indexRow=hiresTable.getSelectedRow();
				rid= jmodel.getValueAt(indexRow, 0).toString();
				aid= jmodel.getValueAt(indexRow,1).toString();
			}
		});
	}
	
		//getters
		public JMenuItem getmntmSignOut() { return mntmSignOut; }
		public JButton getbtnViewHired() { return btnViewHired; }
		public JButton getbtnViewBookChapter(){ return btnViewBookChapter;}
		public JButton getbtnViewJournalArticle(){ return btnViewJournalArticle;}
		public JButton getbtnViewConferenceArticle() { return btnViewConferenceArticle; }
	
}

