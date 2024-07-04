import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scn.nextInt();
        int no = 1;
        scn.nextLine();
        while (t-- > 0) {
            StringBuilder sb = new StringBuilder("");
            String str = scn.nextLine();
            int s[] = new int[str.length()];
            for (int i = 0; i < str.length(); ++i) {
                s[i] = str.charAt(i) - 48;
            }
            int open = 0;
            for (int i = 0; i < s.length; ++i) {
                int x = s[i];
                if (x > open) {
                    for (int j = 0; j < (x - open); ++j) {
                        sb.append("(");
                    }
                    sb.append(s[i]);
                } else if (x == open) {
                    sb.append(s[i]);
                } else {
                    for (int j = 0; j < (open - x); ++j) {
                        sb.append(")");
                    }
                    sb.append(s[i]);
                }
                open = x;
            }
            while (open > 0) {
                sb.append(")");
                open--;
            }
            System.out.println("Case #" + no + ": " + sb.toString());
            no++;
        }
    }
}
