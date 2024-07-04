import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int T = in.nextInt();
        in.nextLine();

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            String currentLine = in.nextLine();
            StringBuilder sb = new StringBuilder();

            int previousDigit = 0;
            for (char curr : currentLine.toCharArray()) {
                int currentDigit = Character.getNumericValue(curr);

                while (previousDigit < currentDigit) {
                    sb.append('(');
                    previousDigit++;
                }
                while (previousDigit > currentDigit) {
                    sb.append(')');
                    previousDigit--;
                }
                sb.append(currentDigit);
            }

            while (previousDigit > 0) {
                sb.append(')');
                previousDigit--;
            }

            System.out.println("Case #" + caseNum + ": " + sb);
        }
    }
}