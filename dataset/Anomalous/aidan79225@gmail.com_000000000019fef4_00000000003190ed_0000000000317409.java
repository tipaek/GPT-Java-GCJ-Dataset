import java.util.Scanner;

public class Solution {
    private static final String OUTPUT_CASE_RESULT = "Case #%d: %d";
    private static final String OUTPUT_CASE_IMPOSSIBLE = "Case #%d: IMPOSSIBLE";

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
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        char[] path = scanner.next().toCharArray();

        for (int i = 0; i < path.length; i++) {
            switch (path[i]) {
                case 'S':
                    y--;
                    break;
                case 'N':
                    y++;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }

            if (Math.abs(x) + Math.abs(y) <= i + 1) {
                System.out.println(String.format(OUTPUT_CASE_RESULT, caseNum, i + 1));
                return;
            }
        }
        System.out.println(String.format(OUTPUT_CASE_IMPOSSIBLE, caseNum));
    }
}