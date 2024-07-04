import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tc = 1 ; tc <= tests ; tc++) {

            String vals = scanner.nextLine();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            System.out.println("Case #" + tc + ": " + solve(vals));
        }

        scanner.close();
    }

    private static String solve(String input) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = 0 ; i < input.length() ; i++) {
            int number =  input.charAt(i) - '0';

            if (number == count) {
                sb.append(number);
            } else if (number > count) {
                for ( ; number > count ; count++) {
                    sb.append('(');
                }
                sb.append(number);
            } else {
                for ( ; number < count ; count--) {
                    sb.append(')');
                }
                sb.append(number);
            }
        }

        for ( ; count > 0 ; count--) {
            sb.append(')');
        }

        return sb.toString();
    }
}
