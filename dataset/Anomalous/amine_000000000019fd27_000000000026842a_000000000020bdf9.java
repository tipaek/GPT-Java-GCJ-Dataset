import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            StringBuilder result = new StringBuilder();

            int jStart = 0, jEnd = 0;
            int cStart = 0, cEnd = 0;

            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (start >= jEnd) {
                    result.append("J");
                    jStart = start;
                    jEnd = end;
                } else if (start >= cEnd) {
                    result.append("C");
                    cStart = start;
                    cEnd = end;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }

        scanner.close();
    }
}