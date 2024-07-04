import java.util.*;

public class Solution 
{
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {        
        int T = in.nextInt();
        
        for (int testCase = 1; testCase <= T; testCase++)
        {
            solveCase(testCase);
        }
    }

    public static void solveCase(int testCase)
    {        
        int x = in.nextInt();
        int y = in.nextInt();

        String M = in.next();
        int minAvailable = M.length();

        String out = "";

        int mhtDistance[] = new int[minAvailable + 1];

        mhtDistance[0] = Math.abs(x) + Math.abs(y);

        for (int i = 1; i <= minAvailable; i++)
        {
            char direction = M.charAt(i - 1);

            switch (direction)
            {
                case 'N': y++;  break;
                case 'S': y--;  break;
                case 'E': x++;  break;
                case 'W': x--;  break;
            }

            mhtDistance[i] = Math.abs(x) + Math.abs(y);
        }

        out = "IMPOSSIBLE";

        for (int i = 0; i < mhtDistance.length; i++)
        {
            if (mhtDistance[i] <= i) 
            {
                out = i + "";
                break;
            }
        }
        //print output
        printCase(testCase, out);
    }

    public static void printCase(int testCase, String out)
    {
        System.out.print("Case #" + testCase + ": ");
        System.out.print(out);
        System.out.println();
    }
}