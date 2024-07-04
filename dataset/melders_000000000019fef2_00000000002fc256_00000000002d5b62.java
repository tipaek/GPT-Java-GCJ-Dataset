import java.io.*;
import java.util.*;

public class Solution {
    private static final boolean INTERACTIVE_PROBLEM = false;
    private static final String FILE_NAME = null;

    private static String solve(Scanner in) {
        int X = in.nextInt();
        int Y = in.nextInt();

        long currentX = 0;
        long currentY = 0;
        long nextJump = 1;
        boolean isImpossible = false;
        StringBuilder path = new StringBuilder();

        while (!isImpossible && (currentX != X || currentY != Y)) {
            if (currentX == X) {
                long northPosition = currentY + nextJump;
                long southPosition = currentY - nextJump;
                if (southPosition == Y) {
                    currentY -= nextJump;
                    path.append('S');
                } else if ((northPosition == Y)
                        || ((Y - northPosition) % (nextJump * 2) == 0 && (Y - northPosition) % (nextJump * 4) != 0)) {
                    currentY += nextJump;
                    path.append('N');
                } else if ((Y - southPosition) % (nextJump * 2) == 0 && (Y - southPosition) % (nextJump * 4) != 0) {
                    currentY -= nextJump;
                    path.append('S');
                } else {
                    isImpossible = true;
                }
            } else if (currentY == Y) {
                long eastPosition = currentX + nextJump;
                long westPosition = currentX - nextJump;
                if (westPosition == X) {
                    currentX -= nextJump;
                    path.append('W');
                } else if ((eastPosition == X)
                        || ((X - eastPosition) % (nextJump * 2) == 0 && (X - eastPosition) % (nextJump * 4) != 0)) {
                    currentX += nextJump;
                    path.append('E');
                } else if ((X - westPosition) % (nextJump * 2) == 0 && (X - westPosition) % (nextJump * 4) != 0) {
                    currentX -= nextJump;
                    path.append('W');
                } else {
                    isImpossible = true;
                }
            } else {
                long northPosition = currentY + nextJump;
                long eastPosition = currentX + nextJump;

                if ((Y - currentY) % (nextJump * 2) != 0 && (X - currentX) % (nextJump * 2) != 0) {
                    isImpossible = true;
                } else if ((Y - currentY) % (nextJump * 2) != 0) {
                    if ((X - currentX) % (nextJump * 4) == 0) {
                        if ((Y - northPosition) % (nextJump * 4) == 0) {
                            currentY -= nextJump;
                            path.append('S');
                        } else {
                            currentY += nextJump;
                            path.append('N');
                        }
                    } else {
                        if ((Y - northPosition) % (nextJump * 4) == 0) {
                            currentY += nextJump;
                            path.append('N');
                        } else {
                            currentY -= nextJump;
                            path.append('S');
                        }
                    }
                } else if ((X - currentX) % (nextJump * 2) != 0) {
                    if ((Y - currentY) % (nextJump * 4) == 0) {
                        if ((X - eastPosition) % (nextJump * 4) == 0) {
                            currentX -= nextJump;
                            path.append('W');
                        } else {
                            currentX += nextJump;
                            path.append('E');
                        }
                    } else {
                        if ((X - eastPosition) % (nextJump * 4) == 0) {
                            currentX += nextJump;
                            path.append('E');
                        } else {
                            currentX -= nextJump;
                            path.append('W');
                        }
                    }
                } else {
                    isImpossible = true;
                }
            }

            nextJump *= 2;
        }

        return isImpossible ? "IMPOSSIBLE" : path.toString();
    }

    private static void run() {
        try {
            Scanner in = new Scanner(new BufferedReader(FILE_NAME == null ? new InputStreamReader(System.in)
                    : new FileReader(new File(FILE_NAME + ".in"))));

            long tc = in.nextLong();
            for (long t = 1; t <= tc; t++) {
                final String solution = solve(in);
                if (INTERACTIVE_PROBLEM) {
                    System.out.println(solution);
                    if (in.next().equals("N")) {
                        break;
                    }
                } else {
                    System.out.println("Case #" + t + ": " + solution);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        run();
    }
}
