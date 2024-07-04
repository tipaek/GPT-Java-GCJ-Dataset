import java.util.Scanner;

class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            System.out.print("Case #" + i + ": ");
            ArrayEnter(sc);
        }
    }

    public static void ArrayEnter(Scanner sc) {
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                arr[i][k] = sc.nextInt();
            }
        }
        DiagSum(arr, N);
    }

    public static void DiagSum(int[][] arr, int N) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i][i];
        }
        System.out.println(sum);
    }
}