import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tests = input.nextInt();

        for(int i = 1; i <= tests; i++){
            int N = input.nextInt();
            int D = input.nextInt();
            long[] A = new long[N];

            for(int j = 0; j < N; j++){
                A[j] = input.nextLong();
            }
            int result = Solve(N, D, A);

            System.out.println( String.format("Case #%d: %d", i, result) );
        }
    }

    static int Solve(int N, int D, long[] A){
        HashMap<Long, Integer> map = new HashMap<>();
        
        for(long s: A) {
            int t = map.getOrDefault(s, 0);
            map.put(s, t + 1);

            if (map.get(s) == D) {
                return 0;
            }
        }
        if (D == 1) { return 0; }
        if (D == 2) { return 1; }

        for(int i = 0; i < A.length; i++){
            long a = A[i];
            for(int j = i + 1; j < A.length; j++){
                long b = A[j];
                if (a != b && (a%b == 0 || b%a == 0)) {
                    return 1;
                }
            }
        }
        
        return 2;
    }

    static int gcd(int a, int b) {
        if (a > 0) {
            return gcd(b % a, a);
        } else {
            return b;
        }
    }
}