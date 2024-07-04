import java.util.*;
import java.io.*;

public class Solution {
    private static final boolean LOCAL_TESTING = false;
    private static final String OUTPUT_FORMAT = "Case #%d: %s"; //Use with String.format - 1.: number of the test case, 2.: solution
    private static final String SEPARATOR = " ";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final String NORTH = "N";
    private static final String SOUTH = "S";
    private static final String EAST = "E";
    private static final String WEST = "W";
    private static final List<Integer> POWERS_OF_2 = new ArrayList();
    static {
        int max_pow = 32;
        for(int pow=0; pow<32; pow++) {
            int pow_of_2 = (int)Math.pow(2, pow);
            testPrintln("2^" + pow + " = " + pow_of_2);
            POWERS_OF_2.add(pow_of_2);
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int T = in.nextInt(); //number of test cases
        in.nextLine();
test:   for (int currentTestCase = 1; currentTestCase <= T; currentTestCase++) {
            StringBuilder sb = new StringBuilder();
            final int X = in.nextInt(); //X coordinate to reach (10^9 fits at least 4 times into an int)
            final int Y = in.nextInt(); //Y coordinate to reach
            in.nextLine();
            testPrintln("Goal: " + X + "," + Y);
            final int X_ABS = Math.abs(X);
            final int Y_ABS = Math.abs(Y);
            if((X_ABS + Y_ABS) % 2 == 0) {
                //even position, we cant reach it
                System.out.println(String.format(OUTPUT_FORMAT, currentTestCase, IMPOSSIBLE));
                continue test;
            }
            //lets solve only for the positive quarter and we just need to negate it later
            if(X_ABS == 0) {
                int powerOf2Pos = -1;
                for(int poz=0; poz<POWERS_OF_2.size(); poz++) {
                    int powerOf2 = POWERS_OF_2.get(poz);
                    testPrintln(Y_ABS + " - " + powerOf2 + " = " + (Y_ABS - powerOf2) + " < 0? ->" + (Y_ABS - powerOf2 < 0));
                    if(Y_ABS - powerOf2 < 0) {
                        //the previous power is what we are looking for, the current is too much
                        powerOf2Pos = poz - 1;
                        testPrintln("Found power of 2 poz to use:" + powerOf2Pos + ". (" + Y_ABS + " - " + "2^" + powerOf2Pos + " = " + (Y_ABS-POWERS_OF_2.get(powerOf2Pos)) + ")");
                        break;
                    }
                }
                if(powerOf2Pos == -1) {
                    //we did not find it
                    System.out.println(String.format(OUTPUT_FORMAT, currentTestCase, IMPOSSIBLE));
                    continue test;
                }
                int yRest = Y_ABS;
                int direction = -1;
                for(int poz=powerOf2Pos; 0<=poz; poz--) {
                    //lets go backward
                    testPrintln(yRest + " - " + "(" + direction + ")" + "2^" + poz + " = " + POWERS_OF_2.get(poz));
                    yRest = yRest + (direction * POWERS_OF_2.get(poz));
                    testPrintln("yRest = " + yRest);
                    sb.insert(0, ((direction == -1) ? NORTH : SOUTH));
                    if(yRest == 0) {
                        System.out.println(String.format(OUTPUT_FORMAT, currentTestCase, sb.toString()));
                        continue test;
                    }
                    else if(0 < yRest && direction == -1) {
                        //still need to reduce = nort steps
                    }
                    else if(yRest < 0 && direction == -1) {
                        //we went over it, we need south steps and to change to addition
                        direction *= -1;
                    }
                }
            }
            System.out.println(String.format(OUTPUT_FORMAT, currentTestCase, sb.toString()));
        } //end of test cases
    } //end of main
    
    /**
     * Helper method to return the negate of a direction.
     * 
     * @param direction
     * @return 
     */
    private static String negate(char direction) {
        return negate(String.valueOf(direction));
    }
    
    /**
     * Helper method to return the negate of a direction.
     * 
     * @param direction
     * @return 
     */
    private static String negate(String direction) {
        switch(direction) {
            case EAST: {
                return WEST;
            }
            case WEST: {
                return EAST;
            }
            case NORTH: {
                return SOUTH;
            }
            case SOUTH: {
                return NORTH;
            }
        }
        throw new RuntimeException("Not available direction: " + direction);
    }
    
    /**
     * Helper method to print text while locally testing but easily switching it off in the Code Jam submission
     * @param s 
     */
    protected static void testPrintln(String s) {
        if(LOCAL_TESTING) {
            System.out.println(s);
        }
    }
    /**
     * Helper method to print text while locally testing but easily switching it off in the Code Jam submission
     * @param s 
     */
    protected static void testPrint(String s) {
        if(LOCAL_TESTING) {
            System.out.print(s);
        }
    }
}