import java.io.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            String input = br.readLine();
            StringBuilder output = new StringBuilder();
            char prev = '-';

            for (int i = 0; i < input.length(); i++) {
                char curr = input.charAt(i);

                if (curr == '0') {
                    if (prev == '1') {
                        output.append(")0");
                    } else {
                        output.append("0");
                    }
                } else {
                    if (prev == '1') {
                        output.append("1");
                    } else {
                        output.append("(1");
                    }
                }
                prev = curr;
            }

            if (input.charAt(input.length() - 1) == '1') {
                output.append(")");
            }

            System.out.println("Case #" + t + ": " + output.toString());
        }
    }
}