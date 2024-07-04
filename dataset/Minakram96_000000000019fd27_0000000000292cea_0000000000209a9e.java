import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Stream;

public class Solution {

    static String y = "";
    static int requests = 0;
    static Scanner in;
    static Boolean[] c;

    public static void main(String[] args) {
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        int b = in.nextInt();
        for (int i = 0; i < cases; i++) {
            y = "";
//            int n = in.nextInt();
            solve(b, in);
            int temp = i + 1;
            System.out.println(y);
            String reply = in.next();
            if (reply.equals("N")) {
                return;
            }
        }
    }

    private static void solve(int b, Scanner in) {
        c = new Boolean[b];
        for (int j=0; j < b; j++){
            c[j] = false;
        }
        int remaining = b/2;

        int equalsParity = -1;
        int oppositeParity = -1;
        int i =0;
        for ( i = 0; i < 5; i++) {
            c[i] = requestPosition(i);
            remaining--;
            c[b - i - 1] = requestPosition(b - i - 1);
            if (c[b - i - 1] == c[i]) {
                equalsParity = i;
            }
            if (c[b - i - 1] != c[i]) {
                oppositeParity = i;
            }
        }

        // Now the changes start!
        //Check what changes have happened


        while (remaining > 0) {
            // System.out.println(remaining);
            checkParityChange(equalsParity, oppositeParity);
            // read 4 new pairs
            int temp = (b/2)-remaining; //starting pairs remaining to read
            for ( i = 0; (i < 4) && (remaining>0); i++) {
                int pairPos = temp + i;
                c[pairPos] = requestPosition(pairPos);
                remaining--;
                c[b - pairPos - 1] = requestPosition(b - pairPos - 1);
                if (c[b - pairPos - 1] == c[pairPos]) {
                    equalsParity = pairPos;
                }
                if (c[b - pairPos - 1] != c[pairPos]) {
                    oppositeParity = pairPos;
                }
            }
        }
        y = Stream.of(c).map(val -> val ? "1" : "0").reduce((x, y) -> x + y).get();
    }

    private static void checkParityChange(int equalsParity, int oppositeParity) {
        boolean newEquals = requestPosition((equalsParity != -1) ? equalsParity : 1);
        boolean newOpposite = requestPosition((oppositeParity != -1) ? oppositeParity : 1);
        if (equalsParity != -1) {
            if (newEquals != c[equalsParity]) {// 1 -> 0
                // Either reflection or inversion
                if (oppositeParity != -1) {
                    if (newOpposite == c[oppositeParity]) { // 1 -> 1
                        c = inverse(reflect(c));
                    } else { //1 -> 0
                        c = inverse(c);
                    }
                } else {
                    // because all parities are essentially the same
                    c = inverse(c);
                }
            } else { // 1 -> 1
                if (oppositeParity != -1) {
                    if (newOpposite == c[oppositeParity]) { // 1 -> 1
                        // nothing changed
                    } else { //1 -> 0
                        // reflection
                        c = reflect(c);
                    }
                }
            }
        } else {
            // Each parity has an opposing pair
            if (newOpposite == c[oppositeParity]){
                // reflect and invert create the same result!
                c = inverse(c);
            }
        }
    }

    private static boolean requestPosition(int pos) {
        System.out.println(pos + 1);
        requests++;
        int inp = in.nextInt();
        return inp != 0;
    }

    private static Boolean[] inverse(Boolean[] b) {
        Boolean[] ret = new Boolean[b.length];
        int size = b.length;
        for (int i = 0; i < size; i++) {
            ret[i] = !b[i];
        }

        return ret;
    }

    private static Boolean[] reflect(Boolean[] b) {
        Boolean[] ret = new Boolean[b.length];
        int size = b.length;
        for (int i = 0; i < size; i++) {
            ret[i] = b[size - i - 1];
        }

        return ret;
    }
}
