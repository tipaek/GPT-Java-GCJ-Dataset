import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            int n = scanner.nextInt();
            int[][] activities = new int[n][3];

            for (int j = 0; j < n; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
                activities[j][2] = j;
            }

            Arrays.sort(activities, (a, b) -> Integer.compare(a[0], b[0]));

            StringBuilder result = new StringBuilder("CJ".substring(0, Math.min(2, n)));

            boolean impossible = false;
            for (int j = 2; j < n && !impossible; j++) {
                if (activities[j][0] < activities[j - 2][1] && activities[j][0] < activities[j - 1][1]) {
                    result = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                } else if (activities[j][0] < activities[j - 2][1]) {
                    result.append("J");
                } else {
                    result.append("C");
                }
            }

            if (!impossible) {
                char[] resArray = new char[n];
                for (int j = 0; j < n; j++) {
                    resArray[activities[j][2]] = result.charAt(j);
                }
                result = new StringBuilder(new String(resArray));
            }

            System.out.println("Case #" + (i + 1) + ": " + result);
        }

        scanner.close();
    }
}