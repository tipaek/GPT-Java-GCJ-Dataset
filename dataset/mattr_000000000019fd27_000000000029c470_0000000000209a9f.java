import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            doCase(in, i);
        }
    }

    private static void doCase(Scanner sc, int caseNumber) {
        String line = sc.nextLine();
        LinkedList<Integer> inputs = new LinkedList<>();
        for (int i = 0; i < line.length(); i++){
            char c = line.charAt(i);
            try {
                int x = Integer.parseInt(Character.toString(c));
                inputs.addLast(x);
            } catch (Exception e) {
                continue;
            }
        }

        StringBuilder sb = new StringBuilder();
        int depth = 0;

        for (Integer i : inputs) {
            if (i == depth) {
                sb.append(i);
            } else if (i > depth) {
                for (int j = depth; j < i; j++) {
                    sb.append("(");
                    depth++;
                }
                sb.append(i);
            } else {
                for (int j = i; j < depth; j++) {
                    sb.append(")");
                    depth--;
                }
                sb.append(i);
            }
        }

        for (int j = 0; j < depth; j++) {
            sb.append(")");
        }

        System.out.println("Case #" + Integer.toString(caseNumber) + ": " + sb.toString());
    }

}
