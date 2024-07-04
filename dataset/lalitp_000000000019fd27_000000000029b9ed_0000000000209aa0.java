import java.util.*;

public class Solution {

    public static void main(String[] args) {
        // write your code here
        int T, N, K, t, sum, i, j, first = 1, num, trace;
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        boolean impossible;
        boolean diagonal;
        T = sc.nextInt();
        for(t = 1; t <= T; t++) {
            impossible = true;
            diagonal = true;
            trace = 0;
            sb.setLength(0);
            N = sc.nextInt();
            K = sc.nextInt();
            sum = (N * (N + 1)) / 2;

            if(K == sum) {first = 1; impossible = false; }
            else for(i = 1; i <= N; i++) if(i*N == K) { diagonal = false; first = i; impossible = false; break; }

            if(impossible) {
                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
            } else {
                for(j = 0; j < N; j++) {
                    num = first;
                    for(i = 0; i < N; i++) {
                        sb.append(num);
                        if(i == j) trace += num;
                        if(i < N - 1)
                            sb.append(" ");
                       num++;
                        if(num > N) num = 1;

                    }
                    if(j < N - 1)
                        sb.append(System.getProperty("line.separator"));
                    if(diagonal) first++;
                    else first--;

                    if(first > N) first = 1;
                    if(first < 1) first = N;
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