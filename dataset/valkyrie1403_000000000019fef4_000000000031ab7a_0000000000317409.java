import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();

        for (int t = 1; t <= tests; t++)
        {
            int x = in.nextInt();
            int y = in.nextInt();
            String path = in.next();

//            System.err.println(x + " " + y + " " + path + " " + path.length());

            System.out.println("Case #" + t + ": " + solve(x, y, path));
        }
    }

    private static String solve(int x, int y, String path)
    {
        int pathLen = path.length();

        for (int i = 1; i <= pathLen; i++)
        {
            char dir = path.charAt(i - 1);
            switch (dir)
            {
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
                case 'W': x--; break;
            }

            int dist = Math.abs(x) + Math.abs(y);

            if (dist <= i)
                return "" + i;
        }

        return "IMPOSSIBLE";
    }

}
