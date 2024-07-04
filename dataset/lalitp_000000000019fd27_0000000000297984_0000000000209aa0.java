import java.util.*;

public class Solution {

    public static void main(String[] args) {
	// write your code here
        int T, N, K, t, sum, i, j, first, num;
        Scanner sc = new Scanner(System.in);
        boolean impossible;
        T = sc.nextInt();
        for(t = 1; t <= T; t++) {
            impossible = true;
            N = sc.nextInt();
            K = sc.nextInt();
            sum = (N * (N + 1)) / 2;

            if(K == sum) impossible = false;
            for(i = 1; i <= N; i++) if(i*N == K) { impossible = false; break; }

            if(impossible) {
                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + "POSSIBLE");
                if(K == sum) {
                    first = 1;
                } else {
                    first = K / N;
                }
                for(j = 0; j < N; j++) {
                    num = first;
                    for(i = 0; i < N; i++) {
                        num = (num + 1);
                        if(num > N) num = 1;
                        System.out.print(num);
                        if(i < N - 1)
                            System.out.print(" ");
                    }
                    System.out.println();
                    first = (first + 1);
                    if(first > N) first = 1;
                }
            }
        }
    }
}