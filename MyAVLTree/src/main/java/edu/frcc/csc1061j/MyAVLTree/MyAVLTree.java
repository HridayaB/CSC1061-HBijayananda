package edu.frcc.csc1061j.MyAVLTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import edu.frcc.csc1061j.MyTreeMap.MyTreeMap.Node;


@SuppressWarnings("rawtypes")
public class MyAVLTree<K, V> implements Map<K, V>, Iterable<edu.frcc.csc1061j.MyAVLTree.MyAVLTree.Node>
{
	
	private Node root = null; // The root node
	private int size; // The tree's size
	private List<Node> path; // A list of the path
	
	protected class Node	
	{
		private K key; // The node's key
		private V value; // The node's value
		private Node left = null; // The left node / left child
		private Node right = null; // The right node / right child
		private int height; // The height of the node
		
		public Node(K key, V value)
		{
			this.key = key;
			this.value = value;
			this.height = 0;
		}

		public K getKey() 
		{
			return key;
		}

		public V getValue() 
		{
			return value;
		}

		public Node getLeft() 
		{
			return left;
		}

		public Node getRight() 
		{
			return right;
		}

		public int getHeight() 
		{
			return height;
		}

	}
	
	private void updateHeight(Node node)
	{
		// If the node is a leaf node then it's height is 0, if only the left child of the node is null then the height is the right child's height + 1
		// if only the right child is null the the height is the left child's height + 1, 
		// if both of node's children aren't null, then we take the max height of either child and add 1//the greater height of the two children + 1
		if (node.left == null && node.right == null)
		{
			node.height = 0;
		}
		else if (node.left == null)
		{
			node.height = node.right.height + 1;
		}
		else if (node.right == null)
		{
			node.height = node.left.height + 1;
		}
		else 
		{
			node.height = Math.max(node.left.height, node.right.height) + 1;
		}
	}
	
	private void balancePath()
	{
		// Traverse through the path, get the current node in the path, update the height for the current node,
		// if the path's size is greater than 0, then the parent gets the path 
		// find the balance factor for the current node, if it is -2 and current's left node is less than or equal to 0, then we have a LL imbalance and we need to do a LL rotation
		// if the balance factor is -2 and the current's left node is greater than or equal to 0, then we have a LR imbalance and we need to do a LR rotation
		// if the balance factor is 2 and the current's right node is greater than or equal to 0, then we have a RR imbalance and we need to do a RR rotation
		// if the balance factor is 2 and the current's right node is less than or equal to 0, then we have a RL imbalance and we need to do a RL rotation
		for (int i = path.size() - 1; i >= 0; i--)
		{
			Node current = path.get(i);
			updateHeight(current);
			Node parent = null;
			if (i > 0)
			{
				parent = path.get(i - 1);
			}
			int bFactor = balanceFactor(current);
			switch (bFactor)
			{
				case -2:
					if (balanceFactor(current.left) <= 0)
					{
						balanceLL(current, parent);
					}
					else 
					{
						balanceLR(current, parent);
					}
					break;
				case 2:
					if (balanceFactor(current.right) >= 0)
					{
						balanceRR(current, parent);
					}
					else
					{
						balanceRL(current, parent);
					}
					break;
			}
		}
	}
	
	private int balanceFactor(Node current)
	{
		int balanceFactor = 0;
		int rightHeight = -1;
		int leftHeight = -1;
		
		// If the current's left child is null, then it's balance factor is -1, if the current's right child is null, then it's balance factor is -1
		if (current.left != null)
		{
			leftHeight = current.left.height;
		}
		if (current.right != null)
		{
			rightHeight = current.right.height;
		}
		
		// if both of current's children aren't null, then the balance factor is the right child's height - the left child's height
		balanceFactor = rightHeight - leftHeight;
		return balanceFactor;
	}
	
