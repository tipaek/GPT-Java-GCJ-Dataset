import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int test_Cases = input.nextInt();
        int flag = 0;
        while (test_Cases != 0) {
            flag++;

            int n = input.nextInt();
            int truce = input.nextInt();

            int[][] matrix = new int[n][n];
            int[][] matrix_new = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                    matrix_new[i][j] = 0;
                }
            check_truce(matrix, n, truce);

            if (solveSudoku(matrix, n)) {

                print(matrix, n, flag);
                

                // print solution


            } else {
                System.out.println("Case #" + flag + ":" + "IMPOSSIBLE");
            }


            test_Cases--;
        }
    }



    private static int[][] check_truce(int[][] matrix, int n, int truce) {
        int sum = 0;
        while (sum != truce) {
            sum = 0;
            int[] x= new int[n];
            for(int i=0;i<n;i++){
             x[i] = 1+(int) (Math.random() * n);
            sum+=x[i];}
            if (sum == truce) {
                for(int i=0;i<n;i++)
                    matrix[i][i]=x[i];
                break;
            }


        }
        return matrix;
    }

    public static boolean isSafe(int[][] board,
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

                    // corresponding square has
                    // unique number (box-clash)
                    int sqrt = (int) Math.sqrt(board.length);
                    int boxRowStart = row - row % sqrt;
                    int boxColStart = col - col % sqrt;

                    for (int r = boxRowStart;
                         r < boxRowStart + sqrt; r++)
                    {
                        for (int d = boxColStart;
                             d < boxColStart + sqrt; d++)
                        {
                            if (board[r][d] == num)
                            {
                                return false;
                            }
                        }
                    }

                    // if there is no clash, it's safe
                    return true;
                }

                public static boolean solveSudoku(int[][] board, int n)
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

                public static void print(int[][] board, int N,int flag)
                {
                    System.out.println("Case #"+ flag+":" + "POSSIBLE");
                    // we got the answer, just print it
                    for (int r = 0; r < N; r++)
                    {
                        for (int d = 0; d < N; d++)
                        {
                            System.out.print(board[r][d]);
                            System.out.print(" ");
                        }
                        System.out.print("\n");

                        if ((r + 1) % (int) Math.sqrt(N) == 0)
                        {
                            System.out.print("");
                        }
                    }
                }

              

}