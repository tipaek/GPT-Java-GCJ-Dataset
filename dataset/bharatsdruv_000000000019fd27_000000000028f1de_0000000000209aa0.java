import java.util.*;
class Solution
{
       

	public static void main(String[] args) 
	{
	    Scanner in=new Scanner(System.in);
	    int testcases=in.nextInt();
	    
	    for(int tc=1;tc<=testcases;tc++)
	    {
	        int N=in.nextInt();
	        int T=in.nextInt();
	        String result="";
	        int f=0;
	        if(N==2)
	        {
	            if(T==2)
	            {   f=1;
	                result="1 2\n2 1";
	            }
	            else if(T==4)
	            {
	                f=1;
	                result="2 1\n1 2";
	            }
	            else 
	            f=0;
	        }
	        else if(N==3)
	        {
	            if(T==3)
	            {
	                f=1;
	                result="1 2 3\n3 1 2\n2 1 3";
	            }
	            else if(T==6)
	            {
	                f=1;
	                result="2 1 3\n3 2 1\n1 3 2";
	            }
	            else if(T==9)
	            {
	                f=1;
	                result="3 1 2\n2 3 1\n1 2 3";
	            }
	            else 
	            f=0;
	        }
	        else if(N==4)
	        {
	            
	            if(T==4)
	            {
	                f=1;
	                result="1 2 3 4\n2 1 4 3\n4 3 1 2\n3 4 2 1";
	            }
	            else if(T==8)
	            {
	                f=1;
	                result="2 3 4 1\n1 2 3 4\n4 1 2 3\n3 4 1 2";
	            }
	            else if(T==12)
	            {
	                f=1;
	                result="3 4 1 2\n2 3 4 1\n1 2 3 4\n4 1 2 3";
	            }
	            else if(T==16)
	            {
	                f=1;
	                result="4 1 2 3\n3 4 1 2\n2 3 4 1\n1 2 3 4";
	            }
	            else 
	            f=0;
	        }
            else if(N==5)
            {
                
	            if(T==5)
	            {
	                f=1;
	                result="1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1";
	            }
	            else if(T==10)
	            {
	                f=1;
	                result="2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2";
	            }
	            else if(T==15)
	            {
	                f=1;
	                result="3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3";
	            }
	            else if(T==20)
	            {
	                f=1;
	                result="4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4";
	            }
	            else if(T==25)
	            {
	                f=1;
	                result="5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5";
	            }
	            else 
	            f=0;
            }
            System.out.print("Case #"+tc+": ");
            if(f==1)
            {
                System.out.println("POSSIBLE");
                System.out.println(result);
            }
            else System.out.println("IMPOSSIBLE");
	    }
	    
	}
}
