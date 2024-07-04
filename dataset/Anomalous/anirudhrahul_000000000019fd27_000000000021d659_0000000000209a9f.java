import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int cases = Integer.parseInt(br.readLine());

            for (int c = 1; c <= cases; c++) {
                wr.write("Case #" + c + ": ");
                String input = br.readLine();
                StringBuilder sb = new StringBuilder();
                int openBrackets = 0;

                for (int i = 0; i < input.length(); i++) {
                    int currentDigit = input.charAt(i) - '0';

                    while (openBrackets < currentDigit) {
                        sb.append("(");
                        openBrackets++;
                    }

                    while (openBrackets > currentDigit) {
                        sb.append(")");
                        openBrackets--;
                    }

                    sb.append(input.charAt(i));
                }

                while (openBrackets > 0) {
                    sb.append(")");
                    openBrackets--;
                }

                wr.write(sb.toString());
                wr.write("\n");
            }
        }
    }
}