import java.util.Scanner;

public class Solution {
    public static void solve(Scanner scanner, int b) {
        boolean[] data = new boolean[b];
        if (b == 10) {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                String input = scanner.next();
                data[i] = Integer.parseInt(input) == 1;
            }
            StringBuilder answer = new StringBuilder();
            for (boolean bit : data) {
                answer.append(bit ? 1 : 0);
            }
            System.out.println(answer.toString());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int B = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            solve(scanner, B);
        }
    }
}