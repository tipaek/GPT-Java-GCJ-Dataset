import java.util.*;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int t = scanner.nextInt();
        String w = scanner.nextLine();
        for (int i = 0; i < t; i++) {
            String str = scanner.nextLine();
            int length = str.length();
            str = str + "0";
            System.out.print("Case #" + (i + 1) + ": ");
            int opening = str.charAt(0) - '0';
            for (int j = 0; j < opening; j++) {
                System.out.print("(");
            }
            for (int j = 0; j < length; j++) {
                System.out.print(str.charAt(j));
                int diff = str.charAt(j + 1) - str.charAt(j);
                if (diff > 0) {
                    for (int k = 0; k < diff; k++) {
                        System.out.print("(");
                    }
                } else if (diff < 0) {
                    for (int k = 0; k < Math.abs(diff); k++) {
                        System.out.print(")");
                    }
                }
            }
            System.out.println();
        }
    }
}