import java.util.*;
import java.io.*;
public class CodeJam1 {
	

	public static void main(String args[]) throws Exception
	{
		
		Scanner src=new Scanner(System.in);
		int tcases=src.nextInt();
		for(int x=0;x<tcases ;x++)
         {		
		int n =src.nextInt();
		int arr1[][]=new int[n][n];
		for (int i = 0; i < n; i++) 
	      for (int j = 0; j < n; j++) 
            arr1[i][j]=src.nextInt();
		
	
	
		int sum=0;
		for (int i = 0; i < n; i++) 
		  for (int j = 0; j < n; j++) 
		            if(i==j)
	            	  sum+=arr1[i][j];
		
		
		
		
	       
		Set<Integer> tset=new HashSet<Integer>();
		int rcount=0,ccount=0;
		for (int i = 0; i < n; i++) 
		{     tset.clear();
		
			for (int j = 0; j < n; j++) 
			{
				 if(tset.contains(arr1[i][j]))
				 {
					 ++rcount;
					 break;
				 }
				 else 
					 tset.add(arr1[i][j]);
				 
				
			}
		}
		
		for (int i = 0; i < n; i++) 
		{     tset.clear();
		
			for (int j = 0; j < n; j++) 
			{
				 if(tset.contains(arr1[j][i]))
				 {
					 ++ccount;
					 break;
				 }
				 else 
					 tset.add(arr1[j][i]);
				 
				
			}
		}        	  
	            	  
	            	  
	System.out.println(sum+" "+rcount+" "+ccount);			
				
      }
		
		
		
		
	}

}













