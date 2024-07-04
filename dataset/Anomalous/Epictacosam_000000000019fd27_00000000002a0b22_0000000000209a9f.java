import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();

        for (int i = 0; i < n; i++) {
            String initialString = stdin.next();
            char[] initialChar = initialString.toCharArray();

            int prevLevel = 0;
            int len = initialChar.length;
            System.out.print("Case #" + (i + 1) + ": ");

            for (int j = 0; j < len; j++) {
                int level = Character.getNumericValue(initialChar[j]);

                if (level > prevLevel) {
                    for (int k = 0; k < (level - prevLevel); k++) {
                        System.out.print("(");
                    }
                } else if (level < prevLevel) {
                    for (int k = 0; k < (prevLevel - level); k++) {
                        System.out.print(")");
                    }
                }

                System.out.print(initialChar[j]);
                prevLevel = level;

                if (j == (len - 1)) {
                    for (int k = level; k > 0; k--) {
                        System.out.print(")");
                    }
                }
            }

            System.out.println();
        }

        stdin.close();
    }
}