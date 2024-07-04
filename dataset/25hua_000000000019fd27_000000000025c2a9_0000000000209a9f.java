
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseCount = sc.nextInt();
        sc.nextLine();
        for (int caseIndex = 1; caseIndex <= caseCount; caseIndex++) {
            String nums = sc.nextLine();
            StringBuilder builder = new StringBuilder();
            char pre = ' ';
            for (char c : nums.toCharArray()) {
                if (c == '0') {
                    if (pre == '1') {
                        builder.append(")");
                    }
                    builder.append(c);
                } else {
                    if (pre != c) {
                        builder.append("(");
                    }
                    builder.append(c);
                }
                pre = c;
            }
            if (pre == '1') {
                builder.append(")");
            }
            System.out.printf("Case #%d: %s\n", caseIndex, builder.toString());
        }
    }
}
