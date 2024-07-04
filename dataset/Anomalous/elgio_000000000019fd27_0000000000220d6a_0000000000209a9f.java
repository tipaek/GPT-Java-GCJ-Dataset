import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        in.nextLine();

        for (int count = 1; count <= T; count++) {
            String currentLine = in.nextLine();
            StringBuilder sb = new StringBuilder();

            int openBrackets = 0;
            int previousDigit = 0;

            for (char c : currentLine.toCharArray()) {
                int currentDigit = Character.getNumericValue(c);

                while (openBrackets < currentDigit) {
                    sb.append('(');
                    openBrackets++;
                }
                while (openBrackets > currentDigit) {
                    sb.append(')');
                    openBrackets--;
                }

                sb.append(currentDigit);
                previousDigit = currentDigit;
            }

            while (openBrackets > 0) {
                sb.append(')');
                openBrackets--;
            }

            System.out.println("Case #" + count + ": " + sb);
        }
    }
}