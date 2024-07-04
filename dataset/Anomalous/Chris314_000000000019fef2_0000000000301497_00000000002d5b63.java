import java.util.Scanner;

public class Solution {
    public static void solve(Scanner input, int A, int B) {
        for (int i = -5; i <= 5; i++) {
            for (int j = -5; j <= 5; j++) {
                System.out.println(i + " " + j);
                String response = input.next();
                if (response.equals("CENTER")) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        int pow = (int) Math.pow(10, 9);
        long[] initUpperLeft = {-pow, pow};
        long[] initBottomRight = {pow, -pow};

        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int A = input.nextInt();
        int B = input.nextInt();

        for (int testCase = 0; testCase < T; testCase++) {
            solve(input, A, B);
        }

        input.close();
    }
}