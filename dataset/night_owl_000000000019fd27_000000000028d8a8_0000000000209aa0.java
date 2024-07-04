import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int i, j;
        int tcase = 1;
        for (; tcase <= testCases; tcase++) {
            i = scanner.nextInt();
            j = scanner.nextInt();
            isPossible(i, j, tcase);

        }
    }

    private static void isPossible(int i, int j, int tcase) {
        int[][] n = new int[i][i];
        int minSum = j / i;
        int ms = j - (i*minSum);
        if( j%i == 0) for(int x=0; x<i; x++ ) n[x][x] = j/i;
        else
        for (int x = 0; x < i; x++) {
            if (x >= (i-ms)) {
                n[x][x] = minSum + 1;
            } else {
                n[x][x] = minSum;
            }
        }
        if(i>2 && n[0][0] != n[1][1]) { n[1][1]--; n[2][2]++;}
        if (check(i,j) && solveSudoku(n, i) == true) {
            System.out.println("Case #" + tcase + ": " + "POSSIBLE");
            print(n, i);
        } else {
            System.out.println("Case #" + tcase + ": " + "IMPOSSIBLE");
        }
    }

    private static boolean check(int i, int j) {
    	if(j > i*i) return false;
		if( i == 2 || i == 3) return j < i*i && j%i == 0;
		return j != i+1 && j != (i*i)-1;
	}

	public static boolean isSafe(int[][] board, int row, int col, int num) {
        for (int d = 0; d < board.length; d++) if (board[row][d] == num) return false;
        for (int r = 0; r < board.length; r++) if (board[r][col] == num) return false;
        return true;
    }

    public static boolean solveSudoku(int[][] board, int n) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        if (isEmpty) {
            return true;
        }

        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board, n)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static void print(int[][] board, int N) {
        for (int r = 0; r < N; r++) {
            for (int d = 0; d < N; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int) Math.sqrt(N) == 0) {
                System.out.print("");
            }
        }
    }
}
