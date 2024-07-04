import java.util.*;
class Solution
{
       

	public static void main(String[] args) 
	{
	    Scanner in=new Scanner(System.in);
	    int testcases=in.nextInt();
	    int B=in.nextInt();
	    
	    for(int tc=1;tc<=testcases;tc++)
	    {
	        String ans="";
	       
	           for(int i=0;i<10;i++)
	           {
	               System.out.println(i+1);
	               ans+=in.nextInt()+""; 
	           }
	            System.out.println(ans);
	            char c=in.next().charAt(0);
	            if(c=='N')break;
            
            
	    }
	    
	}
}
