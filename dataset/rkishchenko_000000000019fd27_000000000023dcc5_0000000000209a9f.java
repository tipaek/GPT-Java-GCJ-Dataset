import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            String solution = parenthesise(scanner.nextLine());
            System.out.println("Case #" + (i + 1) + ": " + solution);
        }
    }

    private static String parenthesise(String s) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (int i = 0; i < s.length(); i++) {
            int v = Character.getNumericValue(s.charAt(i));
            while (v > level) {
                sb.append('(');
                level++;
            }
            while (level > v) {
                sb.append(')');
                level--;
            }
            sb.append(v);
        }

        while (level > 0) {
            sb.append(')');
            level--;
        }

        return sb.toString();
    }
}