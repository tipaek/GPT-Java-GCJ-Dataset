import java.util.*;
import java.lang.Math.*;
public class Solution
{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t  = s.nextInt();
		long x,y;
        int temp = t;
		StringBuffer res;
		while(t-->0)
		{
		    x = s.nextLong();
            y = s.nextLong();
            if(((Math.abs(x)-Math.abs(y))%2 == 0) || ((Math.abs(x) + Math.abs(y))%2 == 0))
            {
                  System.out.println("Case #" + (temp-t) + ": IMPOSSIBLE");
                  continue;
            }
            res = new StringBuffer("");
            int a = 1;
            while(a<=(Math.abs(x) +Math.abs(y)))
            {
                a*=2;
            }
            a/=2;
            while((x!=0 || y!=0) )
            {
                if((Math.abs(Math.abs(x) - a) <= Math.abs(Math.abs(y) - a)) && x!=0 )
                {
                    if(x<0)
                    {
                        x+=a;
                        res.append("W");
                    }
                    else{
                        x-=a;
                        res.append("E");
                    }
                }
                else{
                    if(y<0)
                    {
                        y+=a;
                        res.append("S");
                    }
                    else{
                        y-=a;
                        res.append("N");
                    }
                }
                     a/=2;
            }
		    System.out.println("Case #" + (temp-t) + ": " + res.reverse());
		}
	}
}
