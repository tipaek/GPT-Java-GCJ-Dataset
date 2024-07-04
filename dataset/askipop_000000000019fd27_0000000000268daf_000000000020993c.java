import java.util.HashSet;
import java.util.Scanner;

public class Solution {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();


        for (int i = 0; i < testcases; i++)
        {
            int N = sc.nextInt();

            int[][] arr = new int[N][N];

            // Take the inputs
            for (int x = 0; x < N ; x++)
            {
                for (int y = 0; y < N; y++)
                {
                    arr[x][y] = sc.nextInt();
                }
            }

            int rowRepeats = 0, colRepeats = 0;

            int trace = 0;

            // calculate
            for (int x = 0; x < N ; x++)
            {
                HashSet<Integer> rowSet = new HashSet<Integer>();
                HashSet<Integer> colSet = new HashSet<Integer>();
                boolean rowRepeated = false;
                boolean colRepeated = false;


                trace += arr[x][x];

                for (int y = 0; y < N; y++)
                {
                    // I + J
                    int n1 = arr[x][y];

                    if (rowSet.contains(n1))
                    {
                        rowRepeated = true;
                    } else {
                        rowSet.add(n1);
                    }

                    // J + I
                    int n2 = arr[y][x];

                    if (colSet.contains(n2))
                    {
                        colRepeated = true;
                    } else {
                        colSet.add(n2);
                    }
                }

                if (rowRepeated)
                {
                    rowRepeats++;
                }

                if (colRepeated)
                {
                    colRepeats++;
                }
            }


            System.out.println("Case #" + i + ": " + trace + " " +  rowRepeats + " " + colRepeats);
        }
    }
}
