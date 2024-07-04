import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Vestigium
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i)
        {
            int n = in.nextInt();
            int[][] square = new int[n][];
            for (int row = 0; row < n; row++)
            {
                int[] mij = Arrays.stream(in.nextLine().trim()
                        .split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                square[row] = mij;
            }
            int[] solution = solve(square);
            System.out.println(String.format("Case #%s: %d %d %d", i, solution[0], solution[1], solution[2]));
        }
    }

    public static int[] solve(int[][] square)
    {
        //Case #x: k r c
        // k is the trace of the matrix,
        // r is the number of rows of the matrix that contain repeated elements,
        // and c is the number of columns of the matrix that contain repeated elements
        boolean[] memo = new boolean[square.length + 1];
        int rowsWithReps = computeRows(square, memo);
        int colsWithReps = computeCols(square, memo);
        int trace = computeTrace(square);
        return new int[]{trace, rowsWithReps, colsWithReps};
    }

    private static int computeTrace(int[][] square)
    {
        int result = 0;
        for (int i = 0; i < square.length; i++)
            result += square[i][i];

        return result;
    }

    private static int computeCols(int[][] square, boolean[] memo)
    {
        int result = 0;
        for (int i = 0; i < square.length; i++)
        {
            Arrays.fill(memo, false);
            for (int j = 0; j < square.length; j++)
            {
                if (memo[square[j][i]])
                {
                    result++;
                    break;
                }

                memo[square[j][i]] = true;
            }
        }
        return result;
    }

    private static int computeRows(int[][] square, boolean[] memo)
    {
        int result = 0;
        for (int[] ints : square)
        {
            Arrays.fill(memo, false);
            for (int v : ints)
            {
                if (memo[v])
                {
                    result++;
                    break;
                }
                memo[v] = true;
            }
        }

        return result;
    }

}
