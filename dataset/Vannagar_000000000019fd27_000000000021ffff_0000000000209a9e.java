import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner(System.in);
        Writer writer = new PrintWriter(System.out);
        int t=sc.nextInt();int b=sc.nextInt();
        for(int y=1;y<=t;y++)
        {
            writer.flush();
            int[]r=new int[b];int checks=0;
            int match=-1;int dif=-1;
            for(int x=0;x<=b/2;x++)
            {
                if(checks%10==0)
                {
                    if(dif>-1)
                    {
                        System.out.println(dif+1);
                        if(r[dif]!=sc.nextInt())
                        {r=swap(r);}
                    }
                    if(match>-1)
                    {
                        System.out.println(match+1);
                        if(r[match]!=sc.nextInt())
                        {r=inv(r);}
                    }
                    if(dif>-1&&match>-1)
                    x--;checks+=2;continue;
                }
                System.out.println(x+1);writer.flush();
                int q=sc.nextInt();
                r[x]=q;
                System.out.println(b-x);writer.flush();
                int two=sc.nextInt();
                r[b-x-1]=t;
                if(q==two){match=x;}
                else{dif=x;}
                checks++;
            }
            System.out.print("Case #"+y+": ");
            for(int x:r)
            {System.out.print(x);}
        }
    }
    public static int[] inv(int[]r)
    {
        for(int x=0;x<r.length;x++)
        {
            r[x]=1-r[x];
        }
        return r;
    }
    public static int[] swap(int[]r)
    {
        for(int x=0;x<r.length/2;x++)
        {
            int g=r[x];
            r[x]=r[r.length-x-1];
            r[r.length-x-1]=g;
        }
        return r;
    }
}