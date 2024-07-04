import java.util.*;
import java.io.*;

public class solution
{
	public static void main(String[] args)
	{
		int add=0;
		int count =0;
		int ct=0;
		int q=0;
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int z=sc.nextInt();
		try{
		while(q<z)
		{
		int no=sc.nextInt();
		int arr[][]=new int[no][no];
		for(int i=0;i<no;i++)
		{
			for(int j=0;j<no;j++)
			{
				arr[i][j]=sc.nextInt();
			}
		}
		//diagonal
		for(int i=0;i<no;i++)
		{
			for(int j=0;j<no;j++)
			{
				if(i==j)
				{
					add=arr[i][j]+add;
				}
			}
		}
		
		//row
		aa: for(int i=0;i<no;i++)
			{
				for(int j=0;j<no;j++)
				{
					int temp = arr[i][j];
					for(int k=j+1;k<no;k++)
					{
						if(arr[i][k] == temp)
						{
							count++;
							continue aa;
						}
					}
				}
			}
		//column
		aa:for(int j=0;j<no;j++)
		{
			for(int i=0;i<no;i++)
			{
				int temp = arr[i][j];
				for(int k=i+1;k<no;k++)
				{
					if(arr[k][j] == temp)
					{
						ct++;
						continue aa;
					}
				}
			}
		}
			q++;
		System.out.println("Case #"+q+": "+add+" "+count+" "+ct );
		
		add=0;
		count=0;
		ct=0;
	}	
	}
	catch(Exception e)
	{
		System.out.println("");
	}
}
}


