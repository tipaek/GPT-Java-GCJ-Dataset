import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexMatches {

    public static void main(String[] args) {
        // String to be scanned to find the pattern.
        String text = "This order was placed for QT3000! OK?";
        String regex = "(.*)(\\d+)(.*)";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);

        // Match the pattern in the string
        Matcher matcher = pattern.matcher(text);
        
        // Check if the pattern is found and print the groups
        if (matcher.find()) {
            System.out.println("Found value: " + matcher.group(0));
            System.out.println("Found value: " + matcher.group(1));
            System.out.println("Found value: " + matcher.group(2));
        } else {
            System.out.println("NO MATCH");
        }
    }
}