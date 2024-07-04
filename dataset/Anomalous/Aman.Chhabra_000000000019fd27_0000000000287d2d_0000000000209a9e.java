import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static final Scanner scanner = new Scanner(System.in);
    static final int COMPLEMENT = 1, REVERSE = 2, BOTH = 3, NOCHANGE = 4;

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        int b = scanner.nextInt();
        List<String> resultList = new ArrayList<>();

        mainloop:
        while (testCases-- > 0) {
            StringBuilder actualValue = new StringBuilder("0".repeat(b));
            int i = 0;
            int j = b;
            actualValue.replace(0, 5, getNextInput(0, 5));
            actualValue.replace(b - 5, b, getNextInput(b - 5, 5));
            boolean pointer = true;

            while (i < j - 5) {
                if (pointer) {
                    i += 5;
                    String s1 = getNextInput(i - 5, 5);
                    String s2 = getNextInput(i, 5);
                    switch (compareStrings(s1, actualValue.substring(i - 5, i), actualValue.substring(b - i, b - i + 5))) {
                        case COMPLEMENT:
                            actualValue = new StringBuilder(compliment(actualValue.toString()));
                            actualValue.replace(i, i + 5, s2);
                            break;
                        case NOCHANGE:
                            actualValue.replace(i, i + 5, s2);
                            break;
                        case BOTH:
                            actualValue = new StringBuilder(compliment(actualValue.toString()));
                        case REVERSE:
                            actualValue.replace(b - i - 5, b - i, new StringBuilder(s2).reverse().toString());
                            actualValue.reverse();
                            i -= 5;
                            break;
                        default:
                            break;
                    }
                } else {
                    j -= 5;
                    String s1 = getNextInput(j - 5, 5);
                    String s2 = getNextInput(j, 5);
                    switch (compareStrings(s2, actualValue.substring(j, j + 5), actualValue.substring(b - j - 5, b - j))) {
                        case COMPLEMENT:
                            actualValue = new StringBuilder(compliment(actualValue.toString()));
                            actualValue.replace(j - 5, j, s1);
                            break;
                        case NOCHANGE:
                            actualValue.replace(j - 5, j, s1);
                            break;
                        case BOTH:
                            actualValue = new StringBuilder(compliment(actualValue.toString()));
                        case REVERSE:
                            actualValue.replace(b - j, b - j + 5, new StringBuilder(s1).reverse().toString());
                            actualValue.reverse();
                            j += 5;
                            break;
                        default:
                            break;
                    }
                }
                pointer = !pointer;
            }

            System.out.println(actualValue);
            System.out.flush();
            String input = scanner.next();
            if (!input.equals("Y")) break mainloop;
        }
    }

    private static String compliment(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .map(ch -> ch == '0' ? "1" : "0")
                .reduce("", String::concat);
    }

    private static int compareStrings(String string1, String string2, String string3) {
        if (compliment(string1).equals(string2)) return COMPLEMENT;
        else if (string1.equals(string2)) return NOCHANGE;
        else if (string1.equals(new StringBuilder(string3).reverse().toString())) return REVERSE;
        else return BOTH;
    }

    private static String getNextInput(int count, int limit) {
        StringBuilder output = new StringBuilder();
        for (int i = count + 1; i <= count + limit; i++) {
            System.out.println(i);
            System.out.flush();
            String input = scanner.next();
            if (input.equals("N")) return input;
            output.append(input);
        }
        return output.toString();
    }
}