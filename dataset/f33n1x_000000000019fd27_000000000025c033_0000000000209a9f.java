import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        in.nextLine();
        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= tc; i++) {
            if(i==tc) {
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
                if (current == '0') {
                    if (start > 0) {
                        stringBuilder.append(')');
                        start--;
                    }
                } else {
                    if (start == 0) {
                        stringBuilder.append('(');
                        start++;
                    }
                }
                stringBuilder.append(current);
            }
            if (start > 0) {
                stringBuilder.append(')');
            }
            return new String(stringBuilder);
        }
    }
}
