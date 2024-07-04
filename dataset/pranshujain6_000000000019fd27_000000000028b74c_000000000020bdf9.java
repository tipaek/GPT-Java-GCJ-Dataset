import java.util.*;

class Solution
{
	public static void main(String args[])
	{
	    Scanner s=new Scanner(System.in);
	    int test=s.nextInt();
	    int count=1;
	    while(test-->0)
	    {
	        int n = s.nextInt();
	        int start[] = new int[n];
	        int end[] = new int[n];
	        
	        for(int i=0;i<n;i++)
	        {
	        	start[i] = s.nextInt();
	        	end[i] = s.nextInt();
	        }
	        
	        //sort both array  
	        int temp = 0;  
	         	for(int i=0; i < n; i++){  
	         		for(int j=1; j < (n-i); j++){  
	         			if(start[j-1] > start[j]){   
	         				temp =start[j-1];  
	                        start[j-1] =start[j];  
	                        start[j] = temp;  
	                        temp = end[j-1];
	                        end[j-1] = end[j];
	                        end[j] = temp;
	                    }  
	                }  
	         	}  
			// both are sorted now
	      
	       int j = 0;
	       int c = 0;
	       String ans = "";
	       for(int i=0;i<n;i++)
	       {
	    	   if(j<=start[i])
	    	   {
	    		   ans += "J";
	    		   j=end[i];
	    	   }
	    	   else if(c<=start[i])
	    	   {
	    		   ans += "C";
	    		   c=end[i];
	    	   }
	    	   else
	    	   {
	    		   ans = "IMPOSSIBLE";
	    		   break;
	    	   }
	       }
	       System.out.println("Case #"+count+": "+ans);
	       count++;
	         	
	        
	    }
	}
}