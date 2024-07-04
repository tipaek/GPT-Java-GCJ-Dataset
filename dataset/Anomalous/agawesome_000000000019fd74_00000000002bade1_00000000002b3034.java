import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    static class StringLengthComparator implements Comparator<String> {
        @Override
        public int compare(String x, String y) {
            return Integer.compare(x.length(), y.length());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            int m = scanner.nextInt();
            String[] strs = new String[m];
            boolean works = true;

            for (int j = 0; j < m; j++) {
                strs[j] = scanner.next().substring(1);
            }

            Arrays.sort(strs, new StringLengthComparator());

            for (int j = 1; j < m; j++) {
                if (!strs[j].contains(strs[j - 1])) {
                    System.out.println("Case #" + i + ": \\*");
                    works = false;
                    break;
                }
            }

            if (works) {
                System.out.println("Case #" + i + ": " + strs[m - 1]);
            }
        }

        scanner.close();
    }
}