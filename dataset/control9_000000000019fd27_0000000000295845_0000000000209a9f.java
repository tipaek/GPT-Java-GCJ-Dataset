
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Solution {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        makeNumbersText();
        int t = nextIntFromStr();
        for (int cn = 1; cn <= t; cn++) {
            String s = next();
            char[] ch = s.toCharArray();

            StringBuilder sb = new StringBuilder();
            int braces = 0;

            for (int i = 0; i < ch.length; i++) {
                int cur = ch[i] - '0';
                if (braces < cur) {
                    int add = cur - braces;
                    for (int z = 0; z < add; z++) {
                        sb.append("(");
                    }
                }
                if (braces > cur) {
                    int add = braces - cur;
                    for (int z = 0; z < add; z++) {
                        sb.append(")");
                    }
                }
                braces = cur;
                sb.append(cur);
            }
            for (int z = 0; z < braces; z++) {
                sb.append(")");
            }
            System.out.print("Case #");
            System.out.print(cn);
            System.out.print(": ");
            System.out.println(sb.toString());

            System.out.flush();
        }
    }

    static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    static int nextIntFromStr() throws IOException {
        in.nextToken();
        return Integer.valueOf(in.sval);
    }

    private static void makeNumbersText() {
        in.resetSyntax();
        in.wordChars('a', 'z');
        in.wordChars('A', 'Z');
        in.wordChars(128 + 32, 255);
        in.whitespaceChars(0, ' ');
        in.commentChar('/');
        in.quoteChar('"');
        in.quoteChar('\'');
        in.wordChars('0', '9');
    }

    static String next() throws IOException {
        in.nextToken();
        return in.sval;
    }
}
