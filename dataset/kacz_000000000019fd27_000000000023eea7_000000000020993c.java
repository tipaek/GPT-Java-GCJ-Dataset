import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
        int n = input.nextInt();
        boolean[] columnFlags = new boolean[n];
        HashSet<Integer>[] columnElements = new HashSet[n];
        for (int i = 0; i < n; i++) {
            columnFlags[i] = false;
            columnElements[i] = new HashSet<>(n);
        }

        int r = 0;
        int c = 0;
        int k = 0;

        for (int row = 0; row < n; row++) {
            boolean rowFlag = false;
            Set<Integer> rowElements = new HashSet<>(n);
            for (int col = 0; col < n; col++) {
                int e = input.nextInt();
                if (rowElements.contains(e)) {
                    rowFlag = true;
                } else {
                    rowElements.add(e);
                }

                if(columnElements[col].contains(e)) {
                    columnFlags[col] = true;
                } else {
                    columnElements[col].add(e);
                }
                if(row == col) {
                    k += e;
                }
            }
            if(rowFlag) {
                r++;
            }
        }

        for (int i = 0; i < n; i++) {
            if(columnFlags[i]) {
                c++;
            }
        }
        outln(k + " " + r + " " + c);
    }
}