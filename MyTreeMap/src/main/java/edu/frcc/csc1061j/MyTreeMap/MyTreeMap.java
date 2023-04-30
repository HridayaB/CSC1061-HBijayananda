package edu.frcc.csc1061j.MyTreeMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyTreeMap<K, V> implements Map<K, V>, Iterable<V>
{
	
	private Node root = null; // The root node
	private int size; // The tree's size
	
	private class Node	
	{
		private K key; // The node's key
		private V value; // The node's value
		private Node left = null; // The left node / left child
		private Node right = null; // The right node / right child
		
		public Node(K key, V value)
		{
			this.key = key;
			this.value = value;
		}
	}
	
	public MyTreeMap()
	{
		
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
			return value;
		}
		
		Node current = root;
		Node parent = null;
		@SuppressWarnings("unchecked")
		Comparable<K> k = (Comparable<K>) key;
		
		// While current doesn't equal null, compare the current key with the incoming key, if incoming key is less than current's key
		// then go to the left while keeping track of the parent, if incoming key is greater than current's key, then go to the right
		// while keeping track of the parent, if they are equal, then do nothing or return null
		while (current != null)
		{
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
		}
		else
		{
			parent.right = newNode;
		}
		size++;
		return value;
	}

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

	@Override
	public Iterator<V> iterator() 
	{
		return new InOrderIterator();
	}
	
	private class InOrderIterator implements Iterator<V>
	{

		private List<V> list;
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
			list.add(node.value);
			inOrder(node.right);
		}
		
		@Override
		public boolean hasNext() 
		{
			return currentIndex < list.size();
		}

		@Override
		public V next() 
		{
			V value = list.get(currentIndex);
			currentIndex++;
			return value;
		}
		
	}
	
}
