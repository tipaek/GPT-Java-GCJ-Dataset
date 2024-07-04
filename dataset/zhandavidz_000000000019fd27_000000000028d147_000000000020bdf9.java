import java.util.*;
import java.io.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = in.nextInt();
        for (int test = 1; test <= testCount; test++)
        {
            System.out.print("Case #" + test + ": ");
            
            String result = "";
            int n = in.nextInt();
            
            int[][] c = new int[n][2];
            int[][] j = new int[n][2];
            for (int i = 0; i < n; i++)
            {
                int[] current = {in.nextInt(), in.nextInt()};
                
                if (isAvailable(c, current))
                {
                    c[i] = current;
                    result += "C";
                }
                else if (isAvailable(j, current))
                {
                    j[i] = current;
                    result += "J";
                }
                else
                {
                    result = "IMPOSSIBLE";
                    break;
                }
                
            }
            
            System.out.println(result);
        }
        
        in.close();
        
    }
    
    
    public static boolean isAvailable(int[][] person, int[] activity)
    {
        for (int i = 0; i < person.length; i++)
        {
            if (!(activity[1] <= person[i][0] || person[i][1] <= activity[0]))
                return false;
        }
        return true;
    }
}