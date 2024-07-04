
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {

    public static void main (String[] args){
        Scanner input = new Scanner(System.in);

        int total = Integer.parseInt(input.nextLine());

        for(int cases = 1; cases <= total; cases++){
            String[] pos = input.nextLine().split(" ");
            int x = Integer.parseInt(pos[0]);
            int y = Integer.parseInt(pos[1]);

            Point answerPoint = new Point(x,y, "",0);
            Point firstPoint = new Point(0,0, "",0);

            Deque<Point> stack = new ArrayDeque<>();
            stack.push(firstPoint);
            Point currentPoint = firstPoint;

            while(currentPoint.x != answerPoint.x && currentPoint.y != answerPoint.y ){
                currentPoint = stack.pop();
                System.out.println(stack);
                System.out.println(currentPoint);
                System.out.println(currentPoint.level);
                Point[] p = currentPoint.getNeighbours();
                System.out.println(answerPoint);
                for (int i=0; i<p.length; i++){
                    if(p[i].visited == false && ((p[i].x + currentPoint.x) <= answerPoint.x && (p[i].y + currentPoint.y) <= answerPoint.y) && p[i].level <= (answerPoint.x+answerPoint.y)){
                        stack.push(p[i]);
                    }

                }

            }


            outputAnswer(cases,currentPoint.toString());
        }
    }



        public static void outputAnswer ( int cases, String answer){
            System.out.printf("Case #%d: %s\n", cases, answer);
        }

    }
class Point {

    int x;
    int y;
    String comeFrom;
    boolean visited;
    int level;

    public Point(int x, int y, String comeFrom, int level) {
        this.x = x;
        this.y = y;
        this.comeFrom = comeFrom;
        this.visited = false;
        this.level = level;
    }
    @Override
    public String toString(){
        return String.format("%d-%d",this.x,this.y);
    }

    public Point[] getNeighbours(){

        Point[] points = new Point[4];
        double jump = Math.pow(2, level + 1 - 1);
        Point west = new Point(this.x - (int) jump, this.y, "W", level+1);
        Point east = new Point(this.x + (int) jump, this.y, "E",level+1);
        Point north = new Point(this.x, this.y + (int) jump, "N",level+1);
        Point south = new Point(this.x, this.y - (int) jump, "S", level+1);
        points[0] = west;
        points[1] = east;
        points[2] = north;
        points[3] = south;

        return points;


    }

}
/*


 */