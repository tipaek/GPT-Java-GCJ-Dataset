import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {


    public static void main(String[] args) throws Exception {
        String fileName = "read_v.txt";
        Scanner in = new Scanner(System.in );
//        Scanner in = new Scanner(System.in.available() > 0 ? System.in : new FileInputStream(fileName));
//        PrintStream o = new PrintStream(new FileOutputStream(fileName + ".out"));
        PrintStream o = new PrintStream(System.out);
//        Scanner in = new Scanner(System.in.available() > 0 ? System.in : new FileInputStream("resource/gcj2020/qr/read_v.txt"));
        int cases = in.nextInt();
        for (int i = 0; i<cases; i++ ) {
            o.println(solve(in, i));
        }
        in.close();



        o.close();
    }

    private static String solve(Scanner in, int cc) {
        int t = 0;
        int r = 0;
        int c = 0;
        int n = in.nextInt();
        int[][] m = new int[n][];
        int[] row ;
        for (int i = 0; i<n; i++) {
            m[i] = new int[n];
            row = new int[n];
            boolean good = true;
            for (int j = 0; j< n ; j++) {
                m[i][j] = in.nextInt();
                if (i == j) {
                    t += m[i][j];
                }
                row[m[i][j]-1]++;
                good &= row[m[i][j]-1] == 1;
            }
            if (good) {
                r++;
            }
        }
        for (int j = 0; j<n; j++) {
            row = new int[n];
            boolean good = true;
            for (int i = 0; i< n ; i++) {
                row[m[i][j]-1]++;
                good &= row[m[i][j]-1] == 1;
            }
            if (good) {
                c++;
            }
        }
        return "Case #" + (cc+1) +": " + t +" " + (n-r) +" " + (n-c);
    }
}
