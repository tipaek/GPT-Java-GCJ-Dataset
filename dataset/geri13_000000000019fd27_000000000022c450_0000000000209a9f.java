
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        List<String> strings = readInput();
        int i = 1;
        for (String string : strings) {
            System.out.println("Case #" + i++ + ": " + solve(string));
        }
    }

    static List<String> readInput() {
        List<String> results = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            results.add(scanner.nextLine());
        }
        return results;
    }

    static String solve(String s) {
        List<Part> parts = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            parts.add(new Part(s.charAt(i) - '0'));
        }

        for (int i = 9; i >= 0; i--) {
            parts = mergeAdjacentSameValueParts(parts);
            for (Part part : parts) {
                if (part.calculatingValue == i) {
                    part.wrap();
                }
            }
        }
        return parts.get(0).generatedString;
    }

    static List<Part> mergeAdjacentSameValueParts(List<Part> parts) {
        Set<Integer> merged = new TreeSet<>();
        int size = parts.size() - 1;
        for (int i = 0; i < size; i++) {
            if (parts.get(i).calculatingValue == parts.get(i + 1).calculatingValue) {
                merged.add(i);
                parts.set(i + 1, mergeParts(parts.get(i), parts.get(i + 1)));
            }
        }

        List<Part> results = new ArrayList<>();
        for (int i = 0; i < parts.size(); i++) {
            if (!merged.contains(i)) {
                results.add(parts.get(i));
            }
        }
        return results;
    }

    static Part mergeParts(Part p1, Part p2) {
        Part part = new Part(p1.calculatingValue);
        part.generatedString = p1.generatedString + p2.generatedString;
        return part;
    }

    static class Part {
        int calculatingValue;
        String generatedString;

        public Part(int realValue) {
            this.calculatingValue = realValue;
            this.generatedString = "" + realValue;
        }

        public void wrap() {
            if (calculatingValue == 0) {
                return;
            }

            --calculatingValue;
            generatedString = "(" + generatedString + ")";
        }
    }
}
