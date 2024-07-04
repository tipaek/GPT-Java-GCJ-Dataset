import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            StringBuilder build = new StringBuilder();

            int j = 0;
            while (j < s.length()) {
                int cur = Character.getNumericValue(s.charAt(j));
                build.append("(".repeat(cur));
                build.append(cur);

                while (j < s.length() - 1 && Character.getNumericValue(s.charAt(j)) == Character.getNumericValue(s.charAt(j + 1))) {
                    build.append(cur);
                    j++;
                }
                build.append(")".repeat(cur));
                j++;
            }
            System.out.println("Case #" + (i + 1) + ": " + build);
        }

        br.close();
    }
}