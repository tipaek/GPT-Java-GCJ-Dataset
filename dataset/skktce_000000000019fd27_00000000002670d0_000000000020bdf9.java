import java.util.*;
import java.io.*;
import java.lang.Math;

public class Solution_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        for (int i = 1; i <= tests; ++i) {
            int[][] availabilityMatrix = new int[1440][2];
            boolean impossible = false;

            int taskNos = in.nextInt();
            int[][] resultMatrix = new int[taskNos][2];
            int taskIdentifier = 0;

            int[][] activitiesList = new int[taskNos][3];
            for (int j = 0; j < taskNos; j++) {
                activitiesList[j][0] = in.nextInt();
                activitiesList[j][1] = in.nextInt();
                activitiesList[j][2] = taskIdentifier++;
            }

            Arrays.sort(activitiesList, new java.util.Comparator<int[]>() {
                public int compare(int[] t1, int[] t2) {
                    return Integer.compare(t1[0], t2[0]);
                }
            });

            for (int j = 0; j < taskNos; j++) {
                int startTime = activitiesList[j][0];
                int endTime = activitiesList[j][1];
                int activityReference = activitiesList[j][2];
                boolean isT1Available = true;
                boolean isT2Available = true;

                for (int k = startTime; k < endTime; k++) {
                    if (availabilityMatrix[k][0] == 1) {
                        isT1Available = false;
                        break;
                    }
                }


                if (isT1Available) {
                    for (int k = startTime; k < endTime; k++) {
                        availabilityMatrix[k][0] = 1;
                    }

                    resultMatrix[j] = new int[]{activityReference, 1};
                } else {
                    for (int k = startTime; k < endTime; k++) {
                        if (availabilityMatrix[k][1] == 1) {
                            isT2Available = false;
                            break;
                        }
                    }

                    if (isT2Available) {
                        for (int k = startTime; k < endTime; k++) {
                            availabilityMatrix[k][1] = 1;
                        }
                        resultMatrix[j] = new int[]{activityReference, 2};
                    } else {
                        impossible = true;
                    }
                }
            }

            StringBuilder displayPrintResult = new StringBuilder();
            if (impossible) {
                displayPrintResult = new StringBuilder("IMPOSSIBLE");
            } else {
                Arrays.sort(resultMatrix, new java.util.Comparator<int[]>() {
                    public int compare(int[] a, int[] b) {
                        return Integer.compare(a[0], b[0]);
                    }
                });

                for (int[] matrix : resultMatrix) {
                    if (matrix[1] == 1) {
                        displayPrintResult.append("C");
                    } else if (matrix[1] == 2) {
                        displayPrintResult.append("J");
                    }
                }
            }

            System.out.println("Case #" + i + ": " + displayPrintResult);
        }
    }
}