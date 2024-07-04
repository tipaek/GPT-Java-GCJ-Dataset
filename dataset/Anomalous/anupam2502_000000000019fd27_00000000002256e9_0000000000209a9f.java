import java.util.Scanner;

public class NestingDepth {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        StringBuilder result = new StringBuilder();

        for (char ch : input.toCharArray()) {
            int digit = Character.getNumericValue(ch);

            result.append("(".repeat(digit))
                  .append(digit)
                  .append(")".repeat(digit));
        }

        System.out.println(result.toString());
        // scanner.close(); // Uncomment this line if you want to close the scanner
    }
}