import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    private static Scanner input = new Scanner(System.in);
    private static PrintStream output = new PrintStream(System.out);
    private static PrintStream logger = null;

    private static final String CENTER = "CENTER";
    private static final String HIT = "HIT";
    private static final String MISS = "MISS";
    private static final String WRONG = "WRONG";
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
            logger = new PrintStream(new File("log.txt"));
        }

        int cases = input.nextInt();
        int A = input.nextInt();
        int B = input.nextInt();
        input.nextLine();
        for (int i = 0; i < cases; ++i) {
            solve(i + 1, A, B);
        }
    }

    private static void solve(int testCaseNumber, int A, int B) {
        long x=-500000000,y=-500000000;

        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                counter += 1;
                long xtry = x + i * 500000000;
                long ytry = y + j * 500000000;
                outln(xtry + " " + ytry);
                String reply = input.nextLine();
                if(WRONG.equals(reply)) {
                    System.exit(0);
                } else if(CENTER.equals(reply)) {
                    return;
                } else if (HIT.equals(reply)) {
                    findCenter(xtry, ytry, counter);
                    return;
                }
            }
        }
    }

    private static void findCenter(long x, long y, int counter) {
        //finding minX
        long lower = -1000000000;
        long upper = x;

        while (lower < upper - 1) {
            long xtry = (lower + upper) /2;
            outln(xtry + " " + y);
            String reply = input.nextLine();
            if(WRONG.equals(reply)) {
                System.exit(0);
            } else if(CENTER.equals(reply)) {
                return;
            } else if (HIT.equals(reply)) {
                upper = xtry;
            } else {
                lower = xtry;
            }
        }
        long minX = upper;

        //finding maxX
        lower = x;
        upper = 1000000000;

        while (lower < upper - 1) {
            long xtry = (lower + upper) /2;
            outln(xtry + " " + y);
            String reply = input.nextLine();
            if(WRONG.equals(reply)) {
                System.exit(0);
            } else if(CENTER.equals(reply)) {
                return;
            } else if (HIT.equals(reply)) {
                lower = xtry;
            } else {
                upper = xtry;
            }
        }
        long maxX = lower;

        //finding minY
        lower = -1000000000;
        upper = y;

        while (lower < upper - 1) {
            long ytry = (lower + upper) /2;
            outln(x + " " + ytry);
            String reply = input.nextLine();
            if(WRONG.equals(reply)) {
                System.exit(0);
            } else if(CENTER.equals(reply)) {
                return;
            } else if (HIT.equals(reply)) {
                upper = ytry;
            } else {
                lower = ytry;
            }
        }
        long minY = upper;

        //finding maxY
        lower = y;
        upper = 1000000000;

        while (lower < upper - 1) {
            long ytry = (lower + upper) /2;
            outln(x + " " + ytry);
            String reply = input.nextLine();
            if(WRONG.equals(reply)) {
                System.exit(0);
            } else if(CENTER.equals(reply)) {
                return;
            } else if (HIT.equals(reply)) {
                lower = ytry;
            } else {
                upper = ytry;
            }
        }
        long maxY = lower;
        
        long centerX = (minX + maxX) / 2;
        long centerY = (minY + maxY) / 2;

        outln(centerX + " " + centerY);
        String reply = input.nextLine();
        if(WRONG.equals(reply)) {
            System.exit(0);
        } else if(CENTER.equals(reply)) {
            return;
        } else {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    long xtry = centerX + i;
                    long ytry = centerY + j;
                    outln(xtry + " " + ytry);
                    reply = input.nextLine();
                    if(WRONG.equals(reply)) {
                        System.exit(0);
                    } else if(CENTER.equals(reply)) {
                        return;
                    }
                }
            }
        }
    }
}