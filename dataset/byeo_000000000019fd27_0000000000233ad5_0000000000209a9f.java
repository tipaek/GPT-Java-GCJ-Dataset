import java.util.Scanner;

public class Solution {
    private static String nestingDepth(String line) {
        StringBuilder sb = new StringBuilder();

        int level = 0;

        for(char c : line.toCharArray()) {
            int toInt = Character.getNumericValue(c);
            int diff = toInt - level;
            if (diff > 0) {
                String openParens = multString('(', diff);
                sb.append(openParens);
            } else if (diff < 0) {
                String closeParens = multString(')', Math.abs(diff));
                sb.append(closeParens);
            }
            sb.append(toInt);
            level = toInt;
        }

        String lastClosing = multString(')', level);
        sb.append(lastClosing);

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] cases = readInput();
        for (int i = 0; i < cases.length; i++) {
            String ans = nestingDepth(cases[i]);

            StringBuilder sb = new StringBuilder();
            sb.append("Case #").append(i).append(": ").append(ans);
            System.out.println(sb.toString());
        }
    }

    private static String multString(char c, int freq) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < freq; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    private static String[] readInput() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); sc.nextLine();
        String[] digits = new String[T];

        for (int t = 0; t < T; t++) {
            digits[t] = sc.nextLine();
        }
        return digits;
    }
}