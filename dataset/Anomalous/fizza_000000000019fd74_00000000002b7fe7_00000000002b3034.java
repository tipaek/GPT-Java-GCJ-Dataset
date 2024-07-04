import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexDemo {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("usage: java RegexDemo regex input");
            return;
        }

        // Convert new-line (\n) character sequences to new-line characters.
        String regex = args[0];
        String input = args[1].replaceAll("\\\\n", "\n");

        try {
            System.out.println("regex = " + regex);
            System.out.println("input = " + input);

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                System.out.println("Found [" + matcher.group() + "] starting at "
                        + matcher.start() + " and ending at " + (matcher.end() - 1));
            }
        } catch (PatternSyntaxException e) {
            System.err.println("Bad regex: " + e.getMessage());
            System.err.println("Description: " + e.getDescription());
            System.err.println("Index: " + e.getIndex());
            System.err.println("Incorrect pattern: " + e.getPattern());
        }
    }
}