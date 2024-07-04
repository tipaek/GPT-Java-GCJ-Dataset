import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        final int MAX_LEVEL = 35;
        final int MAX_COUNT = 500;
        long[] levelSum = new long[MAX_LEVEL];
        long power = 2;
        
        for (int i = 1; i < MAX_LEVEL; i++) {
            levelSum[i] = power - 1;
            power *= 2;
        }

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            long n = scanner.nextLong();
            int count = 0;
            int fillLevel = 0;
            
            while (levelSum[fillLevel + 1] <= n) {
                fillLevel++;
            }

            System.out.println("Case #" + caseNum + ":");
            
            outerLoop:
            for (int i = 1; i <= fillLevel; i++) {
                for (int j = 1; j <= i; j++) {
                    if (i % 2 == fillLevel % 2) {
                        System.out.println(i + " " + (i + 1 - j));
                    } else {
                        System.out.println(i + " " + j);
                    }
                    count++;
                    if (count > MAX_COUNT) {
                        break outerLoop;
                    }
                }
            }

            long remaining = n - levelSum[fillLevel];
            int currentLevel = fillLevel + 1;
            
            while (remaining >= currentLevel - 1) {
                System.out.println(currentLevel + " " + 2);
                count++;
                if (count > MAX_COUNT) {
                    break;
                }
                remaining -= (currentLevel - 1);
                currentLevel++;
            }
            
            if (currentLevel > fillLevel + 1) {
                currentLevel--;
            }

            while (remaining > 0) {
                System.out.println(currentLevel + " " + 1);
                count++;
                if (count > MAX_COUNT) {
                    break;
                }
                remaining--;
                currentLevel++;
            }
        }
        
        scanner.close();
    }
}