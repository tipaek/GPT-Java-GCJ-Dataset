import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNum = sc.nextInt();
        List<int[][]> activities = new ArrayList(caseNum);
        // resolve case info data
        for (int i = 0; i < caseNum; i++) {
            int activitiesLength = sc.nextInt();
            int[][] square = new int[activitiesLength][2];
            activities.add(square);
            // resolve square data
            for (int squareX = 0; squareX < activitiesLength; squareX++) {
                for (int squareY = 0; squareY < 2; squareY++) {
                    square[squareX][squareY] = sc.nextInt();
                }
            }
        }
        for (int i = 0; i < caseNum; i++) {
            System.out.println("Case #" + (i + 1) + ": " + pushActivities(activities.get(i)));
        }
    }

    static String pushActivities(int[][] activities) {
        List<int[]> cameronActivities = new LinkedList<>();
        List<int[]> jamieActivities = new LinkedList<>();
        char[] result = new char[activities.length];
        for (int y = 0; y < activities.length; y++) {
            if (containActivities(cameronActivities, activities[y])) {
                
                int[] replace = replaceToNear(cameronActivities, activities[y]);
                if (containActivities(jamieActivities, replace)) {
                    if (containActivities(jamieActivities, activities[y])) {
                        return "IMPOSSIBLE";
                    } else {
                        jamieActivities.add(activities[y]);
                        cameronActivities.remove(activities[y]);
                        cameronActivities.add(replace);
                    }
                } else {
                    jamieActivities.add(replace);
                }
            } else {
                cameronActivities.add(activities[y]);
            }
        }
        suanlujin(result, activities, jamieActivities, cameronActivities);
        return new String(result);
    }

    static void suanlujin(char[] result, int[][] activities, List<int[]> jamieActivities, List<int[]> cameronActivities) {
        for (int y = 0; y < activities.length; y++) {
            if (jamieActivities.contains(activities[y])) {
                result[y] = 'J';
            } else {
                result[y] = 'C';
            }
        }
    }

    static int[] replaceToNear(List<int[]> ones, int[] addActive) {
        List<int[]> conflictActives = ones.stream().filter(one -> {
            return (one[0] > addActive[0] && one[0] < addActive[1]) || (one[0] < addActive[0] && one[1] > addActive[0]) || (one[0] == addActive[0] && one[0] < one[1] && addActive[0] < addActive[1]);
        }).collect(Collectors.toList());
        if (conflictActives.size() > 1) {
            return addActive;
        }
        int minValue = 100000;
        int preIndex = -1;
        int AfterIndex = -1;

        for (int i = 0; i < ones.size(); i++) {
            if (addActive[0] >= ones.get(i)[1]) {
                if (addActive[0] - ones.get(i)[1] < minValue) {
                    minValue = addActive[0] - ones.get(i)[1];
                    preIndex = i;
                }
            }
        }
        if (preIndex > 0) {
            int[] replacePreActive = ones.get(preIndex);
            if ((conflictActives.get(0)[0] - replacePreActive[1]) > (addActive[0] - replacePreActive[1])) {
                int[] replace = conflictActives.get(0);
                ones.remove(replace);
                ones.add(addActive);
                return replace;
            }
        } else {
            for (int i = 0; i < ones.size(); i++) {
                if (ones.get(i)[0] >= addActive[1]) {
                    if (ones.get(i)[0] - addActive[1] < minValue) {
                        minValue = ones.get(i)[0] - addActive[1];
                        AfterIndex = i;
                    }
                }
            }
            if (AfterIndex == 0) {
                int[] replaceAfterActive = ones.get(AfterIndex);
                if ((replaceAfterActive[0] - conflictActives.get(0)[1]) > (replaceAfterActive[0] - addActive[1])) {
                    int[] replace = conflictActives.get(0);
                    ones.remove(replace);
                    ones.add(addActive);
                    return replace;
                }
            }
        }
        return addActive;
    }

    static boolean containActivities(List<int[]> ones, int[] activity) {
        return ones.stream().anyMatch(one -> {
            return (one[0] > activity[0] && one[0] < activity[1]) || (one[0] < activity[0] && one[1] > activity[0]) || (one[0] == activity[0] && one[0] < one[1] && activity[0] < activity[1]);
        });
    }

    static void printSquares(List<int[][]> squares) {
        squares.stream().forEach(square -> {
            for (int x = 0; x < square.length; x++) {
                for (int y = 0; y < square[x].length; y++) {
                    System.out.print(square[x][y] + " ");
                }
                System.out.println("");
            }
        });
    }

}