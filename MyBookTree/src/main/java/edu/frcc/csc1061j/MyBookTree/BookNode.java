package edu.frcc.csc1061j.MyBookTree;

import java.util.ArrayList;
import java.util.List;

public class BookNode implements Comparable <BookNode>
{

	private String title; // The root node
	private int chapterNum; // Root node's children
	private int sectionNum; // Root node's grand children
	private int subSectionNum; // Root node's great-grand children
	private List<BookNode> childNodes; // List of children nodes
	
	public BookNode(String title, int chapNum, int secNum, int subSecNum)
	{
		this.title = title;
		chapterNum = chapNum;
		sectionNum = secNum;
		subSectionNum = subSecNum;
		childNodes = new ArrayList<BookNode>();
	}

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public int getChapterNum() 
	{
		return chapterNum;
	}

	public void setChapterNum(int chapterNum) 
	{
		this.chapterNum = chapterNum;
	}

	public int getSectionNum() 
	{
		return sectionNum;
	}

	public void setSectionNum(int sectionNum) 
	{
		this.sectionNum = sectionNum;
	}

	public int getSubSectionNum() 
	{
		return subSectionNum;
	}

	public void setSubSectionNum(int subSectionNum) 
	{
		this.subSectionNum = subSectionNum;
	}

	public List<BookNode> getChildNodes() 
	{
		return childNodes;
	}

	public void setChildNodes(List<BookNode> childNodes) 
	{
		this.childNodes = childNodes;
	}
	
	@Override
	public int compareTo(BookNode o) 
	{
		if (chapterNum > o.chapterNum)
		{
			return 1;
		}
		else if (chapterNum < o.chapterNum)
		{
			return -1;
		}
		
		if (sectionNum > o.sectionNum)
		{
			return 1;
		}
		else if (sectionNum < o.sectionNum)
		{
			return -1;
		}
		
		if (subSectionNum > o.subSectionNum)
		{
			return 1;
		}
		else if (subSectionNum < o.subSectionNum)
		{
			return -1;
		}
		return 0;
	}
	
	@Override
	public String toString()
	{
		// if chapNum is 0 then return just the title
		if (chapterNum == 0)
		{
			return title;
		}
		// if secNum is 0 then return the chapterNum and the title
		if (sectionNum == 0)
		{
			return ("\t" + " " + title);//chapterNum + " " + title);
		}
		// if subSecNum is 0 then return the sectionNun, the chapterNum, and the title
		if (subSectionNum == 0)
		{
			return ("\t\t" + " " + title); //sectionNum + " " + chapterNum + " " + title);
		}
		// if none of the above then return the subSectionNum, the sectionNum, the chapterNum, and the title
		return ("\t\t\t" + " " + title);//subSectionNum + " " + sectionNum + " " + chapterNum + " " + title);
	}
	
}
