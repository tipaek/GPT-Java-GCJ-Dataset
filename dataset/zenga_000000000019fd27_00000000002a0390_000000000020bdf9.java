import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String result = "";

            int n = Integer.parseInt(br.readLine());

            boolean[] cameron = new boolean[24 * 60];
            boolean[] jamie = new boolean[24 * 60];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                if (isFree(cameron, s, e)) {
                    result = result + "C";
                    fillTask(cameron, s, e);
                } else if (isFree(jamie, s, e)) {
                    result = result + "J";
                    fillTask(jamie, s, e);
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            System.out.printf("Case #%d: %s\n", t, result);
        }
    }

    static boolean isFree(boolean[] arr, int s, int e) {
        for (int i = s; i < e; i++) {
            if (arr[i]) {
                return false;
            }
        }
        return true;
    }

    static void fillTask(boolean[] arr, int s, int e) {
        for (int i = s; i < e; i++) {
            arr[i] = true;
        }
    }
}
