import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();

        for (int c = 1; c <= cases; c++) {

            String number = scanner.next();

            int current = 0;
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < number.length(); i++) {

                int next = number.charAt(i) - '0';

                int diff = Math.abs(next - current);

                char toAdd = next > current ? '(' : ')';

                for (int j = 0; j < diff; j++) {
                    builder.append(toAdd);
                }
                builder.append(next);

                current = next;
            }

            for (int j = 0; j < current; j++) {
                builder.append(')');
            }

            System.out.println("Case #" + c + ": " + builder.toString());
        }
    }
}