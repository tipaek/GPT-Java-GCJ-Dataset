import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            if (K % N != 0) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (t + 1) + ": POSSIBLE");
                int dg = K / N;

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        System.out.print(dg + " ");
                        dg++;
                        if (dg > N) {
                            dg = 1;
                        }
                    }
                    dg--;
                    if (dg < 1) {
                        dg = N;
                    }
                    System.out.println();
                }
            }
        }
        scanner.close();
    }
}