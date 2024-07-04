package codejam.xl.nestingdepth;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        input.nextLine();
        for (int ks = 1; ks <= T; ks++) {
            String line = input.nextLine();
            System.out.println("Case #" + ks + ": " + processLine(line));
        }
    }

    private static String processLine(String line) {
        StringBuilder result = new StringBuilder();
        boolean isOpen = false;
        for (char c : line.toCharArray()) {
            if (c == '1') {
                if (!isOpen) {
                    result.append("(");
                    isOpen = true;
                }
            } else {
                if (isOpen) {
                    result.append(")");
                    isOpen = false;
                }
            }
            result.append(c);
        }
        if (isOpen) {
            result.append(")");
        }
        return result.toString();
    }
}