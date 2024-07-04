import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseCount = in.nextInt();

        for (int i = 1; i <= caseCount; i++) {
            processCase(i, in);
        }
    }

    public static void processCase(int caseNumber, Scanner in) {
        int x = in.nextInt();
        int y = in.nextInt();
        int totalPower = Math.abs(x) + Math.abs(y) - 1;
        boolean impossible = !((x % 2 != y % 2) && (totalPower > 0 && (totalPower & (totalPower - 1)) == 0));

        if (impossible) {
            printResult(caseNumber, "IMPOSSIBLE");
            return;
        }

        int larger = Math.abs(x) > Math.abs(y) ? x : y;
        int smaller = Math.abs(x) > Math.abs(y) ? y : x;
        boolean inverted = Math.abs(x) > Math.abs(y);

        Map<Integer, String> directions = new HashMap<>();
        int val = totalPower;
        int xTotal = 0;
        int yTotal = 0;
        int count = 0;

        while (val > 1) {
            if (count == 0) {
                if (inverted) {
                    if (x > 0) {
                        directions.put(val, "E");
                        xTotal = val;
                    } else {
                        directions.put(val, "W");
                        xTotal = -val;
                    }
                } else {
                    if (y > 0) {
                        directions.put(val, "N");
                        yTotal = val;
                    } else {
                        directions.put(val, "S");
                        yTotal = -val;
                    }
                }
            } else {
                if (inverted) {
                    if (x > 0 && xTotal - val > x) {
                        directions.put(val, "W");
                        xTotal -= val;
                    } else if (x < 0 && xTotal + val < x) {
                        directions.put(val, "E");
                        xTotal += val;
                    } else {
                        handleYDirection(y, directions, val, yTotal);
                        yTotal = updateYTotal(y, directions, val, yTotal);
                    }
                } else {
                    if (y > 0 && yTotal - val > y) {
                        directions.put(val, "S");
                        yTotal -= val;
                    } else if (y < 0 && yTotal + val < y) {
                        directions.put(val, "N");
                        yTotal += val;
                    } else {
                        handleXDirection(x, directions, val, xTotal);
                        xTotal = updateXTotal(x, directions, val, xTotal);
                    }
                }
            }
            val >>= 1;
            count++;
        }

        if (xTotal != x) {
            directions.put(1, x > xTotal ? "E" : "W");
        } else if (yTotal != y) {
            directions.put(1, y > yTotal ? "N" : "S");
        }

        String output = String.join("", directions.values());
        printResult(caseNumber, output);
    }

    private static void handleYDirection(int y, Map<Integer, String> directions, int val, int yTotal) {
        if (yTotal == 0 && y > 0) {
            directions.put(val, "N");
        } else if (yTotal == 0 && y < 0) {
            directions.put(val, "S");
        } else if (y > 0) {
            directions.put(val, "S");
        } else {
            directions.put(val, "N");
        }
    }

    private static int updateYTotal(int y, Map<Integer, String> directions, int val, int yTotal) {
        if (yTotal == 0 && y > 0) {
            return val;
        } else if (yTotal == 0 && y < 0) {
            return -val;
        } else if (y > 0) {
            return yTotal - val;
        } else {
            return yTotal + val;
        }
    }

    private static void handleXDirection(int x, Map<Integer, String> directions, int val, int xTotal) {
        if (x > 0 && xTotal == 0) {
            directions.put(val, "E");
        } else if (x < 0 && xTotal == 0) {
            directions.put(val, "W");
        } else if (x > 0) {
            directions.put(val, "W");
        } else {
            directions.put(val, "E");
        }
    }

    private static int updateXTotal(int x, Map<Integer, String> directions, int val, int xTotal) {
        if (x > 0 && xTotal == 0) {
            return val;
        } else if (x < 0 && xTotal == 0) {
            return -val;
        } else if (x > 0) {
            return xTotal - val;
        } else {
            return xTotal + val;
        }
    }

    private static void printResult(int caseNumber, String result) {
        System.out.println("Case #" + caseNumber + ": " + result);
    }
}