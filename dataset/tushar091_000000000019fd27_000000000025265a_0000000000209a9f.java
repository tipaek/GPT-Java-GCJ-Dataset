

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= t; i++) {
            String s = scanner.nextLine();
            StringBuilder builder = new StringBuilder();
            int depth = 0;
            for (int j = 0; j < s.length() - 1; j++) {
                int currentDepth = s.charAt(j) - '0';
                for (int k = 0; k < currentDepth - depth; k++) {
                    builder.append("(");
                }
                builder.append(s.charAt(j));
                depth = currentDepth;
                int nextDepth = s.charAt(j + 1) - '0';
                int diff = depth - nextDepth;
                diff = Math.max(diff, 0);
                for (int k = 0; k < diff; k++) {
                    builder.append(")");
                }
            }
            int finalDepth = s.charAt(s.length() - 1) - '0';
            for (int k = 0; k < finalDepth - depth; k++) {
                builder.append("(");
            }
            builder.append(s.charAt(s.length()-1));
            int diff = finalDepth;
            for (int k = 0; k < diff; k++) {
                builder.append(")");
            }
            System.out.println(String.format("Case #%d: %s",i,builder.toString()));
        }
    }
}
