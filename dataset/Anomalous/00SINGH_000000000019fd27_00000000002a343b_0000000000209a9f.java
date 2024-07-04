import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {
            String inputString = br.readLine();
            int length = inputString.length();
            StringBuilder result = new StringBuilder();
            int pos = 0;

            for (int i = 0; i < length; i++) {
                if (i < pos) {
                    continue;
                } else if (inputString.charAt(i) == '0') {
                    result.append('0');
                } else {
                    pos = i + 1;
                    while (pos < length && inputString.charAt(pos) == '1') {
                        pos++;
                    }
                    result.append('(').append(inputString, i, pos).append(')');
                    i = pos - 1; // Update i to skip the processed part
                }
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}