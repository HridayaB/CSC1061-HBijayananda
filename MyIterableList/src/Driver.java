import java.util.Iterator;

public class Driver {

	public static void main(String[] args) 
	{
		MyIterableList myList = new MyIterableList();
		
		for ( int num : myList )
		{
			System.out.println (num);
		}

		Iterator<Integer> iterator = myList.iterator();
		while (iterator.hasNext())
		{
			System.out.print (iterator.next());
		}
	}

}
