import java.util.*;
class Solution
{
	public static void main(String[] args) 
	{
	    Scanner in=new Scanner(System.in);
	    int testcases=in.nextInt();
	    for(int tc=1;tc<=testcases;tc++)
	    {
	        int X=in.nextInt();
	        int Y=in.nextInt();
	        String S=in.next();
	        int N=S.length();
	        int Px=0,Py=0;
	        int diff=Math.abs(Px-X)+Math.abs(Py-Y);
	        int steps=0;
	        for(int i=0;i<N;i++)
	        {
                if(diff==0){break;}
                char c=S.charAt(i);
                switch(c)
                {
                    case 'N':Y++;break;
                    case 'S':Y--;break;
                    case 'E':X++;break;
                    case 'W':X--;break;
                }
                if(X>Px)Px++;
                else if(X<Px)Px--;
                else if(Y>Py)Py++;
                else if(Y<Py)Py--;
                diff=(X>Px?X-Px:Px-X) + (Y>Py?Y-Py:Py-Y);
                steps++;
            }
	        if(diff!=0)System.out.println("Case #"+tc+": IMPOSSIBLE");
	        else System.out.println("Case #"+tc+": "+steps);
	    }
	    
	}
}
