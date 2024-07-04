import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {

            String input = in.next();

            String output = nesting(input);

            System.out.println("Case #" + i + ": " + output);

        }
    }

    static String getNChars(int n, String ch) {
        return IntStream.range(0, n).mapToObj(c -> ch).collect(Collectors.joining(""));
    }

    static String nesting(String input) {

        int[] list = input.chars().map(i -> i - 48).toArray();

        String s = getNChars(list[0], "(");
        StringBuilder sb = new StringBuilder(s);
        sb.append(list[0]);

        for (int i = 1; i < list.length; i++) {
            s = "";
            if (list[i] > list[i - 1]) {
                s = getNChars(list[i] - list[i - 1], "(");
            } else if (list[i] < list[i - 1]) {
                s = getNChars(list[i - 1] - list[i], ")");
            }
            sb.append(s);
            sb.append(list[i]);
        }

        s = getNChars(list[list.length - 1], ")");
        sb.append(s);

        return sb.toString();

    }

}
