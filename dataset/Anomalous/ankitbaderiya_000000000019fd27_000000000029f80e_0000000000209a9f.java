import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tt = 0; tt < t; tt++) {
            String s = br.readLine();
            int brac = 0;
            StringBuilder sb = new StringBuilder();

            for (char ch : s.toCharArray()) {
                int val = ch - '0';
                if (val > brac) {
                    sb.append(repeatChar('(', val - brac));
                } else if (val < brac) {
                    sb.append(repeatChar(')', brac - val));
                }
                sb.append(ch);
                brac = val;
            }

            if (brac > 0) {
                sb.append(repeatChar(')', brac));
            }

            System.out.println(sb.toString());
        }
    }

    private static String repeatChar(char ch, int count) {
        return String.join("", Collections.nCopies(count, String.valueOf(ch)));
    }
}