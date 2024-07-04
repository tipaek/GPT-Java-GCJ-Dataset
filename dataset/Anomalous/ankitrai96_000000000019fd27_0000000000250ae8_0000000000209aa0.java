import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte testCases = sc.nextByte();

        for (byte t = 0; t < testCases; t++) {
            byte n = sc.nextByte();
            byte k = sc.nextByte();

            if (k % n != 0) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                byte d = (byte) (k / n);
                System.out.println("Case #" + (t + 1) + ": POSSIBLE");
                byte m = (byte) (d + 1);
                for (byte i = 0; i < n; i++) {
                    m = (byte) (m - 1);
                    for (byte j = 0; j < n; j++) {
                        System.out.print(((m % 4 == 0) ? n : (byte) (m % 4)) + " ");
                        m++;
                    }
                    System.out.println();
                }
            }
        }
        sc.close();
    }
}