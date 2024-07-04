import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());

        for (int caseNum = 0; caseNum < numCases; caseNum++) {
            String target = scanner.nextLine();
            List<Integer> numbers = new ArrayList<>();

            for (char number : target.toCharArray()) {
                numbers.add(Character.getNumericValue(number));
            }

            int occurrences = Collections.frequency(numbers, 0);
            StringBuilder currentAnswer = new StringBuilder();

            if (occurrences > 0) {
                for (int i = 0; i < occurrences; i++) {
                    int currentOccurrence = numbers.indexOf(0);

                    if (currentOccurrence == 0) {
                        currentAnswer.append(0);
                    } else {
                        currentAnswer.append(calculateAnswer(numbers.subList(0, currentOccurrence)));
                        currentAnswer.append(0);
                    }

                    numbers = numbers.subList(currentOccurrence + 1, numbers.size());

                    if ((i + 1) == occurrences && !numbers.isEmpty()) {
                        currentAnswer.append(calculateAnswer(numbers));
                    }
                }
            } else {
                currentAnswer.append(calculateAnswer(numbers));
            }

            System.out.println("Case #" + (caseNum + 1) + ": " + currentAnswer);
        }
    }

    static String calculateAnswer(List<Integer> numbers) {
        StringBuilder answer = new StringBuilder();
        String opening = "(";
        String closing = ")";

        for (int each : numbers) {
            for (int i = 0; i < each - 1; i++) {
                answer.append(opening);
            }
            answer.append(each);
            for (int i = 0; i < each - 1; i++) {
                answer.append(closing);
            }
        }

        return "(" + answer + ")";
    }
}