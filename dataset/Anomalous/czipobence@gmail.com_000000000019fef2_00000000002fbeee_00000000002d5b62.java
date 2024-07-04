import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            boolean isPossible = (x + y) % 2 != 0;
            StringBuilder path = new StringBuilder();
            int exp = 1;
            int currentX = x;
            int currentY = y;

            while (isPossible && (currentX != 0 || currentY != 0)) {
                int nextExp = exp * 2;

                if (currentX % nextExp == currentY % nextExp) {
                    isPossible = false;
                    break;
                }

                int nextNextExp = nextExp * 2;
                if (currentX % nextExp == 0) {
                    int nextY1 = currentY + exp;
                    int nextY2 = currentY - exp;

                    if (nextY1 == 0) {
                        currentY = nextY1;
                        path.append("S");
                    } else if (nextY2 == 0) {
                        currentY = nextY2;
                        path.append("N");
                    } else if (currentX % nextNextExp == 0) {
                        if (nextY1 % nextNextExp == 0) {
                            currentY = nextY2;
                            path.append("N");
                        } else {
                            currentY = nextY1;
                            path.append("S");
                        }
                    } else {
                        if (nextY1 % nextNextExp == 0) {
                            currentY = nextY1;
                            path.append("S");
                        } else {
                            currentY = nextY2;
                            path.append("N");
                        }
                    }
                } else {
                    if (currentY % nextExp != 0) {
                        isPossible = false;
                        break;
                    }

                    int nextX1 = currentX + exp;
                    int nextX2 = currentX - exp;

                    if (nextX1 == 0) {
                        currentX = nextX1;
                        path.append("W");
                    } else if (nextX2 == 0) {
                        currentX = nextX2;
                        path.append("E");
                    } else if (currentY % nextNextExp == 0) {
                        if (nextX1 % nextNextExp == 0) {
                            currentX = nextX2;
                            path.append("E");
                        } else {
                            currentX = nextX1;
                            path.append("W");
                        }
                    } else {
                        if (nextX1 % nextNextExp == 0) {
                            currentX = nextX1;
                            path.append("W");
                        } else {
                            currentX = nextX2;
                            path.append("E");
                        }
                    }
                }

                exp = nextExp;
            }

            if (isPossible) {
                System.out.println("Case #" + caseNumber + ": " + path.toString());
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }
}