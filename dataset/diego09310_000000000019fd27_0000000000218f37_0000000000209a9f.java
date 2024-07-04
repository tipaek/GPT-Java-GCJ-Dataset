import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        in.nextLine();

        for (int i = 0; i < T; i++) {
            String s = in.nextLine();

            StringBuilder s2 = new StringBuilder();
            int p_open = 0;

            for (char c : s.toCharArray()) {
                int n = Character.getNumericValue(c);
                if (n < p_open) {
                    while (p_open > n) {
                        s2.append(")");
                        p_open--;
                    }
                    s2.append(n);
                    continue;
                }
                if (n == p_open) {
                    s2.append(n);
                }
                if (n > p_open) {
                    while (p_open < n) {
                        s2.append("(");
                        p_open++;
                    }
                    s2.append(n);
                    continue;
                }
            }

            while (p_open > 0) {
                s2.append(")");
                p_open--;
            }

            System.out.println("Case #" + (i+1) + ": " + s2.toString());

        }

        in.close();
    }
}
