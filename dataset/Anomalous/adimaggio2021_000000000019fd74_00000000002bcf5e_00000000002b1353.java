import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            System.out.println("Case #" + (t + 1) + ":");
            int n = scanner.nextInt();
            int x = (int) (-0.5 + Math.sqrt(1 + 8 * n) / 2);
            int remaining = n - (x * (x + 1)) / 2 - 1;

            if (remaining < 0) {
                x -= 1;
            }
            remaining = n - (x * (x + 1)) / 2 - 1;

            System.out.println(1 + " " + 1);
            int row = 2;
            int lastIndex = 0;

            for (int i = 0; i < x; i++) {
                System.out.println((row + i) + " " + 2);
                lastIndex = i;
            }

            row = row + lastIndex + 1;

            for (int i = 0; i < remaining; i++) {
                System.out.println((row + i) + " " + 1);
            }
        }
        
        scanner.close();
    }
}