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
        String[][] p = new String[n][2];
        for (int i = 0; i < n; ++i) {
            String temp = scanner.next();
            int star = temp.indexOf("*");
            p[i][0] = temp.substring(0, star);
            p[i][1] = temp.substring(star+1);
        }
        Arrays.sort(p, (s1, s2) -> {
            int l1 = s1[0].length();
            int l2 = s2[0].length();
            if (l1 == l2) {
                return s1[0].compareTo(s2[0]);
            } else {
                return l1 - l2;
            }
        });
        for (int i = 1; i < p.length; ++i) {
            if (!p[i][0].startsWith(p[i-1][0])) {
                System.out.println(String.format(output2, caseNum));
                return;
            }
        }

        Arrays.sort(p, (s1, s2) -> {
            int l1 = s1[1].length();
            int l2 = s2[1].length();
            if (l1 == l2) {
                return s1[1].compareTo(s2[1]);
            } else {
                return l1 - l2;
            }
        });
        for (int i = 1; i < p.length; ++i) {
            if (!p[i][1].endsWith(p[i-1][1])) {
                System.out.println(String.format(output2, caseNum));
                return;
            }
        }


        int max = 0;
        for (int i = 1; i < p.length; ++i) {
            if (p[i][0].length()> p[max][0].length()) {
                max = i;
            }
        }

        int max2 = 0;
        for (int i = 1; i < p.length; ++i) {
            if (p[i][1].length()> p[max][1].length()) {
                max2 = i;
            }
        }
        System.out.println(String.format(output1, caseNum, p[max][0] + p[max2][1]));
    }
}
