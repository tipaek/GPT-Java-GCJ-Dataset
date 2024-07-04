import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Rene Argento on 03/04/20.
 */
// https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd74/00000000002b3034
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();

        for (int t = 0; t < tests; t++) {
            int numberOfPatterns = scanner.nextInt();
            String[] patterns = new String[numberOfPatterns];

            for (int i = 0; i < numberOfPatterns; i++) {
                patterns[i] = scanner.next();
            }
            String name = findName(patterns);
            System.out.println("Case #" + (t + 1) + ": " + name);
        }
    }

    private static final char PLACEHOLDER = '-';

    private static String findName(String[] patterns) {
        char[] start = new char[100];
        char[] end = new char[100];
        List<Character> middleCharacters = new ArrayList<>();

        for (int i = 0; i < start.length; i++) {
            start[i] = PLACEHOLDER;
            end[i] = PLACEHOLDER;
        }

        for (String pattern : patterns) {
            int firstAsterisk = pattern.indexOf('*');

            // Start
            for (int i = 0; i < firstAsterisk; i++) {
                if (start[i] == PLACEHOLDER) {
                    start[i] = pattern.charAt(i);
                } else {
                    if (start[i] != pattern.charAt(i)) {
                        return "*";
                    }
                }
            }

            // End
            int lastAsterisk;
            for (int i = pattern.length() - 1; true; i--) {
                if (pattern.charAt(i) == '*') {
                    lastAsterisk = i;
                    break;
                }

                int index = pattern.length() - 1 - i;

                if (end[index] == PLACEHOLDER) {
                    end[index] = pattern.charAt(i);
                } else {
                    if (end[index] != pattern.charAt(i)) {
                        return "*";
                    }
                }
            }

            // Middle
            for (int i = firstAsterisk + 1; i < lastAsterisk; i++) {
                if (pattern.charAt(i) != '*') {
                    middleCharacters.add(pattern.charAt(i));
                }
            }
        }

        StringBuilder name = new StringBuilder();
        for (char character : start) {
            if (character == PLACEHOLDER) {
                break;
            }
            name.append(character);
        }

        for (Character character : middleCharacters) {
            name.append(character);
        }

        StringBuilder nameReverse = new StringBuilder();
        for (char character : end) {
            if (character == PLACEHOLDER) {
                break;
            }
            nameReverse.append(character);
        }
        return name.append(nameReverse.reverse()).toString();
    }

}
