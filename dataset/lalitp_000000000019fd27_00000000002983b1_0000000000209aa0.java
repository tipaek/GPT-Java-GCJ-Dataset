import java.util.*;

public class Solution {

    public static void main(String[] args) {
	// write your code here
        int T, N, K, t, sum, i, j, first, num, trace;
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        boolean impossible;
        T = sc.nextInt();
        for(t = 1; t <= T; t++) {
            impossible = true;
            trace = 0;
            sb.setLength(0);
            N = sc.nextInt();
            K = sc.nextInt();
            sum = (N * (N + 1)) / 2;

            if(K == sum) impossible = false;
            for(i = 1; i <= N; i++) if(i*N == K) { impossible = false; break; }

            if(impossible) {
                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
            } else {
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
                        sb.append(num);
                        if(i < N - 1)
                            sb.append(" ");
                        if(i == j) trace += num;
                    }
                    sb.append(System.getProperty("line.separator"));
                    first = (first + 1);
                    if(first > N) first = 1;
                }

                if(trace == K) {
                    System.out.println("Case #" + t + ": " + "POSSIBLE");
                    System.out.println(sb.toString());
                } else {
                    System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
                }
            }
        }
    }
}