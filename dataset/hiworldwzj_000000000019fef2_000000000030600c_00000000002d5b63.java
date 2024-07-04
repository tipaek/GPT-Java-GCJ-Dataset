import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws Exception {
        //System.out.println("" + ((-3 + -1) / 2));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        testCaseNum = 0;
        String[] TAB = reader.readLine().split(" ");
        int T = Integer.parseInt(TAB[0]);
        int A = Integer.parseInt(TAB[1]);
        int B = Integer.parseInt(TAB[2]);
        int[][][] firstLocs = getFirstCenters();
        while(T != 0) {
            T--;
            testCaseNum++;
            leftTryCount = 300;
            int hitX = Integer.MAX_VALUE;
            int hitY = Integer.MIN_VALUE;
            boolean isCenter = false;
            for(int i = 0; i < 5; i++) {
                boolean isOut = false;
                for(int j = 0; j < 5; j++) {
                    System.out.print(firstLocs[i][j][0] + " " + firstLocs[i][j][1]);
                    System.out.flush();
                    leftTryCount--;
                    String tmpAns = reader.readLine();
                    if(isCenter(tmpAns)) {
                        isOut = true;
                        isCenter = true;
                        hitX = firstLocs[i][j][0];
                        hitY = firstLocs[i][j][1];
                        break;
                    }
                    if(isHit(tmpAns)) {
                        hitX = firstLocs[i][j][0];
                        hitY = firstLocs[i][j][1];
                        isOut = true;
                        break;
                    }
                    if(isMiss(tmpAns)) continue;
                }
                if(isOut) break;
            }
            if(isCenter) continue;

            int leftX = -1000000001;
            int rightX = hitX;
            while (true) {
                int mid = (leftX + rightX) / 2;
                System.out.print(mid + " " + hitY);
                System.out.flush();
                leftTryCount--;
                String tmpAns = reader.readLine();
                if(isCenter(tmpAns)) {
                    isCenter = true;
                    break;
                }
                if(isHit(tmpAns)) {
                    rightX = mid;
                } else {
                    leftX = mid;
                }
                if(rightX - leftX <= 1) {
                    break;
                }
            }
            if(isCenter) continue;
            int X1 = rightX;
            int Y1 = hitY;

            leftX = hitX;
            rightX = 1000000001;
            while (true) {
                int mid = (leftX + rightX) / 2;
                System.out.print(mid + " " + hitY);
                System.out.flush();
                leftTryCount--;
                String tmpAns = reader.readLine();
                if(isCenter(tmpAns)) {
                    isCenter = true;
                    break;
                }
                if(isHit(tmpAns)) {
                    leftX = mid;
                } else {
                    rightX = mid;
                }
                if(rightX - leftX <= 1) {
                    break;
                }
            }
            if(isCenter) continue;
            int X2 = leftX;
            int Y2 = hitY;

            int minY = hitY;
            int maxY = 1000000001;
            while (true) {
                int mid = (minY + maxY) / 2;
                System.out.print(hitX + " " + mid);
                System.out.flush();
                leftTryCount--;
                String tmpAns = reader.readLine();
                if(isCenter(tmpAns)) {
                    isCenter = true;
                    break;
                }
                if(isHit(tmpAns)) {
                    minY = mid;
                } else {
                    maxY = mid;
                }
                if(maxY - minY <= 1) {
                    break;
                }
            }
            if(isCenter) continue;
            int X3 = hitX;
            int Y3 = minY;

            minY = -1000000001;
            maxY = hitY;
            while (true) {
                int mid = (minY + maxY) / 2;
                System.out.print(hitX + " " + mid);
                System.out.flush();
                leftTryCount--;
                String tmpAns = reader.readLine();
                if(isCenter(tmpAns)) {
                    isCenter = true;
                    break;
                }
                if(isHit(tmpAns)) {
                    maxY = mid;
                } else {
                    minY = mid;
                }
                if(maxY - minY <= 1) {
                    break;
                }
            }
            if(isCenter) continue;
            int X4 = hitX;
            int Y4 = maxY;
            Point p1 = new Point(X1, Y1);
            Point p2 = new Point(X2, Y2);
            Point p3 = new Point(X3, Y3);
            Point p4 = new Point(X4, Y4);
            if(p1.equals(p2)) {
                System.out.print(p1.x + " " + ((p3.y + p4.y) / 2));
                System.out.flush();
                leftTryCount--;
                isCenter = true;
                reader.readLine();
                continue;
            }
            if(!p3.equals(p1) && !p3.equals(p2)) {
                Point np = getCircle(p1, p2, p3);
                System.out.print(np.x + " " + np.y);
                System.out.flush();
                leftTryCount--;
                isCenter = true;
                reader.readLine();
                continue;
            }

            if(!p4.equals(p1) && !p4.equals(p2)) {
                Point np = getCircle(p1, p2, p4);
                System.out.print(np.x + " " + np.y);
                System.out.flush();
                leftTryCount--;
                isCenter = true;
                reader.readLine();
                continue;
            }

        }
    }

    public static int testCaseNum;

    public static int leftTryCount = 0;
    public static int[][][] getFirstCenters() {
        int X = -1000000000;
        int Y = -1000000000;
        int[][][] oklocs = new int[5][5][2];
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                oklocs[i][j][0] = X + i * (2 * 1000000000) / 4;
                oklocs[i][j][0] = Y + i * (2 * 1000000000) / 4;
            }
        }
        return oklocs;
    }

    public static boolean isHit(String inf) {
        if(inf.equals("HIT")) return true;
        return false;
    }

    public static boolean isCenter(String inf) {
        if(inf.equals("CENTER")) return true;
        return false;
    }

    public static boolean isMiss(String inf) {
        if(inf.equals("MISS")) return true;
        return false;
    }


    static class Point {
        long x;
        long y;
        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public boolean isSame(Point tmp) {
            if(this.x == tmp.x && this.y == tmp.y) {
                return true;
            }
            return false;
        }
    }

    public static Point getCircle(Point p1, Point p2, Point p3) {
        long x21 = p2.x - p1.x;
        long y21 = p2.y - p1.y;
        long x32 = p3.x - p2.x;
        long y32 = p3.y - p2.y;
        if (x21 * y32 - x32 * y21 == 0) {
            return null;
        }
        long xy21 = p2.x * p2.x - p1.x * p1.x + p2.y * p2.y - p1.y * p1.y;
        long xy32 = p3.x * p3.x - p2.x * p2.x + p3.y * p3.y - p2.y * p2.y;
        long y0 = (x32 * xy21 - x21 * xy32) / 2 * (y21 * x32 - y32 * x21);
        long x0 = (xy21 - 2 * y0 * y21) / (2 * x21);
        return new Point(x0, y0);
    }


}
