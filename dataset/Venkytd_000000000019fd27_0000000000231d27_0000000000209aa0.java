import java.util.*;
import java.io.*;

class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int tests =  in.nextInt();

        for(int test = 1; test <= tests; test++) {
            int N = in.nextInt();
            int K = in.nextInt();

            if(K % N != 0) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + test + ": POSSIBLE");
                int p = K / N;
                for(int i = 1; i <= N; i++) {

                    if(p <= 0) {
                        p = N;
                    }
                    for(int j = p; j <= N; j++) {
                        System.out.print(j + " ");
                    }

                    for(int j = 1; j < p; j++) {
                        System.out.print(j + " ");
                    }
                    p--;
                    System.out.println();
                }
            }
        }
    }
}