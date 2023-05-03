package edu.frcc.csc1061j.MinHeap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinHeap <E extends Comparable <E>>
{
	private List<E> heapArray;
	private Map<E, Integer> indexMap;
	
	public MinHeap()
	{
		heapArray = new ArrayList<>();
		indexMap = new HashMap<>();
	}
	
	public boolean isEmpty()
	{
		return heapArray.size() == 0;
	}
	
	public int size()
	{
		return heapArray.size();
	}
	
	public List<E> getHeap()
	{
		return heapArray;
	}
	
	public boolean contains(E elem)
	{
		return indexMap.containsKey(elem);
	}
	
	public int leftChild(E entry)
	{
		return ((2 * indexMap.get(entry)) + 1);
	}
	
	public int rightChild(E entry)
	{
		return ((2 * indexMap.get(entry)) + 2);
	}
	
	public int parent(int pos)
	{
		if (pos == 0)
		{
			return -1;
		}
		return ((pos - 1) / 2);
	}
	
	public int leftChild(int pos)
	{
		int child = (2 * pos) + 1;
		return child >= heapArray.size() ? -1 : child;
	}
	
	public int rightChild(int pos)
	{
		int child = (2 * pos) + 2;
		return child >= heapArray.size() ? -1 : child;
	}
	
	public boolean isLeafNode(int pos)
	{
		return (pos >= heapArray.size() / 2) && (pos < heapArray.size());
	}
	
	public int add(E entry)
	{
		heapArray.add(entry);
		return swimUp(heapArray.size());
	}
	
	private int swimUp(int current)
	{
		int parent = parent(current);
		E parentEntry = heapArray.get(parent);
		
		while ((current != 0) && (heapArray.get(current).compareTo(parentEntry) < 0))
		{
			swap(current, parent);
			current = parent;
			parent = parent(current);
			parentEntry = heapArray.get(parent);
		}
		return current;
	}
	
	private void swap(int pos1, int pos2)
	{
		E temp = heapArray.get(pos1);
		heapArray.set(pos1, heapArray.get(pos2));
		heapArray.set(pos2, temp);
	}
	
	public E remove()
	{
		return remove(0);
	}
	
	public E remove(int pos)
	{
		swap(pos, heapArray.size() - 1);
		E removedEntry = heapArray.remove(heapArray.size() - 1);
		if (heapArray.size() > 0)
		{
			siftDown(pos);
		}
		return removedEntry;
	}
	
	private int siftDown(int current)
	{
		while (!isLeafNode(current))
		{
			int leftChild = leftChild(current);
			int rightChild = rightChild(current);
			
			E lChild = heapArray.get(leftChild);
			if (rightChild > -1)
			{
				E rChild = heapArray.get(rightChild);
				if (rChild.compareTo(lChild) < 0)
				{
					
				}
			}
		}
		return 1;
	}
}
