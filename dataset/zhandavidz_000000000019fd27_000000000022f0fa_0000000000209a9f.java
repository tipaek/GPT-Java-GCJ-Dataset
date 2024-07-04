
import java.util.*;
import java.io.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = Integer.parseInt(in.nextLine());
        for (int test = 1; test <= testCount; test++)
        {
            System.out.print("Case #" + test + ": ");
            
            String input = in.nextLine();
            
            int firstVal = Integer.parseInt(input.substring(0,1));
            for (int j = 0; j < firstVal; j++)
                System.out.print("(");
            System.out.print(firstVal);
            for (int i = 1; i < input.length(); i++)
            {
                int prev = Integer.parseInt(input.substring(i-1, i));
                int current = Integer.parseInt(input.substring(i,i+1));
                int diff = current - prev;
                if (diff < 0)
                {
                    diff = -diff;
                    for (int j = 0; j < diff; j++)
                        System.out.print(")");
                }
                else
                    for (int j = 0; j < diff; j++)
                        System.out.print("(");
                System.out.print(current);
            }
            int lastVal = Integer.parseInt(input.substring(input.length()-1,input.length()));
            for (int j = 0; j < lastVal; j++)
                System.out.print(")");
            
            System.out.println();
        }
        
        in.close();
    }
}