/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
    
    
    	    
		  public static void sortbyColumn(int arr[][], int col) 
    { 
        // Using built-in sort function Arrays.sort 
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override              
          // Compare values according to columns 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            // To sort in descending order revert  
            // the '>' Operator 
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });  // End of function call sort(). 
    } 
    
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner in = new Scanner(System.in);
		int t=in.nextInt();
		int sss=1;
		while(t>0)
		{
		    int n=in.nextInt();
		    
		    int c=0,pos1=0;
		    int j=0,pos2=0;
		    
		    String s="";
		    int flag=0;
		    
		    int[][] a= new int[n][2];
		    
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i][0]=in.nextInt();
		        a[i][1]=in.nextInt();
		    } 
	
	
	
	sortbyColumn(a, 0); 
	
	
	
	   
		    for(int i=0;i<n;i++)
		    {
		        int start=a[i][0],end=a[i][1];
		        
		        if(start>=pos1 )
		        {
		            pos1=end;
		            s=s+"C";
		            //c++;
		        }
		        else if(start>=pos2 )
		        {
		            pos2=end;
		            s=s+"J";
		        }
		        else{
		            flag=1;
		            break;
		        }
		    }
		    
		    if(flag==0)
		    System.out.println("Case #"+sss+": "+s);
		    else
		    {
		        System.out.println("Case #"+sss+": "+"IMPOSSIBLE");
		    }
		    sss++;
	
	
		 
		    t--;
		}
	}
}
