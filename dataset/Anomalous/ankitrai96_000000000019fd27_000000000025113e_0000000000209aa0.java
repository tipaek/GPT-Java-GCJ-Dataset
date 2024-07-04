import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte testCases = scanner.nextByte();

        for (byte t = 0; t < testCases; t++) {
            byte n = scanner.nextByte();
            byte k = scanner.nextByte();

            if (k % n != 0) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                byte d = (byte) (k / n);
                System.out.println("Case #" + (t + 1) + ": POSSIBLE");
                byte m = (byte) (d + 1);

                for (byte i = 0; i < n; i++) {
                    m = (byte) (m - 1);
                    for (byte j = 0; j < n; j++) {
                        System.out.print(((m % n == 0) ? n : (byte) (m % n)) + " ");
                        m++;
                    }
                    System.out.println();
                }
            }
        }
        scanner.close();
    }
}