import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws IOException 
	{
	    
	     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test=Integer.parseInt(br.readLine());
	   // int test;
	    
	    for(int i=0;i<test;i++)
	    {
	      
	        
	       int n=Integer.parseInt(br.readLine());
	       int arr[][]=new int[n][n];
	       int rows=0;
	       int cols=0;
	       int trace=0; 
	        for(int j=0;j<n;j++)
	        {
	          String[] tk= br.readLine().split(" ");
	           
	            for(int k=0;k<n;k++)
	            {
	                arr[j][k]=Integer.parseInt(tk[k]);
	                if(j==k)
	                {trace=trace+arr[j][k];}
	                
	            }
	            
	      }
	        int flag=0;
	       for(int m=0;m<n;m++)
	        {
	       
	       for(int o=0;o<n;o++)
	       {
	          int cmp=arr[m][o];
	          
	          for(int p=o+1;p<n;p++)
	          {
	              if(cmp==arr[m][p])
	           {   rows++;
	              flag=1;
	              break;}
	          }
	       if(flag==1)
	       {
	         flag=0;  
	       
	       break;
	       }   
	       }
	        }
	        for(int m=0;m<n;m++)
	        {
	       
	       for(int o=0;o<n;o++)
	       {
	          int cmp=arr[o][m];
	          
	          for(int p=o+1;p<n;p++)
	          {
	              if(cmp==arr[p][m])
	             { cols++;
	              flag=1;
	              break;}
	          }
	       if(flag==1)
	       {
	         flag=0;  
	       
	       break;
	       }   
	       }
	        }
	        
	        
	        
	        
	        System.out.println("Case #"+(i+1)+": "+trace+" "+rows+" "+cols);
	    }
	    
	    
		// your code goes here
	}
}
