import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private void processInput() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int u = scanner.nextInt();
            char[] mapping = new char[10];
            for (int i = 0; i < 10000; i++) {
                long q = scanner.nextLong();
                char[] result = scanner.next().toCharArray();
                for (int j = result.length - 1; j >= 0; j--) {
                    long digit = q % 10;
                    q /= 10;
                    mapping[(int) digit] = result[j];
                }
            }

            System.out.printf("Case #%d: %s\n", caseIndex, String.valueOf(mapping));
        }
    }

    public static void main(String[] args) {
        new Solution().processInput();
    }
}