package View;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controller.*;
import Login.*;
import Model.*;

public class AdminView extends JFrame {
	private static final long serialVersionUID = 1L;
	AdminController c= new AdminController(this);
	DataReader mod= new DataReader();
	//panel 
	JPanel bodyPanel, inbodyPanel;
	//menus
	private JMenu mnFile;
	private JMenuItem mntmSignOut;
	//buttons
	private JButton btnAddResearcher, btnViewResearcher, btnAddBookChapter, btnAddJournalArticle, btnAddConferenceArticle, btnViewBookChapter, btnViewJournalArticle, btnViewConferenceArticle ,btnViewIssuedArticles;
	//add data
	private JButton btnAddJArticle, btnAddCArticle, btnAddBook ,btnSave, btnDelete;
	//text fields
	private JTextField tfID,tfPublisher,tfTitle,tfAddress,tfContact,tfEmail,tfUser,tfPassword, tfArticleTitle, tfJTitle, tfYear, tfVolume, tfIssue, tfAuthor, tfPage, tfEditor, tfPlace;
	private JFormattedTextField tfEmailf;
	//search fields
	private JTextField tfSearch;
	private JButton btnSearch, btnIssue, btnReturn;
	//issue
	private JComboBox researcherID;
	//for table view
	private JTable resTable, bookTable, journalTable, conferenceTable, hiresTable;
	private JScrollPane reScrollPane, bookScrollPane, journalScrollPane, conferenceScrollPane, hireScrollPane;
	private int editIndex;

	//for search results
	private JLabel lblID, lbl2, lbl3, lbl4,lbl5, lbl6, lbl7, lbl8;
	private JTextArea lbl9;

	//constructor
	public AdminView()
	{
		setResizable(false);
		setTitle("Northampton Research Center - Admin");
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

		btnAddResearcher = new JButton("Add Researcher");
		sidelabel.add(btnAddResearcher);
		btnAddResearcher.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAddResearcher.setBorderPainted(false);
		btnAddResearcher.setBackground(new Color(0, 191, 255));
		btnAddResearcher.setBounds(22, 45, 131, 34);

		btnViewResearcher = new JButton("View Researcher");
		sidelabel.add(btnViewResearcher);
		btnViewResearcher.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnViewResearcher.setBorderPainted(false);
		btnViewResearcher.setBackground(new Color(0, 191, 255));
		btnViewResearcher.setBounds(22, 89, 131, 34);

		btnAddBookChapter = new JButton("Add Book Chapter");
		sidelabel.add(btnAddBookChapter);
		btnAddBookChapter.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAddBookChapter.setBorderPainted(false);
		btnAddBookChapter.setBackground(new Color(0, 191, 255));
		btnAddBookChapter.setBounds(22, 133, 131, 34);

		btnAddJournalArticle = new JButton("Add Journal Article");
		sidelabel.add(btnAddJournalArticle);
		btnAddJournalArticle.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAddJournalArticle.setBorderPainted(false);
		btnAddJournalArticle.setBackground(new Color(0, 191, 255));
		btnAddJournalArticle.setBounds(22, 177, 131, 34);

		btnAddConferenceArticle = new JButton("Add Conference Article");
		sidelabel.add(btnAddConferenceArticle);
		btnAddConferenceArticle.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAddConferenceArticle.setBorderPainted(false);
		btnAddConferenceArticle.setBackground(new Color(0, 191, 255));
		btnAddConferenceArticle.setBounds(22, 221, 131, 34);

		btnViewBookChapter = new JButton("View Book Chapter");
		sidelabel.add(btnViewBookChapter);
		btnViewBookChapter.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnViewBookChapter.setBorderPainted(false);
		btnViewBookChapter.setBackground(new Color(0, 191, 255));
		btnViewBookChapter.setBounds(22, 265, 131, 34);

		btnViewJournalArticle = new JButton("View Journal Article");
		sidelabel.add(btnViewJournalArticle);
		btnViewJournalArticle.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnViewJournalArticle.setBorderPainted(false);
		btnViewJournalArticle.setBackground(new Color(0, 191, 255));
		btnViewJournalArticle.setBounds(22, 309, 131, 34);

		btnViewConferenceArticle = new JButton("View Conference Article");
		sidelabel.add(btnViewConferenceArticle);
		btnViewConferenceArticle.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnViewConferenceArticle.setBorderPainted(false);
		btnViewConferenceArticle.setBackground(new Color(0, 191, 255));
		btnViewConferenceArticle.setBounds(22, 353, 131, 34);
		
		btnViewIssuedArticles= new JButton("View Hired Articles");
		sidelabel.add(btnViewIssuedArticles);
		btnViewIssuedArticles.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnViewIssuedArticles.setBorderPainted(false);
		btnViewIssuedArticles.setBackground(new Color(0, 191, 255));
		btnViewIssuedArticles.setBounds(22, 397, 131, 34);
			
		JLabel lblwelcom= new JLabel("Welcome Admin");
		lblwelcom.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblwelcom.setBounds(10,50,800,500);
		bodyPanel.add(lblwelcom);
		
		setVisible(true);
		c.activateButtons();
	}

	//to add inbody panel to body
	public void addPanel()
	{
		bodyPanel.removeAll();
		bodyPanel.add(inbodyPanel);
		bodyPanel.revalidate();
		inbodyPanel.repaint();
		bodyPanel.repaint();
	}

	//inbody panel property
	public void inBodyProperty()
	{
		inbodyPanel.setBackground(Color.WHITE);
		inbodyPanel.setBounds(10, 20, 890, 645);
		inbodyPanel.setLayout(null);
		inbodyPanel.removeAll();
	}
	//body contents

