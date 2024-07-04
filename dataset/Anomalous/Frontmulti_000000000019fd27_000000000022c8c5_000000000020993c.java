import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, N;
    static int[][] matrix;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());
            matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            processTestCase(testCase);
        }
        br.close();
    }

    private static void processTestCase(int testCase) {
        int trace = 0, maxRowRepeat = 0, maxColRepeat = 0;

        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
            maxRowRepeat = Math.max(maxRowRepeat, findMaxRepeat(matrix[i]));
            maxColRepeat = Math.max(maxColRepeat, findMaxRepeat(getColumn(matrix, i)));
        }

        int r = maxRowRepeat == 0 ? 0 : maxRowRepeat + 1;
        int c = maxColRepeat == 0 ? 0 : maxColRepeat + 1;

        System.out.println("Case #" + testCase + ": " + trace + " " + r + " " + c);
    }

    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[N];
        for (int i = 0; i < N; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }

    private static int findMaxRepeat(int[] array) {
        int maxRepeat = 0, currentRepeat = 0, lastValue = array[0];

        for (int value : array) {
            if (value == lastValue) {
                currentRepeat++;
                maxRepeat = Math.max(maxRepeat, currentRepeat);
            } else {
                currentRepeat = 1;
                lastValue = value;
            }
        }

        return maxRepeat;
    }
}