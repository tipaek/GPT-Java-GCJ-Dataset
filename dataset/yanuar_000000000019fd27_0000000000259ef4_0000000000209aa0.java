
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scan.nextInt();
        for (int t=0; t<T; t++) {
            int N = scan.nextInt();
            int K = scan.nextInt();
            
            if (K>=N && K<=(N*N) && K%N == 0) {
                int startNumber = K/N;
                System.out.printf("Case #%d: POSSIBLE\n", t+1);
                printNaturalLatinSquares(N, startNumber);
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", t+1);
            }
        }
    }
    
    public static void printNaturalLatinSquares(int N, int startNumber) {
        for (int i=0; i<N; i++) {
            int start = startNumber+i > N ? ((startNumber+i)%(N+1)+1) : startNumber+i;
            for (int j=0; j<N; j++) {
                if (j==0) {
                    System.out.print(start%(N+1));
                } else {
                    System.out.print(" " + (start%(N+1)));
                }
                start = start-1 <= 0 ? N : start-1;
            }
            System.out.println();
        }
    }
}