	/** ******************************************************************
	 * 				 Add Researcher 
	 ************************************************* */
	public void addResearcher()
	{
		inBodyProperty();

		JLabel lblAddResearcher = new JLabel("Add New Researcher");
		lblAddResearcher.setFont(new Font("Calibri Light", Font.PLAIN, 25));
		lblAddResearcher.setBounds(352, 26, 224, 37);
		inbodyPanel.add(lblAddResearcher);

		JLabel lblID = new JLabel("ID No.");
		lblID.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblID.setBounds(180, 96, 45, 15);
		inbodyPanel.add(lblID);

		tfID = new JTextField();
		tfID.setBounds(304, 92, 364, 19);
		tfID.setEditable(false);
		inbodyPanel.add(tfID);
		tfID.setColumns(10);
		if(mod.readData()==null) {
			tfID.setText("100001");
		}
		else {
			int b= mod.readData().size();
			int n = Integer.parseInt(mod.readData().get(b-1).getId());
			String id = String.valueOf(n+1);
			tfID.setText(id);
		}

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblName.setBounds(180, 138, 45, 15);
		inbodyPanel.add(lblName);

		tfTitle = new JTextField();
		tfTitle.setColumns(10);
		tfTitle.setBounds(304, 134, 364, 19);
		inbodyPanel.add(tfTitle);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblAddress.setBounds(180, 181, 69, 15);
		inbodyPanel.add(lblAddress);

		tfAddress = new JTextField();
		tfAddress.setColumns(10);
		tfAddress.setBounds(304, 177, 364, 19);
		inbodyPanel.add(tfAddress);

		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblContact.setBounds(180, 221, 82, 15);
		inbodyPanel.add(lblContact);

		tfContact = new JTextField();
		tfContact.setColumns(10);
		tfContact.setBounds(304, 217, 364, 19);
		inbodyPanel.add(tfContact);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblEmail.setBounds(180, 265, 45, 15);
		inbodyPanel.add(lblEmail);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(304, 261, 364, 19);
		inbodyPanel.add(tfEmail);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblUsername.setBounds(180, 351, 69, 15);
		inbodyPanel.add(lblUsername);

		tfUser = new JTextField();
		tfUser.setColumns(10);
		tfUser.setBounds(304, 347, 364, 19);
		inbodyPanel.add(tfUser);

		JLabel lblP = new JLabel("Password");
		lblP.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblP.setBounds(180, 403, 82, 15);
		inbodyPanel.add(lblP);

		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(304, 399, 364, 19);
		inbodyPanel.add(tfPassword);

		JLabel lblcreateUsernameAnd = new JLabel("(Create username and password)");
		lblcreateUsernameAnd.setForeground(new Color(0, 102, 204));
		lblcreateUsernameAnd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblcreateUsernameAnd.setBounds(180, 317, 218, 13);
		inbodyPanel.add(lblcreateUsernameAnd);

		btnAddResearcher = new JButton("Add Researcher");
		btnAddResearcher.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		btnAddResearcher.setBounds(387, 491, 142, 29);
		inbodyPanel.add(btnAddResearcher);

		addPanel();
		c.addResearcher();
	}

	/** ******************************************************************
	 * 				 Add Book Chapter 
	 ************************************************* */
	public void addBook()
	{
		inBodyProperty();

		JLabel lblBookchapter = new JLabel("Add a Book Chapter");
		lblBookchapter.setFont(new Font("Calibri Light", Font.PLAIN, 25));
		lblBookchapter.setBounds(352, 26, 224, 37);
		inbodyPanel.add(lblBookchapter);

		JLabel lblID = new JLabel("ID ");
		lblID.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblID.setBounds(188, 96, 45, 15);
		inbodyPanel.add(lblID);

		btnAddBook = new JButton("Add Chapter");
		btnAddBook.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		btnAddBook.setBounds(387, 491, 142, 29);
		inbodyPanel.add(btnAddBook);

		tfID = new JTextField();
		tfID.setBounds(358, 92, 369, 19);
		tfID.setEditable(false);
		inbodyPanel.add(tfID);
		tfID.setColumns(10);
		if(mod.readBookData()==null) {
			tfID.setText("200001");
		}
		else {
			int b= mod.readBookData().size();
			int n = Integer.parseInt(mod.readBookData().get(b-1).getId());
			String id = String.valueOf(n+1);
			tfID.setText(id);
		}

		tfTitle = new JTextField();
		tfTitle.setColumns(10);
		tfTitle.setBounds(358, 135, 369, 19);
		inbodyPanel.add(tfTitle);

		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblTitle.setBounds(188, 139, 45, 15);
		inbodyPanel.add(lblTitle);

		JLabel lblAuthors = new JLabel("Author(s)");
		lblAuthors.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblAuthors.setBounds(188, 185, 111, 15);
		inbodyPanel.add(lblAuthors);

		tfAuthor = new JTextField();
		tfAuthor.setColumns(10);
		tfAuthor.setBounds(358, 181, 369, 19);
		inbodyPanel.add(tfAuthor);

		JLabel lblPublicationYear = new JLabel("Publication Year");
		lblPublicationYear.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblPublicationYear.setBounds(188, 229, 111, 15);
		inbodyPanel.add(lblPublicationYear);

		tfYear = new JTextField();
		tfYear.setColumns(10);
		tfYear.setBounds(358, 225, 369, 19);
		inbodyPanel.add(tfYear);

		JLabel lblBookEditor = new JLabel("Book Editor");
		lblBookEditor.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblBookEditor.setBounds(188, 275, 111, 15);
		inbodyPanel.add(lblBookEditor);

		tfEditor = new JTextField();
		tfEditor.setColumns(10);
		tfEditor.setBounds(358, 271, 369, 19);
		inbodyPanel.add(tfEditor);

		JLabel lblPlaceOfPublication = new JLabel("Place of Publication");
		lblPlaceOfPublication.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblPlaceOfPublication.setBounds(188, 321, 119, 15);
		inbodyPanel.add(lblPlaceOfPublication);

		tfPlace = new JTextField();
		tfPlace.setColumns(10);
		tfPlace.setBounds(358, 317, 369, 19);
		inbodyPanel.add(tfPlace);

		tfPublisher = new JTextField();
		tfPublisher.setColumns(10);
		tfPublisher.setBounds(358, 366, 369, 19);
		inbodyPanel.add(tfPublisher);

		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblPublisher.setBounds(188, 370, 119, 15);
		inbodyPanel.add(lblPublisher);

		tfPage = new JTextField();
		tfPage.setColumns(10);
		tfPage.setBounds(358, 415, 369, 19);
		inbodyPanel.add(tfPage);

		JLabel lblPageNo = new JLabel("Page No.");
		lblPageNo.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblPageNo.setBounds(188, 419, 119, 15);
		inbodyPanel.add(lblPageNo);

		addPanel();
		c.addBookChapter();
	}


	/** ******************************************************************
	 * 				 Add Journal Article 
	 ************************************************* */

