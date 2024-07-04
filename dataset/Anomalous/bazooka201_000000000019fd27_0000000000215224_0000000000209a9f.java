import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int runs = Integer.parseInt(console.nextLine());

        for (int run = 1; run <= runs; run++) {
            String input = console.nextLine();
            ArrayList<String> segments = new ArrayList<>();
            StringBuilder currentSegment = new StringBuilder();
            currentSegment.append(input.charAt(0));

            for (int i = 1; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                char previousChar = input.charAt(i - 1);

                if (currentChar == previousChar) {
                    currentSegment.append(currentChar);
                } else {
                    segments.add(currentSegment.toString());
                    currentSegment = new StringBuilder();
                    currentSegment.append(currentChar);
                }
            }
            segments.add(currentSegment.toString());

            System.out.print("Case #" + run + ": ");
            int currentDepth = 0;

            for (String segment : segments) {
                int targetDepth = Character.getNumericValue(segment.charAt(0));
                while (currentDepth < targetDepth) {
                    System.out.print("(");
                    currentDepth++;
                }
                while (currentDepth > targetDepth) {
                    System.out.print(")");
                    currentDepth--;
                }
                System.out.print(segment);
            }

            while (currentDepth > 0) {
                System.out.print(")");
                currentDepth--;
            }

            System.out.println();
        }
    }
}