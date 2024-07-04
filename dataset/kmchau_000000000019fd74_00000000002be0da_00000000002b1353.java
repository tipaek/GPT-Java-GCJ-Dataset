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

            long curSum = 0;
            int rowNum = 1;
            StringBuilder sb = new StringBuilder();
            if (n <= 500) {
                for (int i = 0; i < n; i++) {
                    sb.append(i+1 + " " + "1").append("\n");
                }
            }
            else {
                int tempN = n;
                tempN--;
                long nextValue = 1;
                while (true) {
                    if (curSum + nextValue > tempN) {
                        break;
                    }

                    curSum += nextValue;
                    nextValue++;
                    rowNum++;
                    sb.append(rowNum + " " + "2" + "\n");
                }
                //System.out.println(curSum);

                for (int i = 0; i < (n-curSum)-1; i++) {
                    sb.append(rowNum + " " + "1" + "\n");
                    rowNum++;
                }
            }




            String ans = "Case #" + caseIdx + ": " + "\n" +"1 1\n" + sb.toString();
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
