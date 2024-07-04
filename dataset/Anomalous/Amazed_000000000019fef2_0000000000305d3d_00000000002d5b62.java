import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static int targetX = 0;
    private static int targetY = 0;
    private static List<List<Integer>> possiblePaths = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter output = new PrintWriter(System.out);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            targetX = scanner.nextInt();
            targetY = scanner.nextInt();
            List<Integer> currentPath = new ArrayList<>();
            findPaths(0, 0, 1, currentPath);
            
            if (!possiblePaths.isEmpty()) {
                List<Integer> optimalPath = possiblePaths.get(0);
                for (List<Integer> path : possiblePaths) {
                    if (path.size() < optimalPath.size()) {
                        optimalPath = path;
                    }
                }
                List<String> directions = new ArrayList<>();
                for (int move : optimalPath) {
                    switch (move) {
                        case 1: directions.add("E"); break;
                        case -1: directions.add("W"); break;
                        case 2: directions.add("N"); break;
                        case -2: directions.add("S"); break;
                    }
                }
                output.printf("Case #%d: ", testCase);
                for (String direction : directions) {
                    output.print(direction);
                }
                output.println();
                possiblePaths.clear();
            } else {
                output.printf("Case #%d: IMPOSSIBLE\n", testCase);
            }
        }
        output.close();
    }

    private static void findPaths(int currentX, int currentY, int stepSize, List<Integer> currentPath) {
        if (Math.abs(currentX) > Math.abs(targetX) * 2 || Math.abs(currentY) > Math.abs(targetY) * 2) {
            return;
        }
        if (currentX == targetX && currentY == targetY) {
            possiblePaths.add(new ArrayList<>(currentPath));
            return;
        }
        
        List<Integer> newPath = new ArrayList<>(currentPath);
        
        newPath.add(1);
        findPaths(currentX + stepSize, currentY, stepSize * 2, newPath);
        newPath.remove(newPath.size() - 1);
        
        newPath.add(2);
        findPaths(currentX, currentY + stepSize, stepSize * 2, newPath);
        newPath.remove(newPath.size() - 1);
        
        newPath.add(-1);
        findPaths(currentX - stepSize, currentY, stepSize * 2, newPath);
        newPath.remove(newPath.size() - 1);
        
        newPath.add(-2);
        findPaths(currentX, currentY - stepSize, stepSize * 2, newPath);
    }
}