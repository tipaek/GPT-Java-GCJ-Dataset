import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; i++)
        {
            int ranks = in.nextInt();
            int suits = in.nextInt();

            System.out.println("Case #" + i + ": " + ((ranks - 1) * (suits - 1)));

            output(ranks, suits);
        }
    }

    private static void output(int ranks, int suits)
    {
        int bottom = ranks * suits;
        int second = ranks - 1;
        for (int i = 1; i < suits; i++)
            System.out.println((bottom - second - i) + " " + second);

        if (ranks > 2)
            output(ranks - 1, suits);
    }

}
