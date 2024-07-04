import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        byte testCases = Byte.parseByte(scanner.nextLine());
        String impossible = "IMPOSSIBLE";
        int[][] dots = new int[testCases][2];

        for (int i = 0; i < testCases; i++) {
            if (scanner.hasNext()) {
                dots[i][0] = scanner.nextInt();
                dots[i][1] = scanner.nextInt();
            }
        }

        for (int i = 0; i < testCases; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            int distance = Math.abs(dots[i][0]) + Math.abs(dots[i][1]);
            if (distance % 2 == 0) {
                System.out.println(impossible);
                continue;
            }

            int curX = dots[i][0];
            int curY = dots[i][1];
            StringBuilder result = new StringBuilder();
            int qty = 0;
            int reverseStep = -1;

            while (distance > 0) {
                int curValue = (qty == 0) ? 1 : 2 * qty;
                qty++;
                if (distance >= curValue) {
                    distance -= curValue;
                } else {
                    boolean found = false;
                    for (int j = 0; j < qty - 1; j++) {
                        int testValue = (j == 0) ? 1 : 2 * j;
                        if (distance + 2 * testValue == curValue) {
                            reverseStep = j;
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        qty = -1;
                    }
                    break;
                }
            }

            if (qty == -1) {
                System.out.println(impossible);
                continue;
            }

            for (int j = 0; j < qty; j++) {
                int curValue = (j == 0) ? 1 : 2 * j;
                int nextValue = (j + 1 == qty) ? 0 : curValue + 2;

                if (curValue == 1) {
                    if (Math.abs(curX) % 2 == 0 && curY != 0) {
                        if (curY > 0) {
                            result.append(reverseStep == j ? "S" : "N");
                            curY += reverseStep == j ? 1 : -1;
                        } else {
                            result.append(reverseStep == j ? "N" : "S");
                            curY += reverseStep == j ? -1 : 1;
                        }
                    } else {
                        if (curX > 0) {
                            result.append(reverseStep == j ? "W" : "E");
                            curX += reverseStep == j ? 1 : -1;
                        } else {
                            result.append(reverseStep == j ? "E" : "W");
                            curX += reverseStep == j ? -1 : 1;
                        }
                    }
                } else {
                    if (curX == 0 || (Math.abs(curY) - curValue == 0)) {
                        if (curY > 0) {
                            result.append(reverseStep == j ? "S" : "N");
                            curY += reverseStep == j ? curValue : -curValue;
                        } else {
                            result.append(reverseStep == j ? "N" : "S");
                            curY += reverseStep == j ? -curValue : curValue;
                        }
                        continue;
                    }
                    if (curY == 0 || (Math.abs(curX) - curValue == 0)) {
                        if (curX > 0) {
                            result.append(reverseStep == j ? "W" : "E");
                            curX += reverseStep == j ? curValue : -curValue;
                        } else {
                            result.append(reverseStep == j ? "E" : "W");
                            curX += reverseStep == j ? -curValue : curValue;
                        }
                        continue;
                    }

                    if (Math.abs(curX) - curValue < nextValue) {
                        if (curY > 0) {
                            result.append(reverseStep == j ? "S" : "N");
                            curY += reverseStep == j ? curValue : -curValue;
                        } else {
                            result.append(reverseStep == j ? "N" : "S");
                            curY += reverseStep == j ? -curValue : curValue;
                        }
                    } else {
                        if (curX > 0) {
                            result.append(reverseStep == j ? "W" : "E");
                            curX += reverseStep == j ? curValue : -curValue;
                        } else {
                            result.append(reverseStep == j ? "E" : "W");
                            curX += reverseStep == j ? -curValue : curValue;
                        }
                    }
                }
            }
            System.out.println(result);
        }
    }
}