	public void addJournalArticle()
	{
		inBodyProperty();

		JLabel lblAddResearcher = new JLabel("Add Journal Article");
		lblAddResearcher.setFont(new Font("Calibri Light", Font.PLAIN, 25));
		lblAddResearcher.setBounds(387, 23, 224, 37);
		inbodyPanel.add(lblAddResearcher);

		JLabel lblID = new JLabel("ID ");
		lblID.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblID.setBounds(188, 96, 45, 15);
		inbodyPanel.add(lblID);

		btnAddJArticle = new JButton("Add Article");
		btnAddJArticle.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		btnAddJArticle.setBounds(387, 491, 142, 29);
		inbodyPanel.add(btnAddJArticle);

		tfID = new JTextField();
		tfID.setBounds(358, 92, 369, 19);
		tfID.setEditable(false);
		inbodyPanel.add(tfID);
		tfID.setColumns(10);
		if(mod.readJournalData()==null) {
			tfID.setText("300001");
		}
		else {
			int b= mod.readJournalData().size();
			int n = Integer.parseInt(mod.readJournalData().get(b-1).getId());
			String id = String.valueOf(n+1);
			tfID.setText(id);
		}

		tfArticleTitle = new JTextField();
		tfArticleTitle.setColumns(10);
		tfArticleTitle.setBounds(358, 135, 369, 19);
		inbodyPanel.add(tfArticleTitle);

		JLabel lblTitle = new JLabel("Article Title");
		lblTitle.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblTitle.setBounds(188, 139, 136, 15);
		inbodyPanel.add(lblTitle);

		JLabel lblAuthors = new JLabel("Author(s)");
		lblAuthors.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblAuthors.setBounds(188, 370, 111, 15);
		inbodyPanel.add(lblAuthors);

		tfJTitle = new JTextField();
		tfJTitle.setColumns(10);
		tfJTitle.setBounds(358, 181, 369, 19);
		inbodyPanel.add(tfJTitle);

		JLabel lblPublicationYear = new JLabel("Publication Year");
		lblPublicationYear.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblPublicationYear.setBounds(188, 229, 111, 15);
		inbodyPanel.add(lblPublicationYear);

		tfYear = new JTextField();
		tfYear.setColumns(10);
		tfYear.setBounds(358, 225, 369, 19);
		inbodyPanel.add(tfYear);

		JLabel lblBookEditor = new JLabel("Volume");
		lblBookEditor.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblBookEditor.setBounds(188, 275, 111, 15);
		inbodyPanel.add(lblBookEditor);

		tfVolume = new JTextField();
		tfVolume.setColumns(10);
		tfVolume.setBounds(358, 271, 369, 19);
		inbodyPanel.add(tfVolume);

		JLabel lblPlaceOfPublication = new JLabel("Issue no.");
		lblPlaceOfPublication.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblPlaceOfPublication.setBounds(188, 321, 119, 15);
		inbodyPanel.add(lblPlaceOfPublication);

		tfIssue = new JTextField();
		tfIssue.setColumns(10);
		tfIssue.setBounds(358, 317, 369, 19);
		inbodyPanel.add(tfIssue);

		tfAuthor = new JTextField();
		tfAuthor.setColumns(10);
		tfAuthor.setBounds(358, 366, 369, 19);
		inbodyPanel.add(tfAuthor);

		tfPage = new JTextField();
		tfPage.setColumns(10);
		tfPage.setBounds(358, 415, 369, 19);
		inbodyPanel.add(tfPage);

		JLabel lblPageNo = new JLabel("Page No.");
		lblPageNo.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblPageNo.setBounds(188, 419, 119, 15);
		inbodyPanel.add(lblPageNo);

		JLabel lblJournalTitle = new JLabel("Journal Title");
		lblJournalTitle.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblJournalTitle.setBounds(188, 184, 136, 15);
		inbodyPanel.add(lblJournalTitle);

		addPanel();
		c.addJournalArticle();

	}

	/** ******************************************************************
	 * 				 Add Conference Article 
	 ************************************************* */
	public void addConference()
	{
		inBodyProperty();

		JLabel lblAddResearcher = new JLabel("Add Conference Article");
		lblAddResearcher.setFont(new Font("Calibri Light", Font.PLAIN, 25));
		lblAddResearcher.setBounds(318, 26, 311, 37);
		inbodyPanel.add(lblAddResearcher);

		JLabel lblID = new JLabel("ID ");
		lblID.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblID.setBounds(188, 96, 45, 15);
		inbodyPanel.add(lblID);

		btnAddCArticle = new JButton("Add Article");
		btnAddCArticle.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		btnAddCArticle.setBounds(403, 467, 142, 29);
		inbodyPanel.add(btnAddCArticle);

		tfID = new JTextField();
		tfID.setBounds(358, 92, 369, 19);
		tfID.setEditable(false);
		inbodyPanel.add(tfID);
		tfID.setColumns(10);
		if(mod.readConferenceData()==null) {
			tfID.setText("400001");
		}
		else {
			int b= mod.readConferenceData().size();
			int n = Integer.parseInt(mod.readConferenceData().get(b-1).getId());
			String id = String.valueOf(n+1);
			tfID.setText(id);
		}

		tfTitle = new JTextField();
		tfTitle.setColumns(10);
		tfTitle.setBounds(358, 135, 369, 19);
		inbodyPanel.add(tfTitle);

		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblTitle.setBounds(188, 139, 45, 15);
		inbodyPanel.add(lblTitle);

		JLabel lblAuthors = new JLabel("Author(s)");
		lblAuthors.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblAuthors.setBounds(188, 185, 111, 15);
		inbodyPanel.add(lblAuthors);

		tfAuthor = new JTextField();
		tfAuthor.setColumns(10);
		tfAuthor.setBounds(358, 181, 369, 19);
		inbodyPanel.add(tfAuthor);

		JLabel lblPublicationYear = new JLabel("Publication Year");
		lblPublicationYear.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblPublicationYear.setBounds(188, 227, 111, 19);
		inbodyPanel.add(lblPublicationYear);

		tfYear = new JTextField();
		tfYear.setColumns(10);
		tfYear.setBounds(358, 225, 369, 19);
		inbodyPanel.add(tfYear);

		JLabel lblBookEditor = new JLabel("Editor(s)");
		lblBookEditor.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblBookEditor.setBounds(188, 273, 111, 19);
		inbodyPanel.add(lblBookEditor);

		tfEditor = new JTextField();
		tfEditor.setColumns(10);
		tfEditor.setBounds(358, 271, 369, 19);
		inbodyPanel.add(tfEditor);

		JLabel lblPlaceOfPublication = new JLabel("Conference Location");
		lblPlaceOfPublication.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblPlaceOfPublication.setBounds(188, 319, 135, 19);
		inbodyPanel.add(lblPlaceOfPublication);

		tfPlace = new JTextField();
		tfPlace.setColumns(10);
		tfPlace.setBounds(358, 317, 369, 19);
		inbodyPanel.add(tfPlace);

		JLabel lblPageNo = new JLabel("Page No.");
		lblPageNo.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblPageNo.setBounds(188, 368, 119, 15);
		inbodyPanel.add(lblPageNo);

		tfPage = new JTextField();
		tfPage.setColumns(10);
		tfPage.setBounds(358, 364, 369, 19);
		inbodyPanel.add(tfPage);

		addPanel();
		c.addConferenceArticle();
	}


