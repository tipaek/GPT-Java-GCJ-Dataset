import java.util.Scanner;

public class Solution{
    private static String output1 = "Case #%d: %s";
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution_NestingDepth().getAnswer(caseNum, scanner);
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
        //do something

        for (int i = 0; i < n.length; ++i) {
            if (n[i] == 0) {
                sb.append("0");
            } else {
                if (i == 0 || n[i-1] == 0) {
                    sb.append("(");
                }
                sb.append("1");
                if (i == n.length-1 || n[i+1] == 0) {
                    sb.append(")");
                }
            }
        }

        System.out.println(String.format(output1, caseNum, sb.toString()));
    }
}