	private void balanceLL(Node node, Node parent)
	{
		Node leftNode = node.left;
		
		// If the node is the root, then shift it to the right and make the left node the root
		if (node == root)
		{
			root = leftNode;
		}
		else
		{
			// If the current node's parent is in the left then we use the parent's right node as left node, 
			// if the current node's parent is in the right then we use the parent's left node as left node 
			if (parent.left == node)
			{
				parent.left = leftNode;
			}
			else
			{
				parent.right = leftNode;
			}
		}
		
		// The current node's left child is the left node's right child and the left node's right child is the node, then update their heights
		node.left = leftNode.right;
		leftNode.right = node;
		updateHeight(node);
		updateHeight(leftNode);
	}
	
	private void balanceLR(Node node, Node parent)
	{
		Node leftNode = node.left; // Starting node's left child
		Node rightNode = leftNode.right; // leftNode's right child
		
		// If the starting node is the root, then the new root becomes the rightNode
		if (node == root)
		{
			root = rightNode;
		}
		else
		{
			// If the current node's parent is in the left then we use the parent's right node as right node, 
			// if the current node's parent is in the right then we use the parent's left node as right node 
			if (parent.left == node)
			{
				parent.left = rightNode;
			}
			else
			{
				parent.right = rightNode;
			}
		}
		
		// Handling the rightNode's children
		node.left = rightNode.right;
		leftNode.right = rightNode.left;
		
		// rightNode is now in the place of the starting node, so it's left child is the leftNode and it's right child is the starting node
		rightNode.left = leftNode;
		rightNode.right = node;
		
		// Update all their heights
		updateHeight(node);
		updateHeight(leftNode);
		updateHeight(rightNode);
	}
	
	private void balanceRR(Node node, Node parent)
	{
		Node rightNode = node.right;
		
		// If the node is the root, then shift it to the right and make the left node the root
		if (node == root)
		{
			root = rightNode;
		}
		else
		{
			// If the current node's parent is in the right then we use the parent's right node as right node, 
			// if the current node's parent is in the left then we use the parent's left node as right node 
			if (parent.right == node)
			{
				parent.right = rightNode;
			}
			else
			{
				parent.left = rightNode;
			}
		}
		
		// The current node's right child is the right node's right child and the right node's left child is the node, then update their heights
		node.right = rightNode.left;
		rightNode.left = node;
		updateHeight(node);
		updateHeight(rightNode);
	}
	
	private void balanceRL(Node node, Node parent)
	{
		Node rightNode = node.right; // Starting node's right child
		Node leftNode = rightNode.left; // rightNode's left child
		
		// If the starting node is the root, then the new root becomes the leftNode
		if (node == root)
		{
			root = leftNode;
		}
		else
		{
			// If the current node's parent is in the right then we use the parent's right node as left node, 
			// if the current node's parent is in the left then we use the parent's left node as left node 
			if (parent.right == node)
			{
				parent.right = leftNode;
			}
			else
			{
				parent.left = leftNode;
			}
		}
		
		// Handling the leftNode's children
		node.right = leftNode.left;
		rightNode.left = leftNode.right;
		
		// leftNode is now in the place of the starting node, so it's right child is the rightNode and it's left child is the starting node
		root.right = rightNode;
		leftNode.left = node;
		
		// Update all their heights
		updateHeight(node);
		updateHeight(rightNode);
		updateHeight(leftNode);
	}
	
	public MyAVLTree()
	{
		path = new ArrayList<>();
	}

	@Override
	public int size() 
	{
		return size;
	}

	@Override
	public boolean isEmpty() 
	{
		return size == 0;
	}

	@Override
	public boolean containsKey(Object key) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(Object key) 
	{
		@SuppressWarnings("unchecked")
		Comparable<K> k = (Comparable<K>) key;
		Node current = root;
		
		// While current doesn't equal null, compare the current key with the incoming key, if incoming key is less than current's key
		// then go to the left, if incoming key is greater than current's key, then go to the right,
		// if they are equal, we have the value we need so return current's value
		while (current != null)
		{
			if (k.compareTo(current.key) < 0)
			{
				current = current.left;
			}
			else if (k.compareTo(current.key) > 0)
			{
				current = current.right;
			}
			else
			{
				return current.value;
			}
		}
		
		return null;
	}

