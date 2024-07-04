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
                rows = rotateLeft(N);
                seq = new int[N];
                boolean result = dfs();
                sb.append(String.format("Case #%d: %s\n", t, getAnswer(result)));
            }

            bw.write(sb.toString());
            bw.flush();
        }
    }

    private static boolean dfs() {
        int depth = 0;

        for (int i = 0; i < N; i++) {
            visits[i] = true;

            if (dfs(depth, i, 0)) {
                return true;
            }

            visits[i] = false;
        }

        return false;
    }

    private static boolean dfs(int depth, int target, int acc) {
        seq[depth] = target;
        acc += rows[target][depth];
        if (depth == N - 1) {
            return acc == K;
        } else if (acc > K) {
            return false;
        }

        depth++;
        for (int i = 0; i < N; i++) {
            if (visits[i]) {
                continue;
            }

            visits[i] = true;

            if (dfs(depth, i, acc)) {
                return true;
            }

            visits[i] = false;
        }

        return false;
    }

    private static String getAnswer(boolean result) {
        if (!result) {
            return "IMPOSSIBLE";
        }

        StringBuilder sb = new StringBuilder("POSSIBLE").append('\n');
        for (int s : seq) {
            for (int num : rows[s]) {
                sb.append(num).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    private static int[][] rotateLeft(int N) {
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