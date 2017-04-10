package Omar;

import java.util.Scanner;

public class Main {

	private static Scanner Cin;
	private static Bank B;
	private static String s ;
	private static String[] parts;
	private static String order;
	private static int size;
	private static int[] array;
	
	public static void main(String[] args)
	{
		Cin = new Scanner(System.in);
	 	B = new Bank();
	 	B.Start();
	    //	B.Status();
	 	
	 	
	 	System.out.print("Enter Operation: ");

	 	s=Cin.nextLine();
	 	
	 	parts = s.split(" ");
	 	order=parts[0];
	 	
	 	size = parts.length-1;
	 	
	 	array = new int [size];
	 	
	 	for(int i=0 ;i<size ;i++)
	 		array[i]=Integer.parseInt(parts[i+1]);
	 	
	 	
	 	if(order.equals("Release"))
	 	{
	 		B.Release(array , size);
	 		B.Status();
	 	}
	 	else if(order.equals("Request"))
	 	{
	 		B.Status();
	 		System.out.println("\n");
	 		B.Request(array);
	 		System.out.println("\n");
	 	//	B.Status();
	 		
	 	}
	 	
	 	if(order.equals("Quit"))
	 	{
	 		System.out.println("Exit.");
	 		System.exit(0);
	 	}
	 	
	 	if(order.equals("Status"))
	 	{
	 		B.Status();
	 	}
	 	
	 		
	 	System.out.println("Finish");
	 	

	}

}
