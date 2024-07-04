import java.io.*;
import java.util.*;

public class Solution {
    static StreamTokenizer input;
    static int nextInt() throws Exception {
        input.nextToken();
        return (int) input.nval;
    }

    static int trace(int[][] a) {
        int total = 0;
        for (int i = 0; i < a.length; i++)
            total += a[i][i];
        return total;
    }

    static int rows(int[][] a) {
        int total = 0;
        for (int i = 0; i < a.length; i++) {
            Set<Integer> s = new HashSet<>();
            for (int j = 0; j < a[i].length; j++) 
                s.add(a[i][j]);
            if (s.size() != a.length) total++;
        }
        return total;
    }

    static int cols(int[][] a) {
        int total = 0;
        for (int i = 0; i < a.length; i++) { // each col
            Set<Integer> s = new HashSet<>();
            for (int j = 0; j < a.length; j++) 
                s.add(a[j][i]);
            if (s.size() != a.length) total++;
        }
        return total;
    }

    public static void main(String [] args) throws Exception {
        input = new StreamTokenizer(new BufferedReader( new InputStreamReader(System.in) ));

        int T = nextInt();
        for (int i = 1; i <= T; i++) {
            int N = nextInt();
            int [][] a = new int[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    a[j][k] = nextInt();
                }
            }

            System.out.println("Case #" + i + ": " + trace(a) +" "+rows(a) + " "+cols(a));
        }        
    }
}