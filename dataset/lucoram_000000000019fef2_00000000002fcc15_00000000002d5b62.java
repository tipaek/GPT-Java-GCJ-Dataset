
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        outer: for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();

            if (x == 0) {

                int ty = 0;
                int pow = 0;
                String tSeq = "";

                while(Math.abs(ty) < Math.abs(y)) {
                    int jump = (int) Math.pow(2, pow); 
                    tSeq += y < ty ? "S" : "N";
                    ty += y < ty ? -jump : jump;
                    if (ty == y) {
                        System.out.println("Case #" + i + ": " + tSeq);
                        continue outer;
                    }

                    pow++;
                }

                for (int k = 0; k < 2; k++) {
                    int power = 0;
                    int yi = 0;

                    boolean north = k % 2 == 0;
                    String sequence = "";

                    while (Math.abs(yi) < Math.abs(y)) {
                        int jump = (int) Math.pow(2, power);
                        yi += north ? jump : -jump;
                        sequence += north ? "N" : "S";
                        north = !north;
                        power++;
                        if (yi == y) {
                            System.out.println("Case #" + i + ": " + sequence);
                            continue outer;
                        }
                    }
                }

                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue outer;
            } else if (y == 0) {

                int tx = 0;
                int pow = 0;
                String tSeq = "";

                while(Math.abs(tx) < Math.abs(x)) {
                    int jump = (int) Math.pow(2, pow); 
                    tSeq += x < tx ? "W" : "E";
                    tx += x < tx ? -jump : jump;
                    if (tx == x) {
                        System.out.println("Case #" + i + ": " + tSeq);
                        continue outer;
                    }

                    pow++;
                }

                for (int k = 0; k < 2; k++) {
                    int power = 0;
                    int xi = 0;

                    boolean east = k % 2 == 0;
                    String sequence = "";

                    while (Math.abs(xi) < Math.abs(x)) {
                        int jump = (int) Math.pow(2, power);
                        xi += east ? jump : -jump;
                        sequence += east ? "E" : "W";
                        east = !east;
                        power++;
                        if (xi == x) {
                            System.out.println("Case #" + i + ": " + sequence);
                            continue outer;
                        }
                    }
                }

                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue outer;
            } else {

                char[] enws = { 'E', 'N', 'W', 'S' };

                for (int k = 0; k < 4; k++) {
                    int power = 0;
                    int enInd = k;
                    int xi = 0;
                    int yi = 0;

                    String sequence = "";

                    while (Math.abs(xi) < Math.abs(x) || Math.abs(yi) < Math.abs(y)) {
                        int jump = (int) Math.pow(2, power);
                        char dir = enws[enInd];

                        if (dir == 'E') {
                            xi += jump;
                        } else if (dir == 'N') {
                            yi += jump;
                        } else if (dir == 'W') {
                            xi -= jump;
                        } else {
                            yi -= jump;
                        }
                        sequence += dir;

                        enInd++;
                        if (enInd == 4) {
                            enInd = 0;
                        }
                        power++;
                        if (xi == x && yi == y) {
                            System.out.println("Case #" + i + ": " + sequence);
                            continue outer;
                        }
                    }
                }

                enws = new char[] { 'E', 'S', 'W', 'N' };

                for (int k = 0; k < 4; k++) {
                    int power = 0;
                    int enInd = k;
                    int xi = 0;
                    int yi = 0;

                    String sequence = "";

                    while (Math.abs(xi) < Math.abs(x) || Math.abs(yi) < Math.abs(y)) {
                        int jump = (int) Math.pow(2, power);
                        char dir = enws[enInd];

                        if (dir == 'E') {
                            xi += jump;
                        } else if (dir == 'N') {
                            yi += jump;
                        } else if (dir == 'W') {
                            xi -= jump;
                        } else {
                            yi -= jump;
                        }
                        sequence += dir;

                        enInd++;
                        if (enInd == 4) {
                            enInd = 0;
                        }
                        power++;
                        if (xi == x && yi == y) {
                            System.out.println("Case #" + i + ": " + sequence);
                            continue outer;
                        }
                    }
                }

                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue outer;
            }
        }
    }
}