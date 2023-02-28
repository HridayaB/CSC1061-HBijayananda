package edu.frcc.csc1061j.ArrayAndLinkedLists;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList < E > implements List < E > 
{

	private class Node
	{
		private E data; // the data in the node
		private Node next; // the next node
		
		public Node ( E data )
		{
			this.data = data;
			this.next = null;
		}
	} // end of class Node
	
	private int size; // the size of the linked list
	private Node head; // the head of the nodes or the first node

	public MyLinkedList ( )
	{
		head = null;
		size = 0;
	}
	
	@Override
	public int size ( ) 
	{
		return size;
	}

	@Override
	public boolean isEmpty ( ) 
	{
		return size == 0;
	}

	@Override
	public boolean contains ( Object o ) 
	{
		if ( indexOf ( o ) != -1 )
		{
			return true;
		}
		return false;
	}

	@Override
	public Iterator < E > iterator ( ) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object [ ] toArray ( ) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public < E > E [ ] toArray ( E [ ] a ) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add ( E e ) 
	{
		Node newNode = new Node ( e );
		
		// Checking if there is anything on the node
		if ( head == null )
		{
			head = newNode;
		}
		else 
		{
			Node node = null;
			
			// Traversing until the last node is found
			for ( node = head; node.next != null; node = node.next )
			{}
			node.next = newNode;
		}
		size++;
		return true;
	}

	@Override
	public boolean remove ( Object o ) 
	{
		// Getting the index for the object, remove at index is called if index is not -1
		int index = indexOf ( o );
		if ( index == -1 )
		{
			return false;
		}
		remove ( index );
		return true;
	}

	@Override
	public boolean containsAll ( Collection < ? > c ) 
	{
		for ( Object data : c )
		{
			contains ( data );
		}
		return true;
	}

	@Override
	public boolean addAll ( Collection < ? extends E > c ) 
	{
		for ( E data : c )
		{
			add ( data );
		}
		return true;
	}

	@Override
	public boolean addAll ( int index, Collection < ? extends E > c ) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll ( Collection < ? > c ) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll ( Collection < ? > c ) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear ( ) 
	{
		// Clearing everything in the linked list
		head = null;
		size = 0;
	}

	@Override
	public E get ( int index ) 
	{
		// Getting the node 
		Node node = getNode ( index );		
		return node.data;
	}

	@Override
	public E set ( int index, E element ) 
	{
		// Setting a new element in the data and putting the old element in a E old and returning it
		Node node = getNode ( index );
		E old = node.data;
		node.data = element;
		return old;
	}

	@Override
	public void add ( int index, E element ) 
	{
		Node newNode = new Node ( element );
		// If index is 0, then a new node is added as the head
		if ( index == 0 )
		{
			newNode.next = head;
			head = newNode;
		}
		// Get the node previous to the node you want to add and make the new node you want to add and add it after the node you just got
		else
		{
			Node node = getNode ( index - 1 );
			newNode.next = node.next;
			node.next = newNode;
		}
		size++;
	}

	@Override
	public E remove ( int index ) 
	{
		// Removing the node at the index provided
		E data = get( index );
		// Checking if index is 0, if yes, then the head points to the next node
		if ( index == 0 )
		{
			head = head.next;
		}
		// Get the node previous to the node you want to remove and make it point to the node after the one you want to remove
		else
		{
			Node node = getNode ( index - 1 );
			node.next = node.next.next;
		}
		size--;
		return data;
	}

	@Override
	public int indexOf ( Object o ) 
	{
		// Traversing and finding the index
		Node node = head;
		int index = -1;
		// finds the first time o equals node.next and returns it
		for ( int i = 0; i < size; i++ )
		{
			if ( o.equals ( node.data ) )
			{
				return i;
			}
			node = node.next;
		}
		return index;
	}

	@Override
	public int lastIndexOf ( Object o ) 
	{
		Node node = head;
		int index = -1;
		// Traversing the last index of the linked list, keeps track of the last thing o equals node.data
		for ( int i = 0; i < size; i++ )
		{
			if ( o.equals ( node.data ) )
			{
				index = i;
			}
		}
		return index;
	}

	@Override
	public ListIterator < E > listIterator ( ) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator < E > listIterator ( int index ) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List < E > subList ( int fromIndex, int toIndex ) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	private Node getNode ( int index )
	{
		// Checking to see if the index is correct
		if ( index < 0 || index >= size )
		{
			throw new IndexOutOfBoundsException ( );
		}
		// Getting the node
		Node node = head;
		for ( int i = 0; i < index; i++ )
		{
			node = node.next;
		}
		return node;
	}

} // end of class MyLinkedList
