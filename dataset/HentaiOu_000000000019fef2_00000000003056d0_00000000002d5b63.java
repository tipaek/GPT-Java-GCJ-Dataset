import java.util.*;

public class Solution {

    public static int totalShootsTried = 0;
    public static boolean shouldContinue = true;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(in.nextLine());

        Outer :
        for (int caseId = 1; caseId <= numberOfCases; caseId++) {
            String input = in.nextLine();
            int A = Integer.parseInt(input.trim().split(" ")[0]);
            int B = Integer.parseInt(input.trim().split(" ")[1]);
            totalShootsTried = 0;

            int radius = Math.min(A, B);
            Point startPoint;

            if (radius > 500000000) {
                startPoint = new Point(0, 0);
            } else {
                startPoint = new Point(0, 0);
                boolean didHit = false;
                while (!didHit) {
                    // Has to be completed
                    startPoint = new Point(-1000000000, -1000000000);
                    int shootVal = shootAt(startPoint);
                    if(shootVal == 2) {
                        break;
                    } else if(shootVal == 1) {
                        continue Outer;
                    } else {
                        if (startPoint.y == 1000000000){
                            startPoint.y += -1000000000;
                            startPoint.x += 500000000;
                        } else {
                            startPoint.y += 1000000000;
                        }
                    }
                }
            }
            if (!shouldContinue) {
                int left = 0, right = 0, up = 0, bottom = 0;
                left = getIntersectionPoint(caseId, 1, startPoint, radius);
                right = getIntersectionPoint(caseId, 2, startPoint, radius);
                up = getIntersectionPoint(caseId, 3, startPoint, radius);
                bottom = getIntersectionPoint(caseId, 4, startPoint, radius);
                
                shootAt(new Point((left + right)/2 , (up + bottom) / 2));
            }
        }

    }

    public static int getIntersectionPoint(int caseID, int type, Point start, int radius) {
        int retVal = -1000000002;
        int tempPos = 0;
        /* 1 = left
         * 2 = right
         * 3 = up
         * 4 = bottom */
        int previousThrow = shootAt(new Point(start.x, start.y));
        if (previousThrow == 1) {
            return -1000000002;
        }
        int end;
        switch (type) {
            case 1:
                end = start.x - radius;
                if (end < -1000000000) {
                    end = -1000000000;
                }
                tempPos = start.x;
                while (tempPos >= end) {
                    tempPos -= radius;
                    if (tempPos < -1000000000) {
                        tempPos = -1000000000;
                    }
                    int currentThrow = shootAt(new Point(tempPos, start.y));
                    if (currentThrow == 1) {
                        return -1000000002;
                    }
                    if (previousThrow == 2 && (currentThrow == 3)) {
                        if (radius == 1) {
                            return tempPos + radius;
                        } else {
                            radius /= 2;
                            if (radius < 1) {
                                radius = 1;
                            }
                            start = new Point(tempPos + radius, start.y);
                            return getIntersectionPoint(caseID, type, start, radius);
                        }
                    }
                    previousThrow = currentThrow;
                }
                break;

            case 2:
                end = start.x + radius;
                if (end > 1000000000) {
                    end = 1000000000;
                }
                tempPos = start.x;
                while (tempPos <= end) {
                    tempPos += radius;
                    if (tempPos > 1000000000) {
                        tempPos = 1000000000;
                    }
                    int currentThrow = shootAt(new Point(tempPos, start.y));
                    if (currentThrow == 1) {
                        return -1000000002;
                    }
                    if (previousThrow == 2 && (currentThrow == 3)) {
                        if (radius == 1) {
                            return tempPos - radius;
                        } else {
                            radius /= 2;
                            if (radius < 1) {
                                radius = 1;
                            }
                            start = new Point(tempPos - radius, start.y);
                            return getIntersectionPoint(caseID, type, start, radius);
                        }
                    }
                    previousThrow = currentThrow;
                }
                break;

            case 3:
                end = start.y - radius;
                if (end < -1000000000) {
                    end = -1000000000;
                }
                tempPos = start.y;
                while (tempPos >= end) {
                    tempPos -= radius;
                    if (tempPos < -1000000000) {
                        tempPos = -1000000000;
                    }
                    int currentThrow = shootAt(new Point(tempPos, start.y));
                    if (currentThrow == 1) {
                        return -1000000002;
                    }
                    if (previousThrow == 2 && (currentThrow == 3)) {
                        if (radius == 1) {
                            return tempPos + radius;
                        } else {
                            radius /= 2;
                            if (radius < 1) {
                                radius = 1;
                            }
                            start = new Point(start.x, tempPos + radius);
                            return getIntersectionPoint(caseID, type, start, radius);
                        }
                    }
                    previousThrow = currentThrow;
                }
                break;

            case 4:
                end = start.y + radius;
                if (end > 1000000000) {
                    end = 1000000000;
                }
                tempPos = start.y;
                while (tempPos <= end) {
                    tempPos += radius;
                    if (tempPos > 1000000000) {
                        tempPos = 1000000000;
                    }
                    int currentThrow = shootAt(new Point(tempPos, start.y));
                    if (currentThrow == 1) {
                        return -1000000002;
                    }
                    if (previousThrow == 2 && currentThrow == 3) {
                        if (radius == 1) {
                            return tempPos - radius;
                        } else {
                            radius /= 2;
                            if (radius < 1) {
                                radius = 1;
                            }
                            start = new Point(start.x, tempPos - radius);
                            return getIntersectionPoint(caseID, type, start, radius);
                        }
                    }
                    previousThrow = currentThrow;
                }
                break;
        }
        return retVal;
    }

    public static int shootAt(Point point) {
        totalShootsTried++;
        System.out.println(point.x + " " + point.y);
        Scanner in = new Scanner(System.in);
        return dataValue(in.nextLine());
    }

    public static int dataValue(String data) {
        if (data.equalsIgnoreCase("CENTER")) {
            shouldContinue = false;
            return 1;
        } else if (data.equalsIgnoreCase("HIT")) {
            return 2;
        } else if (data.equalsIgnoreCase("MISS")) {
            return 3;
        } else {
            System.out.println("Error");
            return -1;
        }
    }

    public static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}