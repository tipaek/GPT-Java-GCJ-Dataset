import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for(int p=1;p<=t;p++) {
            String s = br.readLine();
            StringBuilder sb = new StringBuilder();
            int x = 0;
            for(int i=0;i<s.length();i++) {
                int y = s.charAt(i) - 48;
                if(x > y) {
                    y(sb, x-y);
                    sb.append(y);
                } else if(x < y) {
                    x(sb, y-x);
                    sb.append(y);
                } else {
                    sb.append(y);
                }
                x = y;
            }
            y(sb, x);
            pw.println("Case #"+p+": "+sb.toString());
        }
        pw.close();
        br.close();
    }
    static StringBuilder x(StringBuilder sb, int x) {
        while(x-->0) {
            sb.append("(");
        }
        return sb;
    }
    static StringBuilder y(StringBuilder sb, int x) {
        while(x-->0) {
            sb.append(")");
        }
        return sb;
    }
}