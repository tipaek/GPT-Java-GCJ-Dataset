import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String[] results = new String[t];

        for (int l = 0; l < t; l++) {
            int n = Integer.parseInt(br.readLine());
            int[][] jamie = new int[n][2];
            int[][] cameron = new int[n][2];
            int j = 0, c = 0;
            StringBuilder schedule = new StringBuilder();
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                Scanner sc = new Scanner(br.readLine());
                int s = sc.nextInt();
                int e = sc.nextInt();

                if (possible) {
                    if (isAvailable(jamie, s, e, j)) {
                        schedule.append("J");
                        jamie[j][0] = s;
                        jamie[j++][1] = e;
                    } else if (isAvailable(cameron, s, e, c)) {
                        schedule.append("C");
                        cameron[c][0] = s;
                        cameron[c++][1] = e;
                    } else {
                        schedule.setLength(0);
                        schedule.append("IMPOSSIBLE");
                        possible = false;
                    }
                }
            }
            results[l] = schedule.toString();
            System.out.println("Case #" + (l + 1) + ": " + results[l]);
        }

        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }

    static boolean isAvailable(int[][] arr, int s, int e, int n) {
        for (int i = 0; i < n; i++) {
            if ((s < arr[i][1] && e > arr[i][0])) {
                return false;
            }
        }
        return true;
    }
}