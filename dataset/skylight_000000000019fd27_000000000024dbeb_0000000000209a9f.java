import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            String digits = sc.next();
            StringBuilder result = new StringBuilder();
            result.append("Case #").append(i+1).append(": ");
            int depth = 0;
            for(int j = 0; j < digits.length(); j++) {
                int current = digits.charAt(j) - '0';
                while (current > depth) {
                    result.append('(');
                    depth++;
                }
                while (current < depth) {
                    result.append(')');
                    depth--;
                }
                result.append(current);
            }

            while (depth > 0) {
                result.append(')');
                depth--;
            }
            System.out.println(result);
        }
    }
}
