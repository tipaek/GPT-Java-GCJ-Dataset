import java.io.*;
import java.util.*;

public class Solution3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());
        int[] sums = new int[t];

        for (int i = 0; i < t; i++) {
            String[] dimensions = scanner.nextLine().split(" ");
            int rows = Integer.parseInt(dimensions[0]);
            int cols = Integer.parseInt(dimensions[1]);
            int[][] boardInt = new int[rows][cols];

            for (int k = 0; k < rows; k++) {
                boardInt[k] = Arrays.stream(scanner.nextLine().split(" "))
                                    .mapToInt(Integer::parseInt)
                                    .toArray();
            }

            sums[i] = calculateSum(boardInt);
        }

        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + sums[i]);
        }
    }

    private static int calculateSum(int[][] boardInt) {
        int rows = boardInt.length;
        int cols = boardInt[0].length;
        int sum = 0, oldVal = 0, newVal = -1;

        while (true) {
            oldVal = newVal;
            Dancer[][] board = new Dancer[rows][cols];

            for (int p = 0; p < rows; p++) {
                for (int j = 0; j < cols; j++) {
                    board[p][j] = new Dancer(p, j, boardInt);
                }
            }

            newVal = sumUp(boardInt);
            if (oldVal == newVal) {
                break;
            } else {
                sum += newVal;
                for (int p = 0; p < rows; p++) {
                    for (int j = 0; j < cols; j++) {
                        if (board[p][j].avg > board[p][j].number) {
                            boardInt[p][j] = -1;
                        }
                    }
                }
            }
        }
        return sum;
    }

    private static int sumUp(int[][] boardInt) {
        int sum = 0;
        for (int[] row : boardInt) {
            for (int val : row) {
                if (val != -1) {
                    sum += val;
                }
            }
        }
        return sum;
    }

    private static double calAvg(int x, int y, int[][] board) {
        int counter = 0, sum = 0;
        int rows = board.length, cols = board[0].length;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int d = 0; d < 4; d++) {
            int a = x + dx[d];
            int b = y + dy[d];
            while (a >= 0 && a < rows && b >= 0 && b < cols) {
                if (board[a][b] != -1) {
                    counter++;
                    sum += board[a][b];
                    break;
                }
                a += dx[d];
                b += dy[d];
            }
        }

        return counter == 0 ? -1 : (double) sum / counter;
    }

    static class Dancer {
        public int x, y, number;
        public double avg;

        public Dancer(int x, int y, int[][] board) {
            this.x = x;
            this.y = y;
            this.number = board[x][y];
            this.avg = calAvg(x, y, board);
        }
    }
}