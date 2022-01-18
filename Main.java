import java.util.*;
import java.io.*;
class Main{



   
	public static void main(String arg[])
	{
		
    PriorityQueue<Integer> l1=new PriorityQueue<>(Comparator.reverseOrder());

	l1.add(2);
	l1.add(3);
	l1.add(4);
	l1.add(5);
	l1.add(6);
	for(int i=0;i<l1.size();i++)
	{
		// System.out.println(i);
    System.out.println(l1.peek());
	    l1.poll();
	}
   

	}
}