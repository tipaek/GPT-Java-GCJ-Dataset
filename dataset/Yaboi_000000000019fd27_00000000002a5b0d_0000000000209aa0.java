import java.util.Scanner;

public class Solution {

    public static void main(String[]args){
        Scanner scan= new Scanner(System.in);
        int T = scan.nextInt();
        for(int i=0;i<T;i++) {
            int N = scan.nextInt();
            int K = scan.nextInt();
            Sudoku s = new Sudoku(N);
            int sum =(K/N)*N;


                for (int j = 0; j < N; j++) {
                    s.set(K/N,j,j);
                }
                OUTER_LOOP:
                for(int a=0;a<N;a++){
                    for(int b =K/N;b<N;b++){
                        s.set(b,a,a);
                        sum++;
                        if(sum==K){
                            break OUTER_LOOP;
                        }
                    }
                }
                int king =i+1;
                if(s.solve(N)){
                System.out.println("Case #"+king+": POSSIBLE");
                for(int m=0;m<N;m++){
                    System.out.println(s.board[m][0]);
                    for(int n=1;n<N;n++)
                    System.out.print(s.board[m][n]);
                }
                }
                else{
                    System.out.println("Case #"+i+": IMPOSSIBLE");
                }
        }
        }
    }

class Sudoku {


        public int[][] board;

        /**
         * Constucts a sudoku and a copy of it from the matrix sent in as a parameter.
         */
        public Sudoku(int N) {
            board = new int[N][N];
        }

        /**
         * Gets the value of a field in the sudoku.
         *
         * @param row index of the fields row.
         * @param col index of the fields column.
         */
        public int get(int row, int col) {
            return board[row][col];
        }

        /**
         * Sets the value of a field in the sudoku.
         *
         * @param nbr integer to set.
         * @param row index of nbr.
         * @param col index in of nbr.
         */
        public void set(int nbr, int row, int col) {
            board[row][col] = nbr;
            return;
        }

        /**
         * Clears all the fields in the sudoku board by setting the values to 0.
         *
         * @post: All fields in the board get set to 0.
         */

        public void clear(int N) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = 0;
                }
            }
        }

        /**
         * Tests if the sudoku requirements are met.
         *
         * @param nbr integer to test.
         * @param row index of nbr.
         * @param col index in of nbr.
         * @return true if the requirments for row, column and 3x3 box are met.
         */
        public boolean rules(int nbr, int row, int col,int N) {
            return (ruleRow(nbr, row, col,N) && ruleCol(nbr, row, col,N));
        }

        private boolean ruleRow(int nbr, int row, int col,int N) {
            for (int i = 0; i < N; i++) {
                if (board[row][i] == nbr && i != col) {
                    return false;
                }
            }
            return true;
        }

        private boolean ruleCol(int nbr, int row, int col,int N) {
            for (int i = 0; i < N; i++) {
                if (board[i][col] == nbr && i != row) {
                    return false;
                }
            }
            return true;
        }

        private boolean ruleBox(int nbr, int row, int col) {
            int toprow = (row / 3) * 3;
            int leftcol = (col / 3) * 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[toprow + i][leftcol + j] == nbr && !((row == toprow + i) && (col == leftcol + j))) {
                        return false;
                    }
                }
            }
            return true;
        }

        /**
         * Solves the Sudoku accoring to the requirements if possible.
         * @post: The board gets filled with numbers if it is solvable.
         * @return true if the sudoku is solvable.
         */
        public boolean solve(int N) {
           // for(int i=0;i<N;i++) {
             //   for(int j =0;j<N;j++) {
                    //if(board[i][j]!=0&&!rules(board[i][j],i,j)) {
                      //  return false;
                   // }
               // }
            //}
            return solve1(0, 0,N);
        }

        private boolean solve1(int row, int col,int N) {
            if (row == N) {
                return true;
            }
            else if(col>=N){
                if(solve1(row,0,N)){
                    return true;
                }
            }
                else if (board[row][col] == 0) {
                for (int input = 1; input < N+1; input++) {
                    if (rules(input, row, col,N)) {
                        board[row][col] = input;
                        if (col < N-1&&row!=col+1) {
                            if (solve1(row, col + 1,N)) {
                                return true;
                            }
                        } else if(col>=N){
                            if (solve1(row + 1, 0,N)) {
                                return true;
                            }
                        }
                        else{
                            if(solve1(row,col+2,N)){
                                return true;
                            }
                        }
                    }

                }
                board[row][col] = 0;
                return false;

            } else {
                if (rules(board[row][col], row, col,N)) {
                    if (row == N-1 && col == N-1) {
                        return true;
                    } else if (col < N-1) {
                        if (solve1(row, col + 1,N)) {
                            return true;
                        }
                    } else {
                        if (solve1(row + 1, 0,N)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

    }

