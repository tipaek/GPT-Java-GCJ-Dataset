import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int y=1;y<=t;y++)
        {
            int n=sc.nextInt();int k=sc.nextInt();
            System.out.print("Case #"+y+": ");
            if(k%n==0)
            {System.out.print("POSSIBLE");}
            else {System.out.println("IMPOSSIBLE");continue;}
            int[][]r=new int[n][n];
            int q=k/n;
            for(int x=0;x<n*n;x++)
            {
                if(x%3==0){System.out.println();q--;}
                System.out.print(q+" ");q++;
            }
        }
    }
}