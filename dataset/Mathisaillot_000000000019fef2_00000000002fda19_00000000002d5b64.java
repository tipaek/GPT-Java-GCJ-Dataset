import java.util.Scanner;

public class Solution {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            int R = scanner.nextInt();
            int S = scanner.nextInt();
            
            int N = R*S;
            int tot = N - 1;
            int ok = R - 1;
            int todo = tot - ok;
            int n = (todo + 1) / 2;
            System.out.println("Case #" + i +  ": " + n );
            
            int k = 1;
            int encore = R * (S-1) - 1;
            for (int j = 0; j < S - 1; j++) {
                for (int l = 0; l < R / 2; l++) {
                    int a = (k * 2);
                    System.out.println(a + " " + ( N - a - encore) );
                    encore -= 2;
                }
                if (R % 2 == 1) {
                    System.out.println(k + " " + (N - k - encore) );
                    encore --;
                }
                k++;
            }
        }
    }
}
