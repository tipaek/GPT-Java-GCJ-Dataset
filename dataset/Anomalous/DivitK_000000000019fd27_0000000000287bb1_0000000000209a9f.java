import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tt = 0; tt < t; tt++) {
            String s = br.readLine();
            int n = s.length();
            int brac = 0;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                int val = s.charAt(i) - '0';

                if (val == brac) {
                    sb.append(s.charAt(i));
                } else if (val > brac) {
                    sb.append(generateBraces(val - brac, '(')).append(s.charAt(i));
                    brac = val;
                } else {
                    sb.append(generateBraces(brac - val, ')')).append(s.charAt(i));
                    brac = val;
                }
            }

            if (brac > 0) {
                sb.append(generateBraces(brac, ')'));
            }

            System.out.println(sb.toString());
        }
    }

    private static String generateBraces(int count, char brace) {
        return String.join("", Collections.nCopies(count, String.valueOf(brace)));
    }
}