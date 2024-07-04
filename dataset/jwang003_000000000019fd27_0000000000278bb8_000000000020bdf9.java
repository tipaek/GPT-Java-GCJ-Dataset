import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        //read number of cases
        int cases = Integer.parseInt(in.nextLine());
        //String[] answerLines = new String[cases];
        for (int i = 0; i < cases; i++) {
            //read number of activities
            int activityNum = Integer.parseInt(in.nextLine());
            //create 2d array for start and end times of each interval
            int[][] times = new int[activityNum][3];
            String[] activities = new String[activityNum];
            for (int j = 0; j < activityNum; j++) {
                String[] startEnd = in.nextLine().split(" ");
                times[j][0] = Integer.parseInt(startEnd[0]);
                times[j][1] = Integer.parseInt(startEnd[1]);
                times[j][2] = j;
            }
            sortbyColumn(times, 0);
            boolean[][] parents = new boolean[2][1441];
            boolean possible = true;
            //check if C works
            for (int j = 0; j < activityNum; j++) {
                boolean free = true;
                for (int k = times[j][0]; k < times[j][1]; k++) {
                    if (parents[0][k]) {
                        free = false;
                        break;
                    }
                }
                if (free) {
                    activities[j] = "C";
                    for (int k = times[j][0]; k < times[j][1]; k++) {
                        parents[0][k] = true;
                    }
                } else {
                    //C doesn't work, check J
                    free = true;
                    for (int k = times[j][0]; k < times[j][1]; k++) {
                        if (parents[1][k]) {
                            free = false;
                            break;
                        }
                    }
                    if (free) {
                        activities[j] = "J";
                        for (int k = times[j][0]; k < times[j][1]; k++) {
                            parents[1][k] = true;
                        }
                    } else {
                        //If C and J don't work, it is impossible
                        possible = false;
                        break;
                    }
                }
            }

            StringBuilder order = new StringBuilder();
            int caseNum = i + 1;

            String[] finalA = new String[activityNum];

            for (int j = 0; j < activityNum; j++) {
                finalA[times[j][2]] = activities[j];
            }

            if (possible) {
                for (String name : finalA) {
                    order.append(name);
                }
                System.out.println("Case #" + caseNum + ": " + order.toString());
                //String answer = "Case #" + caseNum + ": " + order.toString();
                //answerLines[i] = answer;
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                //String answer = "Case #" + caseNum + ": IMPOSSIBLE";
                //answerLines[i] = answer;
            }
        }
        /*for (int i = 0; i < cases; i++) {
            System.out.println(answerLines[i]);
        }*/
    }

    public static void sortbyColumn(int arr[][], int col)
    {
        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            // Compare values according to columns
            public int compare(final int[] entry1,
                               final int[] entry2) {

                // To sort in descending order revert
                // the '>' Operator
                if (entry1[col] > entry2[col])
                    return 1;
                else
                    return -1;
            }
        });  // End of function call sort().
    }
}
