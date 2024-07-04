import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int tc = 0; tc < T; tc++) {
            int N = scanner.nextInt();
            int t = 0, r = 0, c = 0;
            int[][] v = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    v[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < N; i++) {
                t += v[i][i];
            }

            for (int i = 0; i < N; i++) {
                Map<Integer, Integer> rowMap = new HashMap<>();
                Map<Integer, Integer> colMap = new HashMap<>();
                boolean r_fl = false, c_fl = false;

                for (int j = 0; j < N; j++) {
                    rowMap.put(v[i][j], rowMap.getOrDefault(v[i][j], 0) + 1);
                    colMap.put(v[j][i], colMap.getOrDefault(v[j][i], 0) + 1);
                }

                for (int value : rowMap.values()) {
                    if (value > 1) {
                        r_fl = true;
                        break;
                    }
                }

                for (int value : colMap.values()) {
                    if (value > 1) {
                        c_fl = true;
                        break;
                    }
                }

                if (r_fl) {
                    r++;
                }
                if (c_fl) {
                    c++;
                }
            }

            System.out.println("Case #" + (tc + 1) + ": " + t + " " + r + " " + c);
        }

        scanner.close();
    }
}