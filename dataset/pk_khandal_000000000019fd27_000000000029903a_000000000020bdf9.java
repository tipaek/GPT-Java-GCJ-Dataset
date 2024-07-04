import java.util.*;

class Solution
{
	public static void main(String args[])
	{
	    Scanner sin=new Scanner(System.in);
	    int t=sin.nextInt();
	    int cnt=1;
	    while(t-->0)
	    {
	        int n = sin.nextInt();
	        int s[] = new int[n];
	        int e[] = new int[n];
	        int c1[] = new int[n];
	        int endc1[] = new int[n];
	        
	        for(int i=0;i<n;i++)
	        {
	        	s[i] = sin.nextInt();
	        	c1[i] = s[i];
	        	e[i] = sin.nextInt();
	        	endc1[i] = e[i];
	        }
	          
	        int temp = 0;  
	         	for(int i=0; i < n; i++){  
	         		for(int j=1; j < (n-i); j++){  
	         			if(s[j-1] > s[j]){   
	         				temp =s[j-1];  
	                        s[j-1] =s[j];  
	                        s[j] = temp;  
	                        temp = e[j-1];
	                        e[j-1] = e[j];
	                        e[j] = temp;
	                    }  
	                }  
	         	}  
			// Ha Ha now sorted
	      
	       int j = 0;
	       int c = 0;
	       String ans = "";
	       boolean not = false;
	       int i;
	       for( i=0;i<n;i++)
	       {
	    	   if(j<=s[i])
	    	   {
	    		   ans += "J";
	    		   j=e[i];
	    	   }
	    	   else if(c<=s[i])
	    	   {
	    		   ans += "C";
	    		   c=e[i];
	    	   }
	    	   else
	    	   {
	    		   ans = "IMPOSSIBLE";
	    		   not = true;
	    		   break;
	    	   }
	       }
	       
	       
	       if(not)
	    	   System.out.println("Case #"+cnt+": "+ans);
	       else
	       {
	    	   System.out.print("Case #"+cnt+": ");
	    	    for(int k=0;k<n;k++) 
	    	    {
	    	    	int ele = c1[k];
	    	    	int eleend = endc1[k];
	    	    	for(int m=0;m<n;m++) 
	    	    	{
	    	    		if(ele==s[m]&&eleend==e[m]) 
	    	    		{
	    	    			s[m] = -1;
	    	    			e[m] = -1;
	    	    			System.out.print(ans.charAt(m)); 
	    	    			break; 
	    	    		}
	    	    	}
	    	    }
				 
	    	   System.out.println();
	       }
	       cnt++;
	         	
	        
	    }
	}
}