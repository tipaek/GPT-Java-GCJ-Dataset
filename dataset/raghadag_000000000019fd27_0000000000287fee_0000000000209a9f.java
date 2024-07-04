import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
        StringBuilder answer = new StringBuilder();
        for (int testCase = 1; testCase <= T; testCase++) {
            String inputString = input.readLine();
            StringBuilder s = new StringBuilder();
            int opening = 0;
            for (int i = 0; i < inputString.length(); i++) {
                int digit = Integer.parseInt(inputString.charAt(i) + "");
                int prenSize = digit - opening;
                String prefixString = createPrenString(prenSize);
                s.append(prefixString + digit);
                opening += prenSize;
            }
            s.append(createPrenString(0 - opening));
            answer.append("Case #" + testCase + ": " + s.toString() + "\n");
        }
        System.out.println(answer);
    }

    private static String createPrenString(int n) {
        if (n == 0)
            return "";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Math.abs(n); i++) {
            if (n < 0)
                result.append(")");
            else
                result.append("(");
        }
        return result.toString();
    }
}
