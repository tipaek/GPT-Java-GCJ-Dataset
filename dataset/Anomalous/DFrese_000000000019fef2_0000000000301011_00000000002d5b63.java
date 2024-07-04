import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final double HEIGHT = 2 * Math.pow(10, 9);
    private static final double WIDTH = 2 * Math.pow(10, 9);

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            String[] conditions = scanner.nextLine().split(" ");
            int numberOfTestcases = Integer.parseInt(conditions[0]);
            double radius = Double.parseDouble(conditions[2]);

            for (int i = 1; i <= numberOfTestcases; i++) {
                findSolution(scanner, radius);
            }
        }
    }

    private static void findSolution(Scanner scanner, double radius) {
        double air = HEIGHT - radius;

        for (int x = -5; x <= 5; x++) {
            for (int y = -5; y <= 5; y++) {
                System.out.println(x + " " + y);
                String judgeAnswer = scanner.nextLine();
                if (judgeAnswer.contains("CENTER")) {
                    return;
                }
            }
        }
    }
}