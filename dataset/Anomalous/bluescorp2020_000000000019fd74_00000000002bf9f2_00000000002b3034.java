import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] patterns = new String[n];
        String[][] lr = new String[n][2];
        int maxLeftLength = 0, maxRightLength = 0;
        int leftIndex = 0, rightIndex = 0;

        for (int i = 0; i < n; i++) {
            patterns[i] = scanner.nextLine();
            lr[i] = patterns[i].split("\\*", 2);

            if (lr[i][0].length() > maxLeftLength) {
                maxLeftLength = lr[i][0].length();
                leftIndex = i;
            }

            if (lr[i][1].length() > maxRightLength) {
                maxRightLength = lr[i][1].length();
                rightIndex = i;
            }
        }

        String ans = lr[leftIndex][0] + lr[rightIndex][1];

        Arrays.sort(lr, Comparator.comparingInt(o -> o[0].length()));

        for (int i = 0; i < n; i++) {
            if (lr[i][0].length() > 0) {
                for (int j = i + 1; j < n; j++) {
                    if (!lr[j][0].startsWith(lr[i][0])) {
                        System.out.println("*");
                        return;
                    }
                }
            }
        }

        Arrays.sort(lr, Comparator.comparingInt(o -> o[1].length()));

        for (int i = 0; i < n; i++) {
            if (lr[i][1].length() > 0) {
                for (int j = i + 1; j < n; j++) {
                    if (!lr[j][1].endsWith(lr[i][1])) {
                        System.out.println("*");
                        return;
                    }
                }
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int k = 1; k <= t; k++) {
            System.out.print("Case #" + k + ": ");
            solve(scanner);
        }

        scanner.close();
    }
}