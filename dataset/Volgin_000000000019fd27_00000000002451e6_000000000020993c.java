import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    final static char ZERO = '0';
    final static char ONE = '1';

    public static void main(String... args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            mainLoop(i + 1, reader);
        }
    }

    private static void mainLoop(int caseId, BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int k = 0;
        int r = 0;
        int c = 0;
        int uniqueSignature = 1;
        int[] colSign = new int[n];
        for (int i = 0; i < n; i++) {
            uniqueSignature *= (i + 1);
            colSign[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            String[] row = reader.readLine().split(" ");
            int rowSign = 1;
            for (int j = 0; j < n; j++) {
                int mij = Integer.parseInt(row[j]);
                rowSign *= mij;
                colSign[j] *= mij;
                if (i == j) {
                    k += mij;
                }
            }
            r += (rowSign != uniqueSignature) ? 1 : 0;
        }
        for (int i = 0; i < n; i++) {
            c += (colSign[i] != uniqueSignature) ? 1 : 0;
        }
        System.out.println("Case #" + caseId + ": " + k + " " + r + " " + c);
    }
}
