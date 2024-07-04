import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            Segments segments = Segments.parse(input);
            System.out.println("CASE #" + (i + 1) + ": " + segments);
        }
        scanner.close();
    }

    private static class Segments {
        private List<Segments> children = new ArrayList<>();

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            buildString(result, 0);
            return result.toString();
        }

        private void buildString(StringBuilder result, int depth) {
            for (Segments child : children) {
                if (child == null) {
                    result.append(depth);
                } else {
                    result.append('(');
                    child.buildString(result, depth + 1);
                    result.append(')');
                }
            }
        }

        public static Segments parse(String input) {
            List<Integer> digits = new ArrayList<>(input.length());
            for (char ch : input.toCharArray()) {
                int digit = ch - '0';
                if (digit < 0 || digit > 9) {
                    throw new IllegalArgumentException("Invalid character in input: " + ch);
                }
                digits.add(digit);
            }
            return parse(digits, 0);
        }

        private static Segments parse(List<Integer> digits, int depth) {
            Segments segments = new Segments();
            List<Segments> children = segments.children;
            int start = 0;
            int current = 0;
            int size = digits.size();

            while (current < size) {
                int digit = digits.get(current);
                if (digit == depth) {
                    if (start < current) {
                        children.add(parse(digits.subList(start, current), depth + 1));
                    }
                    children.add(null);
                    current++;
                    start = current;
                } else {
                    current++;
                }
            }
            if (start < current) {
                children.add(parse(digits.subList(start, current), depth + 1));
            }
            return segments;
        }
    }
}