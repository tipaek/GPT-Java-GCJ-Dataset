import java.awt.*;
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Point p = new Point(x, y);
            String s = scanner.next();
            int j = 0;
            int d = 0;
            for (char c : s.toCharArray()) {
                if (c == 'N') {
                    p.y++;
                } else if (c == 'E') {
                    p.x++;
                } else if (c == 'S') {
                    p.y--;
                } else { // 'W'
                    p.x--;
                }
                j++;
                if (Math.abs(p.x) + Math.abs(p.y) <= j) {
                    d = j;
                    break;
                }
            }
            if(d != 0) {
                System.out.println("Case #" + (i+1) + ": " + d);
            } else {
                System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
            }
        }
    }
}