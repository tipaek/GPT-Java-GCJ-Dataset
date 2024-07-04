import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 1; i <= cases; i++)
        {
            String s = in.next();
            // Input contains no parenthesis, so this is simple for basic case
            String s2 = "";
            // Algorithm is this: Open x number of brackets in the first element, and keep track of open brackets.
            // Look at the diff between next element and prev element, let's call it diff. If diff < 0, close abs(diff)
            // brackets. If diff > 0, open abs(diff) brackets. if diff == 0, just add the number itself
            // If last element is seen, also close all the brackets ( number of open brackets should be == last element)
            int prev_value = 0;
            int open_brackets = 0;
            for (int j = 0; j < s.length(); j++)
            {
                int value = Integer.valueOf(String.valueOf(s.charAt(j)));
                int diff = value - prev_value;
                if (diff > 0)
                {
                    open_brackets += diff;
                    for (int k = 0; k < diff; k++)
                        s2 += '(';
                    s2 += String.valueOf(s.charAt(j));
                }
                else if (diff < 0)
                {
                    open_brackets -= Math.abs(diff);
                    for (int k = 0; k < Math.abs(diff); k++)
                        s2 += ')';
                    s2 += String.valueOf(s.charAt(j));
                }
                else
                {
                    s2 += String.valueOf(s.charAt(j));
                }
                if (j == s.length() - 1)
                {
                    // close all open brackets left over
                    for (int k = 0; k < open_brackets; k++)
                        s2 += ')';
                }
                prev_value = value;
            }
            System.out.println("Case #" + i + ": " + s2);
        }
    }
}
