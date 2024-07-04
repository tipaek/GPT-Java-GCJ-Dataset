import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int L = scanner.nextInt();
            int R = scanner.nextInt();
            int i = 1;

            while (true) {
                if (L >= R) {
                    if (L >= i) {
                        L -= i;
                    } else {
                        System.out.println("CASE #" + t + ": " + (i - 1) + " " + L + " " + R);
                        break;
                    }
                } else {
                    if (R >= i) {
                        R -= i;
                    } else {
                        System.out.println("CASE #" + t + ": " + (i - 1) + " " + L + " " + R);
                        break;
                    }
                }
                i++;
            }
        }

        scanner.close();
    }
}