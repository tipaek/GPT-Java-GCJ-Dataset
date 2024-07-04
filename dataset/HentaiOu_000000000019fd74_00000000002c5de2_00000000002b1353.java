import java.util.*;

class Solution1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(in.nextLine());
        HashMap<Integer, ArrayList<Point>> result = new HashMap<>();

        for (int caseId = 1; caseId <= numberOfCases; caseId++) {
            long requiredSum = Integer.parseInt(in.nextLine());
            long tempSum = requiredSum;
            Point tempPoint;
            int r1 = 1, k1 = 1;
            ArrayList<Point> path = new ArrayList<>();
            ArrayList<Integer> powsOf2 = new ArrayList<>();
            int temp = getMinPowerOf2(1, tempSum);
            powsOf2.add(temp);
            tempSum = tempSum - (long) Math.pow(2, temp) - temp;
            while (tempSum > 0) {
                temp = getMinPowerOf2(2, tempSum);
                powsOf2.add(temp);
                tempSum -= (Math.pow(2, temp) - 1);
            }

            if(requiredSum < 100) {
                tempSum = requiredSum;
                while (tempSum > 0) {
                    path.add(new Point(r1, k1));
                    r1++;
                    tempSum--;
                }
            } else {
                int length = powsOf2.size();
                boolean left = true;
                for(int i = length - 1; i >= 0; i--) {
                    if(i < 0) {
                        break;
                    }
                    int currentPow = 1;

                    if(left) {
                        while (r1 <= currentPow) {
                            tempPoint = new Point(r1, k1);
                            path.add(tempPoint);
                            r1++;
                        }
                        k1 = 1;
                        while(k1 <= r1) {
                            tempPoint = new Point(r1, k1);
                            path.add(tempPoint);
                            k1++;
                        }
                        k1--;
                        r1++;
                        left = false;

                    } else {
                        while (r1 <= currentPow) {
                            k1 = r1;
                            tempPoint = new Point(r1, k1);
                            path.add(tempPoint);
                            r1++;
                        }
                        k1 = r1;
                        while (k1 >= 1) {
                            tempPoint = new Point(r1, k1);
                            path.add(tempPoint);
                            k1--;
                        }
                        k1++;
                        r1++;
                        left = true;
                    }
                }
            }

            result.put(caseId, path);
        }

        // Print
        for(int caseId = 1; caseId <= numberOfCases; caseId++) {
            System.out.println("Case #" + caseId + ":");
            ArrayList<Point> currentPath = result.get(caseId);
            int length = currentPath.size();
            for(int j = 0; j < length; j++) {
                System.out.println(currentPath.get(j).x + " " + currentPath.get(j).y);
            }
        }
    }

    public static int getMinPowerOf2(int type, long val) {
        long powVal;
        if (type == 1) {
            for(int i = 0; i >= 0; i++) {
                if(Math.pow(2, i+1) + i+1 >= val) {
                    return i;
                }
            }
            return 0;
        } else {
            for(int i = 0; i >= 0; i++) {
                if(Math.pow(2, i+1) - 1 > val) {
                    return i;
                }
            }
            return 0;
        }
    }
}
class Point {
        public int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }