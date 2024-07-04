import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        for(int i=1;i<=t;i++)
        {
            int x=scan.nextInt();
            int y=scan.nextInt();
            String s=scan.next();
            int a=minSteps(x,y,s);
            if(a==-1)
            System.out.println("Case #"+i+": "+"IMPOSSIBLE");
            else
            System.out.println("Case #"+i+": "+a);
            
        }
    }
    static int minSteps(int x,int y,String s)
    {
        int a=0,b=0,m=0;
        for(int i=0;i<s.length();i++)
        {
            m++;
            if(s.charAt(i)=='N')
            {
                y++;
            }
            else if(s.charAt(i)=='S')
            {
                y--;
            }
            else if(s.charAt(i)=='E')
            {
                x++;
            }
            else if(s.charAt(i)=='W')
            {
                x--;
            }
            if(Math.abs(x)+Math.abs(y)-m<=0)
            {
                return m;
            }
        }
        return -1;
    }
}