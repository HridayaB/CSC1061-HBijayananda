package edu.frcc.csc1061j.ArrayAndLinkedLists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList < T >implements List < T >
{

	private T [ ] array; // stores all the elements
	private int size; // the size of the array

	@SuppressWarnings ( "unchecked" )
	public MyArrayList ( )
	{
		array = ( T [ ] ) new Object [ 4 ];
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
	public Iterator < T > iterator ( ) 
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
	public < T > T [ ] toArray ( T [ ] a ) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings ( "unchecked" )
	@Override
	public boolean add ( T e ) 
	{
		// Checking if array is big enough and making it bigger if it's not big enough
		if ( size >= array.length )
		{
			T [ ] biggerArray = ( T [ ] ) new Object [ array.length * 2 ];
			System.arraycopy ( array, 0, biggerArray, 0, array.length );
			array = biggerArray;
		}
		array [ size ] = e;
		size++;
		return true;
	}

	@Override
	public boolean remove ( Object o ) 
	{
		// Traversing the array to find the object's index
		int removeIndex = indexOf ( o );
		
		// Checking if object was found
		if ( removeIndex == -1 )
		{
			return false;
		}
		
		// Removing the index and making the array smaller
		for ( int j = removeIndex; j < size - 1; j++ )
		{
			array [ j ] = array [ j + 1 ];
		}
		size--;
		return true;
	}

	@Override
	public boolean containsAll ( Collection < ? > c ) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll ( Collection < ? extends T > c ) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll ( int index, Collection < ? extends T > c ) 
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
		size = 0;
	}

	@Override
	public T get ( int index ) 
	{
		// Checking to see if index is valid
		if ( index < 0 || index >= size )
		{
			throw new IndexOutOfBoundsException ( );
		}
		return array [ index ];
	}

	@Override
	public T set ( int index, T element ) 
	{
		// Checking to see if index is valid
		if ( index < 0 || index >= size )
		{
			throw new IndexOutOfBoundsException ( );
		}
		
		// Setting the new element into the old element
		T oldElement = array [ index ];
		array [ index ] = element;
		return oldElement;
	}

	@Override
	public void add ( int index, T element ) 
	{
		// Checking if index is valid
		if ( index < 0 || index >= size )
		{
			throw new IndexOutOfBoundsException ( );
		}
		
		// Checking and manipulating size
		add ( element );
		
		// Shifting elements
		for ( int i = size - 1; i > index; i-- )
		{
			array [ i ] = array [ i - 1 ];
		}
		array [ index ] = element;
	}

	@Override
	public T remove ( int index ) 
	{
		// Getting the element in the index
		T element = get ( index );
		
		// Removing and shifting elements
		for ( int i = index; i < size - 1; i++ )
		{
			array [ i ] = array [ i + 1 ];
		}
		size--;
		return element;
	}

	@Override
	public int indexOf ( Object o ) 
	{
		int index = -1;
		
		// Traversing through the array to find the object's index 
		for ( int i = 0; i < size; i++ )
		{
			if ( o.equals ( array [ i ] ) )
			{
				index = i;
				break;
			}
		}
		
		return index;
	}

	@Override
	public int lastIndexOf ( Object o ) 
	{
		int index = -1;
		
		// Traversing through the array to find the last index 
		for ( int i = 0; i < size; i++ )
		{
			if ( o.equals ( array [ i ] ) )
			{
				index = i;
			}
		}
		return index;
	}

	@Override
	public ListIterator < T > listIterator ( ) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator < T > listIterator ( int index ) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List < T > subList ( int fromIndex, int toIndex ) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
} // end of class MyarrayList
