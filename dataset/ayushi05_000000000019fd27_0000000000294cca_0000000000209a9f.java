import java.io.*;

/**
 * Created by Ayushi on 04 Apr 2020.
 * Problem:
 * Round:
 */

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int z = 1; z <= t; z ++) {
            String a = br.readLine();
            StringBuilder ans = new StringBuilder();
            int l, c;
            c = 0;
            int o = 0;
            for (int i = 0; i < a.length(); i++) {
                l = c;
                c = Integer.parseInt(String.valueOf(a.charAt(i)));
                if (c < l) {
                    for (int x = 0; x < l-c; x++) {
                        ans.append(")");
                        o--;
                    }
                }
                if (c > l) {
                    for (int x = 0; x < c-l; x++) {
                        ans.append("(");
                        o++;
                    }
                }
                ans.append(c);
            }
            for (int x = 0; x < o; x++) ans.append(")");
            System.out.println("Case #" + z + ": " + ans);
        }
        br.close();
    }
}
