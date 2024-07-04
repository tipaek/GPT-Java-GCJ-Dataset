import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        long[] levelSum = new long[35];
        long pow = 2;
        for (int i = 1; i < 35; i++) {
            levelSum[i] = pow - 1L;
            pow *= 2L;
        }

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int curT = 1; curT <= t; curT++) {
            test:
            {
                long n = scanner.nextInt();
                int count = 0;
                int fillLevel = 0;
                while (levelSum[fillLevel + 1] <= n) fillLevel++;

                System.out.println("Case #" + curT + ":");
                for (int i = 1; i <= fillLevel; i++) {
                    for (int j = 1; j <= i; j++) {
                        if (i % 2 == fillLevel % 2) {
                            System.out.println(i + " " + (i + 1 - j));
                            count++;
                            if (count > 500) break test;
                        } else {
                            System.out.println(i + " " + j);
                            count++;
                            if (count > 500) break test;
                        }
                    }
                }

                long rem = n - levelSum[fillLevel];
                int curLevel = fillLevel + 1;
                while (true) {
                    int cur = curLevel - 1;
                    if (rem >= cur) {
                        System.out.println(curLevel + " " + 2);
                        count++;
                        if (count > 500) break test;
                        rem -= cur;
                        curLevel++;
                    } else {
                        break;
                    }
                }
                if (curLevel > fillLevel + 1) curLevel--;
                while (rem > 0) {
                    System.out.println(curLevel + " " + 1);
                    count++;
                    if (count > 500) break test;
                    rem--;
                    curLevel++;
                }
            }
        }
    }
}
