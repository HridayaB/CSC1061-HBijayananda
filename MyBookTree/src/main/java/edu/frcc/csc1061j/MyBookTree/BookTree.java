package edu.frcc.csc1061j.MyBookTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class BookTree implements Iterable <BookNode>
{
	
	private BookNode root; // the root node defined in BookNode class
	
	public BookTree(String title)
	{
		root = new BookNode(title, 0, 0, 0);
	}

	public BookNode getRoot() 
	{
		return root;
	}
	
	public boolean addBookNode(String title, int chapNum, int secNum, int subSecNum)
	{
		BookNode node = new BookNode(title, chapNum, secNum, subSecNum);
		
		// if chapNum is 0 then false because we already have chapNum
		if (chapNum == 0)
		{
			return false;
		}
		// if secNum is 0 then this is a chapter and we add the chapter to the root
		if (secNum == 0)
		{
			root.getChildNodes().add(node);
			Collections.sort(root.getChildNodes());
			return true;
		}
		// if subSecNum is 0 then this is a section and we find the section through all the chapters and we add the section to the root
		if (subSecNum == 0)
		{
			for (BookNode aNode : root.getChildNodes())
			{
				if (chapNum == aNode.getChapterNum())
				{
					aNode.getChildNodes().add(node);
					Collections.sort(aNode.getChildNodes());
					return true;
				}
			}
			return false;
		}
		
		// if none of the above then this is a subsection and we find the section through all the chapters and then we find the subsection through all the sections and we add the subsection to the root
		BookNode chapterNode = null;
		for (BookNode cNode : root.getChildNodes())
		{
			if (chapNum == cNode.getChapterNum())
			{
				chapterNode = cNode;
				for (BookNode sNode : chapterNode.getChildNodes())
				{
					if (secNum == sNode.getSectionNum())
					{
						sNode.getChildNodes().add(node);
						Collections.sort(sNode.getChildNodes());
						return true;
					}
				}
				return false;
			}
		}
		return false;
	}

	@Override
	public Iterator<BookNode> iterator() 
	{
		return new BookNodeIterator(root);
	}
	
	private class BookNodeIterator implements Iterator<BookNode>
	{

		Deque<BookNode> stack;
		
		public BookNodeIterator(BookNode node)
		{
			stack = new ArrayDeque<BookNode>();
			stack.push(node);
		}
		
		@Override
		public boolean hasNext() 
		{
			return !stack.isEmpty();
		}

		@Override
		public BookNode next() 
		{
			BookNode node = stack.pop(); // Get the node
			List<BookNode> nodes = new ArrayList<BookNode>(node.getChildNodes()); // Get the child nodes and put it in a list
			Collections.reverse(nodes); // Reverse the list
			for (BookNode child : nodes)
			{
				stack.push(child); // Push the child to the stack
			}
			return node;
		}
	}
	
}
