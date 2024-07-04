import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int a = 1; a <= t; ++a) {

            calculate(a, in.next());
        }
    }

    private static void calculate(int number, String string) {
        System.out.println("Case #" + number + ": " + calculate(string));
    }

    private static String calculate(String string) {

        StringBuilder stringBuilder = new StringBuilder();

        int open = 0;
        for (char a : string.toCharArray()) {
            int number = a-48;


            while (number < open) {
                stringBuilder.append(")");
                open--;
            }

            while (number >  open) {

                stringBuilder.append("(");
                 open++;
            }

            stringBuilder.append(a);
        }
        while (open > 0) {
            stringBuilder.append(")");
            open --;
        }

        return stringBuilder.toString();
    }

}