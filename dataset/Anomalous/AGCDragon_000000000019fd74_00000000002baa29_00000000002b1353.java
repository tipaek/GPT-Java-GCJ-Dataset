import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int N = scanner.nextInt();
            System.out.println("Case #" + t + ":");

            if (N <= 1000) {
                int count = 1;
                System.out.println("1 1");

                for (int x = 1; x <= 500; x++) {
                    if (count == N) {
                        break;
                    }
                    if (count + x > N) {
                        for (int y = x - 1; y <= N - count; y++) {
                            System.out.println(y + " 1");
                        }
                        break;
                    }
                    System.out.println(x + " 2");
                    count += x;
                }
            }
        }
        scanner.close();
    }
}