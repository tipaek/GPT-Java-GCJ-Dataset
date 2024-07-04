import java.util.*;
import java.io.*;

public class Solution {
    private static List<Integer> indexes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int x = 1; x <= t; ++x) {
            int xx = in.nextInt();
            int y = in.nextInt();
            String[] result = solve(xx, y);
            String output = (result[0] != null) ? String.join("", result) : "IMPOSSIBLE";
            System.out.println("Case #" + x + ": " + output);
        }
    }

    private static String[] solve(int x, int y) {
        boolean xNeg = x < 0;
        boolean yNeg = y < 0;
        x = Math.abs(x);
        y = Math.abs(y);

        int[] moveX = oneMove(x);
        int[] moveY = oneMove(y);

        if (Arrays.equals(moveX, moveY) && moveX[0] != -1) {
            return new String[]{null};
        }

        indexes.clear();

        if (moveX[0] == 0) {
            moveX = (moveY[0] == 0) ? multiMoves(new ArrayList<>(), x) : multiMoves(new ArrayList<>(List.of(moveY[1])), x);
        } else {
            moveX = new int[]{moveX[2]};
        }

        if (moveX[0] == 0) {
            return new String[]{null};
        }

        List<Integer> indexesX = new ArrayList<>(indexes);

        if (moveY[0] == 0) {
            moveY = multiMoves(new ArrayList<>(indexes), y);
        } else {
            moveY = new int[]{moveY[2]};
        }

        if (xNeg) {
            for (int i = 0; i < moveX.length; i++) {
                moveX[i] = -moveX[i];
            }
        }
        if (yNeg) {
            for (int i = 0; i < moveY.length; i++) {
                moveY[i] = -moveY[i];
            }
        }

        if (moveY[0] == 0) {
            return new String[]{null};
        }

        List<Integer> xxx = new ArrayList<>();
        for (int i : moveX) {
            xxx.add(i);
        }

        List<Integer> yyy = new ArrayList<>();
        for (int i : moveY) {
            yyy.add(i);
        }

        String[] output = new String[moveX.length + moveY.length];
        int minX = Integer.MAX_VALUE;
        int xVal = 0;
        int minY = Integer.MAX_VALUE;
        int yVal = 0;
        int c = 0;

        while (!xxx.isEmpty() || !yyy.isEmpty()) {
            for (int i = 0; i < xxx.size(); i++) {
                if (minX > Math.abs(xxx.get(i)) && xxx.get(i) != 0) {
                    minX = Math.abs(xxx.get(i));
                    xVal = xxx.get(i);
                } else if (xxx.get(i) == 0) {
                    xxx.remove(i);
                    i--;
                }
            }

            for (int i = 0; i < yyy.size(); i++) {
                if (minY > Math.abs(yyy.get(i)) && yyy.get(i) != 0) {
                    minY = Math.abs(yyy.get(i));
                    yVal = yyy.get(i);
                } else if (yyy.get(i) == 0) {
                    yyy.remove(i);
                    i--;
                }
            }

            if (minX < minY) {
                output[c++] = (xVal < 0) ? "W" : "E";
                xxx.remove((Integer) xVal);
                minX = Integer.MAX_VALUE;
                minY = Integer.MAX_VALUE;
            } else {
                output[c++] = (yVal < 0) ? "S" : "N";
                yyy.remove((Integer) yVal);
                minX = Integer.MAX_VALUE;
                minY = Integer.MAX_VALUE;
            }
        }

        return output;
    }

    private static int[] multiMoves(List<Integer> exclude, int target) {
        int mult = 1;
        int counter = 1;

        if (target == 0) {
            return new int[]{0};
        }

        List<Integer> multiples = new ArrayList<>();
        while (addAll(multiples) < target) {
            if (!exclude.contains(counter)) {
                multiples.add(mult);
            }
            mult *= 2;
            counter++;
        }

        int total;
        List<Integer> moves = new ArrayList<>();
        for (int j = 0; j < 2; j++) {
            if (j == 1) {
                multiples.set(0, -multiples.get(0));
            }
            moves.clear();
            indexes.clear();
            total = multiples.get(0);
            moves.add(multiples.get(0));

            for (int i = 1; i < multiples.size(); i++) {
                if (total <= target) {
                    total += multiples.get(i);
                    moves.add(multiples.get(i));
                    indexes.add(i);
                } else {
                    total -= multiples.get(i);
                    moves.add(-multiples.get(i));
                    indexes.add(i);
                }
            }
            if (total == target) {
                return moves.stream().mapToInt(Integer::intValue).toArray();
            }
        }
        return new int[]{0};
    }

    private static int addAll(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    private static int[] oneMove(int val) {
        int mult = 1;
        int counter = 1;
        while (mult < val) {
            mult *= 2;
            counter++;
        }
        return new int[]{(mult == val ? 1 : 0), counter - 1, mult};
    }
}