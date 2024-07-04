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
            
            ArrayList<int[]> c = new ArrayList<int[]>();
            ArrayList<int[]> j = new ArrayList<int[]>();
            for (int i = 0; i < n; i++)
            {
                int[] current = {in.nextInt(), in.nextInt()};
                
                if (isAvailable(c, current))
                {
                    c.add(current);
                    result += "C";
                }
                else if (isAvailable(j, current))
                {
                    j.add(current);
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
        
        // in.close();
        
    }
    
    
    public static boolean isAvailable(ArrayList<int[]> person, int[] activity)
    {
        for (int i = 0; i < person.size(); i++)
        {
            if (!(activity[1] <= person.get(i)[0] || person.get(i)[1] <= activity[0]))
                return false;
        }
        return true;
    }
}