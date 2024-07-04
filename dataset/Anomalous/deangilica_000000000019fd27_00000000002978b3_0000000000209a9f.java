import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static int T;
    private static List<List<Integer>> sequences;
    private static List<String> sequencePatterns;

    public static void main(String[] args) {
        sequences = new ArrayList<>();
        sequencePatterns = new ArrayList<>();
        readInput();
        solve();
        printOutput();
    }

    private static void readInput() {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            List<Integer> sequence = new ArrayList<>();
            String input = scanner.next();
            for (char ch : input.toCharArray()) {
                sequence.add(Character.getNumericValue(ch));
            }
            sequences.add(sequence);
        }
    }

    private static void solve() {
        for (List<Integer> sequence : sequences) {
            StringBuilder currentPattern = new StringBuilder();
            int openBrackets = 0;
            for (int number : sequence) {
                while (number > openBrackets) {
                    currentPattern.append('(');
                    openBrackets++;
                }
                while (number < openBrackets) {
                    currentPattern.append(')');
                    openBrackets--;
                }
                currentPattern.append(number);
            }
            while (openBrackets > 0) {
                currentPattern.append(')');
                openBrackets--;
            }
            sequencePatterns.add(currentPattern.toString());
        }
    }

    private static void printOutput() {
        for (int i = 0; i < T; i++) {
            System.out.printf("Case #%d: %s%n", i + 1, sequencePatterns.get(i));
        }
    }
}