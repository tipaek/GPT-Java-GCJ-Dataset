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
                int cmp = l1.get(i).compareTo(l2.get(i));
                if (cmp != 0) {
                    return cmp;
                }
            }
            return 0;
        }
    }

    private static int targetX = 0;
    private static int targetY = 0;
    private static List<List<Integer>> validPaths = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter output = new PrintWriter(System.out);
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            targetX = scanner.nextInt();
            targetY = scanner.nextInt();
            List<Integer> moves = new ArrayList<>();
            findPaths(0, 0, 0, 1, moves);
            if (!validPaths.isEmpty()) {
                validPaths.sort(new ListComparator());
                List<Integer> optimalPath = validPaths.get(0);
                List<String> directions = new ArrayList<>(optimalPath.size() - 1);
                for (int i = 1; i < optimalPath.size(); i++) {
                    directions.add(getDirection(optimalPath.get(i)));
                }
                output.print("Case #" + (t + 1) + ": ");
                for (String direction : directions) {
                    output.print(direction);
                }
                output.println();
                validPaths.clear();
            } else {
                output.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            }
        }
        output.close();
    }

    private static void findPaths(int currentX, int currentY, int stepIndex, int stepSize, List<Integer> moves) {
        if (Math.abs(currentX) > Math.abs(targetX) || Math.abs(currentY) > Math.abs(targetY)) {
            return;
        }
        if (currentX == targetX && currentY == targetY) {
            moves.add(0, stepIndex);
            validPaths.add(new ArrayList<>(moves));
            return;
        }
        List<Integer> newMoves = new ArrayList<>(moves);
        newMoves.add(1);
        findPaths(currentX + stepSize, currentY, stepIndex + 1, stepSize * 2, newMoves);
        newMoves.remove(newMoves.size() - 1);
        newMoves.add(2);
        findPaths(currentX, currentY + stepSize, stepIndex + 1, stepSize * 2, newMoves);
        newMoves.remove(newMoves.size() - 1);
        newMoves.add(-1);
        findPaths(currentX - stepSize, currentY, stepIndex + 1, stepSize * 2, newMoves);
        newMoves.remove(newMoves.size() - 1);
        newMoves.add(-2);
        findPaths(currentX, currentY - stepSize, stepIndex + 1, stepSize * 2, newMoves);
    }

    private static String getDirection(int move) {
        switch (move) {
            case 1: return "E";
            case -1: return "W";
            case 2: return "N";
            case -2: return "S";
            default: return "";
        }
    }
}