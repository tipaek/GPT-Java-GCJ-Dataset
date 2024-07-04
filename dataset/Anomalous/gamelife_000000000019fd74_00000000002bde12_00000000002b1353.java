import java.util.Scanner;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                new Solution().processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        StringBuilder result = new StringBuilder();
        if (n <= 500) {
            for (int i = 1; i <= n; i++) {
                result.append(String.format("\n%d 1", i));
            }
        } else if (n == 501) {
            result.append("\n1 1")
                  .append("\n2 1")
                  .append("\n3 2")
                  .append("\n3 1");
            for (int i = 4; i <= 499; i++) {
                result.append(String.format("\n%d 1", i));
            }
        }

        System.out.println(String.format(OUTPUT_FORMAT, caseNum, result.toString()));
    }
}