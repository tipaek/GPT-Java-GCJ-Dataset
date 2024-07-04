import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            String num = scanner.next();
            System.out.print("Case #" + (i + 1) + ": ");
            int count = 0;
            for (int j = 0; j < num.length(); j++) {
                int depth = Character.getNumericValue(num.charAt(j));
                for (; count < depth; count++)
                    System.out.print("(");
                for (; count > depth; count--)
                    System.out.print(")");
                System.out.print(depth);
            }
            for (; count > 0; count--)
                System.out.print(")");
            System.out.println();
        }
    }
}
