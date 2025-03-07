import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int randomNum = getRandomNumInRange(0, 3);
            System.out.println("Case #" + i + ": " + randomNum);
        }
    }

    private static int getRandomNumInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}