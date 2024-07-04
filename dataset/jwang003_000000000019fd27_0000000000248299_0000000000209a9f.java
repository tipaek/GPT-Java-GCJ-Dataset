import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        in.nextLine();
        for (int i = 0; i < cases; i++) {
            String[] strD = in.nextLine().split("");
            int[] digits = new int[strD.length];
            for (int j = 0; j < strD.length; j++) {
                digits[j] = Integer.parseInt(strD[j]);
            }
            StringBuilder finalStr = new StringBuilder();
            int prev = 0;
            for (int j : digits) {
                int count = j - prev;
                if (Math.signum(count) == 1) {
                    finalStr.append("(".repeat(count));
                } else if (Math.signum(count) == -1) {
                    finalStr.append(")".repeat(Math.abs(count)));
                }
                finalStr.append(j);
                prev = j;
            }
            finalStr.append(")".repeat(digits[digits.length - 1]));
            int caseNum = i+1;
            System.out.println("Case #" + caseNum + ": " + finalStr);
        }
    }
}
