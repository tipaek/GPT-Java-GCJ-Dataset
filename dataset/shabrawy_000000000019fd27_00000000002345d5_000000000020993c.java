
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *
 * @author Mohamed_Elshabrawy
 */
class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
//        br = new BufferedReader(new FileReader("D:\\A1.in"));
        sc = new Scanner(System.in);
        out = new PrintWriter("D:\\A1.out");
//        sc = new StringTokenizer("");
        int tc = sc.nextInt();
        int n = -1;
        int[][] x = null;
        String s = "";
        for (int t = 1; t <= tc; t++) {
            n = sc.nextInt();
//            s = nxtTok();
            x = nxtIntArr2(n);
            int k = 0;
            int r = 0;
            int c = 0;
            Set rSet = null;
            Set cSet = null;
            for (int i = 0; i < n; i++) {
                rSet = new HashSet<Integer>();
                cSet = new HashSet<Integer>();
                boolean flag1 = true;
                boolean flag2 = true;
                for (int j = 0; j < n; j++) {
                    if (!rSet.add(x[i][j]) && flag1) {
                        r++;
                        flag1 = false;
                    }
                    if (!cSet.add(x[j][i]) && flag2) {
                        c++;
                        flag2 = false;
                    }
                    if (i == j) {
                        k += x[i][j];
                    }

                }
            }
            
            System.out.println("Case #"+t+": "+k+" "+r +" "+c );
        }
//        br.close();
//        out.close();
    }

    static BufferedReader br;
    static Scanner sc;
    static PrintWriter out;

//    static String nxtTok() throws IOException {
//        while (!sc.hasMoreTokens()) {
//            String s = br.readLine();
//            if (s == null) {
//                return null;
//            }
//            sc = new StringTokenizer(s.trim());
//        }
//        return sc.nextToken();
//    }

//    static int nxtInt() throws IOException {
//        return Integer.parseInt(nxtTok());
//    }
//
//    static long nxtLng() throws IOException {
//        return Long.parseLong(nxtTok());
//    }
//
//    static double nxtDbl() throws IOException {
//        return Double.parseDouble(nxtTok());
//    }

    static int[] nxtIntArr(int n) throws IOException {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        return a;
    }

//    static long[] nxtLngArr(int n) throws IOException {
//        long[] a = new long[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = nxtLng();
//        }
//        return a;
//    }

//    static char[] nxtCharArr() throws IOException {
//        return nxtTok().toCharArray();
//    }

    static int[][] nxtIntArr2(int n) throws IOException {
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        return a;
    }

}
