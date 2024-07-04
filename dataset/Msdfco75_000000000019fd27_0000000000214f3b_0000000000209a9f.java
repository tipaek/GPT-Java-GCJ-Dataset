
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            String s = in.next();

            String res = "";
            int open = 0;
            for (int j = 0; j < s.length(); j++) {
                int e = s.charAt(j) - '0';
                if (e > open) {
                    for (int k = 0; k < e - open; k++) {
                        res += "(";
                    }
                    open += e - open;
                } else if (e < open) {
                    for (int k = 0; k < open - e; k++) {
                        res += ")";
                    }
                    open -= open - e;
                }
                res += e;
            }
            for (int j = 0; j < open; j++) {
                res+=")";
            }

            System.out.println("Case #" + (i + 1) + ": " + res);
        }
    }

}
