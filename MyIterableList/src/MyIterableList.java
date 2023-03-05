import java.util.Iterator;

public class MyIterableList implements Iterable<Integer>
{
	private int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

	@Override
	public Iterator iterator() 
	{
		return new MyIterator();
	}
	
	private class MyIterator implements Iterator<Integer>
	{

		private int index = 0;
		
		public MyIterator()
		{
			
		}
		
		@Override
		public boolean hasNext() 
		{
			if ( index < array.length)
			{
				return true;
			}
			return false;
		}

		@Override
		public Integer next() 
		{
			
			return array[index++];
		}
		
	}
}
