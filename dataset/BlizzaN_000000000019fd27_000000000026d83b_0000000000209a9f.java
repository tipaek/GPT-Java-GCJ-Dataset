import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static String solve(String input) {
        StringBuilder sb = new StringBuilder();
        char[] c = input.toCharArray();

        //Check if input length is only 1
        if (input.length() == 1) {
            for (int i = 0; i < (c[input.length() - 1] - 48); i++) {
                sb.append("(");
            }
            sb.append(c[0]);
            for (int i = 0; i < (c[input.length() - 1] - 48); i++) {
                sb.append(")");
            }

            return sb.toString();
        }

        for (int j = 0; j < c[0] - 48; j++) {
            sb.append("(");
        }
        sb.append(c[0]);

        for (int i = 1; i < c.length; i++) {

            //Calculate diff between current and precious char
            int diff = (c[i] - 48) - (c[i - 1] - 48);

            if (diff > 0) {
                for (int k = 0; k < diff; k++) {
                    sb.append("(");
                }
                sb.append(c[i]);
            } else {
                int diffAbs = Math.abs((c[i] - 48) - (c[i - 1] - 48));
                for (int k = 0; k < diffAbs; k++) {
                    sb.append(")");
                }
                sb.append(c[i]);
            }
        }

        for (int i = 0; i < (c[input.length() - 1] - 48); i++) {
            sb.append(")");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        //InputStream is = new FileInputStream("src/main/resources/qualification/nestingDepth");
        InputStream is = System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                String input = scanner.next();
                System.out.println("Case #" + testNumber + ": " + solve(input));

            }
        }
    }
}
