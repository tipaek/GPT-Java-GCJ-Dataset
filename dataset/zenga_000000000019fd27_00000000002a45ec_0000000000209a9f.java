import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String s = br.readLine();
            String result = "";

            int depth = 0;

            for (int i = 0; i < s.length(); i++) {
                int curr = s.charAt(i) - '0';

                if (depth < curr) {
                    while (depth < curr) {
                        result += "(";
                        depth++;
                    }
                } else if (depth > curr) {
                    while (depth > curr) {
                        result += ")";
                        depth--;
                    }
                }
                result += "" + s.charAt(i);
            }
            while (depth > 0) {
                result += ")";
                depth--;
            }

            System.out.printf("Case #%d: %s\n", t, result);
        }
    }
}
