import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(reader.readLine());

        for (int k = 1; k <= testCases; k++) {
            String number = reader.readLine();
            String result = solve(number);
            StringBuilder sb = new StringBuilder();
            sb.append("Case #" + k + ": " + result);
            System.out.println(sb.toString());
        }
    }

    public static String solve(String number) {
        StringBuilder result = new StringBuilder();
        int prev = 0;
        for (char c : number.toCharArray()) {
            int current = c - '0';
            int delta = current - prev;
            if (delta > 0) {
                while (delta > 0) {
                    result.append("(");
                    delta--;
                }
            }

            if (delta < 0) {
                while(delta < 0) {
                    result.append(")");
                    delta++;
                }
            }
            result.append(c);
            prev = current;
        }
        while (prev > 0) {
            result.append(")");
            prev--;
        }
        return result.toString();
    }
}
