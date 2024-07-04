
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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
        List<int[]> jamieActivities = new LinkedList<>();
        List<int[]> cameronActivities = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        for (int y = 0; y < activities.length; y++) {
            if (containActivities(jamieActivities, activities[y])) {
                if (containActivities(cameronActivities, activities[y])) {
                    return "IMPOSSIBLE";
                } else {
                    sb.append("C");
                    cameronActivities.add(activities[y]);
                }
            } else {
                sb.append("J");
                jamieActivities.add(activities[y]);
            }
        }
        return sb.toString();
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