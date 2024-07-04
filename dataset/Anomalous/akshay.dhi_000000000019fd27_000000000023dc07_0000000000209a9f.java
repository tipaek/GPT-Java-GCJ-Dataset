import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {
            String s = br.readLine();
            StringBuilder result = new StringBuilder("Case #" + t + ": ");
            int level = 0;

            for (int i = 0; i < s.length(); i++) {
                int currLevel = s.charAt(i) - '0';

                while (level < currLevel) {
                    result.append('(');
                    level++;
                }
                while (level > currLevel) {
                    result.append(')');
                    level--;
                }

                result.append(s.charAt(i));
            }

            while (level > 0) {
                result.append(')');
                level--;
            }

            System.out.println(result.toString());
        }
    }
}