import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        //scanner.nextLine();
        for(int i = 1; i <= numCases; i++) {
            int numActivities = scanner.nextInt();
            scanner.nextLine();
            ArrayList<int[]> activities = new ArrayList<>();
            for(int j = 1; j <= numActivities; j++) {
                String[] stringActivity = scanner.nextLine().split(" ");
                int[] activity = new int[2];
                activity[0] = Integer.parseInt(stringActivity[0]);
                activity[1] = Integer.parseInt(stringActivity[1]);
                activities.add(activity);
            }
            ArrayList<int[]> sortedActivities = sortActivities(activities);


            if(sortedActivities.size() > 2) {
                int currentSActivity = 0;
                int currentEActivity = 1;
                int nextActivityIndex = 2;
                int[] nextActivity = new int[nextActivityIndex];
                nextActivity = sortedActivities.get(2);

                // S = C, E = J
                char[] solution = new char[sortedActivities.size()];
                solution[getSolutionIndex(activities, sortedActivities, 0)] = 'C';
                activities.set(getSolutionIndex(activities, sortedActivities, 0), new int[]{-1, -1});
                solution[getSolutionIndex(activities, sortedActivities, 1)] = 'J';
                activities.set(getSolutionIndex(activities, sortedActivities, 1), new int[]{-1, -1});

                boolean impossible = false;
                for(int time = 0; time <= 1440; time++) {
                    if(sortedActivities.get(nextActivityIndex)[0] == time) {
                        if (nextActivity[0] >= sortedActivities.get(currentSActivity)[1]) {
                            currentSActivity = nextActivityIndex;
                            solution[getSolutionIndex(activities, sortedActivities, nextActivityIndex)] = 'C';
                            activities.set(getSolutionIndex(activities, sortedActivities, nextActivityIndex), new int[]{-1, -1});
                            if (isFull(solution, sortedActivities.size())) {
                                break;
                            } else {
                                nextActivityIndex++;
                                nextActivity = sortedActivities.get(nextActivityIndex);
                            }
                        }
                        else if (nextActivity[0] >= sortedActivities.get(currentEActivity)[1]) {
                            currentEActivity = nextActivityIndex;
                            solution[getSolutionIndex(activities, sortedActivities, nextActivityIndex)] = 'J';
                            activities.set(getSolutionIndex(activities, sortedActivities, nextActivityIndex), new int[]{-1, -1});
                            if (isFull(solution, sortedActivities.size())) {
                                break;
                            } else {
                                nextActivityIndex++;
                                nextActivity = sortedActivities.get(nextActivityIndex);
                            }
                        } else {
                            impossible = true;
                        }
                    }
                }

                if(impossible) {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + i + ": " + String.valueOf(solution));
                }
            } else {
                if(sortedActivities.get(1)[0] >= sortedActivities.get(0)[1]) {
                    System.out.println("Case #" + i + ": CC");
                } else {
                    System.out.println("Case #" + i + ": CJ");
                }
            }
        }
    }

    public static ArrayList<int[]> sortActivities(ArrayList<int[]> activities) {
        ArrayList<int[]> result = new ArrayList<>(activities);
        int n = result.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (result.get(j)[0] > result.get(j + 1)[0]) {
                    Collections.swap(result, j, j + 1);
                }
            }
        }
        return result;
    }

    public static int getSolutionIndex(ArrayList<int[]> unsorted, ArrayList<int[]> sorted, int index) {
        for(int i = 0; i < unsorted.size(); i++) {
            if(unsorted.get(i) != null) {
                if(sorted.get(index)[0] == unsorted.get(i)[0] && sorted.get(index)[1] == unsorted.get(i)[1]) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static boolean isFull(char[] solution, int expectedLength) {
        int numChars = 0;
        for(int i = 0; i < solution.length; i++) {
            if(solution[i] == 'C' || solution[i] == 'J') {
                numChars++;
            }
        }
        return numChars >= expectedLength;
    }
}
