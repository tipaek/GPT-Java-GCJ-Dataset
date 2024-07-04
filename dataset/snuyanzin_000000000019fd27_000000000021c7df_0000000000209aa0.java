
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfCases = Integer.parseInt(br.readLine());
            StringBuilder output = new StringBuilder();
            for (int i = 1; i < numberOfCases + 1; i++) {
                String[] input = br.readLine().split(" ");
                int n = Integer.parseInt(input[0].trim());
                int k = Integer.parseInt(input[1].trim());
                if (n > 0 && k / n <= n && k > 0) {
                    int[] array = new int[n];
                    for (int j = 0; j < n; j++) {
                        if (n == 1) {
                            array[j] = k;
                        } else {
                            array[j] = (k / n + j) % n == 0 ? n : (k / n + j) % n;
                        }
                    }
                    StringBuilder sb = new StringBuilder("Case #" + i + ": POSSIBLE\n");

                    for (int q = 0; q < n; q++) {
                        for (int j = 0; j < n; j++) {
                            int i1 = array[(n + q - j) % n];
                            if (j == q) {
                                k = k - i1;
                            }
                            sb.append(i1);
                            if (j != n - 1) {
                                sb.append("\t");
                            }
                        }
                        sb.append("\n");
                    }
                    if (k != 0) {
                        output.append("Case #").append(i).append(": IMPOSSIBLE\n");
                    } else {
                        output.append(sb.toString());
                    }
                } else {
                    output.append("Case #").append(i).append(": IMPOSSIBLE\n");
                }
            }
            System.out.print(output.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
