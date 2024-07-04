import java.util.*;
public class Solution
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
            int g=x;
            x=0;
            if(g<=l)
            for(int i=0;i<g;i++)
            {
                if(s.charAt(i)=='N')
                y++;
                else if(s.charAt(i)=='S')
                y--;
            }
            if(g>l)
            System.out.print("IMPOSSIBLE");
            else if(g==l && y!=0)
            System.out.print("IMPOSSIBLE");
            else
            {
                if(g==l && y==0)
                System.out.print(g);
                else
                {
                    int p=g;int c=0;
                    for(int i=p;i<l;i++)
                    {
                        if(s.charAt(i)=='N')
                        y++;
                        else
                        y--;
                        g++;
                        if(y==0)
                        {
                            c=1;
                            break;
                        }
                        if(y<0)
                        y++;
                        if(y>0)
                        y--;
                        if(y==0)
                        {
                            c=1;
                            break;
                        }
                    }
                    if(y==0 || c==1)
                    System.out.print(g);
                    else
                    System.out.print("IMPOSSIBLE");
                }
            }
            System.out.println();
        }
    }
}