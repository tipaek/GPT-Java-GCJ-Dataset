import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for (int k = 1; k <= t; k++) {
            String str = sc.nextLine();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (int i = 0; i < str.length(); i++) {
                int value = Character.getNumericValue(str.charAt(i));

                if (value > openBrackets) {
                    for (int j = 0; j < value - openBrackets; j++) {
                        result.append('(');
                    }
                    openBrackets = value;
                } else if (value < openBrackets) {
                    for (int j = 0; j < openBrackets - value; j++) {
                        result.append(')');
                    }
                    openBrackets = value;
                }

                result.append(value);
            }

            for (int i = 0; i < openBrackets; i++) {
                result.append(')');
            }

            System.out.println("Case #" + k + ": " + result.toString());
        }
    }
}