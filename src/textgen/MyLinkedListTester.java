/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	MyLinkedList<Integer> integers;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);

		integers = new MyLinkedList<>();
		integers.add(1);
		integers.add(100);
		integers.add(100000);
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());

		try {
			int b = list1.remove(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException ignored) {

		}

		try {
			int b = list1.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException ignored) {

		}


		int c = list1.remove(1);
		assertEquals(42, c);
		assertEquals(1, list1.size());

		int d = list1.remove(0);
		assertEquals(0, list1.size());
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
		assertEquals("First adding", (Integer)1, integers.get(0));
		assertEquals("Second adding", (Integer)100, integers.get(1));
		assertEquals("Third adding", (Integer)100000, integers.get(2));
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		assertEquals(2, shortList.size());
		assertEquals(0, emptyList.size());
		assertEquals(LONG_LIST_LENGTH, longerList.size());
		assertEquals(3, list1.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
		integers.add(0, 50);
		assertEquals((Integer)50, integers.get(0));
		assertEquals((Integer)1, integers.get(1));
		assertEquals((Integer)100, integers.get(2));
		assertEquals((Integer)100000, integers.get(3));
		integers.add(3, 500);
		assertEquals((Integer)500, integers.get(3));
		assertEquals((Integer)100000, integers.get(4));

		try {
			integers.add(-1, 50);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException ignored) {

		}

		try {
			integers.add(100, 50);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException ignored) {

		}

		try {
			integers.add(1, null);
			fail("Null element adding");
		} catch (NullPointerException ignored) {

		}
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
		integers.set(2, 1000);
		assertEquals((Integer)1000, integers.get(2));
		integers.set(0, 250);
		assertEquals((Integer)250, integers.get(0));

		try {
			integers.set(-1, 100);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException ignored) {

		}

		try {
			integers.set(100, 100);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException ignored) {

		}

		try {
			integers.set(1, null);
			fail("Null element setting");
		} catch (NullPointerException ignored) {

		}
	}
	
	
	// TODO: Optionally add more test methods.
	
}
