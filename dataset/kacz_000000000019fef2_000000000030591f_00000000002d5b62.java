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
        long x = input.nextLong();
        long y = input.nextLong();

        boolean impossible = false;
        StringBuilder path = new StringBuilder();
        int pow = 0;
        while (x != 0 || y != 0) {
            long step = (long)Math.pow(2,pow);
            long nextStep = step * 2;
            long nextNextStep = nextStep * 2;
            if(Math.floorMod(x,nextStep) == step) {
                if((y!=0 && Math.floorMod(x + step,nextNextStep) != Math.floorMod(y,nextNextStep)) || (y == 0 && (x+step == 0 || Math.floorMod(x+step,nextNextStep) == nextStep))) {
                    if(y == 0 && x-step == 0) {
                        x = x - step;
                        path.append("E");
                        continue;
                    }
                    x = x + step;
                    path.append("W");
                } else if((y!=0 && Math.floorMod(x - step,nextNextStep) != Math.floorMod(y,nextNextStep)) || (y == 0 && (x - step == 0 || Math.floorMod(x-step,nextNextStep) ==nextStep))) {
                    if(y == 0 && x+step == 0) {
                        x = x + step;
                        path.append("W");
                        continue;
                    }
                    x = x - step;
                    path.append("E");
                } else {
                    impossible = true;
                    break;
                }
            } else if (Math.floorMod(y,nextStep) == step) {
                if((x != 0 && Math.floorMod(y + step,nextNextStep) != Math.floorMod(x,nextNextStep)) || (x == 0 && (y+step == 0 || Math.floorMod(y+step,nextNextStep) ==nextStep))) {
                    if(x == 0 && y-step == 0) {
                        y = y - step;
                        path.append("N");
                        continue;
                    }
                    y = y + step;
                    path.append("S");
                } else if((x != 0 && Math.floorMod(y - step,nextNextStep) != Math.floorMod(x,nextNextStep)) || (x == 0 && (y-step == 0 || Math.floorMod(y-step,nextNextStep) ==nextStep))) {
                    if(x == 0 && y+step == 0) {
                        y = y + step;
                        path.append("S");
                        continue;
                    }
                    y = y - step;
                    path.append("N");
                } else {
                    impossible = true;
                    break;
                }
            } else {
                impossible = true;
                break;
            }
            pow+=1;
        }

        if(impossible) {
            outln("IMPOSSIBLE");
        } else {
            outln(path.toString());
        }

    }
}