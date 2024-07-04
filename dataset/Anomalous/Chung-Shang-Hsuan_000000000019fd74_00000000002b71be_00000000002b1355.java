import java.util.*;

public class Solution {

    private int[][] arr;
    private int n;
    private int m;
    private int sum;

    public Solution(int rows, int cols, Scanner sc) {
        this.arr = new int[rows][cols];
        this.n = rows;
        this.m = cols;
        this.sum = 0;
        initializeArray(sc);
    }

    private void initializeArray(Scanner sc) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                sum += arr[i][j];
            }
        }
    }

    public boolean isEliminated(int x, int y) {
        int sum = 0;
        int count = 0;

        sum += getNeighborSum(x - 1, y, -1, 0, count);
        sum += getNeighborSum(x + 1, y, 1, 0, count);
        sum += getNeighborSum(x, y - 1, 0, -1, count);
        sum += getNeighborSum(x, y + 1, 0, 1, count);

        if (count == 0) return false;
        return (float) sum / count > arr[x][y];
    }

    private int getNeighborSum(int x, int y, int dx, int dy, int count) {
        while (x >= 0 && x < n && y >= 0 && y < m) {
            if (arr[x][y] != -1) {
                count++;
                return arr[x][y];
            }
            x += dx;
            y += dy;
        }
        return 0;
    }

    public int calculate() {
        boolean eliminated = true;
        int totalElim = 0;
        int interest = 0;

        while (eliminated) {
            interest += sum - totalElim;
            List<int[]> toEliminate = new ArrayList<>();
            eliminated = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] != -1 && isEliminated(i, j)) {
                        eliminated = true;
                        totalElim += arr[i][j];
                        toEliminate.add(new int[]{i, j});
                    }
                }
            }

            for (int[] cell : toEliminate) {
                arr[cell[0]][cell[1]] = -1;
            }
        }
        return interest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int c = 1; c <= cases; c++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Solution solution = new Solution(n, m, sc);
            System.out.println("Case #" + c + ": " + solution.calculate());
        }
    }
}