import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
static void add(StringBuilder sb, int a, char ch) {
    for(int i=0;i<a;i++) {
        sb.append(ch);
    }
}

public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        for(int k=0; k<T; k++) {
            String N = in.nextLine();
            StringBuilder sb = new StringBuilder();
            int a = N.charAt(0) - '0';
            add(sb, a, '(');
            sb.append(a);
            for(int i=1; i<N.length();i++) {
                int b = N.charAt(i)-'0';
                if (b<a) {
                 add(sb, a-b, ')');
                } else if (b>a) {
                 add(sb, b-a, '(');
                }
                sb.append(b);
                a=b;
            }
            add(sb, a, ')');
            System.out.println("Case #"+(k+1)+": "+sb.toString());
        }
    }
}