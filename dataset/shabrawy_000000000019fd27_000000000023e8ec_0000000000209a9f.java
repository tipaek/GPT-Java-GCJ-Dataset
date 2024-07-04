
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
class Soluation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {
            String sInput = "";
            String sOutput = "";
            sInput = sc.next();
//            s = nxtTok();
            int k = sInput.length();
            int r = 0;
            int c = 0;
            int prev = 0;
            int input = 0;
            for (int i = 0; i < k; i++) {
                input = Integer.parseInt("" + sInput.charAt(i));
//                if (input == 0) {
//                    for (int j = 0; j < c; j++) {
//                        sOutput += ")";
//                    }
//
//                } else
                if (input < prev) {
                    int loop = prev - input;
                    while (loop > 0) {
                        sOutput += ")";
                        loop--;
                    }
                } else if (input == prev) {

                } else if (input > prev) {
                    int loop = input - prev;
                    while (loop > 0) {
                        sOutput += "(";
                        loop--;
                    }

                }
                sOutput += "" + input;
                prev = input;
            }
            for (int i = 0; i < input; i++) {
                sOutput += ")";
            }
            System.out.println("Case #" + t + ": " + sOutput);
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
