import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader rdr  = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(rdr);
        
        int t = Integer.parseInt(in.readLine());
        for (int i = 1; i <= t; i++) {
            StringBuilder ret = new StringBuilder();

            String s = in.readLine();
            int n = s.length();
            int n_brackets = 0;

            for (int j = 0; j < n; j++) {
                int val = s.charAt(j) - 48;
                if (val == n_brackets) {
                    ret.append(s.charAt(j));
                } else if (val > n_brackets) {
                    int diff = val - n_brackets;
                    char[] oc = new char[diff];
                    Arrays.fill(oc, '(');
                    String os = new String(oc);
                    ret.append(os);
                    ret.append(s.charAt(j));
                    n_brackets += diff;
                } else {
                    int diff = n_brackets - val;
                    char[] cc = new char[diff];
                    Arrays.fill(cc, ')');
                    String cs = new String(cc);
                    ret.append(cs);
                    ret.append(s.charAt(j));
                    n_brackets -= diff;
                }
            }
            if (n_brackets > 0) {
                char[] cc2 = new char[n_brackets];
                Arrays.fill(cc2, ')');
                String cs2 = new String(cc2);
                ret.append(cs2);
            }
            System.out.println("Case #" + i + ": " + ret.toString());
        }
    }
}
