import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        int k=1;
        while(t-->0)
        {
            int a= in.nextInt();
            int b= in.nextInt();
            int c=0;
            int r[]=new int[100];
            int s[]=new int[100];
            int r1[]=new int[100];
            int s1[]=new int[100];
            int r2[]=new int[100];
            int s2[]=new int[100];
            for(int i=1;i<=b;i++)
            {
                for(int j=1;j<=a;j++)
                {
                    r[c]=j;
                    s[c]=i;
                    c++;
                }
            }
            int c1=0;
            for(int i=1;i<=b;i++)
            {
                for(int j=1;j<=a;j++)
                {
                    r1[c1]=i;
                    s1[c1]=j;
                    c1++;
                }
            }
            c1=0;
            for(int i=0;i<(c/2);i++)
            {
                if(r[i]!=r1[i])
                {
                    r2[c1]=r[i];
                    s2[c1]=s[i];
                    c1++;
                }
            }
            System.out.println("Case #"+k+": "+c1);
            for(int i=0;i<c1;i++)
            System.out.println(r2[i]+"  "+s2[i]);
            
        }

    }
}
