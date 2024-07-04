import java.util.*;
import java.io.*;
public class Solution {



   public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();

            int exp = 1;

            int tmpx =x;
            int tmpy = y;

            boolean isPossible = (x + y) % 2 != 0;

            StringBuilder path = new StringBuilder();

            while (isPossible && (tmpx != 0 || tmpy != 0)) {

                int nextX;
                int nextY;
                int nextExp = exp *2;

                if (tmpx % nextExp == tmpy % nextExp) {
                    isPossible = false;
                    break;
                }

                int nextNextExp = nextExp *2;
                if (tmpx % nextExp == 0) {
                    nextX = tmpx;

                    int nextTmpY1 = tmpy + exp;
                    int nextTmpY2 = tmpy - exp;

                    if (nextTmpY1 == 0) {
                        nextY = nextTmpY1;
                        path.append("S");
                    } else if (nextTmpY2 == 0) {
                        nextY = nextTmpY2;
                        path.append("N");
                    } else if (tmpx % nextNextExp == 0) {
                        if (nextTmpY1 % nextNextExp == 0) {
                            nextY = nextTmpY2;
                            path.append("N");
                        } else {
                            nextY = nextTmpY1;
                            path.append("S");
                        }
                    } else {
                        if (nextTmpY1 % nextNextExp == 0) {
                            nextY = nextTmpY1;
                            path.append("S");
                        } else {
                            nextY = nextTmpY2;
                            path.append("N");
                        }
                    }

                } else {
                    if (tmpy % nextExp != 0) {
                        isPossible = false;
                        break;
                    }

                    nextY = tmpy;

                    int nextTmpX1 = tmpx + exp;
                    int nextTmpX2 = tmpx - exp;

                    if (nextTmpX1 == 0) {
                        nextX = nextTmpX1;
                        path.append("W");
                    } else if (nextTmpX2 == 0) {
                        nextX = nextTmpX2;
                        path.append("E");
                    } else if (tmpy % nextNextExp == 0) {
                        if (nextTmpX1 % nextNextExp == 0) {
                            nextX = nextTmpX2;
                            path.append("E");
                        } else {
                            nextX = nextTmpX1;
                            path.append("W");
                        }
                    } else {
                        if (nextTmpX1 % nextNextExp == 0) {
                            nextX = nextTmpX1;
                            path.append("W");
                        } else {
                            nextX = nextTmpX2;
                            path.append("E");
                        }
                    }
                }

                tmpx = nextX;
                tmpy = nextY;
                exp = nextExp;
            }



            if (isPossible) {
                System.out.println("Case #" + i + ": " + path.toString());
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }

        }
    }
}