import java.io.InputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Scanner scanner = new Scanner(inputStream);

        int numberOfCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int r = scanner.nextInt();
            int s = scanner.nextInt();
            System.out.printf("Case #%d: %d%n", caseNumber, (r - 1) * (s - 1));

            int a = r * (s - 1);
            int b = r - 1;
            int i = 1;

            while (b != 0) {
                System.out.println(a + " " + b);
                if (i == s - 1) {
                    i = 0;
                    b--;
                }
                a--;
                i++;
            }
        }
    }
}