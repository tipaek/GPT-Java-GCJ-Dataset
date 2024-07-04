import java.util.Scanner;

public class Solution {
    private static String output1 = "Case #%d: %s";
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
        char[] s = scanner.next().toCharArray();
        int[] n = new int[s.length];
        for (int i = 0; i < s.length; ++i) {
            n[i] = s[i] - '0';
        }
        int d = 0;
        StringBuilder sb = new StringBuilder();

        for (int i: n) {
            while(i > d) {
                sb.append('(');
                ++d;
            }
            while(i < d) {
                sb.append(')');
                --d;
            }
            sb.append(i);
        }


        while(0 < d) {
            sb.append(')');
            --d;
        }
        System.out.println(String.format(output1, caseNum, sb.toString()));
    }
}
