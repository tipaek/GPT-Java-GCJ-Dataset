import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            for (int x = 1; x <= T; x++) {
                String str = br.readLine();
                String result = processString(str);
                System.out.println("Case #" + x + ": " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String processString(String str) {
        int depth = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            int targetDepth = ch - '0';
            while (depth < targetDepth) {
                sb.append('(');
                depth++;
            }
            while (depth > targetDepth) {
                sb.append(')');
                depth--;
            }
            sb.append(ch);
        }
        while (depth > 0) {
            sb.append(')');
            depth--;
        }
        return sb.toString();
    }
}