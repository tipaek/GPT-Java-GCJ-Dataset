import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + testCase + ":");

            if (n < 100) {
                for (int i = 0; i < n; i++) {
                    System.out.println((i + 1) + " " + 1);
                }
            } else {
                n -= 30;
                List<Integer> rows = new ArrayList<>();
                int counter = 0;

                while (n > 0) {
                    if (n % 2 == 1) {
                        rows.add(counter);
                    }
                    n /= 2;
                    counter++;
                }

                int lastRow = rows.get(rows.size() - 1);
                int remainingRows = 30 - lastRow + rows.size();
                boolean leftToRight = true;

                for (int i = 0; i <= lastRow; i++) {
                    if (rows.contains(i)) {
                        leftToRight = !leftToRight;
                        for (int j = 0; j < i; j++) {
                            System.out.println((i + 1) + " " + (leftToRight ? (j + 1) : (i + 1 - j)));
                        }
                    }
                    System.out.println((i + 1) + " " + (leftToRight ? (i + 1) : 1));
                }

                for (int i = lastRow + 1; i < lastRow + remainingRows; i++) {
                    System.out.println((i + 1) + " " + (leftToRight ? 1 : (i + 1)));
                }
            }
        }
    }
}