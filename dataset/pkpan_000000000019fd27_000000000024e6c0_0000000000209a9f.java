import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tc = 1 ; tc <= tests ; tc++) {

            String vals = scanner.nextLine();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            System.out.println("Case #" + tc + ": " + brace(vals));
        }

        scanner.close();
    }

    private static String brace(String vals) {
        StringBuilder sb = new StringBuilder();
        short braceCount = 0;

        for (int i = 0 ; i < vals.length() ; i++) {
            short val = (short) (vals.charAt(i) - '0');

            if (val == braceCount) {
                sb.append(val);
            } else if (val > braceCount) {
                for ( ; val > braceCount ; braceCount++) {
                    sb.append('(');
                }
                sb.append(val);
            } else {
                for ( ; val < braceCount ; braceCount--) {
                    sb.append(')');
                }
                sb.append(val);
            }
        }

        for ( ; braceCount > 0 ; braceCount--) {
            sb.append(')');
        }

        return sb.toString();
    }
}