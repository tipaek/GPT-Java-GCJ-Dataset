import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int activityCount = scanner.nextInt();
            ArrayList<int[]> activities = new ArrayList<>();

            for (int j = 0; j < activityCount; j++) {
                int[] activity = new int[3];
                activity[0] = scanner.nextInt();
                activity[1] = scanner.nextInt();
                activity[2] = j;
                activities.add(activity);
            }

            quickSort(activities, 0, activities.size() - 1);

            String[] schedule = new String[activityCount];
            int lastEndC = -1;
            int lastEndJ = -1;
            boolean conflict = false;

            for (int j = 0; j < activityCount && !conflict; j++) {
                int[] currentActivity = activities.get(j);

                if (j == 0) {
                    schedule[currentActivity[2]] = "J";
                    lastEndJ = currentActivity[1];
                } else {
                    boolean conflictWithJ = currentActivity[0] < lastEndJ;
                    boolean conflictWithC = lastEndC != -1 && currentActivity[0] < lastEndC;

                    if (conflictWithJ && conflictWithC) {
                        conflict = true;
                        schedule = null;
                    } else {
                        if (!conflictWithJ) {
                            schedule[currentActivity[2]] = "J";
                            lastEndJ = currentActivity[1];
                        } else {
                            schedule[currentActivity[2]] = "C";
                            lastEndC = currentActivity[1];
                        }
                    }
                }
            }

            System.out.print("Case #" + i + ": ");
            if (schedule == null) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (String s : schedule) {
                    System.out.print(s);
                }
                System.out.println();
            }
        }

        scanner.close();
    }

    private static void quickSort(ArrayList<int[]> activities, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(activities, low, high);
            quickSort(activities, low, pivotIndex - 1);
            quickSort(activities, pivotIndex + 1, high);
        }
    }

    private static int partition(ArrayList<int[]> activities, int low, int high) {
        int[] pivot = activities.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (activities.get(j)[0] < pivot[0]) {
                i++;
                swap(activities, i, j);
            }
        }

        swap(activities, i + 1, high);
        return i + 1;
    }

    private static void swap(ArrayList<int[]> activities, int i, int j) {
        int[] temp = activities.get(i);
        activities.set(i, activities.get(j));
        activities.set(j, temp);
    }
}