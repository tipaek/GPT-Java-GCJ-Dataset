import java.util.*;

class Solution
{
	public static void main(String args[])
	{
	    Scanner sc=new Scanner(System.in);
	    int test=sc.nextInt();
	    int count=1;
	    while(test-->0)
	    {
	        int n = sc.nextInt();
	        int startarr[] = new int[n];
	        int end[] = new int[n];
	        int cp[] = new int[n];
	        int endcp[] = new int[n];
	        
	        for(int i=0;i<n;i++)
	        {
	        	startarr[i] = sc.nextInt();
	        	cp[i] = startarr[i];
	        	end[i] = sc.nextInt();
	        	endcp[i] = end[i];
	        }
	        
	        //first we sort both arrays 
	        int temp = 0;  
	         	for(int i=0; i < n; i++){  
	         		for(int j=1; j < (n-i); j++){  
	         			if(startarr[j-1] > startarr[j]){   
	         				temp =startarr[j-1];  
	                        startarr[j-1] =startarr[j];  
	                        startarr[j] = temp;  
	                        temp = end[j-1];
	                        end[j-1] = end[j];
	                        end[j] = temp;
	                    }  
	                }  
	         	}  
			
	      
	       int j = 0;
	       int c = 0;
	       String str = "";
	       boolean not = false;
	       int i;
	       for( i=0;i<n;i++)
	       {
	    	   if(j<=startarr[i])
	    	   {
	    		   str += "J";
	    		   j=end[i];
	    	   }
	    	   else if(c<=startarr[i])
	    	   {
	    		   str += "C";
	    		   c=end[i];
	    	   }
	    	   else
	    	   {
	    		   str = "IMPOSSIBLE";
	    		   not = true;
	    		   break;
	    	   }
	       }
	       
	       
	       if(not)
	    	   System.out.println("Case #"+count+": "+str);
	       else
	       {
	    	   System.out.print("Case #"+count+": ");
	    	    for(int k=0;k<n;k++) 
	    	    {
	    	    	int element = cp[k];
	    	    	int eleend = endcp[k];
	    	    	for(int m=0;m<n;m++) 
	    	    	{
	    	    		if(element==startarr[m]&&eleend==end[m]) 
	    	    		{
	    	    			startarr[m] = -1;
	    	    			end[m] = -1;
	    	    			System.out.print(str.charAt(m)); 
	    	    			break; 
	    	    		}
	    	    	}
	    	    }
				 
	    	   System.out.println();
	       }
	       count++;
	         	
	        
	    }
	}
}