import java.util.Scanner;

public class NestingDepth {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        StringBuilder result = new StringBuilder();

        for (char ch : input.toCharArray()) {
            int value = Character.getNumericValue(ch);

            for (int i = 0; i < value; i++) {
                result.append('(');
            }
            result.append(value);
            for (int i = 0; i < value; i++) {
                result.append(')');
            }
        }

        System.out.println(result.toString());
        scanner.close();
    }
}