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
	        
	       ArrayList<Integer> jStart = new ArrayList<Integer>();
	       ArrayList<Integer> jEnd = new ArrayList<Integer>();
	       
	       ArrayList<Integer> cStart = new ArrayList<Integer>();
	       ArrayList<Integer> cEnd = new ArrayList<Integer>();
	      
	      
	       String ans = "";
	       
	       for(int i=0;i<n;i++)
	       {
	    	   boolean canDo = true;
	    	   for(int j=0;j<jStart.size();j++)
	    	   {
	    		 if(end[i]<=jStart.get(j)||start[i]>=jEnd.get(j))
	    		 {
	    			
	    		 }
	    		 else
	    		 {
	    			 canDo = false;
	    			 break;
	    		 }
	    	   }
	    	   if(canDo)
	    	   {
	    		   jStart.add(start[i]);
	    			 jEnd.add(end[i]);
	    		   ans += "J";
	    		   continue;
	    	   }
	    	   else
	    	   {
	    		   canDo = true;
	    		   for(int j=0;j<cStart.size();j++)
		    	   {
		    		 if(end[i]<=cStart.get(j)||start[i]>=cEnd.get(j))
		    		 {
		    			 
		    		 }
		    		 else
		    		 {
		    			 canDo = false;
		    			 break;
		    		 }
		    	   }
	    	   }
	    	   if(canDo)
	    	   {
	    		   cStart.add(start[i]);
	    			 cEnd.add(end[i]);
	    		   ans += "C";
	    		   continue;
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