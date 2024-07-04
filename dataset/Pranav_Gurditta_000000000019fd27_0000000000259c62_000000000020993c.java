import java.util.*;
import java.io.*;
public class Solution{
	
	public boolean unique(int arr[])
	{
		ArrayList<Integer> arra=new ArrayList<Integer>();
		for(int i:arr)
		{
			
			if(arra.contains(i))
				return false;
			arra.add(i);	
		}
		return true;	
	}
	public static void main(String[] args){

	Scanner sc=new Scanner(new BufferedReader(new 

InputStreamReader(System.in)));
	Solution obj=new Solution();	
	int number_of_times=sc.nextInt();
	for(int i=0;i< number_of_times;i++){
		int row_count=0;
		int column_count=0;
		int trace=0;
		int size=sc.nextInt();
		int arr[][]=new int[size][size];
		int col_arr[][]=new int[size][size];
		for(int j=0;j<size;j++)
		{	
			for(int k=0;k<size;k++)
			{
				arr[j][k]=sc.nextInt();
				if(j==k)
				{
					trace+=arr[j][k];
				}
			}
			
			if(obj.unique(arr[j])==false)
				row_count++;
		}		
		for(int j=0;j<size;j++)
		{	
			for(int k=0;k<size;k++)
			{
				col_arr[j][k]=arr[k][j];
			}
			
			if(obj.unique(col_arr[j])==false)
				column_count++;
		}		
		
			
	
		System.out.println("Case #"+(i+1)+": "+trace+" "+row_count+" "+column_count);
	}
}
}

	