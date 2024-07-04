import java.util.*;
import java.io.*;
public class Solution {
	

	public static void main(String args[]) throws Exception
	{
		
		Scanner src=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tcases=src.nextInt();
		for(int x=0;x<tcases ;x++)
         {		
		int n =src.nextInt();
		if(n==2)
			System.out.println("Case #"+(x+1)+": CJ");			
		
		else {
		
		int arr[][]=new int[n][3];
		//1 for C  and 2 for J
		for (int i = 0; i < n; i++) 
		      for (int j = 0; j < 2; j++) 
	            arr[i][j]=src.nextInt();
		
		 arr[0][2]=1;
		 int j=1;
	     int i=0;
		  Stack s=new Stack<Integer>();	  
	    
	     boolean flag=false;
	        while (j<n)
	        {
	        	s=new Stack<Integer>();	
	        	
	        	for (int a = 0; a < n; a++)
	        		  if(arr[a][2]==1)
	        			  s.push(i);
	        
			while( !s.empty() && arr[j][2]==0 )
			{
				i= (int)s.pop();
	    	if  ( arr[j][0] >=arr[i][1] ||arr[j][1] <=arr[i][0])  
				flag=true;
			
	    	else 
	    		{flag=false;
	    		break;
	    		
	    		}
	    	
			}
	        if(flag && arr[j][2]==0)
	        	arr[j][2]=1;
	        
	        ++j;
			
         }	
	       
				/*
				 * for (int a = 0; a < n; a++) { for (int b = 0; b < 3; b++)
				 * System.out.print(arr[a][b]+"  "); System.out.println(); }
				 */
	        
	        
	        
		/// for 2nd parent
	        for (int k = 0; k < n; k++) 
	            if(arr[k][2]==0)
	            	{
	            	//System.out.println("k is "+k);
	            	arr[k][2]=2;
	            	break;
	            	}
	       
	        
	        for (int k = 0; k < n; k++) 
	          { if(arr[k][2]==0)
	            	{
	            	 j=k;
	            	 //System.out.println("j is "+j);
	            	 break;
	            	}
	          }
	        
	         flag=false;
	        while (j<n)
	        {
	        	s=new Stack<Integer>();	
	        	for (int a = 0; a < n; a++)
	        	{ if(arr[a][2]==2)
	        	       {
	        			  s.push(a);
	        	       }
	        	}
			while( !s.empty() && arr[j][2]==0)
			{
				i= (int)s.pop();
				//System.out.println(i);
	    	if  ( arr[j][0] >=arr[i][1] ||arr[j][1] <=arr[i][0])  
	    	   { //System.out.println("inisde if");
				flag=true;
	    	   }
	    	else 
	    		{flag=false;
	    		break;
	    		
	    		}
	    	
			}
	        if(flag  &&arr[j][2]==0)
	        	arr[j][2]=2;
	        
	        ++j;
			
         }
		
	            	  
				/*
				 * for (int a = 0; a < n; a++) { for (int b = 0; b < 3; b++)
				 * System.out.print(arr[a][b]+"  "); System.out.println(); }
				 */
	        
	        
		
	        boolean flag2=true;
	            	  
	        for (int a = 0; a < n; a++)         	  
	          {if(arr[a][2]==0)
	             {flag2=false;
	                  System.out.println("Case #"+(x+1)+": IMPOSSIBLE");
	                   break;
	                  }
	          }
	        
	        
	        if(flag2)
	        {  String str="";
	        	for (int a = 0; a < n; a++)         	  
	          {   if(arr[a][2]==1)
	        	   str+="C";
	        	   else
	        		   str+="J";
	          }
	        	
	        	System.out.println("Case #"+(x+1)+": "+str);	
	        }
	        
	        
         
         }
		
         }
		
		
		
	}

}

