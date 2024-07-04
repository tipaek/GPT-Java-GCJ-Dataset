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
            solve(xx, y);
        }
    }

    private static int[] solve(int x, int y) {
        boolean xNeg = x < 0;
        boolean yNeg = y < 0;
        int[] moveX = calculateMove(Math.abs(x));
        int[] moveY = calculateMove(Math.abs(y));

        System.out.println("MoveX: " + Arrays.toString(moveX));
        System.out.println("MoveY: " + Arrays.toString(moveY));

        if (moveX[0] == -1) {
            if (moveY[0] == -1) {
                moveX = calculateMultipleMoves(new ArrayList<>(), x);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(moveY[1]);
                moveX = calculateMultipleMoves(temp, x);
            }
        }

        if (moveX[0] == -1) {
            return new int[]{-1};
        }

        List<Integer> indexesX = new ArrayList<>(indexes);

        if (moveY[0] == -1) {
            moveX = calculateMultipleMoves(indexes, y);
        }

        if (moveY[0] == -1) {
            return new int[]{-1};
        }

        List<Integer> indexesY = new ArrayList<>(indexes);

        System.out.println(indexesX + ", " + indexesY);
        System.out.println(Arrays.toString(moveX) + ", " + Arrays.toString(moveY));
        return new int[]{-1};
    }

    private static int[] calculateMultipleMoves(List<Integer> exclude, int target) {
        int mult = 1;
        int counter = 1;
        List<Integer> multiples = new ArrayList<>();
        while (sum(multiples) < target) {
            if (!exclude.contains(counter)) {
                multiples.add(mult);
            }
            mult *= 2;
            counter++;
        }

        int total;
        List<Integer> moves = new ArrayList<>();
        boolean startNeg = false;

        for (int j = 0; j < 2; j++) {
            if (j == 1) {
                multiples.set(0, -multiples.get(0));
                startNeg = true;
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
            if (total != target && j == 1) {
                return new int[]{-1};
            } else if (total == target) {
                return moves.stream().mapToInt(Integer::intValue).toArray();
            }
        }
        return new int[]{-1};
    }

    private static int sum(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    private static int[] calculateMove(int val) {
        int mult = 1;
        int counter = 1;
        while (mult < val) {
            mult *= 2;
            counter++;
        }
        return new int[]{(mult == val ? 1 : 0), counter};
    }
}