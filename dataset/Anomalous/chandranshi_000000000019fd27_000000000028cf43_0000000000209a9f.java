import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringBuilder ans = new StringBuilder("Case #" + (i + 1) + ": ");
            String s = br.readLine();
            boolean isOpen = false;

            for (int j = 0; j < s.length(); j++) {
                char k = s.charAt(j);
                if (k == '0') {
                    if (isOpen) {
                        ans.append(')');
                        isOpen = false;
                    }
                    ans.append(k);
                } else {
                    if (!isOpen) {
                        ans.append('(');
                        isOpen = true;
                    }
                    ans.append(k);
                }
            }

            if (isOpen) {
                ans.append(')');
            }

            System.out.println(ans);
        }
    }
}