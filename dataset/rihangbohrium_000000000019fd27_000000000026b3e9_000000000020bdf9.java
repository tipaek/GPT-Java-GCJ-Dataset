import java.io.*;
import java.util.*;

public class parents {
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


        for (int i = 0; i < a.length; i++) {
            int s = a[i][0]; int e = a[i][1];
            boolean checkJ = false;

            for (int j = s; j < e; j++) 
                if (ctime[j]) {
                    r += "J";
                    for (int k = s; k < e; k++) {
                        if (jtime[k]) return "IMPOSSIBLE";
                        jtime[k] = true;
                    }
                    continue;
                }
            r += "C";
            for (int j = s; j < e; j++)
                ctime[j] = true;
            
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