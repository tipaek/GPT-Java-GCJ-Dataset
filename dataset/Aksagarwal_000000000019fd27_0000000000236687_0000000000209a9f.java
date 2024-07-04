
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
                if (ch == '0' && count == 0)
                    ans.append(ch);
                else if (ch == '0' && count != 0) {
                    ans.append(')').append(ch);
                    --count;
                } else if (ch == '1' && count == 0) {
                    ans.append('(').append(ch);
                    ++count;
                } else if (ch == '1' && count == 1)
                    ans.append(ch);
            }
            if (count == 1) ans.append(')');

            System.out.printf("Case #%d: %s\n", t, ans);

        }


    }

}
