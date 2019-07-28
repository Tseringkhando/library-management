package Serializable;

import java.io.Serializable;
/*
 * This records the hire out article's id and name and researcher's id
 */
public class IssueRecords implements Serializable {
	private static final long serialVersionUID = 1L;
	private String rid, aid, articlename;
	public IssueRecords(String r, String a, String article)
	{
		rid= r;
		aid= a;
		articlename= article;
	}
	
	public IssueRecords() {}

	public String getRid() { return rid;}
	public String getAid() { return aid;}
	public String getArticleName() { return articlename;}
	
}
