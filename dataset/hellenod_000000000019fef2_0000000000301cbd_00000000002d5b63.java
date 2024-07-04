import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tests = input.nextInt();
        int A = input.nextInt();
        int B = input.nextInt();

        for(int i = 1; i <= tests; i++){
            int result = Solve(input, A, B);
            if (result == -1) {
                return;
            }
            System.out.flush();
        }
    }

    static int Solve(Scanner input, int A, int B){        
        int x = -5;
        int y = -5;
        boolean flag = true;
        int steps = 300;

        while(flag) {
            if (steps <= 0) {
                return -1;
            }
            steps--;
            System.out.println( String.format("%d %d", x, y) );
            System.out.flush();

            String verdict = input.next();
            if ("WRONG".equals(verdict)) {
                flag = false;
                return -1;
            }

            if ("CENTER".equals(verdict)) {
                flag = false;
                return 0;
            }

            x++;
            if (x > 5) {
                x = -5;
                y++;
            }
        }

        return -1;
    }
}