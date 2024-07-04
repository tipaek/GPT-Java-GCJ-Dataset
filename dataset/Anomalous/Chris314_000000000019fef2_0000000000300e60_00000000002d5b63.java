import java.util.Scanner;

public class Solution {
    public static void solve(Scanner input, int A, int B) {
        for (int i = -5; i <= 5; i++) {
            for (int j = -5; j <= 5; j++) {
                System.out.println(i + " " + j);
                String response = input.next();
                if (response.equals("Center")) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        long powerOfTen = 1;
        for (int i = 1; i <= 9; i++) {
            powerOfTen *= 10;
        }
        long[] initUpperLeft = new long[]{-powerOfTen, powerOfTen};
        long[] initBottomRight = new long[]{powerOfTen, -powerOfTen};

        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int A = input.nextInt();
        int B = input.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            solve(input, A, B);
        }
    }
}