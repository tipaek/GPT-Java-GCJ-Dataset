import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Solution
{ 
    public static void main(String args[])
    {
      Scanner in =new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int t=in.nextInt();
      for (int case_num = 1; case_num <= t; case_num ++){
          int n=in.nextInt();
          int k=in.nextInt();
          int arr[][]=new int[n][n];
          if(k%n==0)
          {System.out.println("Case #"+case_num+": POSSIBLE");
            int d=k/n,o=d;
            for(int i=0;i<n;i++)
        {for(int j=0;j<n;j++)
            {
                if(j!=0&&j!=n)
                System.out.print(" ");
                if(n>=d)
                {System.out.print(d);d++;}
                else{d=1;System.out.print(d);d++;}
            }d--;System.out.println();
        }
            }
          else System.out.println("Case #"+case_num+": IMPOSSIBLE");
        }}}