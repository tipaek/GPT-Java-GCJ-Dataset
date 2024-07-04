import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int r = a;
        for (int i = 1; i <= testCases; i++) {
            int tl_x = -r;
            int tl_y = r;
            int br_x = r;
            int br_y = -r;
            int center_x = (tl_x + br_x)/2;
            int center_y = (tl_y + br_y)/2;
            while (true) {
                pw.println((center_x + r) + " " + (center_y));
                pw.flush();
                String readEast = br.readLine();
                pw.println((center_x - r) + " " + (center_y));
                pw.flush();
                String readWest = br.readLine();
                pw.println((center_x) + " " + (center_y + r));
                pw.flush();
                String readNorth = br.readLine();
                pw.println((center_x) + " " + (center_y - r));
                pw.flush();
                String readSouth = br.readLine();
                if (readEast.equals("HIT") && readNorth.equals("HIT") && readWest.equals("HIT") && readSouth.equals("HIT")) {
                    pw.println(center_x + " " + center_y);
                    pw.flush();
                    br.readLine();
                    break;
                } else if (readEast.equals("HIT") && readNorth.equals("HIT")) {
                    br_y = center_y;
                    tl_x = center_x;
                    center_x = (center_x + br_x)/2;
                    center_y = (center_y + tl_y)/2;
                } else if (readNorth.equals("HIT") && readWest.equals("HIT")) {
                    br_y = center_y;
                    br_x = center_x;
                    center_x = (center_x + tl_x)/2;
                    center_y = (center_y + tl_y)/2;
                } else if (readWest.equals("HIT") && readSouth.equals("HIT")) {
                    tl_y = center_y;
                    br_x = center_x;
                    center_x = (center_x + tl_x)/2;
                    center_y = (center_y + br_y)/2;
                } else {
                    tl_x = center_x;
                    tl_y = center_y;
                    center_x = (center_x + br_x)/2;
                    center_y = (center_y + br_y)/2;
                }
            }
        }
        pw.close();
    }
}