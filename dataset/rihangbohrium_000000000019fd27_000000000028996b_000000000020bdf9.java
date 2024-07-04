import java.io.*;
import java.util.*;

public class Solution {
    static StreamTokenizer input;
    static int nextInt() throws Exception {
        input.nextToken();
        return (int) input.nval;
    }

    static String solve(int[][] a) {
        String r = "";
        int lastTime = 0;
        for (int [] ar : a)
            if (ar[1] > lastTime) lastTime = ar[1];
        
        boolean[] ctime = new boolean[lastTime+1];
        boolean[] jtime = new boolean[lastTime+1];

        for (int i = 0; i < a.length; i++) { // for each activity
            int s = a[i][0]; int e = a[i][1];
            boolean checkJ = false;

            for (int j = s; j < e; j++) // if c is occupied, j must be checked
                if (ctime[j]) checkJ = true;
            if (!checkJ) { // if c isnt occupied, assign activity to c
                r += "C";
                for (int j = s; j < e; j++)
                    ctime[j] = true;
            } else {
                r += "J";
                for (int j = s; j < e; j++) {
                    if (jtime[j]) return "IMPOSSIBLE"; // if j is ever occupied too, return impossible
                    jtime[j] = true;
                }
            }
        }
    
        return r;
    }

    public static void main(String [] args) throws Exception {
        input = new StreamTokenizer(new BufferedReader( new InputStreamReader(System.in) ));

        int T = nextInt();
        for (int i = 1; i <= T; i++) {
            int N = nextInt();
            int [][] a = new int[N][2];

            for (int j = 0; j < N; j++) {
                a[j][0] = nextInt();
                a[j][1] = nextInt();
            }

            System.out.println("Case #" + i + ": " + solve(a));

        }        
    }
}