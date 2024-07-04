import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);

        // read in num test cases T
        int T = scanIn.nextInt();
        int[][] results = new int[T][4]; // case num, trace, repeats in rows, repeats in columns

        // read in matrix
        for (int x=1; x<=T; x++) {
            int N = scanIn.nextInt();
            int[][] mat = new int[N][N];
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    mat[i][j] = scanIn.nextInt();
                }
            }
            // work out trace
            int k = 0;
            for (int i=0; i<N; i++) {
                k += mat[i][i];
            }

            // work out repeats in r
            int r = 0;
            for (int i=0; i<N; i++) {
                HashSet<Integer> set = new HashSet<>();
                for (int j=0; j<N; j++) {
                    if (!set.add(mat[i][j])){
                        //couldn't add so must be duplicate
                        r++;
                        break;
                    }
                }
            }

            // work out repeats in c
            int c = 0;
            for (int j=0; j<N; j++) {
                HashSet<Integer> set = new HashSet<>();
                for (int i=0; i<N; i++) {
                    if (!set.add(mat[i][j])){
                        //couldn't add so must be duplicate
                        c++;
                        break;
                    }
                }
            }

            int [] arr = {x,k,r,c};
            results[x-1] = arr;
        }

        for (int x=0; x<T; x++){
            System.out.printf("Case #%d: %d %d %d\n", results[x][0], results[x][1], results[x][2], results[x][3]);
        }
    }
}
