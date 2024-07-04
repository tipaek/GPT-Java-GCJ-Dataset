import java.util.Scanner;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] jamie = new int[1440];
        int[] cameron = new int[1440];

        for (int l = 0; l < t; l++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            StringBuilder str = new StringBuilder();
            Arrays.fill(jamie, 0);
            Arrays.fill(cameron, 0);

            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }

            for (int j = arr[0][0]; j < arr[0][1]; j++) {
                jamie[j] = 1;
            }
            str.append("J");

            str = new StringBuilder(evaluate(jamie, cameron, n, 1, arr, str.toString()));
            System.out.println("Case #" + (l + 1) + ": " + str);
        }
    }

    static String evaluate(int[] jamie, int[] cameron, int n, int start, int[][] arr, String str) {
        for (int i = start; i < n; i++) {
            int s = arr[i][0];
            int e = arr[i][1];
            boolean fj = true, fc = true;

            for (int j = s; j < e; j++) {
                if (jamie[j] == 1) {
                    fj = false;
                    break;
                }
            }

            for (int j = s; j < e; j++) {
                if (cameron[j] == 1) {
                    fc = false;
                    break;
                }
            }

            if (fj && !fc) {
                for (int j = s; j < e; j++) {
                    jamie[j] = 1;
                }
                str += "J";
            } else if (fc && !fj) {
                for (int j = s; j < e; j++) {
                    cameron[j] = 1;
                }
                str += "C";
            } else if (fj && fc) {
                for (int j = s; j < e; j++) {
                    jamie[j] = 1;
                }
                String str1 = str + "J";
                str1 = evaluate(jamie, cameron, n, i + 1, arr, str1);

                for (int j = s; j < e; j++) {
                    cameron[j] = 1;
                    jamie[j] = 0;
                }
                String str2 = str + "C";
                str2 = evaluate(jamie, cameron, n, i + 1, arr, str2);

                if (str1.equals("IMPOSSIBLE")) {
                    str = str2.equals("IMPOSSIBLE") ? str1 : str2;
                } else {
                    str = str1;
                }
                break;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return str;
    }
}