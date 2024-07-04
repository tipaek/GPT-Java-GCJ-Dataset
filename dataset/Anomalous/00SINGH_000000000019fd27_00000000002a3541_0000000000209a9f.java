import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ABC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String input = br.readLine();
            int length = input.length();
            int pos = 0;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < length; i++) {
                if (i < pos) {
                    continue;
                } else if (input.charAt(i) == '0') {
                    result.append("0");
                } else {
                    pos = i + 1;
                    while (pos < length && input.charAt(pos) == '1') {
                        pos++;
                    }
                    result.append("(").append(input, i, pos).append(")");
                }
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}