	/** ******************************************************************
	 * 					View Researchers
	 ************************************************* */
	public void setScrollPane(JScrollPane jsp) { this.reScrollPane = jsp;}
	public void setTable(JTable tab) {	this.resTable = tab;}
	public JTable getResearchTable(){	return resTable;}
	public JScrollPane getResearchScrollPane(){	return reScrollPane;}

	public void displayResearchers()
	{
		inBodyProperty();
		//search box
		tfSearch = new JTextField();
		tfSearch.setToolTipText("Enter the ID");
		tfSearch.setBounds(650, 0, 150, 20);
		inbodyPanel.add(tfSearch);

		btnSearch= new JButton();
		btnSearch.setIcon(new ImageIcon(LoginView.class.getResource("../imgs/find1.png")));
		btnSearch.setBounds(800, -5, 50, 30);
		btnSearch.setBorderPainted(false);
		btnSearch.setContentAreaFilled(false);
		inbodyPanel.add(btnSearch);

		JLabel l1 = new JLabel("Researchers");
		inbodyPanel.add(l1);
		l1.setBounds(8, 0, 150, 20);
		l1.setFont(new Font("Corbel Light", Font.PLAIN, 20));

		AdminController c= new AdminController(this);
		c.viewResearchers();
		inbodyPanel.add(getResearchScrollPane());
		getResearchScrollPane().setBounds(10, 30, 850, 200);

		//modify section
		JLabel lblDetails = new JLabel("Details");
		lblDetails.setForeground(new Color(0, 0, 139));
		lblDetails.setFont(new Font("Corbel Light", Font.PLAIN, 20));
		lblDetails.setBounds(413, 240, 62, 37);
		inbodyPanel.add(lblDetails);

		JLabel label = new JLabel("ID");
		label.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		label.setBounds(10, 303, 45, 15);
		inbodyPanel.add(label);

		JLabel label_1 = new JLabel("Name");
		label_1.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		label_1.setBounds(10, 345, 45, 15);
		inbodyPanel.add(label_1);

		JLabel label_2 = new JLabel("Address");
		label_2.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		label_2.setBounds(10, 388, 69, 15);
		inbodyPanel.add(label_2);


		JLabel label_3 = new JLabel("Contact");
		label_3.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		label_3.setBounds(10, 428, 82, 15);
		inbodyPanel.add(label_3);

		JLabel label_4 = new JLabel("Email");
		label_4.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		label_4.setBounds(10, 472, 45, 15);
		inbodyPanel.add(label_4);

		JLabel label_5 = new JLabel("Username");
		label_5.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		label_5.setBounds(10, 515, 69, 15);
		inbodyPanel.add(label_5);

		JLabel label_6 = new JLabel("Password");
		label_6.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		label_6.setBounds(10, 555, 82, 15);
		inbodyPanel.add(label_6);

		tfID = new JTextField();
		tfID.setEditable(false);
		tfID.setColumns(10);
		tfID.setBounds(134, 299, 364, 19);
		inbodyPanel.add(tfID);

		tfTitle = new JTextField();
		tfTitle.setColumns(10);
		tfTitle.setBounds(134, 341, 364, 19);
		inbodyPanel.add(tfTitle);

		tfAddress = new JTextField();
		tfAddress.setColumns(10);
		tfAddress.setBounds(134, 384, 364, 19);
		inbodyPanel.add(tfAddress);

		tfContact = new JTextField();
		tfContact.setColumns(10);
		tfContact.setBounds(134, 424, 364, 19);
		inbodyPanel.add(tfContact);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(134, 468, 364, 19);
		inbodyPanel.add(tfEmail);

		tfUser = new JTextField();
		tfUser.setColumns(10);
		tfUser.setBounds(134, 511, 364, 19);
		inbodyPanel.add(tfUser);

		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(134, 555, 364, 19);
		inbodyPanel.add(tfPassword);

		btnSave = new JButton("Save");
		btnSave.setBounds(301, 590, 85, 21);
		inbodyPanel.add(btnSave);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(413, 590, 85, 21);
		inbodyPanel.add(btnDelete);

		addPanel();
		showResearcherRowDetails();
		c.editResearcher();
		c.deleteResearcher();
		c.searchResearcher();

	}

	/** ******************************************************************
	 * 					View Book Chapters
	 ************************************************* */
	public void setBookScrollPane(JScrollPane jsp) { this.bookScrollPane = jsp;}
	public void setBookTable(JTable tab) {	this.bookTable = tab;}
	public JTable getBookTable(){	return bookTable;}
	public JScrollPane getBookScrollPane(){	return bookScrollPane;}

