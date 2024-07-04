
import java.io.*;
import java.util.*;

class Solution {
     public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		for(int i=0;i<test;i++)
		{
		    int ord=sc.nextInt();
		    int arr[][]=new int[ord][ord];
		    for(int j=0;j<ord;j++)
		    {
		        for(int k=0;k<ord;k++)
		        {
		         arr[j][k]=sc.nextInt();   
		        }
		    }
		    int trace=0;
		    for(int j=0;j<ord;j++)
		    {
		       
		        for(int k=0;k<ord;k++)
		        {
		            if(j==k)
		              trace=trace+arr[j][k];
		              
		        }
		    }
		
		    int row=0,col=0;
		   
		    
		    
		    for(int j=0;j<ord;j++)
		    {
		        int x[]=new int[ord];
		       for(int k=0;k<ord;k++)
		       {
		          int p=arr[k][j];
		          if(x[p-1]==0)
		          {
		             x[p-1]=-1*p; 
		          }
		          else
		          {
		          col++;
		            break;
		          }
		       }
		    }
		     for(int j=0;j<ord;j++)
		    {
		        Arrays.sort(arr[j]);
		        
		        for(int k=0;k<ord-1;k++)
		        {
		            if(arr[j][k]==arr[j][k+1]){
		            row++;
		            break;
		            }
		        }
		    }
		    System.out.println("Case #"+(i+1)+": "+trace+" "+row+" "+col);
		        
		    
		}
		
	}
}