import java.util.ArrayList;
import java.util.Scanner;

class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCases; t++) {
            String input = scanner.nextLine();
            String result = processInput(input, 0);
            System.out.printf("Case #%d: %s\n", t, result);
        }
    }

    static String processInput(String input, int level) {
        char[] characters = input.toCharArray();
        if (characters.length == 0) {
            return "";
        }

        ArrayList<String> segments = new ArrayList<>();
        int startIndex = 0;
        char expectedChar = (char) ('0' + level);

        for (int i = 1; i < characters.length; i++) {
            if (characters[startIndex] != expectedChar && characters[i] == expectedChar ||
                characters[startIndex] == expectedChar && characters[i] != expectedChar) {
                segments.add(new String(characters, startIndex, i - startIndex));
                startIndex = i;
            }
        }

        segments.add(new String(characters, startIndex, characters.length - startIndex));

        StringBuilder result = new StringBuilder();
        for (String segment : segments) {
            if (segment.charAt(0) == expectedChar) {
                result.append(segment);
            } else {
                result.append("(").append(processInput(segment, level + 1)).append(")");
            }
        }

        return result.toString();
    }
}