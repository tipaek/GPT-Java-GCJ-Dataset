import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseNum = in.nextInt();
        
        for (int caseIndex = 1; caseIndex <= caseNum; caseIndex++) {
            String str = in.next();

            int currentLevel = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                int num = Integer.parseInt(String.valueOf(str.charAt(i)));
                int diff = num - currentLevel;
                alignLevel(sb, diff);
                sb.append(num);
                currentLevel = num;
            }
            alignLevel(sb, -currentLevel);

            System.out.println("Case #" + caseIndex + ": " + sb.toString());
        }
    }

    private static void alignLevel(StringBuilder sb, int diff) {
        if (diff > 0) {
            for (int i = 0; i < diff; i++) {
                sb.append("(");
            }
        } else if (diff < 0) {
            for (int i = 0; i < Math.abs(diff); i++) {
                sb.append(")");
            }
        }
    }
}