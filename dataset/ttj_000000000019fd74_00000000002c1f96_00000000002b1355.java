import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static class Pair {
        public Integer key;
        public Integer value;

        public Pair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        solve(new Scanner(System.in));
    }

    public static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int[][] board = new int[x][y];
            for (int j = 0; j < x; j++) {
                for (int k = 0; k < y; k++) {
                    board[j][k] = scanner.nextInt();
                }
            }
            int result = getResult(board);
            System.out.print("Case #" + (i + 1) + ": ");
            System.out.print(result);
            if (i != n - 1)
                System.out.println();
        }
    }

    private static int getResult(int[][] board) {
        int sum = 0;

        while (true) {
            List<Pair> eliminatedList = new ArrayList<>();

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 0) {
                        continue;
                    }
                    sum += board[i][j];

                    int neighborCount = 0;
                    int neighborSum = 0;
                    int k;
                    for (k = i - 1; k >= 0; k--) {
                        if (board[k][j] > 0) {
                            neighborCount++;
                            neighborSum += board[k][j];
                            break;
                        }
                    }
                    for (k = i + 1; k < board.length; k++) {
                        if (board[k][j] > 0) {
                            neighborCount++;
                            neighborSum += board[k][j];
                            break;
                        }
                    }
                    for (k = j - 1; k >= 0; k--) {
                        if (board[i][k] > 0) {
                            neighborCount++;
                            neighborSum += board[i][k];
                            break;
                        }
                    }
                    for (k = j + 1; k < board[i].length; k++) {
                        if (board[i][k] > 0) {
                            neighborCount++;
                            neighborSum += board[i][k];
                            break;
                        }
                    }
                    if (neighborCount > 0 && (neighborSum / (double)neighborCount) > board[i][j]) {
                        eliminatedList.add(new Pair(i, j));
                    }
                }
            }

            if (eliminatedList.size() == 0) {
                return sum;
            }

            for (Pair pair : eliminatedList) {
                board[pair.key][pair.value] = 0;
            }
        }
    }
}
