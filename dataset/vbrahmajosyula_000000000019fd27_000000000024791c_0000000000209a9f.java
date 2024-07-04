import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 0; i < t; i++) {
            compute(in, i);
        }
    }

    private static void compute(Scanner in, int test) {
        StringBuilder builder = new StringBuilder();
        int leftOpen = 0;

        String line = in.nextLine();

        for (char c : line.toCharArray()) {
            int number = Character.getNumericValue(c);

            if (leftOpen > number) {
                builder.append(repeat(')', leftOpen - number));
            }

            if (number > leftOpen) {
                builder.append(repeat('(', number - leftOpen));
            }

            leftOpen = number;
            builder.append(number);
        }

        if (leftOpen > 0) {
            builder.append(repeat(')', leftOpen));
        }


        System.out.printf("Case #%d: %s\n", test + 1, builder.toString());
    }

    static String repeat(char c, int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i< count; i++) {
            builder.append(c);
        }
        return builder.toString();
    }
}
