import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; i++) {
            String line = in.nextLine();
            String[] array = line.split(" ");
            int[] original = new int[2];
            original[0] = Integer.parseInt(array[0]);
            original[1] = Integer.parseInt(array[1]);
            String tour = array[2];
            OverexcitedFan overexcitedFan = new OverexcitedFan(original, tour);
            System.out.println("Case #" + i + ": " + overexcitedFan.getResult());
        }
    }

    private static class OverexcitedFan {
        private int[] original;
        private String tour;
        private int[][] tourCoordinates;

        OverexcitedFan(int[] original, String tour) {
            this.original = original;
            this.tour = tour;
        }

        String getResult() {
            int smallestNumberOfMinutes = isAbleToMeetPeppurr();
            return smallestNumberOfMinutes < 0 ? "IMPOSSIBLE": "" + smallestNumberOfMinutes;
        }

        int isAbleToMeetPeppurr() {
            if (original[0] == original[1] && original[0] == 0) {
                return 0;
            }

            char[] tourArr = tour.toCharArray();
            int size = tourArr.length;
            int[] coordinate = new int[2];
            coordinate[0] = original[0];
            coordinate[1] = original[1];
            for (int i = 1; i <= size; i++) {
                char direction = tourArr[i-1];
                if (direction == 'N') {
                    coordinate[1] += 1;
                } else if (direction == 'S') {
                    coordinate[1] -= 1;
                } else if (direction == 'E') {
                    coordinate[0] += 1;
                } else {
                    coordinate[0] -= 1;
                }
                int totalStep = Math.abs(coordinate[0]) + Math.abs(coordinate[1]);
                if (totalStep <= i) {
                    return i;
                }
            }
            return -1;
        }
    }
}