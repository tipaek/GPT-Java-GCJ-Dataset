import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        int C = 1;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String s = in.readLine();
            String nS = "";
            for (int i = 0; i < s.length(); ++i) {
                int num = s.charAt(i) - '0';
                for (int j = 0; j < num; ++j) {
                    nS += "(";
                }
                int cant = 1;
                for (int j = i + 1; j < s.length(); ++j) {
                    if (s.charAt(j) == s.charAt(i)) {
                        cant++;
                    } else break;
                }
                i += cant - 1;

                while (cant-- > 0)
                    nS += num;
                for (int j = 0; j < num; ++j) {
                    nS += ")";
                }
            }

            while (true) {
                boolean found = false;
                for (int i = 1; i < nS.length(); ++i) {
                    if (nS.charAt(i - 1) == ')' && nS.charAt(i) == '(') {
                        found = true;
                        nS = nS.substring(0, i - 1) + nS.substring(i + 1);
                    }
                }
                if (!found)
                    break;
            }

            sb.append("Case #" + (C++) + ": " + nS + "\n");
        }
        System.out.print(new String(sb));

    }
}
