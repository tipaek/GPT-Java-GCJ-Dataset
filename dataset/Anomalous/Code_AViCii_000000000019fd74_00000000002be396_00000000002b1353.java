import java.util.Scanner;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int currentTestCase = 1; currentTestCase <= testCaseCount; currentTestCase++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + currentTestCase + ":");

            if (n <= 500) {
                for (int i = 1; i <= n; i++) {
                    System.out.println(i + " 1");
                }
            } else {
                System.out.println("1 1");
                System.out.println("2 1");

                int x = 1;
                int xs = 1;
                int present = 2 + xs;

                while (present + x < n) {
                    System.out.println((x + 2) + " " + x);
                    x++;
                    xs += x;
                    present += xs;
                }

                present -= xs;
                x--;
                present += x;

                while (present < n) {
                    System.out.println((x + 1) + " " + x);
                    x++;
                    present += x;
                }

                present -= x;
                x--;
                present++;

                while (present < n) {
                    System.out.println(x + " " + x);
                    x++;
                    present++;
                }

                System.out.println(x + " " + x);
            }
        }
    }
}