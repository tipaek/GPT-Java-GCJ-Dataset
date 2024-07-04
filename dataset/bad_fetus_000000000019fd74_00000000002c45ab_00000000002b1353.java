import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static List<Position> positionList = new ArrayList<>();
    static boolean huggingRightWall = true;
    static int lastP2Row = -99;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = Integer.parseInt(sc.nextLine());
        for (int testCase = 0; testCase < testCount; testCase++) {
            int requiredResult = Integer.parseInt(sc.nextLine());
            System.out.println("Case #" + (testCase + 1) + ":");
            if (requiredResult <= 500) {
                for (int r = 0; r < requiredResult; r++) {
                    System.out.println((r + 1) + " 1");
                }
            } else if (requiredResult <= 1000) {
                int currTotal = 1;
                int currRow = 2;
                boolean checkLeftOfRightWall = true;
                System.out.println("1 1");
                while (currTotal != requiredResult) {
                    if (checkLeftOfRightWall) {
                        if (currRow - 1 <= requiredResult - currTotal) {
                            currTotal += currRow - 1;
                            System.out.println(currRow + " " + (currRow - 1));
                        }
                        checkLeftOfRightWall = false;
                    } else {
                        currTotal++;
                        System.out.println(currRow + " " + (currRow));
                        currRow++;
                        checkLeftOfRightWall = true;
                    }
                }
            } else {
                positionList.clear();
                solve(requiredResult);

                for (int i = positionList.size() - 1; i >= 0; i--) {
                    Position position = positionList.get(i);
                    System.out.println((position.r + 1) + " " + (position.k + 1));
                }

            }
        }
        sc.close();
    }

    private static void solve(int requiredResult) {
        if (requiredResult > 0) {
            int powerOf2Row = 0;
            while (Math.pow(2, powerOf2Row) <= requiredResult) {
                powerOf2Row++;
            }
            powerOf2Row--;
            if (requiredResult - Math.pow(2, powerOf2Row) < powerOf2Row) {
                powerOf2Row--;
            }


            if (lastP2Row != -99) {
                int temp = lastP2Row - 1;
                while (temp > powerOf2Row) {
                    if (!huggingRightWall) {
                        positionList.add(new Position(temp, temp));
                    } else {
                        positionList.add(new Position(temp, 0));
                    }
                    temp--;
                    requiredResult--;
                }
            }
            lastP2Row = powerOf2Row;

            if (huggingRightWall) {
                huggingRightWall = false;
                for (int i = 0; i <= powerOf2Row; i++) {
                    positionList.add(new Position(powerOf2Row, i));
                }
            } else {
                huggingRightWall = true;
                for (int i = 0; i <= powerOf2Row; i++) {
                    positionList.add(new Position(powerOf2Row, powerOf2Row - i));
                }
            }

            solve((int) (requiredResult - Math.pow(2, powerOf2Row)));
        }
    }

    static class Position {
        private final int r;
        private final int k;

        Position(int r, int k) {

            this.r = r;
            this.k = k;
        }
    }
}
