import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int z = 1; z <= t; z++) {
            String str = br.readLine();
            StringBuilder res = new StringBuilder();

            int prev = 0;
            int curr;

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                curr = Character.getNumericValue(ch);
                int diff = prev - curr;

                if (diff < 0) {
                    while (diff++ < 0) res.append("(");
                    res.append(ch);
                } else if (diff == 0) {
                    res.append(ch);
                } else {
                    while (diff-- > 0) res.append(")");
                    res.append(ch);
                }
                prev = curr;
            }

            for (int i = 0; i < curr; i++) res.append(")");

            System.out.println("Case #" + z + ": " + res.toString());
        }
    }
}