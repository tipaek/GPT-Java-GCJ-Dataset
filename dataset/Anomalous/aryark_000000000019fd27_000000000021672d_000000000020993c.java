import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int a = 0; a < T; a++) {
            int N = scan.nextInt();
            int trace = 0;
            int rows = 0;
            int cols = 0;
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    int num = scan.nextInt();
                    matrix[i][j] = num;
                    if (i == j) trace += num;
                    rowSet.add(num);
                }
                if (rowSet.size() < N) rows++;
            }

            for (int j = 0; j < N; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() < N) cols++;
            }

            System.out.println("Case #" + (a + 1) + ": " + trace + " " + rows + " " + cols);
        }
    }
}