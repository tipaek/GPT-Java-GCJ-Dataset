import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();

        for (int i = 0; i < n; i++) {
            String initialString = stdin.next();
            char[] initialChars = initialString.toCharArray();
            int prevLevel = 0;

            System.out.print("Case #" + (i + 1) + ": ");

            for (int j = 0; j < initialChars.length; j++) {
                int currentLevel = Character.getNumericValue(initialChars[j]);

                if (currentLevel > prevLevel) {
                    for (int k = 0; k < (currentLevel - prevLevel); k++) {
                        System.out.print("(");
                    }
                } else if (currentLevel < prevLevel) {
                    for (int k = 0; k < (prevLevel - currentLevel); k++) {
                        System.out.print(")");
                    }
                }

                System.out.print(initialChars[j]);
                prevLevel = currentLevel;
            }

            for (int k = 0; k < prevLevel; k++) {
                System.out.print(")");
            }

            System.out.println();
        }

        stdin.close();
    }
}