import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int testCases = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testCases; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String path = st.nextToken();
            int time = 0;
            boolean found = false;
            for (int j = 0; j < path.length(); j++) {
                if (path.charAt(j) == 'N') {
                    y++;
                } else if (path.charAt(j) == 'S') {
                    y--;
                } else if (path.charAt(j) == 'E') {
                    x++;
                } else {
                    x--;
                }
                time++;
                int timeReq = Math.abs(x) + Math.abs(y);
                if (timeReq <= time) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                pw.println("Case #" + i + ": " + "IMPOSSIBLE");
            } else {
                pw.println("Case #" + i + ": " + time);
            }
        }
        pw.close();
    }
}