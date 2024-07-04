import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < testCases; ++caseIndex) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String moves = scanner.next();

            HashMap<Character, Integer> moveCounts = new HashMap<>();
            int steps = 0;

            while (steps < moves.length()) {
                char currentMove = moves.charAt(steps);
                boolean isRepeatedMove = moveCounts.getOrDefault(currentMove, 0) > 0;

                if (isRepeatedMove) {
                    moveCounts.put(currentMove, moveCounts.get(currentMove) - 1);
                } else {
                    switch (currentMove) {
                        case 'E': x += 1; break;
                        case 'W': x -= 1; break;
                        case 'N': y += 1; break;
                        case 'S': y -= 1; break;
                    }
                }

                steps++;

                if (x == 0 && y == 0) break;

                if (Math.abs(x) >= Math.abs(y)) {
                    if (x > 0) {
                        x -= 1;
                        moveCounts.put('W', moveCounts.getOrDefault('W', 0) + 1);
                    } else {
                        x += 1;
                        moveCounts.put('E', moveCounts.getOrDefault('E', 0) + 1);
                    }
                } else {
                    if (y > 0) {
                        y -= 1;
                        moveCounts.put('S', moveCounts.getOrDefault('S', 0) + 1);
                    } else {
                        y += 1;
                        moveCounts.put('N', moveCounts.getOrDefault('N', 0) + 1);
                    }
                }

                if (x == 0 && y == 0) break;

                if (isRepeatedMove) {
                    if (Math.abs(x) >= Math.abs(y)) {
                        if (x > 0) {
                            x -= 1;
                            moveCounts.put('W', moveCounts.getOrDefault('W', 0) + 1);
                        } else {
                            x += 1;
                            moveCounts.put('E', moveCounts.getOrDefault('E', 0) + 1);
                        }
                    } else {
                        if (y > 0) {
                            y -= 1;
                            moveCounts.put('S', moveCounts.getOrDefault('S', 0) + 1);
                        } else {
                            y += 1;
                            moveCounts.put('N', moveCounts.getOrDefault('N', 0) + 1);
                        }
                    }
                }

                if (x == 0 && y == 0) break;
            }

            if (x == 0 && y == 0) {
                System.out.println("Case #" + (caseIndex + 1) + ": " + steps);
            } else {
                System.out.println("Case #" + (caseIndex + 1) + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}