import java.util.Scanner;
class Solution
{
    static int sqr[][] = new int[60][60];
    static int n = 0, k = 0, t = 0;
    static boolean row_safe[][] = new boolean[60][60];
    static boolean col_safe[][] = new boolean[60][60];
    static boolean solved = false;
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 0; i < t; ++i)
        {
            n = input.nextInt();
            k = input.nextInt();
            solver(1,1,0);
            if (!solved)
            {
                System.out.println("Case #"+(t)+": IMPOSSIBLE");
            }
            solved = false;
        }
        return;
    }
    public static void solver (int row, int col, int m)
    {
        if (row == n && col == n + 1 && m == k && !solved)
        {
            solved = true;
            System.out.println("Case #"+(t+1)+": POSSIBLE");
            for (int i = 1; i <= n ; ++i)
            {
                for (int j = 1; j <= n ; ++j)
                {
                    System.out.print(sqr[i][j]+" ");
                }
                System.out.println();
            }
            return;
        }
        else if (row > n)
        {
            return;
        }
        else if (col > n)
        {
            solver (row + 1, 1, m);
        }
        for (int i = 1; i <= n && !solved; ++i)
        {
            if (!row_safe[row][i] && !col_safe[col][i])
            {
                row_safe[row][i] = col_safe[col][i] = true;
                if (row == col)
                {
                    m = m + i;
                }
                sqr[row][col] = i;
                solver(row, col + 1, m);
                row_safe[row][i] = col_safe[col][i] = false;
                if (row == col)
                {
                    m = m - i;
                }
                sqr[row][col] = 0;
            }
        }
    }
}