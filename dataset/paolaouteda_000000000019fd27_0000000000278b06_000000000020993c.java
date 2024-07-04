import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int count = 1;
        do {
            int n = sc.nextInt();
            int[][] A = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    A[i][j] = sc.nextInt();
                }
            }
            int c = 0;
            int r = 0;
            int trace = 0;

            for(int i = 0; i < n; i++){
                HashSet<Integer> h = new HashSet<Integer>();
                //System.out.println("i: "+i);
                for (int j = 0; j < n; j++) {
                    if ( !h.contains(A[i][j]) ) {
                        h.add(A[i][j]);
                    }
                    else{
                        r++;
                        //System.out.println("r : "+r);
                        break;
                    }
                }

            }
            for (int j = 0; j < n; j++) {
                HashSet<Integer> h = new HashSet<Integer>();
                for (int i = 0; i < n; i++) {
                    if ( !h.contains(A[i][j]) ) {
                        h.add(A[i][j]);
                    }
                    else{
                        c++;
                        //System.out.println("r : "+r);
                        break;
                    }
                }
            }
            // sumar diagonal
            int j = 0;
            for (int i = 0; i < n; i++) {
                while (j < n) {
                    trace += A[i][j];
                    j++;
                    break;
                }
            }

            System.out.println("Case #"+count+": "+trace + " " + r + " " +c);
            t--;
            count++;
        } while (t > 0);
    }
}
