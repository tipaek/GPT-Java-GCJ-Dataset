import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int caseNo = 1;

        while (t > 0) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            int[] sortedStartTimes = startTimes.clone();
            int[] sortedEndTimes = endTimes.clone();

            // Sort activities by start time
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (sortedStartTimes[i] > sortedStartTimes[j]) {
                        int temp = sortedStartTimes[i];
                        sortedStartTimes[i] = sortedStartTimes[j];
                        sortedStartTimes[j] = temp;

                        temp = sortedEndTimes[i];
                        sortedEndTimes[i] = sortedEndTimes[j];
                        sortedEndTimes[j] = temp;
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            int[] endTimesTracker = new int[2];

            if (sortedEndTimes[0] > sortedStartTimes[1]) {
                result.append("CJ");
                endTimesTracker[0] = sortedEndTimes[0];
                endTimesTracker[1] = sortedEndTimes[1];
            } else {
                result.append("CC");
                endTimesTracker[0] = sortedEndTimes[1];
            }

            for (int i = 2; i < n; i++) {
                if (sortedStartTimes[i] >= endTimesTracker[0]) {
                    endTimesTracker[0] = sortedEndTimes[i];
                    result.append("C");
                } else if (sortedStartTimes[i] >= endTimesTracker[1]) {
                    endTimesTracker[1] = sortedEndTimes[i];
                    result.append("J");
                } else {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                    break;
                }
            }

            if (!result.toString().equals("IMPOSSIBLE")) {
                StringBuilder output = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (startTimes[i] == sortedStartTimes[j] && endTimes[i] == sortedEndTimes[j]) {
                            sortedStartTimes[j] = -1;
                            sortedEndTimes[j] = -1;
                            output.append(result.charAt(j));
                            break;
                        }
                    }
                }
                System.out.println("Case #" + caseNo + ": " + output);
            } else {
                System.out.println("Case #" + caseNo + ": " + result);
            }

            caseNo++;
            t--;
        }
    }
}