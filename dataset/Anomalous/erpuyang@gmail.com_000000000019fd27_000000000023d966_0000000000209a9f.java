import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
            inputs.add(input);
        }

        if (inputs.isEmpty()) {
            return;
        }

        int caseCount = Integer.parseInt(inputs.get(0).trim());

        for (int i = 1; i <= caseCount; i++) {
            String str = inputs.get(i);
            String result = computeNestingDepth(str);
            System.out.printf("Case #%d: %s%n", i, result);
        }
    }

    private static String computeNestingDepth(String str) {
        StringBuilder sb = new StringBuilder();
        int maxIndex = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > str.charAt(maxIndex)) {
                maxIndex = i;
            }
        }

        int maxDepth = str.charAt(maxIndex) - '0';
        sb.append(maxDepth);
        for (int i = 0; i < maxDepth; i++) {
            sb.insert(0, '(');
            sb.append(')');
        }

        int left = maxIndex - 1;
        while (left >= 0) {
            char current = str.charAt(left);
            char next = str.charAt(left + 1);
            if (current < next) {
                sb.insert(current - '0', current);
            } else {
                int diff = current - next;
                StringBuilder tempSb = new StringBuilder();
                tempSb.append(current);
                for (int i = 0; i < diff; i++) {
                    tempSb.insert(0, '(');
                    tempSb.append(')');
                }
                sb.insert(next - '0', tempSb);
            }
            left--;
        }

        int right = maxIndex + 1;
        while (right < str.length()) {
            char current = str.charAt(right);
            char prev = str.charAt(right - 1);
            if (current < prev) {
                sb.insert(sb.length() - (current - '0'), current);
            } else {
                int diff = current - prev;
                StringBuilder tempSb = new StringBuilder();
                tempSb.append(current);
                for (int i = 0; i < diff; i++) {
                    tempSb.insert(0, '(');
                    tempSb.append(')');
                }
                sb.insert(sb.length() - (prev - '0'), tempSb);
            }
            right++;
        }

        return sb.toString();
    }
}