import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numberOfTestcases = Integer.parseInt(in.nextLine());

        for(int i = 1; i <= numberOfTestcases; i++) {
            findSolution(i, in);
        }

//        Solution s = new Solution();
//        String path = s.findPathRecursively(0, 5, new int[]{0,0}, new int[]{2,3}, new StringBuffer(), null);
//        System.out.println(path);
    }

    private static void findSolution(int index, Scanner in) {
        String[] targetCoordinates = in.nextLine().split(" ");
        int x = Integer.parseInt(targetCoordinates[0]);
        int y = Integer.parseInt(targetCoordinates[1]);

        int[] start = {0, 0};
        int[] end = {x, y};

        int turn = 0;

        String path = findPathRecursively(0, 10, start, end, new StringBuffer(), null);

        System.out.println(String.format("Case #%s: %s", index, path));
    }

     static String findPathRecursively(int currentDepth, int maxDepth, int[] nextPosition, int[] target, StringBuffer path, Character nextStep) {
        if(maxDepth == currentDepth || nextPosition[0] == target[0] && nextPosition[1] == target[1]) {
            if(nextPosition[0] == target[0] && nextPosition[1] == target[1]) {
                if(nextStep != null) path.append(nextStep);

                return String.valueOf(path);
            } else {
                return IMPOSSIBLE;
            }
        } else {
            double jumpLength = Math.pow(2, currentDepth);
            if(nextStep != null) path.append(nextStep);

            int[] north = {nextPosition[0], nextPosition[1] + (int) jumpLength};
            int[] south = {nextPosition[0], nextPosition[1] - (int) jumpLength};
            int[] west = {nextPosition[0] - (int) jumpLength, nextPosition[1]};
            int[] east = {nextPosition[0] + (int) jumpLength, nextPosition[1]};

            String pathNorth = findPathRecursively(currentDepth + 1, maxDepth, north, target, new StringBuffer(path), 'N');
            String pathSouth = findPathRecursively(currentDepth + 1, maxDepth, south, target, new StringBuffer(path), 'S');
            String pathWest = findPathRecursively(currentDepth + 1, maxDepth, west, target, new StringBuffer(path), 'W');
            String pathEast = findPathRecursively(currentDepth + 1, maxDepth, east, target, new StringBuffer(path), 'E');

            List<String> possiblePaths = new ArrayList<>();
            if(IMPOSSIBLE.equals(pathNorth) == false) possiblePaths.add(pathNorth);
            if(IMPOSSIBLE.equals(pathSouth) == false) possiblePaths.add(pathSouth);
            if(IMPOSSIBLE.equals(pathWest) == false) possiblePaths.add(pathWest);
            if(IMPOSSIBLE.equals(pathEast) == false) possiblePaths.add(pathEast);

            if(possiblePaths.isEmpty()) {
                return IMPOSSIBLE;
            } else {
                Collections.sort(possiblePaths, new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        return s1.length() - s2.length();
                    }
                });

                return possiblePaths.get(0);
            }
        }
    }
}