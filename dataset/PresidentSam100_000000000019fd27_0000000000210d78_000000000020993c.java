import java.util.*;
public class Solution
{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++)
        {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0;
            int rowDup = 0;
            int colDup = 0;
            for (int r = 0; r < n; r++)
            {
                ArrayList <Integer> test = new ArrayList <>();
                for (int c = 0; c < n; c++)
                {
                    int a = sc.nextInt();
                    arr[r][c] = a;
                    if (r==c)
                        trace+=a;
                    if (!test.contains(a))
                        test.add(a);
                }
                if (test.size()!=n)
                    rowDup++;
            }
            for (int c = 0; c < n; c++)
            {
                ArrayList <Integer> test = new ArrayList <>();
                for (int r = 0; r < n; r++)
                {
                    if (!test.contains(arr[r][c]))
                        test.add(arr[r][c]);
                    else
                        break;
                }
                if (test.size()!=n)
                    colDup++;
            }
            System.out.println("Case #" + i + ": " + trace + " " + rowDup + " " + colDup);
        }
    }
}