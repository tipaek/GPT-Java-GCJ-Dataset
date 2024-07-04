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
        String longest = "";
        String[] matches = new String[N];
        for (int i = 0; i < N; i++) {
            br.read();
            String match = br.readLine();
            matches[i] = match;
            if (match.length() > longest.length()) longest = match;
        }

        boolean all = true;
        for (int i = 0; i < N; i++) {
            if (!longest.endsWith(matches[i])) {
                System.out.println(String.format("Case #%s: *", num));
                return;
            }
        }
        System.out.println(String.format("Case #%s: %s", num, longest));
    }
}