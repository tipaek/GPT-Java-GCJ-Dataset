import java.util.Scanner;

public class Ankesh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        int t = Integer.parseInt(sc.next());
        int N = Integer.parseInt(sc.next());

        int arr[][] = new int[N][N];

        while (t-- > 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(sc.next());
                }
            }

            for (int i = 0; i < N; i++) {
                sum += arr[i][i];
            }

            System.out.println(sum);
            sum = 0; // Reset the sum for the next test case
        }

        sc.close();
    }
}