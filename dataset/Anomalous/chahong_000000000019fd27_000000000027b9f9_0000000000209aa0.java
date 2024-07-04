import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int num = scanner.nextInt();
            int crossSum = scanner.nextInt();
            String result;

            if (crossSum == (num + 1) || crossSum == (Math.pow(num, 2) - 1)) {
                result = "IMPOSSIBLE";
            } else {
                result = "POSSIBLE";
            }

            System.out.println("Case #" + (i + 1) + ": " + result);
        }

        scanner.close();
    }
}