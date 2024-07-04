import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();

        for (int cases = 0; cases < n; cases++) {
            sb.append("Case #").append(cases + 1).append(": ");

            char[] input = reader.readLine().toCharArray();
            int[] arr = new int[input.length];

            for (int i = 0; i < input.length; i++) {
                arr[i] = (Character.getNumericValue(input[i]));
            }

            int open = 0;

            for (Integer i : arr) {
                if (i > open) {
                    sb.append(repeatChars(i - open, '('));
                    open = i;
                    sb.append(i);
                } else if (i < open) {
                    sb.append(repeatChars(open - i, ')'));
                    sb.append(i);
                    open = open - i;
                }


            }
            sb.append(repeatChars(open, ')'));
            sb.append('\n');


        }
        System.out.println(sb.toString());
    }

    static String repeatChars(int count, char c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
}
