import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static  int max = 1000000000;
    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
    static
    int [][] initChecks = {{0,0},{0,max/2}, {0,-max/2}, {max/2,0},{-max/2,0}, {0,max}, {max, 0}, {0, -max}, {-max, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str[] = br.readLine().split(" ");
        int t = Integer.parseInt(str[0]);
        int a = Integer.parseInt(str[1]);
        int b = Integer.parseInt(str[2]);
        for (int i = 0; i < t; i++) {
              Point inside = getFirstInside(br);
              if (null==inside)
                  continue;
              Point top = binSearchUp(inside, br, new Point(inside.x, max), true);
              if (top==null)
                  continue;
              Point bottom = binSearchUp(inside, br, new Point(inside.x, -max), true);
              if (bottom==null)
                continue;
            Point left = binSearchLeft(inside, br, new Point(max, inside.y), true);
            if (left==null)
                continue;
            Point right = binSearchLeft(inside, br, new Point(-max, inside.y), true);
            if (right==null)
                continue;
            String resp = getPointResp(br,new Point((left.x+right.x)/2, (top.y+bottom.y)/2));
            if(!"CENTER".equals(resp))
                break;
        }


        }

    private static Point binSearchUp(Point inside, BufferedReader br, Point top, boolean checkTop) throws IOException {
        if (checkTop){
            String resp = getPointResp(br, top);
            if("HIT".equals(resp))
                return top;
        }

        int newY = (inside.y+top.y)/2;
        if (newY==inside.y)
            return inside;
        Point newP = new Point(inside.x,newY);
        String resp = getPointResp(br,newP );
        switch (resp){
            case "CENTER": return null;
            case "HIT": return binSearchUp(newP, br, top, false);
            case "MISS": return binSearchUp(inside, br, newP, false);
        }
        return null;
    }

    private static Point binSearchLeft(Point inside, BufferedReader br, Point top, boolean checkTop) throws IOException {
        if (checkTop){
            String resp = getPointResp(br, top);
            if("HIT".equals(resp))
                return top;
        }

        int newX = (inside.x+top.x)/2;
        if (newX==inside.x)
            return inside;
        Point newP = new Point(newX,inside.y);
        String resp = getPointResp(br,newP );
        switch (resp){
            case "CENTER": return null;
            case "HIT": return binSearchUp(newP, br, top, false);
            case "MISS": return binSearchUp(inside, br, newP, false);
        }
        return null;
    }
    private static String getPointResp(BufferedReader br, Point p) throws IOException {
        System.out.println(p.x+" "+p.y);
        System.out.flush();
        return br.readLine();
    }

    private static Point getFirstInside(BufferedReader br) throws IOException {
        for (int i[] : initChecks){

            String response = getPointResp(br,new Point(i[0], i[1]));
            switch (response){
                case "CENTER": return null;
                case "HIT": return new Point(i[0], i[1]);
                
            }
        }
        return null;
    }
}
