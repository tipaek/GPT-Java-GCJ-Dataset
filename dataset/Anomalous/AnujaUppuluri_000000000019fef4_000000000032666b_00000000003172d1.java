import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int randomNum = getRandomNumInRange(0, 2);
            System.out.println("Case #" + caseNumber + ": " + randomNum);
        }
    }

    private static int getRandomNumInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min");
        }
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}