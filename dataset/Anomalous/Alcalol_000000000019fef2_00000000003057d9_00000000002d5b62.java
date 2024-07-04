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

        if (isImpossible(x, y)) {
            printResult(caseNumber, "IMPOSSIBLE");
        } else {
            String path = findPath(x, y);
            printResult(caseNumber, path);
        }
    }

    private static boolean isImpossible(int x, int y) {
        int totalPower = Math.abs(x) + Math.abs(y) - 1;
        if ((x % 2 != 0 && y % 2 == 0) || (x % 2 == 0 && y % 2 != 0)) {
            return !(totalPower > 0 && (totalPower & (totalPower - 1)) == 0);
        }
        return true;
    }

    private static String findPath(int x, int y) {
        int totalPower = Math.abs(x) + Math.abs(y) - 1;
        boolean inverted = Math.abs(x) > Math.abs(y);
        int larger = inverted ? x : y;
        int smaller = inverted ? y : x;

        Map<Integer, String> moves = new HashMap<>();
        int xTotal = 0, yTotal = 0;
        int val = totalPower;
        int count = 0;

        while (val > 1) {
            if (count == 0) {
                if (inverted) {
                    if (x > 0) {
                        moves.put(val, "E");
                        xTotal = val;
                    } else {
                        moves.put(val, "W");
                        xTotal = -val;
                    }
                } else {
                    if (y > 0) {
                        moves.put(val, "N");
                        yTotal = val;
                    } else {
                        moves.put(val, "S");
                        yTotal = -val;
                    }
                }
            } else {
                if (inverted) {
                    if (x > 0 && xTotal - val > x) {
                        moves.put(val, "W");
                        xTotal -= val;
                    } else if (x < 0 && xTotal + val < x) {
                        moves.put(val, "E");
                        xTotal += val;
                    } else {
                        if (yTotal == 0) {
                            if (y > 0) {
                                moves.put(val, "N");
                                yTotal = val;
                            } else {
                                moves.put(val, "S");
                                yTotal = -val;
                            }
                        } else if (y > 0) {
                            moves.put(val, "S");
                            yTotal -= val;
                        } else {
                            moves.put(val, "N");
                            yTotal += val;
                        }
                    }
                } else {
                    if (y > 0 && yTotal - val > y) {
                        moves.put(val, "S");
                        yTotal -= val;
                    } else if (y < 0 && yTotal + val < y) {
                        moves.put(val, "N");
                        yTotal += val;
                    } else {
                        if (xTotal == 0) {
                            if (x > 0) {
                                moves.put(val, "E");
                                xTotal = val;
                            } else {
                                moves.put(val, "W");
                                xTotal = -val;
                            }
                        } else if (x > 0) {
                            moves.put(val, "W");
                            xTotal -= val;
                        } else {
                            moves.put(val, "E");
                            xTotal += val;
                        }
                    }
                }
            }
            val >>= 1;
            count++;
        }

        if (xTotal != x) {
            moves.put(1, x > xTotal ? "E" : "W");
        } else if (yTotal != y) {
            moves.put(1, y > yTotal ? "N" : "S");
        }

        return String.join("", moves.values());
    }

    private static void printResult(int caseNumber, String result) {
        System.out.println("Case #" + caseNumber + ": " + result);
    }
}