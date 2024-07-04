import java.util.Scanner;

public class Solution {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            int R = scanner.nextInt();
            int S = scanner.nextInt();

            int N = R*S;

            //StringBuilder str = new StringBuilder();

            int[] nombre = new int[R];

            int k = 0;
            int encore = R * (S-1) - 1;

            int n = 1 + (encore) / 2;
            System.out.println("Case #" + i +  ": " + n );

            while (encore >= 0) {
                nombre[k]++;
                int a = nombre[k];
                k++;
                k = k % R;
                if (encore > 0) {
                    nombre[k] ++;
                    a += nombre[k];
                    k++;
                    k = k % R;
                }
                int b = N - a - encore;

                encore -= 2;
                System.out.println(a + " " + b);
            }

        }
    }
}
