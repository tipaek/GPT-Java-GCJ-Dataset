import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine();
            int[] a = s.chars().map(x -> x - '0').toArray();
            System.out.println("Case #" + i + ": " + nest(a));
        }
    }

    private static String nest(int[] original) {
        int[] a = Arrays.copyOf(original, original.length);
        int[] open = new int[a.length];
        int[] close = new int[a.length];
        boolean repeat;

        do {
            repeat = false;

            for (int i = 0; i < a.length; i++) {
                if (a[i] > 0) {
                    repeat = true;
                    open[i]++;
                    for (; i < a.length && a[i] > 0; i++)
                        a[i]--;

                    close[i - 1]++;
                }
            }
        } while (repeat);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < open[i]; j++) {
                sb.append('(');
            }

            sb.append(original[i]);

            for (int j = 0; j < close[i]; j++) {
                sb.append(')');
            }
        }

        return sb.toString();
    }
}