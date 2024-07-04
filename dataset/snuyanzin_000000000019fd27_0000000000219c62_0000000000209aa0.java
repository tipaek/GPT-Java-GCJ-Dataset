
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfCases = Integer.parseInt(br.readLine());
            for (int i = 1; i < numberOfCases + 1; i++) {
                String[] input = br.readLine().split(" ");
                int n = Integer.parseInt(input[0].trim());
                int k = Integer.parseInt(input[1].trim());
                if (k / n <= n && k > 0) {
                    int[] array = new int[n];
                    for (int j = 0; j < n; j++) {
                        if (n == 1) {
                            array[j] = k;
                        } else {
                            array[j] = (k / n + j) % n == 0 ? n : (k / n + j) % n;
                        }
                    }
                    StringBuilder sb = new StringBuilder("Case #" + i + ": POSSIBLE\n");

                    for (int j = 0; j < n; j++) {
                        for (int q = 0; q < n; q++) {
                            int i1 = array[(n + q - j) % n];
                            if (j == q) {
                                k = k - i1;
                            }
                            sb.append(i1);
                            if (q != n - 1) {
                                sb.append(" ");
                            }
                        }
                        if (j != n - 1) {
                            sb.append("\n");
                        }
                    }
                    if (k != 0) {
                        System.out.println("Case #" + i + ": IMPOSSIBLE");
                    } else {
                        System.out.println(sb.toString());
                    }
                } else {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
