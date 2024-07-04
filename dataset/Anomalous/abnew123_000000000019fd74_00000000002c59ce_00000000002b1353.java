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
                for (int j = 0; j < n; j++) {
                    System.out.println((j + 1) + " " + 1);
                }
            } else {
                n -= 30;
                int counter = 0;
                List<Integer> rows = new ArrayList<>();

                while (n > 0) {
                    if (n % 2 == 1) {
                        rows.add(counter);
                    }
                    n /= 2;
                    counter++;
                }

                int remaining = 30 - rows.get(rows.size() - 1) + rows.size();
                boolean flag = true;

                for (int j = 0; j <= rows.get(rows.size() - 1); j++) {
                    if (rows.contains(j)) {
                        for (int k = 0; k < j; k++) {
                            System.out.println((j + 1) + " " + (flag ? (k + 1) : (j + 1 - k)));
                        }
                        flag = !flag;
                    }
                    System.out.println((j + 1) + " " + (flag ? 1 : (j + 1)));
                }

                for (int j = rows.get(rows.size() - 1) + 1; j < rows.get(rows.size() - 1) + remaining; j++) {
                    System.out.println((j + 1) + " " + (flag ? 1 : (j + 1)));
                }
            }
        }
    }
}