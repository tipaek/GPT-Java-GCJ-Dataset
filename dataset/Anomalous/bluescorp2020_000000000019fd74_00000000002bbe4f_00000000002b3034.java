import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] patterns = new String[n];
        String[][] lr = new String[n][2];
        int maxLeftLength = 0, maxRightLength = 0, leftIdx = 0, rightIdx = 0;

        for (int i = 0; i < n; i++) {
            patterns[i] = scanner.nextLine();
            lr[i] = patterns[i].split("\\*", 2);
            if (lr[i][0].length() > maxLeftLength) {
                maxLeftLength = lr[i][0].length();
                leftIdx = i;
            }
            if (lr[i][1].length() > maxRightLength) {
                maxRightLength = lr[i][1].length();
                rightIdx = i;
            }
        }

        String result = lr[leftIdx][0] + lr[rightIdx][1];

        Arrays.sort(lr, (o1, o2) -> Integer.compare(o1[0].length(), o2[0].length()));
        if (!isValidPattern(lr, 0)) {
            System.out.println("*");
            return;
        }

        Arrays.sort(lr, (o1, o2) -> Integer.compare(o1[1].length(), o2[1].length()));
        if (!isValidPattern(lr, 1)) {
            System.out.println("*");
            return;
        }

        System.out.println(result);
    }

    private static boolean isValidPattern(String[][] lr, int index) {
        for (int i = 0; i < lr.length; i++) {
            if (lr[i][index].length() > 0) {
                for (int j = i + 1; j < lr.length; j++) {
                    if (!lr[j][index].contains(lr[i][index])) {
                        return false;
                    }
                }
            }
        }
        return true;
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