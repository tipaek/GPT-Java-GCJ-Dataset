import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final double HEIGHT = Math.pow(10, 9) * 2;
    private static final double WIDTH = Math.pow(10, 9) * 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] conditions = scanner.nextLine().split(" ");
        
        int numberOfTestcases = Integer.parseInt(conditions[0]);
        double radius = Double.parseDouble(conditions[2]);

        for (int i = 1; i <= numberOfTestcases; i++) {
            processTestcase(i, scanner, radius);
        }
    }

    private static void processTestcase(int index, Scanner scanner, double radius) {
        double air = HEIGHT - radius;

        for (int x = -5; x <= 5; x++) {
            for (int y = -5; y <= 5; y++) {
                System.out.println(x + " " + y);

                String judgeResponse = scanner.nextLine();
                System.err.println(judgeResponse);
            }
        }
    }
}