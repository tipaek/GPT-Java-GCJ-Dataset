

import java.io.*;
import java.util.*;

/**
 *
 * @author User
 */
public class Solution
{

    public static String solve(Scanner in)
    {
        String answer = "";
        int N = in.nextInt();
        String arr[] = new String[N];
        for (int rep = 0; rep < N; rep++)
        {
            arr[rep] = in.next();
        }
        String prefix = "";
        String sufix = "";
        for (int i = 0; i < N; i++)
        {
            String p = arr[i];
            for (int j = 0; j < p.length(); j++)
            {
                char c = p.charAt(j);
                if (c == '*')
                {
                    break;
                }
                if (prefix.length() > j && prefix.length() != 0)
                {
                    if (prefix.charAt(j) != c)
                    {
                        return "*";
                    }
                }
                else
                {
                    if (prefix.length() > p.length())
                    {
                        System.out.println("secret " + c);
                    }
                    else
                    {
                        prefix += prefix;
                    }
                }
            }
            for (int j = 0; j < p.length(); j++)
            {
                char c = p.charAt(p.length() - 1 - j);
                if (c == '*')
                {
                    break;
                }
                if (sufix.length() > j && sufix.length() != 0)
                {
                    if (sufix.charAt(sufix.length() - 1 - j) != c)
                    {
                        return "*";
                    }
                }
                else
                {
                    if (sufix.length() > p.length())
                    {
                        System.out.println("");
                    }
                    else
                    {
                        sufix = c + sufix;
                    }
                }
            }
        }
        answer = prefix + sufix;
        //stop writing from here
        return answer;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int rep = 0; rep < T; rep++)
        {
            String answer = solve(in);
            System.out.println("Case #" + (rep + 1) + ": " + answer);

        }
    }
}
