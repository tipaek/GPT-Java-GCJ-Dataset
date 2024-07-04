import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int intervalsCount = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            int startJ = 0, endJ = 0, startC = 0, endC = 0;

            boolean possible = true;
            for (int i = 0; i < intervalsCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (start >= endJ || end <= startJ) {
                    result.append("J");
                    startJ = start;
                    endJ = end;
                } else if (start >= endC || end <= startC) {
                    result.append("C");
                    startC = start;
                    endC = end;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }
}