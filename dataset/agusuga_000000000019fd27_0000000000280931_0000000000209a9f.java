import java.util.*;    
import java.io.*;
import java.util.ArrayList;

public class Solution 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        in.nextLine();

        for (int i = 0; i < cases; i++)
        {
            String S = in.nextLine();
            int current = 0;
            int next = 0;
            int level = 0;
            
            System.out.print("Case #" + (i + 1) + ": ");
            
            for (int j = 0; j < S.length(); j++)
            {
                current = Character.getNumericValue(S.charAt(j));
                for (int k = 0; k < current - level; k++)
                {
                    System.out.print("(");
                }
                System.out.print(current);
                
                // Peek forward
                if (j < S.length() - 1)
                    next = Character.getNumericValue(S.charAt(j + 1));
                else
                    next = 0;
                    
                while (current == next && j < S.length() - 1)
                {
                    System.out.print(current);
                    j++;
                    if (j < S.length() - 1)
                        next = Character.getNumericValue(S.charAt(j + 1));
                }
                
                // Peek forward
                if (j < S.length() - 1)
                    next = Character.getNumericValue(S.charAt(j + 1));
                else
                    next = 0;
                
                level = current;
                
                for (int k = 0; k < current - next; k++)
                {
                    System.out.print(")");
                    level--;
                }
            }
            
            if (i < cases - 1)
                System.out.println();
        }
    }
}