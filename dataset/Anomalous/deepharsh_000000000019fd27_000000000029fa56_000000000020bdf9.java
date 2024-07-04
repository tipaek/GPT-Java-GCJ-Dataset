import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            int n = scanner.nextInt();
            int[] num = new int[n * 2];
            for (int j = 0; j < num.length; j++) {
                num[j] = scanner.nextInt();
            }
            System.out.println("Case #" + i + ": " + findSolution(num, "", 0, true));
        }
        scanner.close();
    }

    public static String findSolution(int[] num, String str, int i, boolean isC) {
        int k = i - 2;
        if (i == num.length - 2 && k >= 2) {
            return "IMPOSSIBLE";
        }

        str += isC ? "C" : "J";

        if (num[i + 1] <= num[i + 2]) {
            while (num[i + 1] <= num[i + 2]) {
                str += isC ? "C" : "J";
                i += 2;
                if (i == num.length - 2) {
                    return str;
                }
            }
            return findSolution(num, str, i + 2, !isC);
        } else {
            return findSolution(num, str, i + 2, !isC);
        }
    }
}