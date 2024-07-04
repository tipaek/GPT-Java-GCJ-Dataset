import java.io.*;
import java.util.*;

public class Solution {
    public static BufferedReader reader;
    public static PrintWriter writer;
//    public static PrintWriter writ;
    
    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
//        writ = new PrintWriter(new BufferedWriter(new FileWriter("test.txt")));
        
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int numCases = Integer.parseInt(st.nextToken());
        int lowBound = Integer.parseInt(st.nextToken());
        int upBound = Integer.parseInt(st.nextToken());
        for (int caseN = 0; caseN < numCases; caseN++) {
            int pointX = 0;
            int pointY = 0;
            int res = check(500000000, 500000000);
            if (res == 0) {
                continue;
            }
            if (res == 1) {
                pointX = 500000000;
                pointY = 500000000;
            }
            res = check(-500000000, 500000000);
            if (res == 0) {
                continue;
            }
            if (res == 1) {
                pointX = -500000000;
                pointY = 500000000;
            }
            res = check(500000000, -500000000);
            if (res == 0) {
                continue;
            }
            if (res == 1) {
                pointX = 500000000;
                pointY = -500000000;
            }
            res = check(-500000000, -500000000);
            if (res == 0) {
                continue;
            }
            if (res == 1) {
                pointX = -500000000;
                pointY = -500000000;
            }
            
            int leftBound = 0;
            int low = -pointX;
            int up = 1000000001;
            boolean solved = false;
            while (true) {
                if (low + 1 == up) {
                    leftBound = -low;
                    break;
                }
                int mid = (low + up) / 2;
                res = check(-mid, pointY);
                if (res == 0) {
                    solved = true;
                    break;
                }
                if (res == 1) {
                    low = mid;
                } else {
                    up = mid;
                }
            }
            if (solved) {
                continue;
            }
            int rightBound = 0;
            low = pointX;
            up = 1000000001;
            solved = false;
            while (true) {
                if (low + 1 == up) {
                    rightBound = low;
                    break;
                }
                int mid = (low + up) / 2;
                res = check(mid, pointY);
                if (res == 0) {
                    solved = true;
                    break;
                }
                if (res == 1) {
                    low = mid;
                } else {
                    up = mid;
                }
            }
            if (solved) {
                continue;
            }
            int botBound = 0;
            low = -pointY;
            up = 1000000001;
            solved = false;
            while (true) {
                if (low + 1 == up) {
                    botBound = -low;
                    break;
                }
                int mid = (low + up) / 2;
                res = check(pointX, -mid);
                if (res == 0) {
                    solved = true;
                    break;
                }
                if (res == 1) {
                    low = mid;
                } else {
                    up = mid;
                }
            }
            if (solved) {
                continue;
            }
            int topBound = 0;
            low = pointY;
            up = 1000000001;
            solved = false;
            while (true) {
                if (low + 1 == up) {
                    topBound = low;
                    break;
                }
                int mid = (low + up) / 2;
                res = check(pointX, mid);
                if (res == 0) {
                    solved = true;
                    break;
                }
                if (res == 1) {
                    low = mid;
                } else {
                    up = mid;
                }
            }
            if (solved) {
                continue;
            }
//            writ.println(leftBound + " " + rightBound + " " + botBound + " " + topBound);
            int cenX = (leftBound + rightBound) / 2;
            int cenY = (botBound + topBound) / 2;
            res = check(cenX, cenY);
            if (res != 0) {
                break;
            }
        }
        reader.close();
        writer.close();
//        writ.close();
    }
    
    private static int check(int x, int y) throws IOException {
//        writ.println(x + " " + y);
        writer.println(x + " " + y);
        writer.flush();
        String res = reader.readLine();
        if (res.equals("CENTER")) {
//            writ.println(0);
            return 0;
        }
        if (res.equals("HIT")) {
//            writ.println(1);
            return 1;
        }
//        writ.println(2);
        return 2;
    }
}