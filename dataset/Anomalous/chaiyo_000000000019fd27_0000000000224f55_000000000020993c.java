import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void go(int[][] arr2d, int N, int T) {
        int numberOfRepeatedRow = 0;
        int numberOfRepeatedColumn = 0;
        int traceSum = 0;

        for (int t = 0; t < N; t++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int e = 0; e < N; e++) {
                if (e == t) {
                    traceSum += arr2d[t][e];
                }
                rowSet.add(arr2d[t][e]);
                colSet.add(arr2d[e][t]);
            }
            if (rowSet.size() != N) {
                numberOfRepeatedRow++;
            }
            if (colSet.size() != N) {
                numberOfRepeatedColumn++;
            }
        }

        System.out.println("Case #" + T + ": " + traceSum + " " + numberOfRepeatedRow + " " + numberOfRepeatedColumn);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int[][] arr2d = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr2d[i][j] = scanner.nextInt();
                }
            }

            go(arr2d, N, t);
        }

        scanner.close();
    }
}