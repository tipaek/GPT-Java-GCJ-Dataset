import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            String result = solution.processCase(i + 1, in);
            System.out.print(result);
            if (i + 1 != t) {
                System.out.println();
            }
        }
    }

    private String processCase(int t, Scanner in) {
        int r = in.nextInt();
        int c = in.nextInt();
        int[][] skills = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                skills[i][j] = in.nextInt();
            }
        }

        return "Case #" + t + ": " + calculateInterest(skills, r, c);
    }

    private int calculateInterest(int[][] skills, int r, int c) {
        int totalInterest = 0;
        while (true) {
            double[][] neighbourAverages = findNeighbourAverages(skills, r, c);
            Set<List<Integer>> toDelete = new HashSet<>();
            int roundInterest = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (skills[i][j] != 0 && skills[i][j] < neighbourAverages[i][j]) {
                        List<Integer> point = new ArrayList<>();
                        point.add(i);
                        point.add(j);
                        toDelete.add(point);
                    }
                    roundInterest += skills[i][j];
                }
            }
            totalInterest += roundInterest;
            if (toDelete.size() == 0) {
                break;
            }
            for (List<Integer> point : toDelete) {
                deletePoint(skills, point.get(0), point.get(1));
            }
        }
        return totalInterest;
    }

    private void deletePoint(int[][] skills, int i, int j) {
        skills[i][j] = 0;
    }

    private double[][] findNeighbourAverages(int[][] skills, int r, int c) {
        double[][] neighbourAverages = new double[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int[] haveValue = {0};
                int left = getNeighbour(skills, i, j, r, c, true, -1, haveValue);
                int right = getNeighbour(skills, i, j, r, c, true, 1, haveValue);
                int up = getNeighbour(skills, i, j, r, c, false, -1, haveValue);
                int down = getNeighbour(skills, i, j, r, c, false, 1, haveValue);

                int total = left + right + up + down;
                neighbourAverages[i][j] = haveValue[0] == 0 ? 0 : total / (double) haveValue[0];
            }
        }
        return neighbourAverages;
    }

    private int getNeighbour(int[][] skills, int i, int j, int r, int c, boolean isRow, int updateValue, int[] haveValue) {
        if (isRow) {
            while (isValid(r, c, i, j)) {
                i += updateValue;
                if (isValid(r, c, i, j) && skills[i][j] != 0) {
                    haveValue[0]++;
                    return skills[i][j];
                }
            }
        } else {
            while (isValid(r, c, i, j)) {
                j += updateValue;
                if (isValid(r, c, i, j) && skills[i][j] != 0) {
                    haveValue[0]++;
                    return skills[i][j];
                }
            }
        }
        return 0;
    }

    private boolean isValid(int r, int c, int i, int j) {
        return i >= 0 && i < r && j >= 0 && j < c;
    }
}
