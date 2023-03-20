package edu.frcc.csc1061j.MyHashMap;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map<K, V>
{

	private static final int INITIAL_NUM_BUCKETS = 4; // The initial number of buckets
	private int size = 0; // The total number of entries in the hash map
	private double loadFactorThreshold = 0.5; // The load factor threshold, number of entries / number of buckets must not pass load factor threshold 
	private LinkedList<Entry<K, V>>[] buckets; // An array of linked lists
	
	@SuppressWarnings("unchecked")
	public MyHashMap()
	{
		buckets = new LinkedList[INITIAL_NUM_BUCKETS];
	}
	
	private static class Entry<K, V> implements Map.Entry<K, V>
	{

		K key; // The key of the entry
		V value; // The value of the entry
		
		public Entry(K key, V value)
		{
			this.key = key;
			this.value = value;
		}
		
		@Override
		public K getKey() 
		{
			return key;
		}

		@Override
		public V getValue() 
		{
			return value;
		}

		@Override
		public V setValue(V value) 
		{
			V oldValue = this.value;
			this.value = value;
			return oldValue;
		}
		
	} // end of class Entry<K, V>
	
	@Override
	public int size() 
	{
		return size; // The size of the hash map
	}

	@Override
	public boolean isEmpty() 
	{
		return size == 0; // Checks if hash map is empty, if yes then returns true, else returns false
	}

	@Override
	public boolean containsKey(Object key) 
	{
		// If key is not null then return true, else return false
		if (get(key) != null)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean containsValue(Object value) 
	{
		// Traverse through the hash map and if bucket is not null, then make a new linked list and try to find the value in that linked list through the entry's value
		// if yes, then return true, else return false
		for (int i = 0; i < buckets.length; i++)
		{
			if (buckets[i] != null)
			{
				LinkedList<Entry<K, V>> bucket = buckets[i];
				for (Entry<K, V> entry : bucket)
				{
					if (entry.getValue().equals(value))
					{
						return true;
					}
				}

			}
		}
		return false;
	}

	@Override
	public V get(Object key) 
	{
		int bucketIndex = Math.abs(key.hashCode()) % buckets.length;
		LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];
		// If bucket isn't null, then traverse through the linked list, check if the entry's key matches key, then return entry's value
		if (bucket != null)
		{
			for (Entry<K, V> entry : bucket)
			{
				if (entry.getKey().equals(key))
				{
					return entry.getValue();
				}
			}
		}
		// Traverse through the linked list, check if the entry's key matches key, then return entry's value
//		for (Entry<K, V> entry : bucket)
//		{
//			if (entry.getKey().equals(key))
//			{
//				return entry.getValue();
//			}
//		}
		return null;
	}

	@Override
	public V put(K key, V value) 
	{
		int bucketIndex = Math.abs(key.hashCode()) % buckets.length;
		LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];
		// Check if bucket is null, if yes then assign a new linked list to bucket
		if (bucket == null)
		{
			bucket = new LinkedList<Entry<K, V>>();
			buckets[bucketIndex] = bucket;
		}
		// Traverse through the linked list, check if the entry's key matches key, then assign value in the bucket
		for (Entry<K, V> entry : bucket)
		{
			if (entry.getKey().equals(key))
			{
				V oldValue = entry.getValue();
				entry.value = value;
				return oldValue;
			}
		}
		bucket.add(new Entry<K, V>(key, value));
		size++;
		// Check if load factor has exceeded the threshold then rehash		
		double currentLoadFactor = (1.0 * size)/buckets.length;
		if (currentLoadFactor > loadFactorThreshold)
		{
			rehash();
		}
		return value;
	}

	@Override
	public V remove(Object key) 
	{
		int bucketIndex = Math.abs(key.hashCode()) % buckets.length;
		LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];
		// If bucket isn't null, then traverse through the linked list with the entry, if entry's key equals key then, get entry's value and remove entry and return the value
		if (bucket != null)
		{
			for (Entry<K, V> entry : bucket)
			{
				if (entry.getKey().equals(key))
				{
					V value = entry.getValue();
					bucket.remove(entry);
					size--;
					return value;
				}
			}

		}
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) 
	{
		Set<? extends Map.Entry<? extends K, ? extends V>> entries = m.entrySet ( );
		for (Map.Entry<? extends K,? extends V> entry : entries)
		{
			put(entry.getKey(),entry.getValue());
		}
	}

	@Override
	@SuppressWarnings("unused") 
	public void clear() 
	{
		size = 0;
		// Traverse through the buckets and make them null
		for (LinkedList<Entry<K, V>> bucket : buckets)
		{
			bucket = null;
		}
	}

	@Override
	public Set<K> keySet() 
	{
		Set<K> set = new HashSet<K>();
		// Traverse through the hash map and if bucket is not null, then make a new linked list and try to find the value in that linked list through the entry's value
		// if yes, then add entry's key into set which is a hash set
		for (int i = 0; i < buckets.length; i++)
		{
			if (buckets[i] != null)
			{
				LinkedList<Entry<K, V>> bucket = buckets[i];
				for (Entry<K, V> entry : bucket)
				{
					set.add(entry.getKey());
				}
			}
		}
		return set;
	}

	@Override
	public Collection<V> values() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Map.Entry<K, V>> entrySet() 
	{
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
		// Traverse through the hash map and if bucket is not null, then make a new linked list and try to find the value in that linked list through the entry's value
		// if yes, then add entry's key into set which is a hash set
		for (int i = 0; i < buckets.length; i++)
		{
			if (buckets[i] != null)
			{
				LinkedList<Entry<K, V>> bucket = buckets[i];
				for (Entry<K, V> entry : bucket)
				{
					set.add(entry);
				}
			}
		}
		return set;
	}

	@SuppressWarnings("unchecked")
	private void rehash()
	{
		int newCapacity = buckets.length * 2; // New capacity for new list
	    LinkedList<Entry<K, V>>[] newBuckets = new LinkedList[newCapacity]; // Making new buckets with new capacity
	    for (LinkedList<Entry<K, V>> bucket : buckets) 
	    {
	        if (bucket == null) 
	        {
	            continue;
	        }
	        for (Entry<K, V> entry : bucket) 
	        {
	            // Similar to put(K, V)
	        	int newBucketIndex = Math.abs(entry.getKey().hashCode()) % newCapacity;
	            LinkedList<Entry<K, V>> newBucket = newBuckets[newBucketIndex];
	            if (newBucket == null) 
	            {
	                newBucket = new LinkedList<>();
	                newBuckets[newBucketIndex] = newBucket;
	            }
	            newBucket.add(entry);
	        }
	    }
	    buckets = newBuckets;
	} // end of rehash
	
} // end of class MyHashMap