	public void displayBookChapter()
	{
		inBodyProperty();
		//search box
		tfSearch = new JTextField();
		tfSearch.setBounds(650, 0, 150, 20);
		tfSearch.setToolTipText("Enter chapter title to search");
		inbodyPanel.add(tfSearch);

		btnSearch= new JButton();
		btnSearch.setIcon(new ImageIcon(LoginView.class.getResource("../imgs/find1.png")));
		btnSearch.setBounds(800, -5, 50, 30);
		btnSearch.setBorderPainted(false);
		btnSearch.setContentAreaFilled(false);
		inbodyPanel.add(btnSearch);

		JLabel l1 = new JLabel("Book Chapters");
		inbodyPanel.add(l1);
		l1.setBounds(8, 0, 150, 20);
		l1.setFont(new Font("Corbel Light", Font.PLAIN, 20));

		AdminController c= new AdminController(this);
		c.viewBookChapters();
		inbodyPanel.add(getBookScrollPane());
		getBookScrollPane().setBounds(10, 30, 850, 200);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(413, 580, 85, 21);
		inbodyPanel.add(btnDelete);

		btnSave = new JButton("Save");
		btnSave.setBounds(301, 580, 85, 21);
		inbodyPanel.add(btnSave);

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

		tfID = new JTextField();
		tfID.setEditable(false);
		tfID.setColumns(10);
		tfID.setBounds(192, 255, 369, 19);
		inbodyPanel.add(tfID);

		tfTitle = new JTextField();
		tfTitle.setColumns(10);
		tfTitle.setBounds(192, 295, 369, 19);
		inbodyPanel.add(tfTitle);

		tfAuthor = new JTextField();
		tfAuthor.setColumns(10);
		tfAuthor.setBounds(192, 335, 369, 19);
		inbodyPanel.add(tfAuthor);

		tfYear = new JTextField();
		tfYear.setColumns(10);
		tfYear.setBounds(192, 375, 369, 19);
		inbodyPanel.add(tfYear);

		tfEditor = new JTextField();
		tfEditor.setColumns(10);
		tfEditor.setBounds(192, 415, 369, 19);
		inbodyPanel.add(tfEditor);

		tfPlace = new JTextField();
		tfPlace.setColumns(10);
		tfPlace.setBounds(192, 455, 369, 19);
		inbodyPanel.add(tfPlace);

		tfPublisher = new JTextField();
		tfPublisher.setColumns(10);
		tfPublisher.setBounds(192, 495, 369, 19);
		inbodyPanel.add(tfPublisher);

		tfPage = new JTextField();
		tfPage.setColumns(10);
		tfPage.setBounds(192, 535, 369, 19);
		inbodyPanel.add(tfPage);
		
		JLabel l = new JLabel("Select Research ID to issue:");
		l.setBounds(693, 255, 200, 19);
		l.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		inbodyPanel.add(l);
		researcherID = new JComboBox();
		String[] ids =getReasearcherIds().toArray(new String[] {});
		researcherID.setModel(new DefaultComboBoxModel(ids));
		researcherID.setBounds(700, 295, 150, 19);
		inbodyPanel.add(researcherID);
		btnIssue = new JButton("Issue");
		btnIssue.setBounds(750, 335, 100, 25);
		inbodyPanel.add(btnIssue);
		
		addPanel();
		showBookChapterRow();
		c.editBookChapters();
		c.deleteBookChapters();
		c.searchBook();
		c.issuebook();
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
		//search box
		tfSearch = new JTextField();
		tfSearch.setBounds(650, 0, 150, 20);
		tfSearch.setToolTipText("Enter article title to search");
		inbodyPanel.add(tfSearch);

		btnSearch= new JButton();
		btnSearch.setIcon(new ImageIcon(LoginView.class.getResource("../imgs/find1.png")));
		btnSearch.setBounds(800, -5, 50, 30);
		btnSearch.setBorderPainted(false);
		btnSearch.setContentAreaFilled(false);
		inbodyPanel.add(btnSearch);

		AdminController c= new AdminController(this);
		c.viewJournalAricles();
		inbodyPanel.add(getJournalScrollPane());
		getJournalScrollPane().setBounds(10, 30, 850, 200);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(413, 580, 85, 21);
		inbodyPanel.add(btnDelete);

		btnSave = new JButton("Save");
		btnSave.setBounds(301, 580, 85, 21);
		inbodyPanel.add(btnSave);

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

		tfID = new JTextField();
		tfID.setEditable(false);
		tfID.setColumns(10);
		tfID.setBounds(192, 255, 369, 19);
		inbodyPanel.add(tfID);

		tfTitle = new JTextField();
		tfTitle.setColumns(10);
		tfTitle.setBounds(192, 295, 369, 19);
		inbodyPanel.add(tfTitle);

		tfJTitle = new JTextField();
		tfJTitle.setColumns(10);
		tfJTitle.setBounds(192, 335, 369, 19);
		inbodyPanel.add(tfJTitle);

		tfYear = new JTextField();
		tfYear.setColumns(10);
		tfYear.setBounds(192, 375, 369, 19);
		inbodyPanel.add(tfYear);

		tfVolume = new JTextField();
		tfVolume.setColumns(10);
		tfVolume.setBounds(192, 415, 369, 19);
		inbodyPanel.add(tfVolume);

		tfIssue = new JTextField();
		tfIssue.setColumns(10);
		tfIssue.setBounds(192, 455, 369, 19);
		inbodyPanel.add(tfIssue);

		tfAuthor = new JTextField();
		tfAuthor.setColumns(10);
		tfAuthor.setBounds(192, 495, 369, 19);
		inbodyPanel.add(tfAuthor);

		tfPage = new JTextField();
		tfPage.setColumns(10);
		tfPage.setBounds(192, 535, 369, 19);
		inbodyPanel.add(tfPage);
		
		JLabel l = new JLabel("Select Research ID to issue:");
		l.setBounds(693, 255, 200, 19);
		l.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		inbodyPanel.add(l);
		researcherID = new JComboBox();
		String[] ids =getReasearcherIds().toArray(new String[] {});
		researcherID.setModel(new DefaultComboBoxModel(ids));
		researcherID.setBounds(700, 295, 150, 19);
		inbodyPanel.add(researcherID);
		btnIssue = new JButton("Issue");
		btnIssue.setBounds(750, 335, 100, 25);
		inbodyPanel.add(btnIssue);
		
		addPanel();
		showJournalRow();
		c.editJournalArticles();
		c.deleteJournalArticles();
		c.searchJournalArticle();
		c.issuebook();

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
		//search box
		tfSearch = new JTextField();
		tfSearch.setBounds(650, 0, 150, 20);
		tfSearch.setToolTipText("Enter article title to search");
		inbodyPanel.add(tfSearch);

		btnSearch= new JButton();
		btnSearch.setIcon(new ImageIcon(LoginView.class.getResource("../imgs/find1.png")));
		btnSearch.setBounds(800, -5, 50, 30);
		btnSearch.setBorderPainted(false);
		btnSearch.setContentAreaFilled(false);
		inbodyPanel.add(btnSearch);

		JLabel l1 = new JLabel("Coference Articles");
		inbodyPanel.add(l1);
		l1.setBounds(8, 0, 150, 20);
		l1.setFont(new Font("Corbel Light", Font.PLAIN, 20));

		AdminController c= new AdminController(this);
		c.viewConferenceArticles();
		inbodyPanel.add(getconferenceScrollPane());
		getconferenceScrollPane().setBounds(10, 30, 850, 200);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(413, 580, 85, 21);
		inbodyPanel.add(btnDelete);

		btnSave = new JButton("Save");
		btnSave.setBounds(301, 580, 85, 21);
		inbodyPanel.add(btnSave);

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

		tfID = new JTextField();
		tfID.setEditable(false);
		tfID.setColumns(10);
		tfID.setBounds(192, 255, 369, 19);
		inbodyPanel.add(tfID);

		tfTitle = new JTextField();
		tfTitle.setColumns(10);
		tfTitle.setBounds(192, 295, 369, 19);
		inbodyPanel.add(tfTitle);

		tfAuthor = new JTextField();
		tfAuthor.setColumns(10);
		tfAuthor.setBounds(192, 335, 369, 19);
		inbodyPanel.add(tfAuthor);

		tfYear = new JTextField();
		tfYear.setColumns(10);
		tfYear.setBounds(192, 375, 369, 19);
		inbodyPanel.add(tfYear);

		tfEditor = new JTextField();
		tfEditor.setColumns(10);
		tfEditor.setBounds(192, 415, 369, 19);
		inbodyPanel.add(tfEditor);

		tfPlace = new JTextField();
		tfPlace.setColumns(10);
		tfPlace.setBounds(192, 455, 369, 19);
		inbodyPanel.add(tfPlace);

		tfPage = new JTextField();
		tfPage.setColumns(10);
		tfPage.setBounds(192, 495, 369, 19);
		inbodyPanel.add(tfPage);

		//issue section
		JLabel l = new JLabel("Select Research ID to issue:");
		l.setBounds(693, 255, 200, 19);
		l.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		inbodyPanel.add(l);
		researcherID = new JComboBox();
		String[] ids =getReasearcherIds().toArray(new String[] {});
		researcherID.setModel(new DefaultComboBoxModel(ids));
		researcherID.setBounds(700, 295, 150, 19);
		inbodyPanel.add(researcherID);
		btnIssue= new JButton("Issue");
		btnIssue.setBounds(750, 335, 100, 25);
		inbodyPanel.add(btnIssue);
				
		addPanel();
		showConferenceRow();
		c.editConfernceArticles();
		c.deleteConferenceArticles();
		c.searchConferenceArticle();
		c.issuebook();
	}

