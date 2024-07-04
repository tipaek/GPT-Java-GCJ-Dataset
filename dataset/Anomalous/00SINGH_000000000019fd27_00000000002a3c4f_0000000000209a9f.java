import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String SS = br.readLine();
            StringBuilder S2 = new StringBuilder();
            int ln = SS.length();
            int pos = 0;

            for (int i = 0; i < ln; i++) {
                if (i < pos) {
                    continue;
                } else if (SS.charAt(i) == '0') {
                    S2.append("0");
                } else {
                    pos = i + 1;
                    while (pos < ln && SS.charAt(pos) == '1') {
                        pos++;
                    }
                    S2.append("(").append(SS.substring(i, pos)).append(")");
                }
            }
            System.out.println("Case #" + t + ": " + S2);
        }
    }
}