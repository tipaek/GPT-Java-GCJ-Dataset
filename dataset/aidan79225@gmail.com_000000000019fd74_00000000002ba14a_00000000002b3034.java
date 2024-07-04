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
    public int getCount(char[] temp) {
        int ans = 0;
        for (char c : temp) {
            if (c == '*') {
                ++ans;
            }
        }
        return ans;
    }
    public void getAnswer(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        String[][] p = new String[n][];
        for (int i = 0; i < n; ++i) {
            String temp = scanner.next();
            char[] tc = temp.toCharArray();
            int sc = getCount(tc);
            p[i] = new String[sc+1];
            int last = 0;
            int k = 0;
            for (int j = 0; j < tc.length; ++j) {
                if (tc[j] == '*') {
                    p[i][k] = temp.substring(last, j);
                    last = j+1;
                    ++k;
                }
            }
            if (last == tc.length) {
                p[i][k] = "";
            } else {
                p[i][k] = temp.substring(last);
            }
         }
//        for (String[] pc: p) {
//            for (String cc: pc) {
//                System.out.print(cc);
//            }
//            System.out.println();
//        }


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
            int la1 = s1.length-1;
            int la2 = s2.length-1;
            int l1 = s1[la1].length();
            int l2 = s2[la2].length();
            if (l1 == l2) {
                return s1[la1].compareTo(s2[la2]);
            } else {
                return l1 - l2;
            }
        });
        for (int i = 1; i < p.length; ++i) {

            if (!p[i][p[i].length-1].endsWith(p[i-1][p[i-1].length-1])) {
                System.out.println(String.format(output2, caseNum));
                return;
            }
        }


        StringBuilder sb = new StringBuilder();

        int max = 0;
        for (int i = 1; i < p.length; ++i) {
            if (p[i][0].length()> p[max][0].length()) {
                max = i;
            }
        }
        sb.append(p[max][0]);

        for (int i = 0; i < p.length; ++i) {
            int l = p[i].length-1;
            for (int j = 1; j < l; ++j) {
                sb.append(p[i][j]);
            }
        }



        int max2 = 0;
        for (int i = 1; i < p.length; ++i) {
            if (p[i][p[i].length-1].length()> p[max2][p[max2].length-1].length()) {
                max2 = i;
            }
        }
        sb.append(p[max2][p[max2].length-1]);
        System.out.println(String.format(output1, caseNum, sb));
    }
}