	/**
	 * *** Accessors *******
	 */
	//menu
	public JMenuItem getmntmSignOut() { return mntmSignOut; }
	//buttons
	public JButton getbtnAddResearcher(){ return btnAddResearcher; }
	public JButton getbtnViewResearcher(){ return btnViewResearcher;}
	public JButton getbtnAddBookChapter(){ return btnAddBookChapter;}
	public JButton getbtnAddJournalArticle(){ return btnAddJournalArticle;}
	public JButton getbtnAddConferenceArticle(){ return btnAddConferenceArticle;}
	public JButton getbtnViewBookChapter(){ return btnViewBookChapter;}
	public JButton getbtnViewJournalArticle(){ return btnViewJournalArticle;}
	public JButton getbtnViewConferenceArticle() { return btnViewConferenceArticle; }
	public JButton getbtnViewIssuedArticles() { return btnViewIssuedArticles; }
	public JButton getbtnAddJArticle(){ return btnAddJArticle;}
	public JButton getbtnAddCArticle(){ return btnAddCArticle;}
	public JButton getbtnAddBook(){ return btnAddBook;}

	public JButton getbtnSave() { return btnSave; }
	public JButton getbtnDelete() { return btnDelete; }
	public JButton getbtnSearch() { return btnSearch; }
	public JButton getbtnIssue() { return btnIssue; }
	public JButton getbtnReturn() { return btnReturn; }

	//textfields
	public JTextField gettfID() { return tfID; }
	public JTextField gettfPublisher() { return tfPublisher; }
	public JTextField gettfTitle() { return tfTitle; }
	public JTextField gettfAddress() { return tfAddress; }
	public JTextField gettfContact() { return tfContact; }
	public JTextField gettfEmail() { return tfEmail; }
	public JTextField gettfUser() { return tfUser; }
	public JTextField gettfPassword() { return tfPassword; }
	public JTextField gettfArticleTitle() { return tfArticleTitle; }
	public JTextField gettfJTitle() { return tfJTitle; }
	public JTextField gettfYear() { return tfYear; }
	public JTextField gettfVolume() { return tfVolume; }
	public JTextField gettfIssue() { return tfIssue; }
	public JTextField gettfAuthor() { return tfAuthor; }
	public JTextField gettfPage() { return tfPage; }
	public JTextField gettfEditor() { return tfEditor; }
	public JTextField gettfPlace() { return tfPlace; }
	public JTextField gettfSearch() { return tfSearch; }
	
	public JComboBox getReID() { return researcherID; }


	//table row index
	public int getEditIndex() { return editIndex; }
	public void setEditIndex(int i) {editIndex= i;}

