import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int level = 1;

        while (t-- > 0) {
            boolean found = false;
            StringTokenizer str = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(str.nextToken());
            int k = Integer.parseInt(str.nextToken());

            for (int i = 1; i <= N; i++) {
                int sum = i * N;
                if (sum == k) {
                    System.out.println("Case #" + level + ": POSSIBLE");
                    printMatrix(N, i);
                    found = true;
                    break;
                }
            }

            if (!found) {
                for (int j = 1; j <= N; j++) {
                    int sum = 0;
                    for (int i = 0; i < N; i++) {
                        int x = (i + i + j) % N;
                        if (x == 0) x = N;
                        sum += x;
                    }
                    if (sum == k) {
                        System.out.println("Case #" + level + ": POSSIBLE");
                        printMatrix(N, j);
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                System.out.println("Case #" + level + ": IMPOSSIBLE");
            }
            level++;
        }
    }

    private static void printMatrix(int N, int start) {
        int value = start;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int ans = value % N;
                if (ans == 0) ans = N;
                System.out.print(ans + " ");
                value++;
            }
            value = (value - 1) % N + 1;
            System.out.println();
        }
    }
}