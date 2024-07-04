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

            for (int j = 1; j <= N; j++) {
                int sum = 0;
                for (int i = 0; i < N; i++) {
                    int x = (i + i + j) % N;
                    if (x == 0) {
                        x = N;
                    }
                    sum += x;
                }

                if (sum == k) {
                    System.out.println("Case #" + level + ": POSSIBLE");
                    for (int ci = 0; ci < N; ci++) {
                        for (int cj = 0; cj < N; cj++) {
                            int x = (ci + cj + j) % N;
                            if (x == 0) {
                                x = N;
                            }
                            System.out.print(x + " ");
                        }
                        System.out.println();
                    }
                    found = true;
                    break;
                }
            }

            if (!found) {
                for (int i = 1; i <= N; i++) {
                    int sum = i * N;
                    if (sum == k) {
                        System.out.println("Case #" + level + ": POSSIBLE");
                        int xx = i;
                        for (int ci = 0; ci < N; ci++) {
                            int lastElement = -1;
                            for (int cj = 0; cj < N; cj++) {
                                int ans = xx % N;
                                if (ans == 0) {
                                    xx = N;
                                } else {
                                    xx = ans;
                                }
                                lastElement = xx;
                                System.out.print(lastElement + " ");
                                xx++;
                            }
                            xx = lastElement;
                            System.out.println();
                        }
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
}