import java.util.*;
class Solution
{
    public static void main(String ARGS[])
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int z=1;z<=t;z++)
        {
            System.out.print("Case #"+z+": ");
            int x=in.nextInt();
            int y=in.nextInt();
            String s=in.next();
            int l=s.length();
            int x1=0,y1=0;int g=0;int c=0;
            for(int i=0;i<l;i++)
            {
                if(s.charAt(i)=='N')
                y++;
                else if(s.charAt(i)=='S')
                y--;
                else if(s.charAt(i)=='E')
                x++;
                else
                x--;
                g++;
                if(x==x1 && y==y1)
                {
                    c=1;
                    break;
                }
                if(Math.abs(x-x1)<Math.abs(y-y1) && (Math.abs(x-x1)!=1 || Math.abs(y-y1)!=1))
                {
                    if(y<0)
                    y1--;
                    else
                    y1++;
                }
                else if(Math.abs(x-x1)>=Math.abs(y-y1) && (Math.abs(x-x1)!=1 || Math.abs(y-y1)!=1))
                {
                    if(x>0)
                    x1++;
                    else
                    x1--;
                }
                if(x1==x && y==y1)
                {
                    c=1;
                    break;
                }
            }
            if(c==1 || (x==x1 && y==y1))
            System.out.println(g);
            else 
            System.out.println("IMPOSSIBLE");
        }
    }
}