import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.valueOf(scanner.nextLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.valueOf(scanner.nextLine());
            String[] input = new String[N];
            for (int j = 0; j < N; j++) {
                input[j] = scanner.nextLine();
            }
            int[][] activities = new int[N][2];
            int[][] sorted = new int[N][3];

            for (int j = 0; j < N; j++) {
                String[] inputs = input[j].split(" ");
                for (int k = 0; k < inputs.length; k++) {
                    activities[j][k] = Integer.valueOf(inputs[k]);
                    sorted[j][k] = activities[j][k];
                }
            }

            sortbyColumn(sorted, 0);
            String answer = solve(activities, sorted);

            if (!answer.equals("IMPOSSIBLE")) {
                StringBuilder str = new StringBuilder();
                for (int k = 0; k < activities.length; k++) {

                    int index = 0;
                    for (int l = 0; l < sorted.length; l++) {
                        if (sorted[l][0] == activities[k][0] && sorted[l][1] == activities[k][1] && sorted[l][1] != -1) {
                            index = l;
                        }
                    }
                    char charAt = answer.charAt(index);
                    str.append((charAt == '1') ? 'C' : 'J');
                    sorted[index][1] = -1;
                }
                answer = str.toString();
            }

            System.out.println("Case #" + (i + 1) + ": " + answer);
        }
    }

    private static String solve(int[][] activities, int[][] sortedInput) {
        int cBusyUntil = sortedInput[0][1];
        int jBusyUntil = 0;

        String solution = "1";
        for (int i = 1; i < activities.length; i++) {
            if (sortedInput[i][0] >= cBusyUntil) {
                solution += "1";
                cBusyUntil = sortedInput[i][1];
            } else if (sortedInput[i][0] >= jBusyUntil) {
                solution += "0";
                jBusyUntil = sortedInput[i][1];
            } else {
                solution = "IMPOSSIBLE";
                break;
            }
        }
        return solution;
    }

    public static void sortbyColumn(int arr[][], int col) {
        Arrays.sort(arr, (entry1, entry2) -> {
            if (entry1[col] > entry2[col])
                return 1;
            else
                return -1;
        });
    }
}