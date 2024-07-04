import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        int[] validSteps = new int[31];
        
        for (int i = 0; i < validSteps.length; i++) {
            validSteps[i] = (int) Math.pow(2, i);
        }
        
        for (int testCase = 0; testCase < testCases; testCase++) {
            String[] input = scanner.nextLine().split("\\s+");
            int xTarget = Integer.parseInt(input[0]);
            int yTarget = Integer.parseInt(input[1]);

            if (xTarget % 2 == 1 && yTarget % 2 == 1) {
                System.out.println("Case #" + (testCase + 1) + ": IMPOSSIBLE");
                continue;
            }

            boolean xIsNegative = xTarget < 0;
            boolean yIsNegative = yTarget < 0;
            if (xIsNegative) xTarget = -xTarget;
            if (yIsNegative) yTarget = -yTarget;

            boolean[] xBits = new boolean[31];
            for (int i = 30; i >= 0; i--) {
                xBits[i] = (xTarget & (1 << i)) != 0;
            }

            int[] moves = new int[31];
            int maxIndex = 0;
            for (int i = 0; i < moves.length; i++) {
                if (xBits[i]) {
                    maxIndex = i;
                    moves[i] = xIsNegative ? 1 : 2; // 1: W, 2: E
                }
            }

            int total = 0;
            for (int i = 0; i < moves.length; i++) {
                if (moves[i] == 0) {
                    if (i < maxIndex) {
                        total += validSteps[i];
                    } else if (total >= yTarget) {
                        break;
                    } else {
                        total += validSteps[i];
                        maxIndex = i;
                    }
                }
            }

            int yPos = 0;
            for (int i = maxIndex; i >= 0; i--) {
                if (moves[i] == 0) {
                    if (yPos <= yTarget) {
                        yPos += validSteps[i];
                        moves[i] = yIsNegative ? 3 : 4; // 3: S, 4: N
                    } else {
                        yPos -= validSteps[i];
                        moves[i] = yIsNegative ? 4 : 3; // 4: S, 3: N
                    }
                }
            }

            if (yPos == yTarget) {
                StringBuilder result = new StringBuilder();
                for (int move : moves) {
                    switch (move) {
                        case 1:
                            result.append('W');
                            break;
                        case 2:
                            result.append('E');
                            break;
                        case 3:
                            result.append('S');
                            break;
                        case 4:
                            result.append('N');
                            break;
                        default:
                            break;
                    }
                }
                System.out.println("Case #" + (testCase + 1) + ": " + result.toString());
            } else {
                System.out.println("Case #" + (testCase + 1) + ": IMPOSSIBLE");
            }
        }
        scanner.close();
    }
}