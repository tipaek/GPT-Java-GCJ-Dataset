import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static BufferedReader in;
    static List<Point> points = new ArrayList<>();

    public static void main(String[] args) {
        int horizontalJumps[] = new int[32];
        int verticalJumps[] = new int[32];

        readInput();

        int i = 1;

        for (Point point : points) {
            computeScore(point, i);
            i++;
        }
    }

    private static void computeScore(Point point, int testcaseId) {
        int verticalJumps[] = new int[32];
        int horizontalJumps[] = new int[32];

        int x = Math.abs(point.x);
        int y = Math.abs(point.y);

        boolean horizontalPositive = point.x >= 0;
        boolean verticalPositive = point.y >= 0;

        int size = 0;

        while (x > 0 || y > 0) {
            int xByte = x % 2;
            int yByte = y % 2;

            if ((xByte == 0 && yByte == 0 && size == 0) || (xByte == 1 && yByte == 1 && size == 0)) {
                impossible(testcaseId);
                return;
            }

            if (xByte == 1 && yByte == 1) {
                if (verticalJumps[size - 1] != 0) {
                    horizontalJumps[size] = 1;
                    verticalJumps[size + 1] = 1;
                    flipJump(verticalJumps, size - 1);
                } else {
                    verticalJumps[size] = 1;
                    horizontalJumps[size + 1] = 1;
                    flipJump(horizontalJumps, size - 1);
                }
            } else {
                if (xByte == 1) {
//                    if (horizontalJumps[size] != 0) {
//                        impossible(testcaseId);
//                        return;
//                    }

                    if (horizontalJumps[size] != 0) {
                        horizontalJumps[size] = 0;
                        horizontalJumps[size + 1] = 1;
                        verticalJumps[size] = 1;
                        flipJump(verticalJumps, size - 1);
                    } else {
                        horizontalJumps[size] = 1;
                    }
                }

                if (yByte == 1) {
//                    if (verticalJumps[size] != 0) {
//                        impossible(testcaseId);
//                        return;
//                    }

                    if (verticalJumps[size] != 0) {
                        verticalJumps[size] = 0;
                        verticalJumps[size + 1] = 1;
                        horizontalJumps[size] = 1;
                        flipJump(horizontalJumps, size - 1);
                    } else {
                        verticalJumps[size] = 1;
                    }
                }
            }

            x = x / 2;
            y = y / 2;

            size++;
        }

        for (int i = 0; i < size; i++) {
            if (verticalJumps[i] == 0 && horizontalJumps[i] == 0) {
                if (verticalJumps[i - 1] != 0) {
                    flipJump(verticalJumps, i - 1);
                    verticalJumps[i] = verticalJumps[i - 1];
                    flipJump(verticalJumps, i);
                } else {
                    flipJump(horizontalJumps, i - 1);
                    horizontalJumps[i] = horizontalJumps[i - 1];
                    flipJump(horizontalJumps, i);
                }
            }
        }

        if (!horizontalPositive) {
            for (int i = 0; i < size + 1; i++) {
                if (horizontalJumps[i] != 0) {
                    flipJump(horizontalJumps, i);
                }
            }
        }

        if (!verticalPositive) {
            for (int i = 0; i < size + 1; i++) {
                if (verticalJumps[i] != 0) {
                    flipJump(verticalJumps, i);
                }
            }
        }

        if (!verifySolution(verticalJumps, horizontalJumps, point)) {
            impossible(testcaseId);
            return;
        }

        System.out.print("Case #" + testcaseId + ": ");

        for (int i = 0; i < size + 1; i++) {
            if (horizontalJumps[i] == 1) {
                System.out.print("E");
            }

            if (horizontalJumps[i] == -1) {
                System.out.print("W");
            }

            if (verticalJumps[i] == 1) {
                System.out.print("N");
            }

            if (verticalJumps[i] == -1) {
                System.out.print("S");
            }
        }

        System.out.println();
    }

    private static boolean verifySolution(int[] verticalJumps, int[] horizontalJumps, Point point) {
        boolean endOfJumps = false;
        int xScore = 0;
        int yScore = 0;

        boolean valid = true;

        for (int i = 0; i < 32; i++) {
            if (verticalJumps[i] != 0 && horizontalJumps[i] != 0) {
                valid = false;
            }

            if (verticalJumps[i] == 0 && horizontalJumps[i] == 0) {
                endOfJumps = true;
            }

            if ((verticalJumps[i] != 0 || horizontalJumps[i] != 0) && endOfJumps) {
                valid = false;
            }

            xScore += horizontalJumps[i] * Math.pow(2, i);
            yScore += verticalJumps[i] * Math.pow(2, i);
        }

        if (xScore != point.x || yScore != point.y) {
            valid = false;
        }

//        if (!valid) {
//            System.out.println("ERROR");
//        }

        return valid;
    }

    private static void flipJump(int[] horizontalJumps, int index) {
        if (horizontalJumps[index] == 1) {
            horizontalJumps[index] = -1;
        } else {
            horizontalJumps[index] = 1;
        }
    }

    private static void impossible(int testcaseId) {
        System.out.println("Case #" + testcaseId + ": IMPOSSIBLE");
    }

    private static void readInput() {
        in = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = in.readLine();

            int numberOfTestCases = Integer.parseInt(line);

            for (int i = 0; i < numberOfTestCases; i++) {
                line = in.readLine();

                String[] fractals = line.split(" ");

                Point point = new Point();
                point.x = Integer.parseInt(fractals[0]);
                point.y = Integer.parseInt(fractals[1]);

                points.add(point);
            }
        } catch (IOException e) {
            System.out.println("something went wrong during reading input");
        }
    }
}
