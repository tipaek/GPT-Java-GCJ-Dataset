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
            boolean open = false; // FLag telling us if we have opened a bracket or not
            for (int j = 0; j < s.length(); j++)
            {
                if (s.charAt(j) == '0')
                {
                    if (!open) {
                        // Nothing special here, we have closed all brackets and see a 0, so just add the 0 by itself
                        s2 += String.valueOf(s.charAt(j));
                    }
                    else
                    {
                        // We have an open bracket, and have seen 0 so we should close it, reset it and add the 0
                        s2 += ')' + String.valueOf(s.charAt(j));
                        open = false;
                    }
                }
                if (s.charAt(j) == '1')
                {
                    if (!open) {
                        // After closing all brackets, we see a 1 so we should open the bracket
                        s2 += '(' + String.valueOf(s.charAt(j));
                        open = true;
                    }
                    else
                    {
                        // We see a 1 with open bracket, so we should add the 1 and just move on.
                        s2 += String.valueOf(s.charAt(j));
                    }
                }
                if (j == s.length() - 1 && open)
                {
                    // if last element is 1 we should close the bracket
                    s2 += ')';
                    open = false;
                }
            }
            System.out.println("Case #" + i + ": " + s2);
        }
    }
}
