import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    private static String output1 = "Case #%d: %s";
    private static String output2 = "Case #%d: *";
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution().getAnswer(caseNum, scanner);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAnswer(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        String[] p = new String[n];
        for (int i = 0; i < n; ++i) {
            p[i] = scanner.next();
        }
        Arrays.sort(p, (s1, s2) -> {
            int l1 = s1.length();
            int l2 = s2.length();
            if (l1 == l2) {
                return s1.compareTo(s2);
            } else {
                return l1 - l2;
            }
        });
        for (int i = 1; i < p.length; ++i) {
            if (!p[i].endsWith(p[i-1].substring(1))) {
                System.out.println(String.format(output2, caseNum));
                return;
            }
        }
        System.out.println(String.format(output1, caseNum, p[n-1].substring(1)));
    }
}
