import java.io.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nt = Integer.parseInt(br.readLine());
        for (int t = 1; t <= nt; ++t) {
            char[] cs = br.readLine().toCharArray();
            int curDep = 0, reqDep = 0;
            StringBuilder sb = new StringBuilder();
            for (char c : cs) {
                reqDep = c - '0';
                if (curDep < reqDep) {
                    while (curDep < reqDep) {
                        sb.append('(');
                        curDep++;
                    }
                } else if (curDep > reqDep) {
                    while (curDep > reqDep) {
                        sb.append(')');
                        curDep--;
                    }
                }
                sb.append(c);
            }
            while (0 < curDep--) sb.append(')');
            System.out.format("Case #%d: %s\n", t, sb.toString());
        }
        br.close();
    }
}
