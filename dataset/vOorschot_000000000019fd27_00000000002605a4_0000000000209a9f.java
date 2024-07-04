import java.util.Scanner;

/**
 *
 * @author user
 */
public class Solution
{

    public static void main(String[] args)
    {
        new Solution().run();
    }

    private void run()
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int t = 1; t <= T; t++)
        {
            int curDepth = 0;
            char[] input = sc.nextLine().toCharArray();
            for (char c : input)
            {
                while (c - '0' > curDepth)
                {
                    curDepth++;
                    System.out.print("(");
                }
                while (c - '0' < curDepth)
                {
                    curDepth--;
                    System.out.print(")");
                }
                System.out.print(c);
            }
            while (0 < curDepth)
            {
                curDepth--;
                System.out.print(")");
            }
            System.out.println("");
        }
    }
}
