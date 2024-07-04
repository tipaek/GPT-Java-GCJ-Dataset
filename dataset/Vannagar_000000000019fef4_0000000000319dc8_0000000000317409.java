import java.util.*;

import javax.management.QueryEval;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        for(int xo=1;xo<=test;xo++)
        {
            int x=sc.nextInt();int y=sc.nextInt(); String m=sc.nextLine().substring(1);int q=m.length();int steps=0;
            while(steps<=q)
            {
                if(Math.abs(x)+Math.abs(y)<=steps)
                {break;}
                else if(steps<=q-1)
                {
                    String h=m.substring(0,1);
                    m=m.substring(1);
                    if(h.equals("N"))
                    {y++;}
                    if(h.equals("S"))
                    {y--;}
                    if(h.equals("E"))
                    {x++;}
                    if(h.equals("W"))
                    {x--;}
                }
                steps++;
            }
            if(steps>q)
            {System.out.println("Case #"+xo+": IMPOSSIBLE");}
            else
            {System.out.println("Case #"+xo+": "+steps);}
        }
        sc.close();
    }
}
