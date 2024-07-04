import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();

        for (int testcase = 1; testcase <= T; testcase++) {
            int ox = 0;
            int oy = 0;

            for (int i = 0; i < 121; i++) {
                int guessX = ox - 5 + i % 11;
                int guessY = oy - 5 + i / 11;
                System.out.println(guessX + " " + guessY);

                if (sc.next().equals("CENTER")) {
                    break;
                }
            }
        }
    }
}