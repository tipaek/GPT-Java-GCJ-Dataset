import java.util.Scanner;

public class Q2 {

    private static Scanner scanner;
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        scanner.nextLine();

        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        char[] characters = input.toCharArray();

        int currentNum = Character.getNumericValue(characters[0]);
        int openBrackets = currentNum;

        appendCharacters(result, '(', currentNum);
        result.append(currentNum);

        for (int i = 1; i < characters.length; i++) {
            int nextNum = Character.getNumericValue(characters[i]);

            if (nextNum > currentNum) {
                appendCharacters(result, '(', nextNum - currentNum);
            } else if (nextNum < currentNum) {
                appendCharacters(result, ')', currentNum - nextNum);
            }

            result.append(nextNum);
            currentNum = nextNum;
        }

        appendCharacters(result, ')', openBrackets);

        System.out.println("Case #" + (testCaseNumber++) + ": " + result.toString());
    }

    private static void appendCharacters(StringBuilder sb, char character, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(character);
        }
    }
}