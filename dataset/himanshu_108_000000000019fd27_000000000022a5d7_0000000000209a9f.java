import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class NestingDepth {
    static String nest (String n) {
        String str = "";

        int i, count = 0;
        char curr;
        Stack<Character> paren = new Stack<>();
        for (i = 0; i < n.length(); i++) {
            curr = n.charAt(i);
            if (count < (curr - '0')) {
                while (count != (curr - '0')) {
                    paren.push('(');
                    count++;
                }
            } else if (count > (curr - '0')) {
                while (count != (curr - '0')) {
                    paren.push(')');
                    count--;
                }
            }
            paren.push(curr);
        }
        if (i == n.length() && count != 0) {
            while (count != 0) {
                paren.push(')');
                count--;
            }
        }

        for (char c : paren) {
            str += c;
        }
        return str;
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int x = 1; x <= t; x++) {
            String n = br.readLine();
            System.out.println("Case #" + x + ": " + nest(n));
        }
    }
}
