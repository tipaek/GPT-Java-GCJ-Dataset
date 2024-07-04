import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + caseNumber + ":");
            
            if (n < 100) {
                for (int i = 0; i < n; i++) {
                    System.out.println((i + 1) + " 1");
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
                int remaining = 30 - lastRow + rows.size();
                boolean flag = true;

                for (int i = 0; i <= lastRow; i++) {
                    if (rows.contains(i)) {
                        flag = !flag;
                        for (int j = 0; j < i; j++) {
                            System.out.println((i + 1) + " " + (flag ? (j + 1) : (i + 1 - j)));
                        }
                    }
                    System.out.println((i + 1) + " " + (flag ? (i + 1) : 1));
                }

                for (int i = lastRow + 1; i < lastRow + remaining; i++) {
                    System.out.println((i + 1) + " " + (flag ? 1 : (i + 1)));
                }
            }
        }
        scanner.close();
    }
}