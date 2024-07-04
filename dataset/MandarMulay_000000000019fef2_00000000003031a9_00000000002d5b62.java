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

        Point prevPoint;

        public Point(int x, int y, Point p){
            this.x = x;
            this.y = y;
            this.prevPoint = p;
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

        Point startPoint = new Point(startX, startY, null);
        Set<String> visited = new HashSet<String>();

        Queue<Point> q = new LinkedList<Point>();
        q.offer(startPoint);
        visited.add(startPoint.toString());
        int stepLength = 1;

        Point p = null;
        while(!q.isEmpty()){

            for(int i = q.size(); i > 0; i--){
                p = q.poll();
                if(p.isDestination(endX, endY)){
                    break;
                }

                List<Point> hPoints = getHorizontalPointsAtDistance(p, stepLength);
                List<Point> vPoints = getVerticalPointsAtDistance(p, stepLength);
                List<Point> points = new ArrayList<Point>();

                if(stepLength == 1){
                    if(isOdd(Math.abs(endX))) {
                        points.addAll(hPoints);
                    } else if(isOdd(Math.abs(endY))){
                        points.addAll(vPoints);
                    } else {
                        points.addAll(hPoints);
                        points.addAll(vPoints);
                    }
                } else {
                    points.addAll(hPoints);
                    points.addAll(vPoints);
                }

                for(Point nextPoint : points){
                    if(visited.contains(nextPoint.toString())) continue;

                    q.offer(nextPoint);
                }
            }
            if(p.isDestination(endX, endY)) break;
            stepLength *= 2;
        }
        if(p.isDestination(endX, endY)){
            String path = computePath(p);
            return path;
        }
        return "IMPOSSIBLE";
    }

    public String computePath(Point point){
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
    }

    public List<Point> getHorizontalPointsAtDistance(Point p, int stepLength){
        Point rightPoint = new Point(p.x + stepLength, p.y, p);
        Point leftPoint = new Point(p.x - stepLength, p.y, p);

        List<Point> points = new ArrayList<Point>();
        points.add(rightPoint);
        points.add(leftPoint);

        return points;
    }

    public List<Point> getVerticalPointsAtDistance(Point p, int stepLength){
        Point belowPoint = new Point(p.x, p.y - stepLength, p);
        Point abovePoint = new Point(p.x, p.y + stepLength, p);

        List<Point> points = new ArrayList<Point>();
        points.add(belowPoint);
        points.add(abovePoint);

        return points;
    }
}