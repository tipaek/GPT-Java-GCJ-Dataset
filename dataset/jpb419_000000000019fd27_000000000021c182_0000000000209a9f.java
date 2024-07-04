import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        for (int casenum = 1; casenum <= T; casenum++) {
            String d = in.nextLine();
            System.out.printf("Case #%d: ", casenum);
            int bal = 0;
            for (char c : d.toCharArray()) {
                while (bal > c - '0') {
                    System.out.print(")");
                    bal--;
                }
                while (bal < c - '0') {
                    System.out.print("(");
                    bal++;
                }
                System.out.print(c);
            }
            while (bal --> 0) {
                System.out.print(")");
            }
            System.out.println();
        }
    }
}