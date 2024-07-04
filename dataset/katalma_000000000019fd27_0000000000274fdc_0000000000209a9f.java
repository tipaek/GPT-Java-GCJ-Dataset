import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {


    public static void main(String[] args) throws Exception {
        String fileName = "read_n.txt";
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
        String row = in.next();
        char[] inputs = row.toCharArray();
        int[] count = new int[10];
        char prev = '0';
        String left = "((((((((((";
        String right = "))))))))))";
        StringBuffer b = new StringBuffer(row.length() + 2);
        for (int i = 0; i< inputs.length; i++) {
            char act = inputs[i];
            if (prev != act) {
                int dist = act - prev;
                if (dist > 0) {
                    b.append(left.substring(0, dist ));
                } else {
                    b.append(right.substring(0, -1* dist));
                }
            }
            b.append(act);
            prev = act;
        }
        b.append(right.substring(0, prev - '0' ));
        return "Case #" + (cc+1) +": " +b.toString();
    }
}
