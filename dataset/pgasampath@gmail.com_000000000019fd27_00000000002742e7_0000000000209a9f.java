import java.util.Objects;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            String S = sc.nextLine();
            if (Objects.equals(S, "")) {
                S = sc.nextLine();
            }
            StringBuilder ret = new StringBuilder();
            int oldVal = 0;
            for (int i = 0; i < S.length(); i++) {
                int val = Integer.parseInt(String.valueOf(S.charAt(i)));

                if (oldVal == val) {
                    // Do nothing
                } else if (oldVal > val) {
                    for (int k = 0; k < oldVal - val; k++) {
                        ret.append(")");
                    }
                } else if (oldVal < val) {
                    for (int k = 0; k < val - oldVal; k++) {
                        ret.append("(");
                    }
                }
                ret.append(val);
                oldVal = val;
            }
            for(int k=0;k<oldVal;k++) {
                ret.append(")");
            }
            int k = t + 1;
            System.out.println("Case #" + k + ": " + ret);
        }
    }
}