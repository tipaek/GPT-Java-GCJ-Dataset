import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    private static Scanner input = null;
    private static PrintStream logger = null;
    private static PrintStream output = null;
    private static boolean debug = false;

    public static <E> void log(E msg) {
        if(debug) {
            logger.println("LOG: " + msg);
        }
    }

    public static <E> void out(E msg) {
        out(msg, false);
    }

    public static <E> void outln(E msg) {
        out(msg, true);
    }

    private static <E> void out(E msg, boolean println) {
        output.print(msg);
        if(println) {
            output.println();
        }
        output.flush();

        if(debug) {
            logger.print("OUT: " + msg);
            if(println) {
                logger.println("\\n");
            } else {
                logger.println();
            }
            logger.flush();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length > 0 && args[0].equals("-debug")) {
            debug = true;
            input = new Scanner(new File("in.txt"));
            output = new PrintStream(new File("out.txt"));
            logger = new PrintStream(new File("log.txt"));
        } else {
            input = new Scanner(System.in);
            output = new PrintStream(System.out);
        }

        int cases = input.nextInt();
        input.nextLine();
        for (int i = 0; i < cases; ++i) {
            solve(i + 1);
        }
    }

    private static void solve(int testCaseNumber) {
        out("Case #" + testCaseNumber + ": ");
        long l = input.nextLong();
        long r = input.nextLong();

        long diff = Math.max(l,r) - Math.min(l,r);

        long n = (long) Math.floor((Math.sqrt(-1+8*diff)+1)/2);

        if (l >= r) {
            l -= n*(n+1)/2;
        } else {
            r -= n*(n+1)/2;
        }



        boolean maxLeft = l >= r;
        long max = Math.max(l,r);
        long min = Math.min(l,r);

        long xmax = n+1;
        long xmin = n + 2;

        if(xmax > max) {
            report(maxLeft, n, max, min);
            return;
        } else if (xmin > min) {
            report(maxLeft, n+1, max - xmax, min);
            return;
        }
        long kmax = (long)Math.floor((-xmax-1+Math.sqrt((xmax+1)*(xmax+1)-4*(xmax-max)))/2);
        long kmin = (long)Math.floor((-xmin-1+Math.sqrt((xmin+1)*(xmin+1)-4*(xmin-max)))/2);

        long maxRemain = max - (kmax*kmax + kmax * (xmax+1) + xmax);
        long minRemain = min - (kmin*kmin + kmin * (xmin+1) + xmin);
        report(maxLeft, n + kmax+1 + kmin+1, maxRemain, minRemain);

    }

    private static void report(boolean maxLeft, long l, long maxRemain, long minRemain) {
        long left = maxLeft ? maxRemain : minRemain;
        long right = maxLeft ? minRemain : maxRemain;
        outln(l + " " + left + " " + right);
    }
}