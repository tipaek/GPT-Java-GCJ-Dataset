import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt(); in.nextLine();
        for (int t = 1; t <= T; t++) {
            String S = in.nextLine();
            StringBuilder s = new StringBuilder();
            for (int i = 0, cnt = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                int val = Character.getNumericValue(c);
                while (val - cnt < 0) {
                    s.append(')');
                    cnt--;
                }
                while (val - cnt > 0) {
                    s.append('(');
                    cnt++;
                }
                s.append(c);
                if (i == S.length() - 1) {
                  while (cnt > 0) {
                    s.append(')');
                    cnt--;
                  }
                }
            }
            System.out.printf("Case #%d: %s\n", t, s.toString());
        }
    }
}