package com.corejava;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.PriorityBlockingQueue;

public class Collection01 {

	public static void main(String[] args) {
//hashcode and equals methods
		String x = "prasad";
		String y = "PRASAD";
		String z = "Swati";
		
		//System.out.println(x.equals(y));  //If true then hascode of x and y must be same
		//If x.equals(y) is true then y.equals(x) must be true
		//If x.equals(y) is true and y.equals(z) is also true then, x.equals(z) is must be true.
		//System.out.println(x.equals(null));  //false
		//System.out.println(x.hashCode());
		//System.out.println(y.hashCode());
		//it is necessary to override the hashCode() method of the Object class if we are overriding the equals() method.
		//we can compare String, Integer, Array, List, Arraylist ... anything with using .equals() methods.
		
//Iterable(I)
		//part of java.lang
		//It provides a standard mechanism for iterating over the elements of a collection.
		//It has a single abstract method:- Iterator<T> iterator();
		
//Collection(I)
		//part of java.util
		//subinterfaces-List,Set,Queue
		//methods - size(),isEmpty(),add(),remove(),contains(),containsAll(),addAll(),removeAll()
		
//List(I)
		//https://www.javadevjournal.com/java/java-arraylist/
		//Extends collection
		//Sequence is maintained OR ordered collection i.e. it maintains the insertion order.
		//Duplicates are allowed
	
	//1) ArrayList(C)
		//allows to store duplicate values including “null” values
		//It is an ordered collection, i.e. it maintains the insertion order.
		//So, This provides flexibility to use elements using the indexes.
		
		
		//List<String> list = new List<String>(); //wrong bcuz we can ojb for classes only not for interface 
		List<String> list = new ArrayList<String>();
		  list.add("California");
		  list.add("Alabama");
		  list.add("Colorado");
		  list.add("Delaware");
			/*
			 * System.out.println(list); list.add(3, "Texas"); System.out.println(list);
			 * list.add(4, "Texas"); System.out.println(list); list.remove(1);
			 * System.out.println(list);
			 */
		  System.out.println(list.hashCode());
		  
		List<String> list2 = new ArrayList<String>();
		  list2.add("California");
		  list2.add("Alabama");
		  list2.add("Colorado");
		  list2.add(null);
		  list2.add("");
		  list2.add("Delaware");
		System.out.println(list2.hashCode());
		//use equals method on arraylist
		System.out.println(list.equals(list2));
		//Add multiple elements in arraylist
		List<String> list3 = Arrays.asList("abc","pqr","xyz");
		List<String> list4 = new ArrayList<String>();
		list4.addAll(list3);
		list4.addAll(list2);
		System.out.println("list4 - "+list4);
		System.out.println("indexOf() abc is "+list4.indexOf("abc")); //indexOf()
		System.out.println("indexOf() '' is "+list4.indexOf(""));
		//set() - used to replace/change/set element from arraylist, get() returns the element(not remove)
		
		//Iterate the arraylist
		//1) Iterator(I)
		//It can traverse list forward...use .iterator() method
		List<Integer> list5 = new ArrayList<Integer>();
		list5.add(1);list5.add(4);list5.add(43);list5.add(666);list5.add(909);list5.add(4);
		System.out.println(list5);
		System.out.println("lastIndexOf() 4 is "+list5.lastIndexOf(4)); //lastIndexOf()
		Iterator<Integer> iterator = list5.iterator();
		while(iterator.hasNext()) {
			System.out.println("Next element is : "+ iterator.next());
		}
		
		//2)ListIteraotor(I)
		//It can traverse list forward and backward
		/*
		 * ListIterator<Integer> listIterator = list5.listIterator();
		 * while(listIterator.previous() != null) {
		 * System.out.println("Previous element is : "+listIterator); }
		 */
	
		
	//2) Vector
		//arraylist                   									 vector
		//not synchronized											synchronized
		//If no of elements exceeds from its capacity, 				increments 100%
		//arraylist increments to 50% of current array size
		//Fast, because it is non-synchronized						Slow because of synchronized
		//Synchronized - method can access by one thread at a time and non-synchronized - method can accessed 
		//by multiple threads simultaneously.
	
	//3) LinkedList
		//Nodes of LinkedList don't need continuously present in memory. They placed randomly and connected using next.
		//Memory optimized
		//doesn't allow "empty" node
		//insertion order maintained
		//size of LL doesn't need to declare to be advance
		//Limitations-(LL vs Array)
		//Requires more memory than array bcuz each node contains pointer and that requires extra memory to store
		//requires more access time, we must traverse from head(first element) to the required element to access
		//unlike in array we can access directly by index.
		//null insertion is allowed
		
		//Singly LL representation
		//Head=>|Data|Next|->|Data|Next|->|Data|NULL|=>Tail
		
		//Insertion
		//1)Inserting a new node as a first node
		//2)Inserting node after node
		//3)Inserting at end of list
		
		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.add("prasad");
		linkedList.add(null);
		linkedList.add("");
		System.out.println("linkedList is "+linkedList);
		
//Queue(I)-FIFO
		//Maintains insertion order where insertion occur at end of list and removal happen at start 
		// It is used to keep the elements that are processed in the First In First Out (FIFO) manner.
		//Imple classes-LinkedList and PriorityQueue(Not thread safe)
		//Thread safe-
		//PriorityBlockingQueue(C) is thread safe
		//offer() - to add at end / poll() - to remove from start
		//1) PriorityQueue 
		//null insertion is not allowed.
		Queue<Integer> queue = new PriorityQueue<Integer>();
		queue.add(3);
		queue.add(4);
		queue.add(5);
		//queue.add(null);
		queue.offer(6);
		System.out.println("Queue is "+queue);
		queue.poll();
		System.out.println("After poll Queue is "+queue);
		
		//2) LinkedList 
		//If we use LL implementation for Queue(I) the null insertion allowed
		Queue<String> queue2 = new LinkedList<String>();
		queue2.add("Prasad");
		queue2.add("");
		queue2.add(null);
		queue2.add("abc");
		queue2.offer(null);
		System.out.println("Queue2 before poll "+queue2);
		queue2.poll();
		System.out.println("Queue2 after poll "+queue2);
		//System.out.println(queue.contains(2));
		
//Set(I) - java.util
		//unordered collection/list and duplicates not allowed
		//mostly used for mathematical operations
		//TreeSet(C) -> implements NavigableSet(I) -> extends SortedSet(I) -> extends Set(I) -> extend Collection(I)
		//LinkedHashSet(C)-> extends HashSet(C) -> implements Set(I)
	
		//We can perform basic mathematical operations like intersection, union and difference
		//Intersection-return common elements between sets--retainAll()
		//Union-returns union of sets==addAll()
		//Difference-deletes non-common between sets--removeAll()
		
		//1)HashSet(C) and 2)LinkedHashSet(C)
		Integer[] A = {10,20,30,40,50};
		Integer[] B = {60,70,80,90,100};
		Set<Integer> set1 = new HashSet<Integer>();
		set1.addAll(Arrays.asList(A));
		Set<Integer> set2 = new HashSet<Integer>();
		set2.addAll(Arrays.asList(B));
		
		//Union
		Set<Integer> set3 = new HashSet<>(set1);
		System.out.println("First Set is "+set3);
		System.out.println("Second set is "+set2);

		set3.addAll(set2);
		System.out.println("Union Set is "+set3);
		
		//Intersection
		set3.retainAll(set2);
		System.out.println("Intersection Set is "+set3);
		
		//Difference
		set3.removeAll(set2);
		System.out.println("Difference Set is "+set3);

		//clear() method removes all elements - method of set(I)
		set3.clear();
		System.out.println("Last set3 "+set3);
		//contains(), containsAll() - check presence in set - - methods of set(I)
		HashSet<Integer> data = new HashSet<Integer>();   
        data.add(51);   
        data.add(11);   
        data.add(81);   
        System.out.println("Hashset: " + data);  
        Set<Integer> newData = new LinkedHashSet<Integer>();   
        newData.add(81);   
        newData.add(11);   
        newData.add(51);
        //trying to add duplicates->Contents of the Set remain unchanged, and the duplicate value will not added.
        data.add(51);
        newData.add(11);
        //null insertion-not possible
        data.add(null);
        System.out.println("LinkedHashSet: " + newData);
        System.out.println("Does Hashset contains 81: "+data.contains(81));
        System.out.println("Does Hashset contains LinkedHashSet?: "+ data.containsAll(newData)); 
        //remove(), removeAll(), size(), 
        
        //LinkedHashSet(C)-> extends HashSet(C) -> implements Set(I)
        //      HashSet(C)                        Vs 				LinkedHashSet(C)
        //1)Order of insertion not maintains              Order of insertion is maintains
        //2)use hash table to store elements			  Extends HashSet and uses LinkedList along with 
        //											      hash table to maintain order of insertion 
        //3)slightly better performance than LHashSet	  Slightly slower
        //4)takes less memory than LHashSet
        
        //3)TreeSet(C)
        //TreeSet(C) -> implements NavigableSet(I) -> extends SortedSet(I) -> extends Set(I) -> extend Collection(I)
        //non synchronized
        //null insertion not allowed
        //always maintain ascending order
        //TreeSet implemented using Binary search tree which self-balancing tree so 
        //It is one of most efficient data structure in order to keep large data that is sorted and duplicate not allowed.
        
        TreeSet<String> treeSet1 = new TreeSet<>();
        treeSet1.add("Prasad");
        treeSet1.add("Ashwini");
        //treeSet.add(null);
        TreeSet<Integer> treeSet2 = new TreeSet<>();
        treeSet2.add(32);
        treeSet2.add(13);
        treeSet2.add(100);
        treeSet2.add(0);
        treeSet2.add(-6);
        System.out.println("TreeSet1 is "+treeSet1);
        System.out.println("TreeSet2 is "+treeSet2);
        //descending TreeSet
        System.out.println("descendingSet TreeSet1 is "+treeSet1.descendingSet());
        //pollFirst() and pollLast() --> return first and last from set and remove it from set collcetion
        TreeSet<Integer> treeSet3 = new TreeSet<>();
        treeSet3.add(24);
        treeSet3.add(66);
        treeSet3.add(12);
        treeSet3.add(15);
        System.out.println("Lowest value is "+treeSet3.pollFirst());
        System.out.println("Highest value is "+treeSet3.pollLast());
        System.out.println("Poll Set is "+treeSet3);
        //Navigable Set operations
        TreeSet<String> set=new TreeSet<String>();  
        set.add("A");  
        set.add("B");  
        set.add("C");  
        set.add("D");  
        set.add("E");
        System.out.println("Intial Navigable set: "+set);  
        System.out.println("Head Navigable Set: "+set.headSet("C"));  
        System.out.println("SubSet Navigable set: "+set.subSet("A", "E"));  
        System.out.println("TailSet Navigable set: "+set.tailSet("C"));  
        System.out.println("Navigable set: "+set);
        
//Map(I)
        //in java.util
        //Not inherited from Collection(I)
        //collection of elements as key/value pair
        
        
	}

}
