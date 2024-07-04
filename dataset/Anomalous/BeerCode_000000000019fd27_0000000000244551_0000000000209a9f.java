import java.util.*;

class Solution {
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

    private static String processInput(String input, int level) {
        if (input.isEmpty()) {
            return "";
        }
        
        char[] characters = input.toCharArray();
        List<String> segments = new ArrayList<>();
        int start = 0;
        char expectedChar = (char) ('0' + level);
        
        for (int i = 1; i < characters.length; i++) {
            if (characters[start] == expectedChar && characters[i] != expectedChar ||
                characters[start] != expectedChar && characters[i] == expectedChar) {
                segments.add(new String(characters, start, i - start));
                start = i;
            }
        }
        segments.add(new String(characters, start, characters.length - start));
        
        StringBuilder result = new StringBuilder();
        for (String segment : segments) {
            if (segment.startsWith(String.valueOf(expectedChar))) {
                result.append(segment);
            } else {
                result.append("(").append(processInput(segment, level + 1)).append(")");
            }
        }
        
        return result.toString();
    }
}