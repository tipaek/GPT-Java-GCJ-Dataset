import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String[] input = scanner.nextLine().split(" ");
            int startX = Integer.parseInt(input[0]);
            int startY = Integer.parseInt(input[1]);
            String path = input[2];

            String result = calculateSteps(startX, startY, path);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String calculateSteps(int x, int y, String path) {
        for (int i = 0; i < path.length(); i++) {
            char direction = path.charAt(i);
            switch (direction) {
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
                case 'W': x--; break;
            }
            if (Math.abs(x) + Math.abs(y) <= i + 1) {
                return Integer.toString(i + 1);
            }
        }
        return "IMPOSSIBLE";
    }
}