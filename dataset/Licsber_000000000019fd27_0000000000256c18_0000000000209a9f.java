import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Soulution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        reader = new BufferedReader(new StringReader("4\n" +
//                "0000\n" +
//                "101\n" +
//                "111000\n" +
//                "1"));
//        "Case #1: 0000\n" +
//                "Case #2: (1)0(1)\n" +
//                "Case #3: (111)000\n" +
//                "Case #4: (1)"

        int T = Integer.parseInt(reader.readLine());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < T; i++) {
            result.append("Case #").append(i + 1).append(": ");
            String input = reader.readLine();
            int len = input.length();
            int last = 0;
            int depth = 0;
            for (int j = 0; j < len; j++) {
                int ch = input.charAt(j) - '0';
                int diff = ch - last;
                while (diff > 0 && depth < diff) {
                    depth++;
                    result.append("(");
                }
                while (diff < 0) {
                    depth--;
                    diff++;
                    result.append(")");
                }
                result.append(ch);
                last = ch;
            }
            while (depth != 0) {
                depth--;
                result.append(")");
            }
            result.append("\n");
        }
        System.out.print(result);
    }
}
