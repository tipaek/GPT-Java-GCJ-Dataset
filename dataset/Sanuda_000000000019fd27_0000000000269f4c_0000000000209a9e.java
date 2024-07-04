import java.io.*;
import java.util.*;

/**
 *
 * @author User
 */
public class Solution
{

    public static void solve(Scanner input, int b)
    {
        String answer = "";
        for (int i = 0; i < b; i++)
        {
            if ((i + 1) % 10 == 1)
            {
            }

            System.out.println(i + 1);
            int k = input.nextInt();
            answer += k;

        }
        System.out.println(answer);
        String s = input.next();
        if (s.equals("Y"))
        {
            return;
        }
        else if (s.equals("N"))
        {
            System.exit(0);
        }
    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();
        for (int ks = 1; ks <= T; ks++)
        {
            solve(input, B);
        }
    }
}
