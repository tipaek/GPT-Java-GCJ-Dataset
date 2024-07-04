import java.util.*;

public class Solution {
    Scanner scanner = new Scanner(System.in);

    private void parentheses() {
        int test = scanner.nextInt();
        scanner.nextLine();
        for (int z = 0; z < test; z++) {
            String s = scanner.nextLine();
            int[] dec = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                dec[i] = Character.getNumericValue(s.charAt(i));
            }
            System.out.println();
            int number = z + 1;
            System.out.print("Case #" + number + ": ");
            int count = 0;
            for (int i = 0; i < dec.length; i++) {
                if (dec[i] > count) {
                    while (count < dec[i]) {
                        System.out.print("(");
                        count++;
                    }
                } else if (dec[i] < count) {
                    while (count > dec[i]) {
                        System.out.print(")");
                        count--;
                    }
                }
                System.out.print(dec[i]);
            }
            if (count > 0) {
                while (count > 0) {
                    System.out.print(")");
                    count--;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution nest = new Solution();
        nest.parentheses();
    }
}
