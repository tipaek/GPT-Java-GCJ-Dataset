import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[] S = new int[N];
            int[] E = new int[N];
            for (int i = 0; i < N; i++) {
                S[i] = sc.nextInt();
                E[i] = sc.nextInt();
            }
        }
        sc.close();
    }
}