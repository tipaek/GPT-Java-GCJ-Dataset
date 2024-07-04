import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int q = 1; q <= t; q++) {
            StringBuilder res = new StringBuilder();
            String s = sc.next();
            for (int x = 0; x < s.length(); ) {
                StringBuilder cur = new StringBuilder();
                char current = 0;
                while (x < s.length()) {
                    char temp = s.charAt(x);
                    if (cur.length() == 0) {
                        cur.append(current = temp);
                    } else {
                        if (temp == current)
                            cur.append(temp);
                        else
                            break;
                    }
                    x++;
                }
                int num = current - '0';
                for (int w = 0; w < num; w++) {
                    cur.insert(0, '(');
                    cur.append(')');
                }
                res.append(cur);
            }
            System.out.printf("Case #%d: %s\n", q, res);
        }
    }
}