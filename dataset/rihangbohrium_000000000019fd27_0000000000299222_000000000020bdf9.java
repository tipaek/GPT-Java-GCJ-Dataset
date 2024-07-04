import java.io.*;
import java.util.*;


public class Solution {
    static void disp(boolean [] a) {
        for (boolean b : a) {
            if (b) System.out.print(1);
            else System.out.print(0);
        }
        System.out.println();
    }
    
    static String solve(int[][] a) {
        String r = "";
        boolean[] c = new boolean[1441];
        boolean[] j = new boolean[1441];
        int [] time = new int[1441];
        
        for (int[] act : a) {
            int s = act[0]; int e = act[1];
            for (int i = s; i < e; i++) {
                time[i]++;
            }
        }
        // if they ever need to be at more than 2 places
        // they cannot schedule
        boolean check = false;
        for (int i : time) {
            if (i > 2) {return "IMPOSSIBLE";}
            if (i == 2) check = true;
        }
        // if they never need to be at more than 1 place,
        // one of them can be scheduled for all
        if (!check) {
            for (int i = 0; i < a.length; i++) 
                r += "C";
            return r;
        }

        for (int[] act : a) {
            int s = act[0]; int e = act[1];
            boolean cOccupied = false;
            boolean jOccupied = false;
            for (int i = s; i < e; i++) {
                if (c[i]) cOccupied = true;
                if (j[i]) jOccupied = true;
            }
            
            if (!cOccupied) {
                r += 'C';
                for (int i = s; i < e; i++) 
                    c[i] = true;
            } else if (!jOccupied) {
                r += 'J';
                for (int i = s; i < e; i++) 
                    j[i] = true;
            } else return "IMPOSSIBLE";
        }

        return r;
    }

    public static void main(String [] args) throws Exception {
        BufferedReader in = new BufferedReader( new InputStreamReader(System.in) );
        int T = Integer.parseInt( in.readLine() );
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(in.readLine());
            int[][] a = new int[N][2];

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                a[j][0] = Integer.parseInt(st.nextToken());
                a[j][1] = Integer.parseInt(st.nextToken());
            }

            System.out.println("Case #" + i + ": " + solve(a));
        }
    }
}