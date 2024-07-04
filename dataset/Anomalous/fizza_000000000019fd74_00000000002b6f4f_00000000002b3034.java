import java.util.regex.*;

public class RegexDemo {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java RegexDemo <regex> <input>");
            return;
        }

        // Convert escaped new-line sequences to actual new-line characters
        String input = args[1].replaceAll("\\\\n", "\n");
        String regex = args[0];

        try {
            System.out.println("Regex: " + regex);
            System.out.println("Input: " + input);

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                System.out.println("Found [" + matcher.group() + "] starting at " 
                                   + matcher.start() + " and ending at " + (matcher.end() - 1));
            }
        } catch (PatternSyntaxException e) {
            System.err.println("Invalid regex: " + e.getMessage());
            System.err.println("Description: " + e.getDescription());
            System.err.println("Index: " + e.getIndex());
            System.err.println("Incorrect pattern: " + e.getPattern());
        }
    }
}