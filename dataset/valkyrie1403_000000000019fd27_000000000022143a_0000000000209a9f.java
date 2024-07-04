import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();

        for (int i = 0; i < t; i++)
        {
            String s = in.nextLine();
            String s1 = balance(s);

            System.out.println("Case #" + (i+1) + ": " + s1);
        }
    }

    private static String balance(String s)
    {
        StringBuilder sb = new StringBuilder();
        int length = s.length();

        int prev = 0;
        for (int i = 0; i < length; i++)
        {
            int curr = s.charAt(i) - '0';
            if (curr > prev)
            {
                while (prev < curr)
                {
                    sb.append('(');
                    prev++;
                }
            }
            else if (curr < prev)
            {
                while (prev > curr)
                {
                    sb.append(')');
                    prev--;
                }
            }

            sb.append(curr);
        }

        while (prev > 0)
        {
            sb.append(')');
            prev--;
        }
        return sb.toString();
    }
}
