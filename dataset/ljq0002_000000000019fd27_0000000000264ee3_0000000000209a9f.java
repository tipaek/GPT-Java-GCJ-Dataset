import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= T; i++) {
            String s = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            int pre = 0;
            for(char c: s.toCharArray()) {
                int cur = c - '0';
                if(cur == pre) {
                    sb.append(c);
                } else if(cur > pre) {
                    for(int j = 0;j< cur - pre;j++) sb.append('(');
                    pre = cur;
                    sb.append(c);
                } else {
                    for(int j = 0;j< pre - cur; j++) sb.append(')');
                    pre = cur;
                    sb.append(c);
                }
            }
            for(int j = 0; j< pre;j++) sb.append(')');
            System.out.println(sb.toString());
        }

    }
}

