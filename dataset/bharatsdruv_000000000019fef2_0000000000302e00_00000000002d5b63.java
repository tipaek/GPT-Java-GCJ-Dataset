import java.util.*;
 class Solution
{
	public static void main(String[] args) 
	{ 
	    Scanner in=new Scanner(System.in);
	    int testcases=in.nextInt();
	    long A=in.nextLong();
        long B=in.nextLong();
	        
	    for(int tc=1;tc<=testcases;tc++)
	    {
	        int f=0;
	        for(int x=-5;x<=5;x++)
	        {
	            for(int y=5;y>=-5;y--)
	            {
	                System.out.println(x+" "+y);
	                String input=in.next();
	                if(input.equals("CENTER")){f=1;break;}
	                
	            }
	            if(f==1)break;
	        }
	        
	    }
	}
}