	@Override
	public V put(K key, V value) 
	{
		Node newNode = new Node(key, value);

		// If there's nothing in the tree, put the first node in the tree as a root
		if (root == null)
		{
			root = newNode;
			size++;
			path = new ArrayList<Node>();
			updateHeight(root);
			return value;
		}
		
		Node current = root;
		Node parent = null;
		@SuppressWarnings("unchecked")
		Comparable<K> k = (Comparable<K>) key;
		
		// Clear the list before traversing the tree
		path.clear();
		
		// While current doesn't equal null, compare the current key with the incoming key, if incoming key is less than current's key
		// then go to the left while keeping track of the parent, if incoming key is greater than current's key, then go to the right
		// while keeping track of the parent, if they are equal, then do nothing or return null
		while (current != null)
		{
			path.add(current);
			if (k.compareTo(current.key) < 0)
			{
				parent = current;
				current = current.left;
			}
			else if (k.compareTo(current.key) > 0)
			{
				parent = current;
				current = current.right;
			}
			else
			{
				return null;
			}
		}
		
		// create a new node after comparing incoming key to parent's key
		if (k.compareTo(parent.key) < 0)
		{
			parent.left = newNode;
			//path.add(parent.left);
		}
		else
		{
			parent.right = newNode;
			//path.add(parent.right);
		}
		size++;
		updateHeight(newNode);
		balancePath();
		return value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public V remove(Object key) 
	{
		Node current = root; // get the current value from the get method
		Node parent = null;
		Comparable<K> k = (Comparable<K>) key;
		
		if (current == null)
		{
			throw new NullPointerException();
		}
		
		while (current != null)
		{
			if (k.compareTo(current.key) == 0)
			{ 
				if (current.left != null && current.right != null) // Case 2: two children
		         {
		             Node child = current.right;
		             parent = current;
		             while (child.left != null) 
		             {
		                 parent = child;
		                 child = child.left;
		             }
		             
		             V value = current.value;
		             current.key = child.key;
		             current.value = child.value;
		             if (parent.left == child) 
		             {
		                 parent.left = child.right;
		             } 
		             else 
		             {
		                 parent.right = child.right;
		             }
		             size--;
		             return value;
		         } 
		         else if (current.left == null && current.right == null) // Case 1: no children
		         {
		             if (parent == null) 
		             {
		                 root = null;
		             } 
		             else if (current == parent.left) 
		             {
		                 parent.left = null;
		             } 
		             else 
		             {
		                 parent.right = null;
		             }
		         } 
		         else // Case 3: one child
		         {
		            Node child = current.left;
		         	if (current.left != null)
		             {
		             	child = current.left;
		             }
		             else if (current.right != null)
		             {
		             	child = current.right;
		             }

		             if (parent == null) 
		             {
		                 root = child;
		             } 
		             else if (current == parent.left) 
		             {
		                 parent.left = child;
		             } 
		             else 
		             {
		                 parent.right = child;
		             }
		         }
				size--;
		        return current.value;
		     } 
		     else if (k.compareTo(current.key) < 0) // go left 
		     {
		         parent = current;
		         current = current.left;
		     } 
		     else // go right
		     {
		         parent = current;
		         current = current.right;
		     }
			
		}
		return null;	
	}

	@Override
	public void clear() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<K> keySet() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Entry<K, V>> entrySet() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void putAll(Map<? extends K, ? extends V> m) 
	{
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator iterator() 
	{
		// An iterator to traverse the AVL tree with a in-order traversal
		return new InOrderIterator();
	}
	
	private class InOrderIterator implements Iterator<Node>
	{

		private List<Node> list;
		private int currentIndex = 0;
		
		public InOrderIterator()
		{
			list = new ArrayList<>();
			inOrder(root);
		}
		
		private void inOrder(Node node)
		{
			if (node == null)
			{
				return;
			}
			inOrder(node.left);
			list.add(node);
			inOrder(node.right);
		}
		
		@Override
		public boolean hasNext() 
		{
			return currentIndex < list.size();
		}

		@Override
		public Node next() 
		{
			Node value = list.get(currentIndex);
			currentIndex++;
			return value;
		}
		
	}
	
}
