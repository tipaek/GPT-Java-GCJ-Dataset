import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();

        for (int i = 0; i < n; i++) {
            String initialString = stdin.next();
            char[] initialChar = initialString.toCharArray();

            int currentLevel = 0;
            int previousLevel = 0;
            int length = initialChar.length;

            System.out.print("Case #" + (i + 1) + ": ");
            for (int j = 0; j < length; j++) {
                currentLevel = Character.getNumericValue(initialChar[j]);

                if (currentLevel > previousLevel) {
                    for (int k = 0; k < (currentLevel - previousLevel); k++) {
                        System.out.print("(");
                    }
                } else if (currentLevel < previousLevel) {
                    for (int k = 0; k < (previousLevel - currentLevel); k++) {
                        System.out.print(")");
                    }
                }

                System.out.print(initialChar[j]);
                previousLevel = currentLevel;

                if (j == (length - 1)) {
                    for (int k = 0; k < currentLevel; k++) {
                        System.out.print(")");
                    }
                }
            }

            System.out.println();
        }

        stdin.close();
    }
}