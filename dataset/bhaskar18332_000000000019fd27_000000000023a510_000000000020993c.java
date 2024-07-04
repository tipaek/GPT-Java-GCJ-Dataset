import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int a = 0;
        while(a<t)
        {
            int n = scan.nextInt();
            int[][] nums = new int[n][n];
            int trace = 0;
            int r=0;
            int c=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    nums[i][j]=scan.nextInt();
                    if(i==j)
                    {
                        trace+=nums[i][j];
                    }
                }
            }
            for(int i=0;i<n;i++)
            {
                HashSet<Integer> s = new HashSet<>();
                for(int j=0;j<n;j++)
                {
                    if(s.contains(nums[i][j]))
                    {
                        r++;
                        break;
                    }
                    s.add(nums[i][j]);
                }
            }
            for(int i=0;i<n;i++)
            {
                HashSet<Integer> s = new HashSet<>();
                for(int j=0;j<n;j++)
                {
                    if(s.contains(nums[j][i]))
                    {
                        c++;
                        break;
                    }
                    s.add(nums[j][i]);
                }
            }
            System.out.println("Case #"+(a+1)+" "+trace+" "+r+" "+c);
            a++;
        }
    }
}