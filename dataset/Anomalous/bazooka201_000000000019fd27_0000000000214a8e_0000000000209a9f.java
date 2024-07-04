import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int runs = Integer.parseInt(console.nextLine());

        for (int run = 1; run <= runs; run++) {
            String input = console.nextLine();
            ArrayList<String> list = new ArrayList<>();
            StringBuilder currentSegment = new StringBuilder();
            currentSegment.append(input.charAt(0));

            for (int i = 1; i < input.length(); i++) {
                if (input.charAt(i) == input.charAt(i - 1)) {
                    currentSegment.append(input.charAt(i));
                } else {
                    list.add(currentSegment.toString());
                    currentSegment = new StringBuilder();
                    currentSegment.append(input.charAt(i));
                }
            }
            list.add(currentSegment.toString());

            System.out.print("Case #" + run + ": ");

            int levelsIn = 0;
            for (String segment : list) {
                int digit = Character.getNumericValue(segment.charAt(0));
                while (levelsIn < digit) {
                    System.out.print("(");
                    levelsIn++;
                }
                while (levelsIn > digit) {
                    System.out.print(")");
                    levelsIn--;
                }
                System.out.print(segment);
            }

            while (levelsIn > 0) {
                System.out.print(")");
                levelsIn--;
            }

            System.out.println();
        }
    }
}