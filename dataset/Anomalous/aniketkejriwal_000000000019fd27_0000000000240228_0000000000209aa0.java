import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();

            if (K % N != 0) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": POSSIBLE");
                int j = K / N;
                List<Integer> list = new ArrayList<>();

                for (int k = 1; k <= N; k++) {
                    if (k != j) {
                        list.add(k);
                    }
                }

                for (int k = 0; k < N; k++) {
                    int m = 0;
                    for (int l = 0; l < N; l++) {
                        if (k == l) {
                            System.out.print(j + " ");
                        } else {
                            System.out.print(list.get(m) + " ");
                            m++;
                        }
                    }
                    System.out.println();
                    list.add(0, list.remove(N - 2));
                }
            }
        }
        scanner.close();
    }
}