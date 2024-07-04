import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        long[] levelSum = new long[35];
        long pow = 2;
        for (int i = 1; i < 35; i++) {
            levelSum[i] = pow - 1L;
            pow <<= 1;
        }

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
            long n = scanner.nextLong();
            int fillLevel = 0;
            while (levelSum[fillLevel + 1] <= n) {
                fillLevel++;
            }

            System.out.println("Case #" + caseNumber + ":");
            for (int i = 1; i <= fillLevel; i++) {
                if (i % 2 == fillLevel % 2) {
                    for (int j = i; j >= 1; j--) {
                        System.out.println(i + " " + j);
                    }
                } else {
                    for (int j = 1; j <= i; j++) {
                        System.out.println(i + " " + j);
                    }
                }
            }

            long remaining = n - levelSum[fillLevel];
            int currentLevel = fillLevel + 1;
            while (remaining >= currentLevel - 1) {
                System.out.println(currentLevel + " " + 2);
                remaining -= (currentLevel - 1);
                currentLevel++;
            }

            if (currentLevel > fillLevel + 1) {
                currentLevel--;
            }

            while (remaining > 0) {
                System.out.println(currentLevel + " " + 1);
                remaining--;
                currentLevel++;
            }
        }
    }
}