import java.util.Objects;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            String S = sc.nextLine();
            StringBuilder ret = new StringBuilder();
            int oldVal = 0;
            for (int i = 0; i < S.length(); i++) {
                int val = Integer.parseInt(String.valueOf(S.charAt(i)));
                if (oldVal == 0 && val == 1) {
                    ret.append("(").append(val);
                } else if (oldVal == 1 && val == 0) {
                    ret.append(")").append(val);
                } else {
                    ret.append(val);
                }
                oldVal = val;
            }
            if (oldVal == 1) {
                ret.append(")");
            }
//            output[t] = "Case #" + t + 1 + ": " + ret;
            int k = t + 1;
            System.out.println("Case #" + k + ": " + ret);
        }
    }
}