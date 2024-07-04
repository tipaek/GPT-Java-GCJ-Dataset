import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = input.nextInt();
        for (int i = 1; i <= T; i++) {
            String[] result = processTestCase(input);
            System.out.println("Case #" + i + ": " + result[0]);
            for (int j = 1; j < result.length; j++) {
                System.out.println(result[j]);
            }
        }
    }

    public static String[] processTestCase(Scanner input) {
        int n = input.nextInt();
        int k = input.nextInt();
        
        if (k % n != 0) {
            return new String[] { "IMPOSSIBLE" };
        }

        int s = k / n;
        String[] result = new String[n + 1];
        result[0] = "POSSIBLE";
        
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = -i; j < n - i; j++) {
                row.append((j + s + n - 1) % n + 1).append(" ");
            }
            result[i + 1] = row.toString().trim();
        }
        
        return result;
    }
}