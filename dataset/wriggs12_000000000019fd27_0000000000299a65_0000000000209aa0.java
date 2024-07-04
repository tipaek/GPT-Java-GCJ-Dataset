import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int numCases = keyboard.nextInt();
        for (int z = 1; z <= numCases; z++) {

            String ans = "";
            int num = 0;
            int size = keyboard.nextInt();
            int trace = keyboard.nextInt();
            int[] allTrace = new int[size + 1];
            for (int i = 0; i < allTrace.length - 1; i++) {
                allTrace[i] = (i + 1) * size;
                if (trace == allTrace[i]) {
                    num = i + 1;
                }
            }

            int added = add(size);
            allTrace[allTrace.length - 1] = added;

            boolean possible = false;

            for (int i = 0; i < allTrace.length - 1; i++) {
                if (trace == allTrace[i]) {
                    possible = true;
                }
            }
            if ((size % 2 == 1 && trace == allTrace[allTrace.length - 1]) || (size % 2 == 0 && trace == allTrace[allTrace.length - 1] && size > 2)) {
                possible = true;
            }

            if (!possible) {
                ans = "Case #" + z + ": IMPOSSIBLE";
                System.out.println(ans);
            }
            else {
                ans = "Case #" + z + ": POSSIBLE";
                System.out.println(ans);

                if (trace == added) {
                    int[][] matrix = new int[size][size];
                    for (int i = 0; i < size; i++) {
                        matrix[i][i] = i + 1;
                    }
                    solve(matrix);
                }
                else {
                    int[][] matrix = new int[size][size];
                    for (int i = 0; i < size; i++) {
                        matrix[i][i] = num;
                    }
                    solve(matrix);
                }
            }
        }
    }

    public static int add(int n) {
        if (n % 2 == 0) {
            int numTimes = n / 2;
            int num = ++n;
            return num * numTimes;
        }
        int numTimes = n / 2;
        int num = ++n;
        return (num * numTimes) + ((num + 1) / 2);
    }
    public static boolean solve(int[][] board) {
        boolean isFull = true;
        int row = 0;
        int col = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    isFull = false;
                    row = i;
                    col = j;
                    break;
                }
            }
            if (!isFull)
                break;
        }

        if (isFull) {
            printBoard(board);
            return true;
        }
        for (int i = 1; i <= board.length; i++) {
            if(isValid(board, row, col, i)) {
                board[row][col] = i;
                if (solve(board))
                    return true;
                else
                    board[row][col] = 0;
            }
        }
        return false;
    }
    public static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (j != board[i].length - 1) {
                    System.out.print(board[i][j] + " ");
                }
                else {
                    System.out.print(board[i][j]);
                }
            }
            System.out.println();
        }
    }
    public static boolean isRowValid(int[][] board, int row, int num) {
        for (int i = 0; i < board.length; i++) {
            if(board[row][i] == num)
                return false;
        }
        return true;
    }
    public static boolean isColValid(int[][] board, int col, int num) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num)
                return false;
        }
        return true;
    }
    public static boolean isValid(int[][] board, int row, int col, int num) {
        return isRowValid(board, row, num) && isColValid(board, col, num);
    }
}