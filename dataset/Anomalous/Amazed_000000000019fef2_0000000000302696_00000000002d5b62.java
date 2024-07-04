import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static class ListComparator implements Comparator<List<Integer>> {
        @Override
        public int compare(List<Integer> l1, List<Integer> l2) {
            for (int i = 0; i < l1.size(); ++i) {
                int comparison = l1.get(i).compareTo(l2.get(i));
                if (comparison != 0) {
                    return comparison;
                }
            }
            return 0;
        }
    }

    private static int targetX = 0;
    private static int targetY = 0;
    private static List<List<Integer>> solutions = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            targetX = scanner.nextInt();
            targetY = scanner.nextInt();
            List<Integer> moves = new ArrayList<>();
            findPath(0, 0, 0, 1, moves);
            if (solutions.size() > 0) {
                solutions.sort(new ListComparator());
                List<Integer> bestSolution = solutions.get(0);
                List<String> directions = new ArrayList<>(bestSolution.size() - 1);
                for (int j = 1; j < bestSolution.size(); j++) {
                    switch (bestSolution.get(j)) {
                        case 1: directions.add("E"); break;
                        case -1: directions.add("W"); break;
                        case 2: directions.add("N"); break;
                        case -2: directions.add("S"); break;
                    }
                }
                out.print("Case #" + (i + 1) + ": ");
                for (String direction : directions) {
                    out.print(direction);
                }
                out.println();
                solutions.clear();
            } else {
                out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
        out.close();
    }

    public static void findPath(int currentX, int currentY, int stepCount, int stepSize, List<Integer> moves) {
        if (Math.abs(currentX) > Math.abs(targetX) || Math.abs(currentY) > Math.abs(targetY)) {
            return;
        }
        if (currentX == targetX && currentY == targetY) {
            List<Integer> validPath = new ArrayList<>(moves);
            validPath.add(0, stepCount);
            solutions.add(validPath);
            return;
        }
        List<Integer> newMoves = new ArrayList<>(moves);
        newMoves.add(1);
        findPath(currentX + stepSize, currentY, stepCount + 1, stepSize * 2, newMoves);
        newMoves.remove(newMoves.size() - 1);
        newMoves.add(2);
        findPath(currentX, currentY + stepSize, stepCount + 1, stepSize * 2, newMoves);
        newMoves.remove(newMoves.size() - 1);
        newMoves.add(-1);
        findPath(currentX - stepSize, currentY, stepCount + 1, stepSize * 2, newMoves);
        newMoves.remove(newMoves.size() - 1);
        newMoves.add(-2);
        findPath(currentX, currentY - stepSize, stepCount + 1, stepSize * 2, newMoves);
    }
}