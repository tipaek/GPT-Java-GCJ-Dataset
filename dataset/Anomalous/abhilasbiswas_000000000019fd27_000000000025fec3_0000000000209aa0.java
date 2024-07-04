import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));                           
        int T = input.nextInt();
        for (int i = 1; i <= T; i++) {
            String result = solveCase(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String solveCase(Scanner input) {
        int n = input.nextInt();
        int k = input.nextInt();
        
        if (k % n != 0) {
            return "IMPOSSIBLE";
        }

        int s = k / n;
        StringBuilder result = new StringBuilder("POSSIBLE");
        
        for (int i = 0; i < n; i++) {
            result.append("\n");
            for (int j = -i; j < n - i; j++) {
                result.append((j + s + n - 1) % n + 1).append(" ");
            }
        }
        return result.toString();
    }
}