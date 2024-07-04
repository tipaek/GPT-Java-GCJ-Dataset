import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    private static int[][] currentGrid;
    private static int N;

    public static int findTrace() {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += currentGrid[i][i];
        }
        return trace;
    }

    public static int findR() {
        int problemCount = 0;
        for (int i = 0; i < N; i++) {
            boolean[] seen = new boolean[N + 1];
            for (int j = 0; j < N; j++) {
                int currentSquare = currentGrid[i][j];
                if (!seen[currentSquare]) {
                    seen[currentSquare] = true;
                } else {
                    problemCount++;
                    break;
                }
            }
        }
        return problemCount;
    }

    public static int findC() {
        int problemCount = 0;
        for (int i = 0; i < N; i++) {
            boolean[] seen = new boolean[N + 1];
            for (int j = 0; j < N; j++) {
                int currentSquare = currentGrid[j][i];
                if (!seen[currentSquare]) {
                    seen[currentSquare] = true;
                } else {
                    problemCount++;
                    break;
                }
            }
        }
        return problemCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(reader.readLine().trim());
            currentGrid = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                for (int j = 0; j < N; j++) {
                    currentGrid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int trace = findTrace();
            int r = findR();
            int c = findC();

            System.out.println("Case #" + t + ": " + trace + " " + r + " " + c);
        }
        reader.close();
    }
}