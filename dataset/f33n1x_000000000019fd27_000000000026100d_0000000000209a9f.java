import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        in.nextLine();
        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= tc; i++) {
            if (i == tc) {
                output.append("Case #" + i + ": " + calculate(in.nextLine()));
            } else {
                output.append("Case #" + i + ": " + calculate(in.nextLine()) + "\n");
            }
        }
        System.out.println(output);
    }

    private static String calculate(String input) {
        if (null == input || input.isEmpty()) {
            return "";
        } else {
            int start = 0, j = 0;
            int length = input.length();
            StringBuilder stringBuilder = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                char current = input.charAt(i);
                int currentInt = Character.getNumericValue(current);
                if (start > currentInt) {
                    int diff = start - currentInt;
                    for (int c = 0; c < diff; c++) {
                        stringBuilder.append(')');
                    }
                    start -= diff;
                } else if (start < currentInt) {
                    int diff = currentInt - start;
                    for (int c = 0; c < diff; c++) {
                        stringBuilder.append('(');
                    }
                    start += diff;
                }
                stringBuilder.append(current);
            }
            for (int c = 0; c < start; c++) {
                stringBuilder.append(')');
            }
            return new String(stringBuilder);
        }
    }
}
