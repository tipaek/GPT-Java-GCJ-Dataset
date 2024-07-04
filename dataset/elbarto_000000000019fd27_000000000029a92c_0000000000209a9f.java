import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long cases = scanner.nextLong();

        for (long index = 1; index <= cases; index++) {
            String line = scanner.next();
            StringBuilder sb = new StringBuilder();

            int deep = 0;
            for (int i = 0; i < line.length(); i++) {
                int digit = Integer.parseInt(line.substring(i, i + 1));

                if (digit > deep) {
                    sb.append(printChar(digit - deep, "("));
                    deep = digit;
                } else if (digit < deep) {
                    sb.append(printChar(deep - digit, ")"));
                    deep = digit;
                }
                sb.append(digit);
            }
            if (deep > 0) {
                sb.append(printChar(deep, ")"));
            }
            System.out.println(String.format("Case #%d: %s", index, sb.toString()));
        }
    }

    private static String printChar(int n, String str) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(str);
            n--;
        }
        return sb.toString();
    }
}
