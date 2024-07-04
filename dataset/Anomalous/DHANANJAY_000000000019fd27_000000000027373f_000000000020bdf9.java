import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[] intervals = new int[n * 2];

            for (int j = 0; j < n * 2; j++) {
                intervals[j] = scanner.nextInt();
            }

            StringBuilder result = new StringBuilder();
            String s1, s2;

            if ((intervals[0] == 0 && intervals[1] == 1440 && n > 2) || (n > 2 && intervals[2] > intervals[0] && intervals[3] < intervals[1])) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
                continue;
            }

            if (n <= 3) {
                s1 = "C";
                s2 = "J";
                result.append("C");
            } else {
                s1 = "J";
                s2 = "C";
                result.append("J");
            }

            for (int k = 2; k < n * 2; k += 2) {
                if ((intervals[k] < intervals[k - 1] && intervals[k] > intervals[k - 2]) || (intervals[k + 1] > intervals[k - 2] && intervals[k + 1] < intervals[k - 2])) {
                    result.append(s2);
                } else if ((intervals[k] < intervals[k - 1] && intervals[k] < intervals[k - 2]) || (intervals[k + 1] < intervals[k - 2] && intervals[k + 1] > intervals[k - 2])) {
                    if (result.charAt(result.length() - 1) == 'J') {
                        result.append(s2);
                    } else {
                        result.append(s1);
                    }
                } else if (intervals[k] == intervals[k - 1]) {
                    result.append(result.charAt(result.length() - 1));
                } else {
                    result.append(s1);
                }
            }

            System.out.println("Case #" + t + ": " + result);
        }

        scanner.close();
    }
}