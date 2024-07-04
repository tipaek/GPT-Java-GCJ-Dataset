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
            String ans = getPath(Math.abs(x), Math.abs(y), "");
            if (ans.isEmpty()) {
                pw.println("Case #" + i + ": " + "IMPOSSIBLE");
            } else {
                StringBuilder sb = new StringBuilder(ans);
                if (x < 0) {
                    for (int j = 0; j < sb.length(); j++) {
                        if (sb.charAt(j) == 'E') {
                            sb.setCharAt(j, 'W');
                        } else if (sb.charAt(j) == 'W') {
                            sb.setCharAt(j, 'E');
                        }
                    }
                }
                if (y < 0) {
                    for (int j = 0; j < sb.length(); j++) {
                        if (sb.charAt(j) == 'N') {
                            sb.setCharAt(j, 'S');
                        } else if (sb.charAt(j) == 'S') {
                            sb.setCharAt(j, 'N');
                        }
                    }
                }
                pw.println("Case #" + i + ": " + sb.toString());
            }
        }
        pw.close();
    }

    private static String getPath(int targetX, int targetY, String res) {
        if (targetX == 0 && targetY == 0) {
            return res;
        }
        if (targetX == 1 && targetY == 0) {
            return res + 'E';
        }
        if (targetX == 0 && targetY == 1) {
            return res + 'N';
        }
        if (targetX % 2 == targetY % 2) {
            return "";
        }
        if (targetX % 4 == 3) {
            if (targetY % 4 == 0) {
                return getPath((targetX - 1) / 2, targetY / 2, res + 'E');
            }
            return getPath((targetX + 1) / 2, targetY / 2, res + 'W');
        } else if (targetX % 4 == 1) {
            if (targetY % 4 == 0) {
                return getPath((targetX + 1)/2, targetY/2, res + 'W');
            }
            return getPath((targetX - 1)/2, targetY/2, res + 'E');
        } else if (targetY % 4 == 3) {
            if (targetX % 4 == 0) {
                return getPath(targetX/2, (targetY - 1)/2, res + 'N');
            }
            return getPath(targetX/2, (targetY + 1)/2, res + 'S');
        }
        if (targetX % 4 == 0){
            return getPath(targetX/2, (targetY + 1)/2, res + 'S');
        }
        return getPath(targetX/2, (targetY - 1)/2, res + 'N');
    }
}