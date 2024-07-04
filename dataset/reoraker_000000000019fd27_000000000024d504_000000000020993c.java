import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner in =new Scanner(System.in);
        int t=in.nextInt();
        int test=1;
        while(t>0)
        {
            t--;
            System.out.print("Case #"+test+": ");
            test++;
            int n=in.nextInt();
            int[][] mat=new int[n][n];
            int trace=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    mat[i][j]=in.nextInt();
                    if(i==j)
                        trace+=mat[i][j];
                }
            }
            int r=0;
            for(int i=0;i<n;i++)
            {
                HashSet<Integer> set=new HashSet<>();
                for(int j=0;j<n;j++)
                {
                    if(set.contains(mat[i][j]))
                    {
                        r++;
                        break;
                    }
                    set.add(mat[i][j]);
                }
            }
            int c=0;
            for(int i=0;i<n;i++)
            {
                HashSet<Integer> set=new HashSet<>();
                for(int j=0;j<n;j++)
                {
                    if(set.contains(mat[j][i]))
                    {
                        c++;
                        break;
                    }
                    set.add(mat[j][i]);
                }
            }
            System.out.println(trace+" "+r+" "+c);

        }
    }

}
