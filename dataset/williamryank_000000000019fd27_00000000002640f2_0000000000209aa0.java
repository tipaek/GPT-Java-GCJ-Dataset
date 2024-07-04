import java.util.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            String result = "";

            if ((K % N == 0 || (N + 1) * N / 2 == K) && (K < (N * N - 1)) && K > (N + 1)) {
                result = "POSSIBLE";
            } else {
                result = "IMPOSSIBLE";
            }

            System.out.printf("Case #%d: %s\n", i + 1, result);
        }
    }
}
