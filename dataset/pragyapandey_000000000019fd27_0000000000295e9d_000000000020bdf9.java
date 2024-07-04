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
	   
	   System.out.print("Case #"+(i+1)+": ");
	        int task=Integer.parseInt(br.readLine());
	         int c[]=new int[task];
	      int large=0;
	      int im=0;
	      int flag=0;
	       int arr[][]=new int[task][2];
	       for(int j=0;j<task;j++)
	       {
	            
	            // int j[]=new int[task];
	    
	           String a=br.readLine();
	           String[] tk=a.split(" ");
	           for(int k=0;k<2;k++)
	           {
	            arr[j][k]=Integer.parseInt(tk[k]);
	            
	         }
	         
	         
	       if(j==0)
	       {
	          large=arr[j][1];
	           c[j]=1;
	       }
	    
	    else
	    {
	       
	       if(arr[j][0]<arr[j-1][1])
	       {
	           c[j]=0;
	           if(flag==0)
	           {flag=1;}
	           else
	           {
	               if(arr[j][0]<arr[j-2][1])
	               {System.out.print("IMPOSSIBLE");
	                im=1;
	               break;
	               }
	               else
	               
	               {c[j]=0;}
	           }
	       }
	  
	 else if(arr[j][0]>=arr[j-1][1])
      	 {
      	     c[j]=1;
      	     flag=0;
      	 }
	 
	    }
	  
	           
	          
	           
	           
	       }
	       
	  
	   if(im==0) {int e=0;
	   for(int d=0;d<task;d++)
	           
	           {
	           
	      // System.out.print("task"+task);
	      
	                char ae[]={'C','J'};
	                if(c[d]==1)
	                {
	                      System.out.print(ae[e]);
	                }
	                else
	                {if(e==1)
	               { System.out.print(ae[0]);e=0;
	                
	                }else
	                 {    System.out.print(ae[1]);
	                e=1;
	                     
	                 }
	                    
	                }
	           }}
	
	
	   System.out.println();
	   }
	   
	}
    
}