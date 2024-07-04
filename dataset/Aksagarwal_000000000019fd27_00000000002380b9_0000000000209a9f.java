
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 1; t <= T; t++) {
            String s = reader.readLine();
            StringBuilder ans = new StringBuilder();
            int count = 0;
            for (char ch : s.toCharArray()) {
                int diff = (ch - '0') - count;
                count+=diff;
                append(ans, diff);
                ans.append(ch);
            }
            if (count != 0)
                append(ans, count * -1);

            System.out.printf("Case #%d: %s\n", t, ans);

        }


    }

    private static void append(StringBuilder ans, int count) {
        char brace = count < 0 ? ')' : '(';
        count = Math.abs(count);
        for (int i = 0; i < count; i++)
            ans.append(brace);
    }

}
