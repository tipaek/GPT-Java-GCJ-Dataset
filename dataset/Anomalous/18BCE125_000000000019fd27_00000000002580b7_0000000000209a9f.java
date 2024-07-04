import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            String s = in.next();
            StringBuilder s1 = new StringBuilder();

            int a = Character.getNumericValue(s.charAt(0));
            appendCharacters(s1, '(', a);
            s1.append(s.charAt(0));

            for (int j = 0; j < s.length() - 1; j++) {
                a = Character.getNumericValue(s.charAt(j));
                int b = Character.getNumericValue(s.charAt(j + 1));

                if (a > b) {
                    appendCharacters(s1, ')', a - b);
                } else if (a < b) {
                    appendCharacters(s1, '(', b - a);
                }
                s1.append(s.charAt(j + 1));
            }

            int lastDigit = Character.getNumericValue(s.charAt(s.length() - 1));
            appendCharacters(s1, ')', lastDigit);

            System.out.println(s1);
        }
    }

    private static void appendCharacters(StringBuilder sb, char ch, int count) {
        for (int k = 0; k < count; k++) {
            sb.append(ch);
        }
    }
}