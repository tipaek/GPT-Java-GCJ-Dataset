import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(reader.readLine());
            for (int t = 1; t <= T; t++) {
                String s = reader.readLine();
                StringBuilder ans = new StringBuilder();
                int openParentheses = 0;

                for (char ch : s.toCharArray()) {
                    if (ch == '0') {
                        if (openParentheses > 0) {
                            ans.append(')');
                            openParentheses--;
                        }
                        ans.append(ch);
                    } else if (ch == '1') {
                        if (openParentheses == 0) {
                            ans.append('(');
                            openParentheses++;
                        }
                        ans.append(ch);
                    }
                }

                while (openParentheses > 0) {
                    ans.append(')');
                    openParentheses--;
                }

                System.out.printf("Case #%d: %s\n", t, ans);
            }
        }
    }
}