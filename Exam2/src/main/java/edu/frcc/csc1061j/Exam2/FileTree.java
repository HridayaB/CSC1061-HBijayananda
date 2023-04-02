package edu.frcc.csc1061j.Exam2;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;



public class FileTree implements Iterable <FileNode> {

	private FileNode root;
	
	public FileTree(String path) {
		root = new FileNode(path);
		buildTree(root);
	}

	/**
	 * Return a depth first post-order traversal iterator 
	 */
	@Override
	public Iterator<FileNode> iterator() {

		return new DepthFirstIterator();
	}
	
	/**
	 * 	TODO for Exam 2
	 *  Use recursion to build the tree from the directory structure.
	 *  For each of node starting from the root node use listFiles() from File to get 
	 *  the list of files in that directory/folder.
	 *  Create a node for each of the files and add it to a list of child nodes for the node
	 *  Do this recursively for all the nodes.  
	 * 
	 * @param fileNode
	 */
	private void buildTree(FileNode fileNode) {

		File file = fileNode.getFile(); // get the file path from fileNode and put it in a file object
		FileNode node = new FileNode(file);
		
		File[] files = file.listFiles(); // An array of files usinf listFiles()
		// if the current file is a directory/folder then go into the directory and go through each file to search
		// for children, if children is found then add it to the list of child nodes
		// recurse until current file isn't a directory
		if (file.isDirectory())
		{
			for (File fle : files)
			{
				FileNode childNode = new FileNode(fle);
				node.getChildNodes().add(childNode);
				buildTree(childNode);
			} // end of for each loop
			fileNode.setChildNodes(node.getChildNodes());
		} // end of if statement
	}
	
	/**
	 * TODO for Exam 2
	 * Iterator that does a post order traversal of the tree.
	 * For post-order traversal use the 2 stack approach outlined here: 
	 * https://www.geeksforgeeks.org/iterative-postorder-traversal/
	 * 
	 * @return 
	 */
	private class DepthFirstIterator implements Iterator<FileNode> {
		
		private Deque<FileNode> stack1, stack2; // The two stacks of FileNodes using a deque
		
		public DepthFirstIterator() {
			stack1 = new ArrayDeque<>(); // using ArrayDeque
			stack2 = new ArrayDeque<>(); // using ArrayDeque
			stack1.push(root); // Initialize/push the root node to the first stack
		}

		@Override
		public boolean hasNext() {
			return !stack1.isEmpty() || !stack2.isEmpty(); // returns true if either one of the stacks contains nodes in it
		}
		
		@Override
		public FileNode next() {
			if (!hasNext())
			{
				throw new NoSuchElementException("End Reached");
			} // end of if statement
			
			// if stack 2 is empty while stack 1 has nodes in it, pop the nodes from stack 1
			// and push it to stack 2, then for every child in the child list, push it to stack 1
			// returns the nodes in stack 2
			if (stack2.isEmpty())
			{
				while (!stack1.isEmpty())
				{
					FileNode node = stack1.pop();
					stack2.push(node);
					
					for (FileNode child : node.getChildNodes())
					{
						stack1.push(child);
					} // end of for each loop
				} // end of while loop
			} // end of if statement
			return stack2.pop();
		}
	}
	
	/**
	 *  Returns an iterator that does a breadth first traversal of the tree using a queue.
	 * 
	 * @return
	 */
	public Iterator<FileNode> breadthFirstIterator() {
		
		return new BreadthFirstIterator();

	}	
	
	/** 
	 * TODO for Exam 2
	 * Iterator that does a breadth first traversal of the tree using a queue.
	 * 
	 */
	private class BreadthFirstIterator implements Iterator<FileNode> {
		
		private Queue<FileNode> queue; // The queue of FileNodes
		
		public BreadthFirstIterator() {
			queue = new LinkedList<>(); // using LinkedList
			queue.add(root); // add the the root node to the queue
		}
		
		@Override
		public boolean hasNext() {
			return !queue.isEmpty(); // returns true if queue has nodes in it
		}

		@Override
		public FileNode next() {
			if (!hasNext())
			{
				throw new NoSuchElementException("End Reached");
			} // end of if statement
			
			// Removes the current node from the queue and for each child in the child list
			// it gets added to the queue
			// returns the next node in the queue
			FileNode nextNode = queue.remove();
			for (FileNode child : nextNode.getChildNodes())
			{
				queue.add(child);
			} // end of for loop
			return nextNode;
		}
	}
}
