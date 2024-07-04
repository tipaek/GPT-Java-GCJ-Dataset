import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] jamie = new int[1440];
        int[] cameron = new int[1440];

        for (int l = 1; l <= t; l++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            String result = "";
            Arrays.fill(jamie, 0);
            Arrays.fill(cameron, 0);

            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }

            for (int j = arr[0][0]; j < arr[0][1]; j++) {
                jamie[j] = 1;
            }
            result += "J";
            result = evaluate(jamie, cameron, n, 1, arr, result);
            System.out.println("Case #" + l + ": " + result);
        }
    }

    static String evaluate(int[] jamie, int[] cameron, int n, int start, int[][] arr, String result) {
        outerLoop:
        for (int i = start; i < n; i++) {
            int startTime = arr[i][0];
            int endTime = arr[i][1];
            boolean canJamie = true, canCameron = true;

            for (int j = startTime; j < endTime; j++) {
                if (jamie[j] == 1) {
                    canJamie = false;
                    break;
                }
            }

            for (int j = startTime; j < endTime; j++) {
                if (cameron[j] == 1) {
                    canCameron = false;
                    break;
                }
            }

            if (canJamie && !canCameron) {
                for (int j = startTime; j < endTime; j++) {
                    jamie[j] = 1;
                }
                result += "J";
            } else if (canCameron && !canJamie) {
                for (int j = startTime; j < endTime; j++) {
                    cameron[j] = 1;
                }
                result += "C";
            } else if (canJamie && canCameron) {
                for (int j = startTime; j < endTime; j++) {
                    jamie[j] = 1;
                }
                String resultJamie = result + "J";
                resultJamie = evaluate(jamie, cameron, n, i + 1, arr, resultJamie);

                for (int j = startTime; j < endTime; j++) {
                    cameron[j] = 1;
                    jamie[j] = 0;
                }
                String resultCameron = result + "C";
                resultCameron = evaluate(jamie, cameron, n, i + 1, arr, resultCameron);

                if (resultJamie.equals("IMPOSSIBLE")) {
                    if (resultCameron.equals("IMPOSSIBLE")) {
                        result = resultJamie;
                    } else {
                        result = resultCameron;
                    }
                } else {
                    result = resultJamie;
                }
                break outerLoop;
            } else {
                result = "IMPOSSIBLE";
                break outerLoop;
            }
        }
        return result;
    }
}