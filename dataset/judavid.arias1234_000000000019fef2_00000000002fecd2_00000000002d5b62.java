import java.util.*;

public class Solution {

    static class Point{
        long x;
        long y;
        boolean v;
        Point father;
        String d;
        int time;

        public Point(long x, long y, Point father, String d, int time) {
            this.x = x;
            this.y = y;
            this.father = father;
            this.d = d;
            this.time = time;
        }
    }

    static long mt = (long) Math.pow(10, 9);
    static Map<String, Point> generados = new HashMap<>();

    static long X ;
    static long Y;

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            X = sc.nextInt();
            Y = sc.nextInt();
            Point target=null;
            Point ini = new Point(0,0, null, "",-1);
            List<Point> lista = new ArrayList<>();
            lista.add(ini);
            while (!lista.isEmpty()){

                Point f = lista.remove(0);

                if(f.x == X && f.y == Y){
                    target = f;
                    break;
                }
                List<Point> childs = generarHijos(f, f.time + 1);
                for (Point c : childs){
                    if(c.v == false){
                        lista.add(c);
                    }
                }
                f.v= true;

            }

            if(target == null)
                System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
            else {
                List<String> path = new ArrayList<>();
                while (target.father != null){
                    path.add(target.d);
                    target = target.father;
                }
                path.add(target.d);
                String res = "";
                for (int i = path.size()-1; i >= 0; i--) {
                    res += path.get(i);
                }
                System.out.println("Case #"+(t+1)+": "+res);
            }

        }
    }

    static List<Point> generarHijos(Point p, int times){
        List<Point> childs = new ArrayList<>();
        long max =mt;
        long min = max*-1;
        long j = (long) Math.pow(2, times);

        Long rmx = p.x -  j;
        Long ry = p.y +  j;
        Long rmy = p.y -  j;
        Long rx = p.x +  j;
        if(Math.abs(rx) <= Math.abs(X)){
            Point h1 = new Point(rx,p.y, p,"E",times);
            childs.add(h1);
        }
        if(Math.abs(rmx) <= Math.abs(X)){
            Point h2 = new Point(rmx,p.y, p,"W",times);
            childs.add(h2);
        }
        if(Math.abs(ry) <= Math.abs(Y)){
            Point h3 = new Point(p.x,ry, p,"N",times);
            childs.add(h3);
        }
        if(Math.abs(rmy) <= Math.abs(Y)){
            Point h4 = new Point(p.x,rmy, p,"S",times);
            childs.add(h4);
        }

        return childs;
    }

    static Point generar(long x, long y, Point father, String d,int times){
        String k = x+" "+y;
        Point point = generados.get(k);
        if(point != null)
            return point;
        return new Point(x,y, father,d,times);
    }

}
