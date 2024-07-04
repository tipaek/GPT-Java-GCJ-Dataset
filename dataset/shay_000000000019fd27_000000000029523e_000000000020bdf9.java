import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            ArrayList<Point> points = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int t1 = in.nextInt();
                int t2 = in.nextInt();
                points.add(new Point(t1, t2));
            }

            points.sort(Comparator.comparingInt(Point::getStart));
      //  System.out.println("Case #" + i + ": " + points);
            System.out.println("Case #" + i + ": " + tasks(points));
        }
    }

    private static String tasks(ArrayList<Point> points) {

        StringBuilder sb = new StringBuilder();

        int Cbusy=-1;
        int Jbusy=-1;

        while(!points.isEmpty()) {
            Point p1 = points.get(0);
            if (p1.getStart() >= Cbusy) {
                sb.append('C');
                Cbusy = p1.getEnd();
            } else if (p1.getStart() >= Jbusy) {
                sb.append('J');
                Jbusy = p1.getEnd();
            } else {
                return "IMPOSSIBLE";
            }
            points.remove(0);
        }


        return sb.toString();
    }
//    private static String tasks(ArrayList<Point> points) {
//
//        StringBuilder sb = new StringBuilder();
//        int end=0;
//
//        while (!points.isEmpty()) {
//
//            Point p1 = points.remove(0);
//
//            sb.append("C");
//            List<Point> intesact = points.stream().filter(p -> (p.start > p1.start) && (p.start < p1.end)).collect(Collectors.toList());
//            if (intesact.size() > 1) {
//                for (int i = 0; i < intesact.size() - 1; i++) {
//                    if(p1.getStart()>end){
//                        return "IMPOSSIBLE";
//                    }
//                    if (intersact(intesact.get(i),intesact.get(i + 1))) {
//                        return "IMPOSSIBLE";
//                    }
//                }
//            }
//            for(int i=0;i<intesact.size();i++){
//                Point p2= points.remove(0);
//                if(p2.getEnd()>end)
//                {
//                    end=p2.getEnd();
//                }
//                sb.append("J");
//            }
//
//
//        }
//        return sb.toString();
//    }

    private static boolean intersact(Point p1, Point p2) {
        return (p1.end > p2.start);
    }

static class Point {
    final int start;
    final int end;

    public Point(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }


    @Override
    public String toString() {
        return "Point{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}



}
