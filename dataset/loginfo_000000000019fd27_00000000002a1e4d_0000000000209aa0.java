import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static boolean[] visits;
    private static int[][] rows;
    private static int[] seq;
    private static int N;
    private static int K;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder sb = new StringBuilder();

            int T = Integer.parseInt(br.readLine());

            for (int t = 1; t <= T; t++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                K = Integer.parseInt(st.nextToken());
                visits = new boolean[N];
                rows = rotateLeft(N, K);
                seq = new int[N];
                int result = dfs();
                sb.append(String.format("Case #%d: %s\n", t, getAnswer(result)));
            }

            bw.write(sb.toString());
            bw.flush();
        }
    }

    private static int dfs() {
        for (int i = 0; i < N; i++) {
            if (visits[i]) {
                continue;
            } else {
                visits[i] = true;
            }
            int result = dfs(0, i, 0);
            if (result != 0) {
                return result;
            }
            visits[i] = false;
        }
        return 0;
    }

    private static int dfs(int depth, int target, int acc) {
        acc += rows[depth][target];

        if (depth == N - 1) {
            return acc == K ? acc : 0;
        } else if (acc > K) {
            return 0;
        }

        depth += 1;
        for (int i = 0; i < N; i++) {
            if (visits[i]) {
                continue;
            } else {
                visits[i] = true;
            }
            int result = dfs(depth, i, acc);
            seq[depth] = i;
            if (result != 0) {
                return result;
            }
            visits[i] = false;
        }

        return 0;
    }

    private static String getAnswer(int result) {
        if (result == 0) {
            return "IMPOSSIBLE";
        } else {
            StringBuilder sb = new StringBuilder("POSSIBLE").append('\n');
            for (int s : seq) {
                for (int num : rows[s]) {
                    sb.append(num).append(' ');
                }
                sb.append('\n');
            }
            return sb.toString();
        }
    }

    private static int[][] rotateLeft(int N, int K) {
        int[] arr = sequantialArr(N);
        return rotateLeft(arr);
    }

    private static int[][] rotateLeft(int[] arr) {
        int N = arr.length;
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] = arr[(j + i + N) % N];
            }
        }
        return result;
    }

    private static int[] sequantialArr(int N) {
        int[] arr = new int[N];
        for (int j = 0; j < N; j++) {
            arr[j] = j + 1;
        }
        return arr;
    }
}