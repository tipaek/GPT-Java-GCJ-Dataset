import java.util.*;
import java.io.*;

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
            boolean reverseFlag = false;
            int curValue;
            while (distance > 0) {
                curValue = (qty == 0 ? 1 : 2 * qty);
                if (distance >= curValue) {
                    distance -= curValue;
                } else {
                    reverseFlag = true;
                    distance = 0;
                }
                qty++;
            }

            for (int j = 0; j < qty; j++) {
                curValue = (j == 0 ? 1 : 2 * j);
                int nextValue = (j + 1 == qty) ? 0 : curValue + 2;

                if (curValue == 1) {
                    if (Math.abs(curX) % 2 == 0 && curY != 0) {
                        if (curY > 0) {
                            result.append(reverseFlag ? "S" : "N");
                            curY += reverseFlag ? 1 : -1;
                        } else {
                            result.append(reverseFlag ? "N" : "S");
                            curY += reverseFlag ? -1 : 1;
                        }
                    } else {
                        if (curX > 0) {
                            result.append(reverseFlag ? "W" : "E");
                            curX += reverseFlag ? 1 : -1;
                        } else {
                            result.append(reverseFlag ? "E" : "W");
                            curX += reverseFlag ? -1 : 1;
                        }
                    }
                } else {
                    if (curX == 0 || Math.abs(curY) == curValue) {
                        result.append(curY > 0 ? "N" : "S");
                        curY += curY > 0 ? -curValue : curValue;
                    } else if (curY == 0 || Math.abs(curX) == curValue) {
                        result.append(curX > 0 ? "E" : "W");
                        curX += curX > 0 ? -curValue : curValue;
                    } else if (Math.abs(curX) - curValue < nextValue) {
                        result.append(curY > 0 ? "N" : "S");
                        curY += curY > 0 ? -curValue : curValue;
                    } else {
                        result.append(curX > 0 ? "E" : "W");
                        curX += curX > 0 ? -curValue : curValue;
                    }
                }
            }
            System.out.println(result);
        }
    }
}