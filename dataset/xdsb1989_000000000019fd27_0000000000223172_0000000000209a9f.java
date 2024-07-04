import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        String[] result = new String[cases];
        for (int i = 1; i <= cases; ++i) {
            String input = in.nextLine();
            StringBuilder sb = new StringBuilder();

            for (int index = 0; index < input.length(); ) {
                if (input.charAt(index) == '1') {
                    sb.append('(');
                    int j = index;
                    while (j < input.length() && input.charAt(j) == '1') {
                        sb.append('1');
                        j++;
                    }
                    sb.append(')');
                    index = j;
                } else {
                    sb.append('0');
                    index++;
                }
            }
            result[i-1] = sb.toString();
            result[i-1] = "Case #" + i + ": " + result[i-1];
        }
        for (int i = 0; i < cases; i++) {
            System.out.println(result[i]);
        }
    }
}
