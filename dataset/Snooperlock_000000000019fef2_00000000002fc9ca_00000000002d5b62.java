import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;

/*
Java:
 openjdk 1.8.0_181 (package: openjdk-8-jdk)
 javac src/Solution.java -d .
 java -Xms896m -Xmx896m -Xss64m -XX:+UseSerialGC Solution
 */

public class Solution implements Runnable {

    ///////////////////////
    // File name variables
    final String problem = "A";
//    final String problem = "B";
//    final String problem = "C";
//    final String problem = "D";

    //    final String filename = problem + "-sample";
    final String filename = problem + "-small-practice";
//    final String filename = problem + "-large-practice";

//    final String filename = problem + "-small-attempt0";
//     final String filename= problem+"-small-attempt1";
//    final String filename= problem+"-small-attempt2";
//     final String filename= problem+"-large";

    // Output Float format
    // e.g. out.write(df.format(T0));
    DecimalFormat df = new DecimalFormat("0.000000");

    Comparator<Integer[]> comparator = new Comparator<Integer[]>() {

        @Override
        public int compare(Integer[] o1, Integer[] o2) {
            return o1[0].compareTo(o2[0]);
        }
    };

    //////////////////////////////////////////
    // Hard core function
    public void solve() throws Exception {
        int goalX = iread(), goalY = iread();

        StringBuffer sb = new StringBuffer();
        int check = canJump(new BigInteger("0"), new BigInteger("0"),
                new BigInteger(String.valueOf(goalX)), new BigInteger(String.valueOf(goalY)), 1, sb);

        if (check != Integer.MAX_VALUE) {
            out.write(sb.reverse().toString());
        } else {
            out.write("IMPOSSIBLE");
        }
    }

    private int canJump(BigInteger curX, BigInteger curY, BigInteger goalX, BigInteger goalY, int nextMoveIndex, StringBuffer res) {
        if (curX.compareTo(goalX) == 0 && curY.compareTo(goalY) == 0) return nextMoveIndex;

        BigInteger total = goalX.abs().add(goalY.abs());
        BigInteger two = new BigInteger("2");

        if (two.pow(nextMoveIndex - 1).compareTo(total) > 0) return Integer.MAX_VALUE;

        BigInteger nextJump = two.pow(nextMoveIndex - 1);

        //System.out.println("Current steps: " + res.toString());

        int findMin = Integer.MAX_VALUE;

        // North
        //System.out.println("Checking south");
        int north = canJump(curX, curY.add(nextJump), goalX, goalY, nextMoveIndex + 1, res);
        if (north < findMin) findMin = north;

        // South
        //System.out.println("Checking south");
        int south = canJump(curX, curY.subtract(nextJump), goalX, goalY, nextMoveIndex + 1, res);
        if (south < findMin) findMin = south;

        // East
        //System.out.println("Checking east");
        int east = canJump(curX.add(nextJump), curY, goalX, goalY, nextMoveIndex + 1, res);
        if (east < findMin) findMin = east;

        // West
        //System.out.println("Checking west");
        int west = canJump(curX.subtract(nextJump), curY, goalX, goalY, nextMoveIndex + 1, res);
        if (west < findMin) findMin = west;

        if (findMin != Integer.MAX_VALUE) {
            if (north == findMin) {
                res.append('N');
            } else if (south == findMin) {
                res.append('S');
            } else if (east == findMin) {
                res.append('E');
            } else {
                res.append('W');
            }
        }
        return findMin;
    }

    //////////////////////////////////////////
    /// Helper functions
    public void solve_gcj() throws Exception {
        int tests = iread();

        for (int test = 1; test <= tests; test++) {
            // Remember to comment it out for interactive question
            out.write("Case #" + test + ": ");
            solve();
            out.write("\n");
            out.flush();

            // Remember to uncomment it for interactive question
//            String res = readLine();
//            if (res.equals("N")) {
//                break;
//            }
        }
    }

    public void run() {
        try {
            // Helper in-&-out for local test

            in = new BufferedReader(new InputStreamReader(System.in));
            out = new BufferedWriter(new OutputStreamWriter(System.out));

            // For real file input and output
//            in = new BufferedReader(new FileReader(filename + ".in"));
//            out = new BufferedWriter(new FileWriter(filename + ".out"));
            solve_gcj();
            //out.flush();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    BufferedReader in;

    BufferedWriter out;

    public int iread() throws Exception {
        return Integer.parseInt(readword());
    }

    public double dread() throws Exception {
        return Double.parseDouble(readword());
    }

    public long lread() throws Exception {
        return Long.parseLong(readword());
    }

    public String readword() throws IOException {
        StringBuilder b = new StringBuilder();
        int c;
        c = in.read();
        while (c >= 0 && c <= ' ')
            c = in.read();
        if (c < 0)
            return "";
        while (c > ' ') {
            b.append((char) c);
            c = in.read();
        }
        return b.toString();
    }

    public String readLine() throws IOException {
        StringBuilder b = new StringBuilder();
        int c;
        c = in.read();
        while (c != '\n') {
            b.append((char) c);
            c = in.read();
        }
        return b.toString();
    }

    /////////////////////////
    // Solution Function
    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception e) {

        }
        new Thread(new Solution()).start();
    }
}
