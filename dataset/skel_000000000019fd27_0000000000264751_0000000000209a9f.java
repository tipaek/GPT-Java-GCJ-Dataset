import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution  {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            int currentTest = 1;
            while (T-- > 0) {
                String digits = br.readLine();
                int len = digits.length();
                int currentDepth = 0;
                int currentPos = 0;
                System.out.printf("Case #%d: ", currentTest);
                while (currentPos < len) {
                    int nowDigit = digits.charAt(currentPos) - '0';
                    for (int d = currentDepth; d < nowDigit; d++) {
                        System.out.print("(");
                    }
                    for (int d = currentDepth; d > nowDigit; d--) {
                        System.out.print(")");
                    }
                    System.out.printf("%d", nowDigit);
                    currentPos++;
                    currentDepth = nowDigit;
                }

               for (int d = 0; d < currentDepth; d++)
                    System.out.print(")");
                System.out.print("\n");
                currentTest++;
            }
        } catch (IOException e) {

        }
    }
}
