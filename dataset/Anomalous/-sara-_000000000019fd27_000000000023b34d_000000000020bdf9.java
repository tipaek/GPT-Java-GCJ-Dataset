import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            String jamie = "0".repeat(1441);
            String cameron = "0".repeat(1441);
            int n = scanner.nextInt();
            StringBuilder solution = new StringBuilder();

            for (int j = 0; j < n; j++) {
                int beginTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (jamie.substring(beginTime, endTime).contains("1") && cameron.substring(beginTime, endTime).contains("1")) {
                    solution = new StringBuilder("IMPOSSIBLE");
                    break;
                } else if (!jamie.substring(beginTime, endTime).contains("1")) {
                    solution.append("J");
                    jamie = jamie.substring(0, beginTime) + "1".repeat(endTime - beginTime) + jamie.substring(endTime);
                } else {
                    solution.append("C");
                    cameron = cameron.substring(0, beginTime) + "1".repeat(endTime - beginTime) + cameron.substring(endTime);
                }
            }

            System.out.println("Case #" + i + ": " + solution);
        }

        scanner.close();
    }
}