import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Parenting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int testCaseCount = Integer.parseInt(br.readLine());
        String[] finalOutput = new String[testCaseCount];

        for (int t = 0; t < testCaseCount; t++) {
            int noOfActivities = Integer.parseInt(br.readLine());
            int[] startTimes = new int[noOfActivities];
            int[] endTimes = new int[noOfActivities];
            int[] indices = new int[noOfActivities];
            char[] schedule = new char[noOfActivities];

            for (int n = 0; n < noOfActivities; n++) {
                startTimes[n] = sc.nextInt();
                endTimes[n] = sc.nextInt();
                indices[n] = n;
            }

            // Sort activities by start time using bubble sort
            for (int i = 0; i < noOfActivities - 1; i++) {
                for (int j = 0; j < noOfActivities - i - 1; j++) {
                    if (startTimes[j] > startTimes[j + 1]) {
                        swap(startTimes, j, j + 1);
                        swap(endTimes, j, j + 1);
                        swap(indices, j, j + 1);
                    }
                }
            }

            boolean cAvailable = true, jAvailable = true, impossible = false;
            int cEndTime = 0, jEndTime = 0;

            for (int i = 0; i < noOfActivities; i++) {
                if (startTimes[i] >= cEndTime) {
                    schedule[i] = 'C';
                    cEndTime = endTimes[i];
                    cAvailable = false;
                } else if (startTimes[i] >= jEndTime) {
                    schedule[i] = 'J';
                    jEndTime = endTimes[i];
                    jAvailable = false;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                finalOutput[t] = "IMPOSSIBLE";
            } else {
                // Restore original order using bubble sort
                for (int i = 0; i < noOfActivities - 1; i++) {
                    for (int j = 0; j < noOfActivities - i - 1; j++) {
                        if (indices[j] > indices[j + 1]) {
                            swap(indices, j, j + 1);
                            swap(schedule, j, j + 1);
                        }
                    }
                }
                finalOutput[t] = new String(schedule, 0, noOfActivities);
            }
        }

        for (int i = 0; i < testCaseCount; i++) {
            System.out.println("Case #" + (i + 1) + ": " + finalOutput[i]);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}