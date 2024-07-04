import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();

        for (int i = 1; i <= t; ++i)
        {
            String result = solve(in.nextLine().toCharArray());
            System.out.println(String.format("Case #%s: %s", i, result));
        }
    }

    public static String solve(char[] digits)
    {
        StringBuilder r = new StringBuilder();

        int prevDigit = 0;
        int numberOfPar;
        int currentDigit;
        for (char c : digits)
        {
            currentDigit = (c - '0');
            numberOfPar = prevDigit - currentDigit;
            if (numberOfPar > 0)
                while (numberOfPar-- > 0) r.append(')');

            else if (numberOfPar < 0)
                while (numberOfPar++ < 0) r.append('(');

            r.append(c);
            prevDigit = currentDigit;
        }
        while (prevDigit-- > 0) r.append(')');

        return r.toString();
    }
}
