import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NestedParentheses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTests = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        List<String> responses = new ArrayList<>();

        for (int i = 0; i < numTests; i++) {
            String nextString = scanner.nextLine();
            responses.add(getDepth(nextString));
        }

        for (int i = 0; i < responses.size(); i++) {
            String response = responses.get(i);
            System.out.println("Case #" + (i + 1) + ": " + response);
        }

        scanner.close();
    }

    private static String merge(int lastNum, String str1, String str2) {
        int numCut = Math.min(lastNum, Integer.parseInt(str2));

        // Remove from left
        for (int i = 0; i < numCut; i++) {
            str1 = str1.substring(0, str1.length() - 1);
        }

        int parenAdd = Integer.parseInt(str2) - numCut;

        // Add the next nums to left
        for (int i = 0; i < parenAdd; i++) {
            str1 += "(";
        }
        str1 += str2;
        for (int i = 0; i < Integer.parseInt(str2); i++) {
            str1 += ")";
        }

        return str1;
    }

    private static String initialize(String input) {
        if (input.equals("0")) {
            return "0";
        }
        StringBuilder string = new StringBuilder();
        int num = Integer.parseInt(input);

        for (int i = 0; i < num; i++) {
            string.append("(");
        }
        string.append(input);
        for (int i = 0; i < num; i++) {
            string.append(")");
        }

        return string.toString();
    }

    private static String getDepth(String input) {
        StringBuilder output = new StringBuilder();

        int first = 0;
        int next = 1;
        String curr = "";
        while (first < input.length()) {
            curr += initialize(String.valueOf(input.charAt(first)));
            int lastNum = Integer.parseInt(String.valueOf(input.charAt(first)));

            while (next < input.length() && input.charAt(next) != '0') {
                curr = merge(lastNum, curr, String.valueOf(input.charAt(next)));
                lastNum = Integer.parseInt(String.valueOf(input.charAt(next)));
                next++;
            }

            output.append(curr);
            if (next < input.length() && input.charAt(next) == '0') {
                output.append("0");
            }
            first = next + 1;
            next = first + 1;
            curr = "";
        }

        return output.toString();
    }
}