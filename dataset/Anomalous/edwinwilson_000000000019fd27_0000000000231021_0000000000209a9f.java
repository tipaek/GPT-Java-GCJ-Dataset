import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());
        StringBuilder solution = new StringBuilder();

        for (int currentCase = 1; currentCase <= numCases; currentCase++) {
            solution.append("Case #").append(currentCase).append(": ");
            String line = scanner.nextLine();
            int nestingLevel = 0;

            for (int i = 0; i < line.length(); i++) {
                int current = Character.getNumericValue(line.charAt(i));

                if (current > nestingLevel) {
                    solution.append("(".repeat(current - nestingLevel));
                    nestingLevel = current;
                } else if (current < nestingLevel) {
                    solution.append(")".repeat(nestingLevel - current));
                    nestingLevel = current;
                }

                solution.append(current);
            }

            solution.append(")".repeat(nestingLevel)).append("\n");
        }

        System.out.print(solution);
    }
}