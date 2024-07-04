import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            oneRun(i);
        }
    }

    private static void oneRun(int num) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String longestLeft = "", longestRight = "";
        String[] matches = new String[N];
        for (int i = 0; i < N; i++) {
            String match = br.readLine();
            int index = match.indexOf("*");
            matches[i] = match;
            if (index > longestLeft.length()) {
                longestLeft = match.substring(0, index);
            }
            if (match.length() - index - 1 > longestRight.length()) {
                longestRight = match.substring(index + 1);
            }
        }

        String word = longestLeft + longestRight;
        boolean all = true;
        for (int i = 0; i < N; i++) {
            if (!word.matches(matches[i].replace("*", ".*"))) {
                System.out.println(String.format("Case #%s: *", num));
                return;
            }
        }
        System.out.println(String.format("Case #%s: %s", num, word));
    }
}
