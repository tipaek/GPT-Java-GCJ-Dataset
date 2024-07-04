import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0)
        {
            int n = scan.nextInt();
            in[][] nums = new int[n][n];
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
                for(int i=0;i<n;i++)
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
            System.out.println("Case #"+t+" "+trace+" "+r+" "+c);
            t--;
        }
    }
}