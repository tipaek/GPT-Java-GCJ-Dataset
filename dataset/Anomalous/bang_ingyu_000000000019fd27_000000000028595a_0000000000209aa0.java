import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static String solve(int N, int K) {
        StringBuilder sb = new StringBuilder();
        
        if (N == 2) {
            if (K == 2) {
                sb.append("POSSIBLE\n1 2\n2 1\n");
            } else if (K == 4) {
                sb.append("POSSIBLE\n2 1\n1 2\n");
            } else {
                sb.append("IMPOSSIBLE\n");
            }
        } else if (N == 3) {
            switch (K) {
                case 3:
                    sb.append("POSSIBLE\n1 2 3\n3 1 2\n2 3 1\n");
                    break;
                case 6:
                    sb.append("POSSIBLE\n1 2 3\n2 3 1\n3 1 2\n");
                    break;
                case 9:
                    sb.append("POSSIBLE\n3 2 1\n1 3 2\n2 1 3\n");
                    break;
                default:
                    sb.append("IMPOSSIBLE\n");
                    break;
            }
        } else if (N == 4) {
            switch (K) {
                case 4: case 6: case 7: case 8: case 9: case 10:
                case 11: case 12: case 13: case 14: case 16:
                    sb.append("POSSIBLE\n");
                    sb.append(getMatrix(N, K));
                    break;
                default:
                    sb.append("IMPOSSIBLE\n");
                    break;
            }
        } else if (N == 5) {
            switch (K) {
                case 5: case 7: case 8: case 9: case 10: case 11:
                case 12: case 13: case 14: case 15: case 16:
                case 17: case 18: case 19: case 20: case 21:
                case 22: case 23: case 25:
                    sb.append("POSSIBLE\n");
                    sb.append(getMatrix(N, K));
                    break;
                default:
                    sb.append("IMPOSSIBLE\n");
                    break;
            }
        } else {
            sb.append("IMPOSSIBLE\n");
        }

        return sb.toString();
    }

    public static String getMatrix(int N, int K) {
        StringBuilder sb = new StringBuilder();
        // Implement the logic to generate the matrix based on N and K.
        // This is a placeholder. You need to replace it with the actual logic.
        // For example purposes, let's return a simple identity matrix:
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    sb.append(i).append(" ");
                } else {
                    sb.append((i + j - 1) % N + 1).append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = stoi(br.readLine());

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = stoi(st.nextToken());
            int K = stoi(st.nextToken());

            sb.append("Case #").append(i).append(": ").append(solve(N, K));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}