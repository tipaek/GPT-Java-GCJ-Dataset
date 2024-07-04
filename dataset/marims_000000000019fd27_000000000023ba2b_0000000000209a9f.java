import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCase = sc.nextInt();
        for (int k = 1; k <= testCase; k++) {
            System.out.printf("Case #%d: ", k);
            String S = sc.next();
            StringBuilder sb = new StringBuilder();
            int ph_counter = 0;
            char last = '0';
            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                int diff = c - last;
                if (diff == 0) {
                    sb.append(c);
                } else if (diff > 0) {
                    for (int j = 0; j < diff; j++) {
                        sb.append("(");
                    }
                    if (c > '0') {

                    }
                    sb.append(c);
                } else {
                    for (int j = diff; j < 0; j++) {
                        sb.append(")");
                    }
                    sb.append(c);
                }
                last = c;
            }
            int diff = last - '0';
            for (int i = 0; i < diff; i++) {
                sb.append(")");
            }
            System.out.println(sb.toString());

        }
    }
}