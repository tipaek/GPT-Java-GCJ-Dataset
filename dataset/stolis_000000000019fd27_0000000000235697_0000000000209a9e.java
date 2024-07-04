import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int B = in.nextInt();
        for (int t=0; t<T; t++) {
            int[] A = new int[B];
            int known = 0;

            main: while (true) { // one iteration = 10 queries
                // check flip
                int idx = 0;
                // find index that would disclose flip
                for (int i=0; i<known; i++) {
                    if (A[i] == A[B-1-i]) {
                        idx = i;
                        break;
                    }
                }
                System.out.println(idx+1);
                System.out.flush();
                int response = in.nextInt();
                if (response != A[idx]) {
                    // flip
                    for (int i=0; i<B; i++) {
                        A[i] = 1-A[i];
                    }
                }

                // check reversal
                idx = 0;
                // find index that would disclose reversal
                for (int i=0; i<known; i++) {
                    if (A[i] != A[B-1-i]) {
                        idx = i;
                        break;
                    }
                }
                System.out.println(idx+1);
                System.out.flush();
                response = in.nextInt();
                if (response != A[idx]) {
                    // reversal
                    for (int i=0; i<B/2; i++) {
                        int temp = A[i];
                        A[i] = A[B-i-1];
                        A[B-i-1] = temp;
                    }
                }
                
                // extend our knowledge
                for (int i=0; i<4; i++) {
                    known++;
                    System.out.println(known);
                    System.out.flush();
                    A[known-1] = in.nextInt();
                    System.out.println(B-known+1);
                    System.out.flush();
                    A[B-known] = in.nextInt();
                    if (known == B/2) {
                        // all known
                        break main;
                    }
                }
            }
            StringBuilder output = new StringBuilder();
            for (int a : A) {
                output.append(a);
            }
            System.out.println(output);
            System.out.flush();
            in.next();
        }
    }

}
