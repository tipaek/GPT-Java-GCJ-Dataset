import java.io.*;
import java.util.*;
/**
 *
 * @author Rasha267
 */
public class Solution {

    public static int count = 0;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int cases = 0; cases < T; cases++)
        {
            count++;
            String s = br.readLine();
            int n = s.length();
            int parentheses = 0;
            StringBuilder sb = new StringBuilder();
            for (int i=0; i < n; i++)
            {
                int num = s.charAt(i)-48;
                if (num == parentheses)
                {
                    sb.append(s.charAt(i));
                }
                else if(num > parentheses)
                {
                    int difference = num - parentheses;
                    sb.append(leftParentheses(difference)).append(s.charAt(i));
                    parentheses = parentheses + difference;
                }
                else
                {
                    int diff = parentheses - num;
                    sb.append(rightParentheses(diff)).append(s.charAt(i));
                    parentheses = parentheses - diff;
                }
            }
            if (parentheses > 0)
            {
                sb.append(rightParentheses(parentheses));
            }
            System.out.println("Case #" + count + ": " + sb.toString());

        }
        System.exit(0);
    }

    public static String leftParentheses(int n)
    {
         return String.join("", Collections.nCopies(n, "("));
    }
    public static String rightParentheses(int n)
    {
         return String.join("", Collections.nCopies(n, ")"));
    }
}