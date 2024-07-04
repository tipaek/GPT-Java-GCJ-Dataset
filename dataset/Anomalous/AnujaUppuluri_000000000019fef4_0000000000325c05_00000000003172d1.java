import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        for (int z = 1; z <= T; z++) {
            int k = getRandomNumInRange(0, 3);
            System.out.println("Case #" + z + ": " + k);
        }
    }

    private static int getRandomNumInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}