package Omar;

import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Bank
{
	
    ArrayList<Integer> Available =new ArrayList<Integer>() ;
	int AvailableSize;

	int Maximum[][];
	int Allocation[][];
	int Need[][];
	
	int Rows , Columns;

	String FileName , S ;
	Formatter F ;
	Scanner Cin = new Scanner(System.in);
	private String [] parts;
	private int y;
	

	public Bank()
	{
		System.out.print("Enter File name And of Resoursces: ");
		S=Cin.nextLine();
		parts = S.split(" ");
		FileName=parts[0];
		
		AvailableSize=parts.length-1;
		
		for(int i=0 ; i<AvailableSize ;i++ ){
			Available.add(i,Integer.parseInt(parts[i+1])) ;
		}
		
		int Cnt=0;
		try
		{
			Cin=new Scanner(new File (FileName));
		}catch(Exception e)
		{
			System.out.println("Can't Open File");
		}
		while(Cin.hasNext())
		{
			y=Cin.nextInt();
			Cnt++;
		}
		
		Cin.close();
		
	//	System.out.println(Cnt);
		
		Rows=Cnt/AvailableSize;
		Columns=AvailableSize;
		
		Allocation= new int [Rows][Columns];
		Need=new int [Rows][Columns];
		Maximum=new int [Rows][Columns];
		
	//	System.out.println(Rows+" "+Columns);
		
	}
	
	public void Start ()
	{
		
		//System.out.println(Rows+" "+Columns);
		
		for(int i=0 ;i<Rows ;i++)
		{
			for(int j=0 ;j<Columns ;j++)
			{
				Allocation[i][j]=0;
			}
		}
		
		try
		{
			Cin=new Scanner(new File (FileName));
		}catch(Exception e)
		{
			System.out.println("Can't Open File");
		}
		
		for(int i=0 ;i<Rows ;i++)
		{
			for(int j=0 ;j<Columns ;j++)
			{
				int x=Cin.nextInt();
				Maximum[i][j]=x;
				Need[i][j]=x;
			}
		}		
		Cin.close();
		
	
		
	}
	
	public void Status ()
	{
		System.out.println("Avaiable: ");
		for(int i=0 ;i<AvailableSize ;i++)
			System.out.print(Available.get(i)+" ");
		System.out.println("\n");
		
		System.out.println("Allocation: ");
		for(int i=0 ;i<Rows ;i++)
		{
			for(int j=0 ;j<Columns ;j++)
				System.out.print(Allocation[i][j]+" ");
			System.out.println();
		}
		
		System.out.println("\nNeed: ");
		for(int i=0 ;i<Rows ;i++)
		{
			for(int j=0 ;j<Columns ;j++)
				System.out.print(Need[i][j]+" ");
			System.out.println();
		}
		
		System.out.println("\nMaximum Need: ");
		for(int i=0 ;i<Rows ;i++)
		{
			for(int j=0 ;j<Columns ;j++)
				System.out.print(Maximum[i][j]+" ");
			System.out.println();
		}
		
		
	}
	
	
	public void Release (int arr[] , int s)
	{
		int index=arr[0];
		Boolean flag = true;
		int arr2[] = new int[s-1];
		
		
		for(int i=1 ;i<s ;i++)
		{
			arr2[i-1]=arr[i];
		}
				
		System.out.println();
		
		for(int i=0 ; i<Columns ;i++ )
		{
			if(arr2[i]>Allocation[index-1][i])
			{
				flag=false;
				break;
			}
		}
		
		if(!flag)
		{
			System.out.println("Cann't Do The Order!");
			return;
		}
		int temp;
				
		for(int i=0 ;i<Columns ;i++)
		{
			Allocation[index-1][i]-=arr2[i];
			temp=Available.get(i)+arr2[i];
			Available.set(i,temp);
		}
		
		
	}
	
	

}
