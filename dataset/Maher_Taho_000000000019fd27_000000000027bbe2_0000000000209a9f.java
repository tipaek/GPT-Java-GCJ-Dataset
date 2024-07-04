
import java.util.*;

public class Solution {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            StringBuilder build = new StringBuilder();
            char[] txt = in.next().toCharArray();
            int[] z = new int[txt.length];
            for (int i = 0; i < z.length; i++) {
                z[i] = Integer.valueOf(txt[i] + "");
            }
            int v = z[0];
            while (v-- > 0) {
                build.append("(");
            }
            build.append(z[0]);
            for (int i = 0; i < z.length - 1; i++) {
                int cur = z[i];
                int next = z[i + 1];
                if (next != 0) {
                    int dif = Math.abs(cur - next);
                    if (dif != 0) {
                        if (cur > next) {
                            while (dif-- > 0) {
                                build.append(")");
                            }
                        } else {
                            while (dif-- > 0) {
                                build.append("(");
                            }
                        }
                    }
                    build.append(next);
                } else {

                    while (cur-- > 0) {
                        build.append(")");
                    }
                    build.append("0");
                }
            }
            int last = z[z.length - 1];
            while (last-- > 0) {
                build.append(")");
            }
            System.out.println("Case #" + t + ": " + build.toString());
        }
    }

}
