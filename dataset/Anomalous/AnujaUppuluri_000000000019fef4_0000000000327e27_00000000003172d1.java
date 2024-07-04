import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int randomNumber = generateRandomNumber(0, 2);
            System.out.println("Case #" + i + ": " + randomNumber);
        }
    }

    private static int generateRandomNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("IMPOSSIBLE");
        }
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}