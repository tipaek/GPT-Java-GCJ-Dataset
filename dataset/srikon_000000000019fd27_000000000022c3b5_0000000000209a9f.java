import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = reader.nextInt();
        for (int testNum = 1; testNum <= testCount; testNum++)
        {
            String digits = reader.next();
            int currentNestingDepth = 0;
            StringBuilder result = new StringBuilder();
            for (int index = 0; index < digits.length(); index++) 
            {
                char digit = digits.charAt(index);
                int nestingDepth = digit - '0';
                int parenthesisCount = nestingDepth - currentNestingDepth;

                // if +ve, append parenthesisCount (
                if (parenthesisCount > 0)
                {
                    result.append(new String(new char[parenthesisCount]).replace("\0", "("));
                }

                // if -ve, append parenthesisCount )
                if (parenthesisCount < 0)
                {
                    result.append(new String(new char[-parenthesisCount]).replace("\0", ")"));
                }
    
                result.append(digit);
                currentNestingDepth = nestingDepth;
            }

            // append currentNestingDepth )
            result.append(new String(new char[currentNestingDepth]).replace("\0", ")"));

            System.out.println(String.format("Case #%d: %s", testNum, result));
        }
        reader.close();
    }
}
