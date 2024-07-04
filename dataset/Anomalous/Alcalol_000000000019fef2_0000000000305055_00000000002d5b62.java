import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int caseCount = scanner.nextInt();
        for (int i = 1; i <= caseCount; i++) {
            handleCase(i, scanner);
        }
    }

    public static void handleCase(int caseNumber, Scanner scanner) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int totalPower = Math.abs(x) + Math.abs(y) - 1;
        boolean isImpossible = !((x % 2 != y % 2) && (totalPower > 0 && (totalPower & (totalPower - 1)) == 0));

        if (isImpossible) {
            printResult(caseNumber, "IMPOSSIBLE");
            return;
        }

        int larger, smaller;
        boolean inverted = Math.abs(x) > Math.abs(y);

        if (inverted) {
            larger = x;
            smaller = y;
        } else {
            larger = y;
            smaller = x;
        }

        HashMap<Integer, String> moves = new HashMap<>();
        int val = totalPower;
        int count = 0;
        int xTotal = 0;
        int yTotal = 0;

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
                        if (x > 0 && xTotal == 0) {
                            moves.put(val, "E");
                            xTotal = val;
                        } else if (x < 0 && xTotal == 0) {
                            moves.put(val, "W");
                            xTotal = -val;
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

        StringBuilder output = new StringBuilder();
        for (int i = totalPower; i > 0; i >>= 1) {
            output.append(moves.get(i));
        }

        printResult(caseNumber, output.toString());
    }

    public static void printResult(int caseNumber, String result) {
        System.out.println("Case #" + caseNumber + ": " + result);
    }
}