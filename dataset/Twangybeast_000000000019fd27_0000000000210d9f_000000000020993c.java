import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int t = 0; t < T; t++)
        {
            int N = in.nextInt();
            int[][] matrix = new int[N][N];

            boolean[] arr = new boolean[N];
            for (int r = 0; r < N; r++)
            {
                for (int c = 0; c < N; c++)
                {
                    matrix[r][c] = in.nextInt();
                }
            }

            int trace = 0;
            for (int i = 0; i < N; i++)
            {
                trace += matrix[i][i];
            }

            int badR = 0;
            for (int r = 0; r < N; r++)
            {
                Arrays.fill(arr, false);
                for (int c = 0; c < N; c++)
                {
                    int val = matrix[r][c] - 1;
                    if (arr[val]) {
                        badR++;
                        break;
                    }
                    arr[val] = true;
                }
            }

            int badC = 0;
            for (int c = 0; c < N; c++)
            {
                Arrays.fill(arr, false);
                for (int r = 0; r < N; r++)
                {
                    int val = matrix[r][c] - 1;
                    if (arr[val]) {
                        badC++;
                        break;
                    }
                    arr[val] = true;
                }
            }

            System.out.print(String.format("Case #%d: %d %d %d\n", t + 1, trace, badR, badC));
        }


//        bw.flush();
//        bw.close();
        in.close();
    }
}
