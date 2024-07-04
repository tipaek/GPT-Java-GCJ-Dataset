import java.util.*;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        int i = 1;

        int testCasesCount = scanner.nextInt();
        while(i <= testCasesCount){
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            String path = solution.findPath(0, 0, x, y);

            System.out.print("Case #" + i + ": " + path);
            System.out.println();
            i++;
        }
    }

    class Point {
        int x;
        int y;

        String currentPath;

        public Point(int x, int y, String s){
            this.x = x;
            this.y = y;
            this.currentPath = s;
        }

        public String toString(){
            return this.x + "," + this.y;
        }

        public boolean isDestination(int x, int y){
            return this.x == x && this.y == y;
        }
    }

    public boolean isOdd(int n){
        return n % 2 == 1;
    }

    public String findPath(int startX, int startY, int endX, int endY){
        if(isOdd(Math.abs(endX)) && isOdd(Math.abs(endY))){
            return "IMPOSSIBLE";
        }

        Point startPoint = new Point(startX, startY, "");
        Set<String> visited = new HashSet<String>();

        Queue<Point> q = new LinkedList<Point>();
        q.offer(startPoint);
        visited.add(startPoint.toString());
        int stepLength = 1;

        Point p = null;
        while(!q.isEmpty()){
            System.gc();
            for(int i = q.size(); i > 0; i--){
                p = q.poll();
                if(p.isDestination(endX, endY)){
                    q = new LinkedList<Point>();
                    System.gc();
                    return p.currentPath;
                }
                List<Point> points = new ArrayList<Point>();

                if(stepLength == 1){
                    if(isOdd(Math.abs(endX))) {
                        List<Point> hPoints = getHorizontalPointsAtDistance(p, stepLength);
                        points.addAll(hPoints);
                    } else if(isOdd(Math.abs(endY))){
                        List<Point> vPoints = getVerticalPointsAtDistance(p, stepLength);
                        points.addAll(vPoints);
                    } else {
                        List<Point> hPoints = getHorizontalPointsAtDistance(p, stepLength);
                        List<Point> vPoints = getVerticalPointsAtDistance(p, stepLength);
                        points.addAll(hPoints);
                        points.addAll(vPoints);
                    }
                } else {
                    List<Point> hPoints = getHorizontalPointsAtDistance(p, stepLength);
                    List<Point> vPoints = getVerticalPointsAtDistance(p, stepLength);
                    points.addAll(hPoints);
                    points.addAll(vPoints);
                }

                for(Point nextPoint : points){
                    if(visited.contains(nextPoint.toString())) continue;

                    q.offer(nextPoint);
                }
                System.gc();
            }
            stepLength *= 2;
        }
        return "IMPOSSIBLE";
    }

    /*public String computePath(Point point){
        StringBuilder sb = new StringBuilder();
        while(point.prevPoint != null){
            Point currentPoint = point;
            point = point.prevPoint;
            char c = '\0';
            if(currentPoint.x == point.x){
                //Up or down
                c = ((currentPoint.y - point.y) > 0) ? 'N' : 'S';
            } else {
                //Left or right
                c = ((currentPoint.x - point.x) > 0) ? 'E' : 'W';
            }
            sb.insert(0, c);
        }
        return new String(sb);
    }*/

    public List<Point> getHorizontalPointsAtDistance(Point p, int stepLength){
        Point rightPoint = new Point(p.x + stepLength, p.y, p.currentPath + "E");
        Point leftPoint = new Point(p.x - stepLength, p.y, p.currentPath + "W");

        List<Point> points = new ArrayList<Point>();
        points.add(rightPoint);
        points.add(leftPoint);

        return points;
    }

    public List<Point> getVerticalPointsAtDistance(Point p, int stepLength){
        Point belowPoint = new Point(p.x, p.y - stepLength, p.currentPath + "S");
        Point abovePoint = new Point(p.x, p.y + stepLength, p.currentPath + "N");

        List<Point> points = new ArrayList<Point>();
        points.add(belowPoint);
        points.add(abovePoint);

        return points;
    }
}