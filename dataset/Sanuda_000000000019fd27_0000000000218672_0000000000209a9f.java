

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
        String s = in.next();
        int currentPos = 0;
        for (int j = 0; j < s.length(); j++)
        {
            int num = Integer.parseInt(s.charAt(j) + "");
            if (currentPos < num)
            {
                for (int i = 0; i < num - currentPos; i++)
                {
                    answer += "(";
                }
                currentPos = num;
            }
            else if (currentPos > num)
            {
                for (int i = 0; i < currentPos - num; i++)
                {
                    answer += ")";
                }
                currentPos = num;
            }
            answer += num;

        }
        for (int i = currentPos; i > 0; i--)
        {
            answer += ")";
        }
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
