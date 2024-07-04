
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = in.nextInt();
        StringBuilder output = new StringBuilder();
        for (int i = 1; i < numberOfCases + 1; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            if (n > 0 && k % n == 0 && k / n <= n && k > 0) {
                int[] array = new int[n];
                array[0] = k / n;
                int value = 1;
                for (int j = 1; j < n; j++) {
                    if (value == array[0]) {
                        value += 1;
                    }
                    array[j] = value;
                    value += 1;
                }
                StringBuilder sb = new StringBuilder("Case #" + i + ": POSSIBLE\n");

                for (int q = 0; q < n; q++) {
                    for (int j = 0; j < n; j++) {
                        int i1 = array[(n + j - q) % n];
                        sb.append(i1);
                        if (j != n - 1) {
                            sb.append(" ");
                        }
                    }
                    sb.append("\n");
                }
                output.append(sb.toString());
            } else {
                output.append("Case #").append(i).append(": IMPOSSIBLE\n");
            }
        }
        System.out.print(output.toString());
    }
}
