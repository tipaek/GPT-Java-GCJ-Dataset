import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();
        int k=1;
        while(t-->0)
        {
            int n=in.nextInt(),s=0;
            System.out.println("Case #"+k+":");
            int i;
            for(i=1;s<n;i++)
            {
                s=s+i;
                if(s<=n)
                System.out.println((i+1)+" 2");
            }
            if(n!=1)
            {s=s-i;
            int l=n-s-1;
            int c=4,d=4;
            for(int j=1;j<=l;j++)
            {
                System.out.println(c+" "+d);
                c++;d++;
            }}
            k++;
        }

    }
}