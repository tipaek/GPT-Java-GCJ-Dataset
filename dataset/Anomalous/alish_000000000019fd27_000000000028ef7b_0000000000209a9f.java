import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        input.nextLine(); // Consume the newline character after the integer input

        for (int k = 1; k <= cases; k++) {
            String str = input.nextLine();
            LinkedList<Character> list = new LinkedList<>();

            int firstDigit = Character.getNumericValue(str.charAt(0));
            addCharacters(list, '(', firstDigit);
            list.add(str.charAt(0));

            for (int i = 0; i < str.length() - 1; i++) {
                int cur = Character.getNumericValue(str.charAt(i));
                int next = Character.getNumericValue(str.charAt(i + 1));
                if (cur > next) {
                    addCharacters(list, ')', cur - next);
                } else if (cur < next) {
                    addCharacters(list, '(', next - cur);
                }
                list.add(str.charAt(i + 1));
            }

            int lastDigit = Character.getNumericValue(str.charAt(str.length() - 1));
            addCharacters(list, ')', lastDigit);

            System.out.print("Case #" + k + ": ");
            for (char c : list) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static void addCharacters(LinkedList<Character> list, char ch, int count) {
        for (int i = 0; i < count; i++) {
            list.add(ch);
        }
    }
}