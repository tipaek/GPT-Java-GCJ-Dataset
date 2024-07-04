import java.util.*;
import java.io.*;

public class Solution {
    private static final boolean LOCAL_TESTING = false;
    private static final String OUTPUT_FORMAT = "Case #%d: %s";
    private static final String SEPARATOR = " ";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final String NORTH = "N";
    private static final String SOUTH = "S";
    private static final String EAST = "E";
    private static final String WEST = "W";
    private static final List<Integer> POWERS_OF_2 = new ArrayList<>();
    
    static {
        for (int pow = 0; pow < 32; pow++) {
            int powOf2 = 1 << pow;
            testPrintln("2^" + pow + " = " + powOf2);
            POWERS_OF_2.add(powOf2);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int T = in.nextInt();
        in.nextLine();
        
        for (int currentTestCase = 1; currentTestCase <= T; currentTestCase++) {
            StringBuilder sb = new StringBuilder();
            final int X = in.nextInt();
            final int Y = in.nextInt();
            in.nextLine();
            
            testPrintln("Goal: " + X + "," + Y);
            final int X_ABS = Math.abs(X);
            final int Y_ABS = Math.abs(Y);
            
            if ((X_ABS + Y_ABS) % 2 == 0) {
                System.out.println(String.format(OUTPUT_FORMAT, currentTestCase, IMPOSSIBLE));
                continue;
            }
            
            if (X_ABS == 0) {
                int powerOf2Pos = findPowerOf2Position(Y_ABS);
                if (powerOf2Pos == -1) {
                    System.out.println(String.format(OUTPUT_FORMAT, currentTestCase, IMPOSSIBLE));
                    continue;
                }
                findPath(Y_ABS, powerOf2Pos, sb);
                System.out.println(String.format(OUTPUT_FORMAT, currentTestCase, sb.toString()));
            }
        }
    }

    private static int findPowerOf2Position(int Y_ABS) {
        for (int poz = 0; poz < POWERS_OF_2.size(); poz++) {
            int powerOf2 = POWERS_OF_2.get(poz);
            testPrintln(Y_ABS + " - " + powerOf2 + " = " + (Y_ABS - powerOf2) + " < 0? ->" + (Y_ABS - powerOf2 < 0));
            if (Y_ABS - powerOf2 < 0) {
                testPrintln("Found power of 2 poz to use:" + (poz - 1) + ". (" + Y_ABS + " - " + "2^" + (poz - 1) + " = " + (Y_ABS - POWERS_OF_2.get(poz - 1)) + ")");
                return poz - 1;
            }
        }
        return -1;
    }

    private static void findPath(int Y_ABS, int powerOf2Pos, StringBuilder sb) {
        int yRest = Y_ABS;
        int direction = -1;
        for (int poz = powerOf2Pos; poz >= 0; poz--) {
            testPrintln(yRest + " - " + "(" + direction + ")" + "2^" + poz + " = " + POWERS_OF_2.get(poz));
            yRest += direction * POWERS_OF_2.get(poz);
            testPrintln("yRest = " + yRest);
            sb.insert(0, (direction == -1) ? NORTH : SOUTH);
            if (yRest == 0) {
                return;
            } else if (yRest > 0 && direction == -1) {
                // still need to reduce = north steps
            } else if (yRest < 0 && direction == -1) {
                direction *= -1;
            }
        }
    }

    private static void testPrintln(String s) {
        if (LOCAL_TESTING) {
            System.out.println(s);
        }
    }

    private static void testPrint(String s) {
        if (LOCAL_TESTING) {
            System.out.print(s);
        }
    }
}