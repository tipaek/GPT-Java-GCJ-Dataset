import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Stream;

public class Solution {

    static String y = "";
    static int requests = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
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
        Boolean[] c = new Boolean[b];
        int remaining = b;
//        while (requests <= 150 && (remaining > 0)) {
//            requests++;
//            if ((requests % 10 == 1) && (requests > 1)) {
//                //TODO some check of the chosen parities and alter c accordingly
//            }
//        }
        for (int i = 0; i < b; i ++){
            System.out.println((i+1));
            int inp = in.nextInt();
            c[i] = (inp == 0)? false: true;
        }
        y = Stream.of(c).map(i -> i ? "1" : "0").reduce((x, y) -> x + y).get();
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
