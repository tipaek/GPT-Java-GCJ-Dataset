import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        //PrintWriter pw = new PrintWriter("output.txt");

        int maxCaseNum = in.nextInt();

        for (int caseIdx = 1; caseIdx <= maxCaseNum; caseIdx++) {
            //String[] array = line.split(" ");
//            long n = in.nextLong();
            int n = in.nextInt();

            String[] array = new String[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.next();
            }

            Arrays.sort(array, (s1,s2) -> Integer.compare(s2.length(), s1.length()));

            String longestStr = array[0].replaceAll("\\*", "");
//            System.out.println(longestStr);

            String ansStr = longestStr;

            for (int i = 1; i < array.length; i++) {
               String[] subStr = array[i].split("\\*");
                for (int j = 0; j < subStr.length; j++) {
                    String s = subStr[j];

                    if (j == 0) {
                        if (!longestStr.startsWith(s)) {
                            ansStr = "*";
                        }
                    }
                    else if (j == subStr.length-1) {
                        if (!longestStr.endsWith(s)) {
                            ansStr = "*";
                        }
                    }
                    else {
                        if (!longestStr.contains(s)) {
                            ansStr = "*";
                        }
                    }
//
//                    System.out.println(s);
//                    System.out.println(ansStr);

                }
            }




            String ans = "Case #" + caseIdx + ": " + ansStr;
            System.out.println(ans);



        }

        in.close();

    }

    static boolean solveSudoku(int[][] board, int n)
    {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == 0)
                {
                    row = i;
                    col = j;

                    // we still have some remaining
                    // missing values in Sudoku
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty)
            {
                break;
            }
        }

        // no empty space left
        if (isEmpty)
        {
            return true;
        }

        // else for each-row backtrack
        for (int num = 1; num <= n; num++)
        {
            if (isSafe(board, row, col, num))
            {
                board[row][col] = num;
                if (solveSudoku(board, n))
                {
                    // print(board, n);
                    return true;
                }
                else
                {
                    board[row][col] = 0; // replace it
                }
            }
        }
        return false;
    }

    static boolean isSafe(int[][] board,
                          int row, int col,
                          int num)
    {
        // row has the unique (row-clash)
        for (int d = 0; d < board.length; d++)
        {
            // if the number we are trying to
            // place is already present in
            // that row, return false;
            if (board[row][d] == num)
            {
                return false;
            }
        }

        // column has the unique numbers (column-clash)
        for (int r = 0; r < board.length; r++)
        {
            // if the number we are trying to
            // place is already present in
            // that column, return false;

            if (board[r][col] == num)
            {
                return false;
            }
        }

        // if there is no clash, it's safe
        return true;
    }

    static void printMatrix (int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static long diagonal (long[][] matrix, int n) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }

        return sum;
    }
}
