import java.util.*;

class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCases; t++) {
            String input = scanner.nextLine();
            String result = process(input, 0);
            System.out.printf("Case #%d: %s\n", t, result);
        }
    }

    static String process(String s, int level) {
        if (s.isEmpty()) {
            return "";
        }

        char[] chars = s.toCharArray();
        ArrayList<String> segments = new ArrayList<>();
        int start = 0;
        char expectedChar = (char) ('0' + level);

        for (int i = 1; i < chars.length; i++) {
            if (chars[start] != expectedChar && chars[i] == expectedChar || chars[start] == expectedChar && chars[i] != expectedChar) {
                segments.add(s.substring(start, i));
                start = i;
            }
        }

        segments.add(s.substring(start));

        StringBuilder result = new StringBuilder();
        for (String segment : segments) {
            if (segment.charAt(0) == expectedChar) {
                result.append(segment);
            } else {
                result.append("(").append(process(segment, level + 1)).append(")");
            }
        }

        return result.toString();
    }
}