	/*
	 * row setters
	 */
	//researchers
	public void showResearcherCell(String id, String name, String address, String contact, String email, String username, String password)
	{	this.tfID.setText(id);
	this.tfTitle.setText(name);
	this.tfAddress.setText(address);
	this.tfContact.setText(contact);
	this.tfEmail.setText(email);
	this.tfUser.setText(username);
	this.tfPassword.setText(password);
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

	/*
	 * row selector of table
	 */
	//researcher table
	public void showResearcherRowDetails()
	{ 
		resTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				int indexRow;
				String valID ,valName,valAddress,valContact,valEmail,valUser, valPassword;
				DefaultTableModel resModel = (DefaultTableModel)resTable.getModel();
				indexRow=resTable.getSelectedRow();
				valID= resModel.getValueAt(indexRow, 1).toString();
				valName= resModel.getValueAt(indexRow,2).toString();
				valAddress= resModel.getValueAt(indexRow,3).toString();
				valContact= resModel.getValueAt(indexRow,4).toString();
				valEmail= resModel.getValueAt(indexRow,5).toString();
				valUser= resModel.getValueAt(indexRow,6).toString();
				valPassword= resModel.getValueAt(indexRow,7).toString();
				showResearcherCell(valID, valName, valAddress, valContact, valEmail, valUser, valPassword);
				setEditIndex(resTable.getSelectedRow());
			}
		});
	}

	//book chapter table
	public void showBookChapterRow()
	{ 
		bookTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				int indexRow;
				String valID ,valName,valAuthor,valYear,valEditor,valPlace, valPublisher, valPage;
				DefaultTableModel bookMdl = (DefaultTableModel)bookTable.getModel();
				indexRow=bookTable.getSelectedRow();
				valID= bookMdl.getValueAt(indexRow, 1).toString();
				valName= bookMdl.getValueAt(indexRow,2).toString();
				valAuthor= bookMdl.getValueAt(indexRow,3).toString();
				valYear= bookMdl.getValueAt(indexRow,4).toString();
				valEditor= bookMdl.getValueAt(indexRow,5).toString();
				valPlace= bookMdl.getValueAt(indexRow,6).toString();
				valPublisher= bookMdl.getValueAt(indexRow,7).toString();
				valPage= bookMdl.getValueAt(indexRow,8).toString();
				showBookcell(valID, valName, valAuthor, valYear, valEditor, valPlace, valPublisher, valPage);
				setEditIndex(bookTable.getSelectedRow());
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
				valID= jmodel.getValueAt(indexRow, 1).toString();
				valName= jmodel.getValueAt(indexRow,2).toString();
				valJournalTitle= jmodel.getValueAt(indexRow,3).toString();
				valYear= jmodel.getValueAt(indexRow,4).toString();
				valVolume= jmodel.getValueAt(indexRow,5).toString();
				valIssue= jmodel.getValueAt(indexRow,6).toString();
				valAuthor= jmodel.getValueAt(indexRow,7).toString();
				valPage= jmodel.getValueAt(indexRow,8).toString();
				showJournalCell(valID, valName, valJournalTitle, valYear, valVolume, valIssue, valAuthor,  valPage);
				setEditIndex(journalTable.getSelectedRow());
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
				valID= bookMdl.getValueAt(indexRow, 1).toString();
				valName= bookMdl.getValueAt(indexRow,2).toString();
				valAuthor= bookMdl.getValueAt(indexRow,3).toString();
				valYear= bookMdl.getValueAt(indexRow,4).toString();
				valEditor= bookMdl.getValueAt(indexRow,5).toString();
				valPlace= bookMdl.getValueAt(indexRow,6).toString();
				valPage= bookMdl.getValueAt(indexRow,7).toString();
				showConferenceCell(valID, valName, valAuthor, valYear, valEditor, valPlace, valPage);
				setEditIndex(conferenceTable.getSelectedRow());
			}
		});
	}

	//methods
	public void lblProperty()
	{
		lblID = new JLabel();
		lbl2 = new JLabel();
		lbl3 = new JLabel();
		lbl4 = new JLabel();
		lbl5 = new JLabel();
		lbl6 = new JLabel();
		lbl7 = new JLabel();
		lbl8 = new JLabel();
		
		
		inbodyPanel.add(lblID);
		inbodyPanel.add(lbl2);
		inbodyPanel.add(lbl3);
		inbodyPanel.add(lbl4);
		inbodyPanel.add(lbl5);
		inbodyPanel.add(lbl6);
		inbodyPanel.add(lbl7);
		inbodyPanel.add(lbl8);

		lblID.setBounds(358, 92, 369, 19);
		lbl2.setBounds(358, 135, 369, 19);
		lbl3.setBounds(358, 181, 369, 19);
		lbl4.setBounds(358, 225, 369, 19);
		lbl5.setBounds(358, 271, 369, 19);
		lbl6.setBounds(358, 317, 369, 19);
		lbl7.setBounds(358, 366, 369, 19);
		lbl8.setBounds(358, 415, 500, 19);
	}
	//search results deatails panel
	public void searchResearcherPanel()
	{
		inBodyProperty();
		
		JLabel label_7 = new JLabel("Researcher Details");
		label_7.setForeground(new Color(0, 0, 139));
		label_7.setFont(new Font("Corbel Light", Font.PLAIN, 20));
		label_7.setBounds(352, 26, 224, 37);
		inbodyPanel.add(label_7);

		JLabel label_8 = new JLabel("ID ");
		JLabel label_6 = new JLabel("Name");
		JLabel label_5 = new JLabel("Address");
		JLabel label_3 = new JLabel("Contact");
		JLabel label_4 = new JLabel("Email");
		JLabel label_2 = new JLabel("Username");
		JLabel label_1 = new JLabel("Password");
		JLabel articles = new JLabel("Articles / Chapters Hired:");
		
		JButton btnBack = new JButton("Back");
		
		label_8.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_8.setBounds(188, 96, 150, 20);
		label_6.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_6.setBounds(188, 139, 150, 20);
		label_5.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_5.setBounds(188, 185, 150, 20);
		label_3.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_3.setBounds(188, 229, 150, 20);
		label_4.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_4.setBounds(188, 275, 150, 20);
		label_2.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_2.setBounds(188, 321, 150, 20);
		label_1.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_1.setBounds(188, 370, 150, 20);
		articles.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		articles.setBounds(188, 415, 200, 20);
		btnBack.setBounds(600, 500, 100, 25);
		
		lbl9 = new JTextArea();
		lbl9.setBounds(358, 415, 495, 50);
		lbl9.setLineWrap(true);
		
		inbodyPanel.add(label_8);
		inbodyPanel.add(label_6);
		inbodyPanel.add(label_5);
		inbodyPanel.add(label_3);
		inbodyPanel.add(label_4);
		inbodyPanel.add(label_2);
		inbodyPanel.add(label_1);
		inbodyPanel.add(articles);
		inbodyPanel.add(lbl9);
		inbodyPanel.add(btnBack);
		lblProperty();		
		addPanel();
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {displayResearchers();}
		});
	}

	public void bookDetailPanel()
	{
		inBodyProperty();
		JLabel label_7 = new JLabel("Book Chapter Details");
		label_7.setForeground(new Color(0, 0, 139));
		label_7.setFont(new Font("Corbel Light", Font.PLAIN, 20));
		label_7.setBounds(352, 26, 224, 37);
		inbodyPanel.add(label_7);

		JLabel label_8 = new JLabel("ID ");
		JLabel label_6 = new JLabel("Title");
		JLabel label_5 = new JLabel("Author(s)");
		JLabel label_3 = new JLabel("Publication Year");
		JLabel label_4 = new JLabel("Book Editor");
		JLabel label_2 = new JLabel("Place of Publication");
		JLabel label_1 = new JLabel("Publisher");
		JLabel label = new JLabel("Page No.");
		JButton btnBack = new JButton("Back");


		label_8.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_8.setBounds(188, 96, 150, 20);
		label_6.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_6.setBounds(188, 139, 150, 20);
		label_5.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_5.setBounds(188, 185, 150, 20);
		label_3.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_3.setBounds(188, 229, 150, 20);
		label_4.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_4.setBounds(188, 275, 150, 20);
		label_2.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_2.setBounds(188, 321, 150, 20);
		label_1.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_1.setBounds(188, 370, 150, 20);
		label.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label.setBounds(188, 419, 150, 20);
		btnBack.setBounds(600, 500, 100, 25);

		inbodyPanel.add(label_8);
		inbodyPanel.add(label_6);
		inbodyPanel.add(label_5);
		inbodyPanel.add(label_3);
		inbodyPanel.add(label_4);
		inbodyPanel.add(label_2);
		inbodyPanel.add(label_1);
		inbodyPanel.add(label);
		inbodyPanel.add(btnBack);
		lblProperty();		
		addPanel();
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {displayBookChapter();}
		});

	}

	public void searchJournalPanel()
	{
		inBodyProperty();
		JLabel label_7 = new JLabel("Article Details");
		label_7.setForeground(new Color(0, 0, 139));
		label_7.setFont(new Font("Corbel Light", Font.PLAIN, 20));
		label_7.setBounds(352, 26, 224, 37);
		inbodyPanel.add(label_7);

		JLabel label_8 = new JLabel("ID ");
		JLabel label_6 = new JLabel("Article Title");
		JLabel label_5 = new JLabel("Journal Title");
		JLabel label_3 = new JLabel("Publication Year");
		JLabel label_4 = new JLabel("Volume");
		JLabel label_2 = new JLabel("Issue No.");
		JLabel label_1 = new JLabel("Author(s)");
		JLabel label = new JLabel("Page No.");
		JButton btnBack = new JButton("Back");

		label_8.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_8.setBounds(188, 96, 150, 20);
		label_6.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_6.setBounds(188, 139, 150, 20);
		label_5.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_5.setBounds(188, 185, 150, 20);
		label_3.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_3.setBounds(188, 229, 150, 20);
		label_4.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_4.setBounds(188, 275, 150, 20);
		label_2.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_2.setBounds(188, 321, 150, 20);
		label_1.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_1.setBounds(188, 370, 150, 20);
		label.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label.setBounds(188, 419, 150, 20);
		btnBack.setBounds(600, 500, 100, 25);

		inbodyPanel.add(label_8);
		inbodyPanel.add(label_6);
		inbodyPanel.add(label_5);
		inbodyPanel.add(label_3);
		inbodyPanel.add(label_4);
		inbodyPanel.add(label_2);
		inbodyPanel.add(label_1);
		inbodyPanel.add(label);
		inbodyPanel.add(btnBack);
		lblProperty();		
		addPanel();
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {displayJournalArticles();}
		});
	}
	public void searchConferencePanel()
	{
		inBodyProperty();
		JLabel label_7 = new JLabel("Article Details");
		label_7.setForeground(new Color(0, 0, 139));
		label_7.setFont(new Font("Corbel Light", Font.PLAIN, 20));
		label_7.setBounds(352, 26, 224, 37);
		inbodyPanel.add(label_7);

		JLabel label_8 = new JLabel("ID ");
		JLabel label_6 = new JLabel("Title");
		JLabel label_5 = new JLabel("Author(s)");
		JLabel label_3 = new JLabel("Publication Year");
		JLabel label_4 = new JLabel("Editor(s)");
		JLabel label_2 = new JLabel("Conference Location");
		JLabel label = new JLabel("Page No.");
		JButton btnBack = new JButton("Back");

		label_8.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_8.setBounds(188, 96, 150, 20);
		label_6.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_6.setBounds(188, 139, 150, 20);
		label_5.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_5.setBounds(188, 185, 150, 20);
		label_3.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_3.setBounds(188, 229, 150, 20);
		label_4.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_4.setBounds(188, 275, 150, 20);
		label_2.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label_2.setBounds(188, 321, 150,20);
		label.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		label.setBounds(188, 370, 150, 20);
		btnBack.setBounds(600, 500, 100, 25);

		inbodyPanel.add(label_8);
		inbodyPanel.add(label_6);
		inbodyPanel.add(label_5);
		inbodyPanel.add(label_3);
		inbodyPanel.add(label_4);
		inbodyPanel.add(label_2);
		inbodyPanel.add(label);
		inbodyPanel.add(btnBack);
		lblProperty();		
		addPanel();
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {displayConferenceArticle();}
		});}

	public JLabel getlblId() {return lblID; }
	public JLabel getlbl2() {return lbl2; }
	public JLabel getlbl3() {return lbl3; }
	public JLabel getlbl4() {return lbl4; }
	public JLabel getlbl5() {return lbl5; }
	public JLabel getlbl6() {return lbl6; }
	public JLabel getlbl7() {return lbl7; }
	public JLabel getlbl8() {return lbl8; }
	public JTextArea getlbl9() {return lbl9; }
	
	// arraylist of researchers id required for issue of articles
	public ArrayList<String> getReasearcherIds() {
		ArrayList<String> ids= new ArrayList<String>();
		if(mod.readData()!=null) {
			for(int i=0;i<mod.readData().size();i++) 
			{ids.add(mod.readData().get(i).getId());}}
		return ids;	}
	
//	view articles issued and researchers id
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

	AdminController c= new AdminController(this);
	c.viewHires();
	inbodyPanel.add(getHireScrollPane());
	getHireScrollPane().setBounds(10, 30, 850, 500);

	btnReturn= new JButton("Return");
	btnReturn.setBounds(750, 555, 100, 25);
	inbodyPanel.add(btnReturn);
	
	tfID =new JTextField();
	tfID.setEditable(false);
	tfID.setBounds(10, 555, 150, 25);
	inbodyPanel.add(tfID);
	
	addPanel();
	issueRowSelect();
	c.returnHire();
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
			tfID.setText(aid);
			setEditIndex(hiresTable.getSelectedRow());
		}
	});
}
}

