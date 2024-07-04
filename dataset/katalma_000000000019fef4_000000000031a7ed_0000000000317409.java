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
        int x = in.nextInt();
        int y = in.nextInt();
        char[] path = in.next().toCharArray();
        if (x == 0 && y == 0) {
            return "Case #" + (cc+1) +": 0" ;
        }
        for (int i = 0; i<path.length; i++) {
            switch (path[i]) {
                case 'S': y--; break;
                case 'E': y++; break;
                case 'W': x--; break;
                case 'N': x++; break;
            }
            if (Math.abs(x) + Math.abs(y) <= i+1) {
                return "Case #" + (cc+1) +": " + (i+1);
            }
        }
        return "Case #" + (cc+1) +": IMPOSSIBLE" ;
    }

}