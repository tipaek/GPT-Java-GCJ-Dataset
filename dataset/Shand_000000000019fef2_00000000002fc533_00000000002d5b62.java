import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public class Point {
        double x,y;
        Point(double x,double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            Point p = (Point) o;
            return this.x == p.x && this.y == p.y;
        }
    }

    public class Node {
        double i,j,from,jump;
        String path;
        Point p;
        Node(double i, double j, double from, double jump, String path) {
            this.i = i;
            this.j = j;
            this.from = from;
            this.jump = jump;
            p = new Point(i,j);
            this.path = path;
        }
    }
    
    public boolean binary(double n) {
        int sum = 1;
        int i = 1;
        while(n>sum)
            sum+= Math.pow(2,i++);
        return n==sum;
    }

    public void solve() {
        int tests;
        Scanner s = new Scanner(System.in);
        tests = s.nextInt();
        for(int t=0;t<tests;t++) {
            double x = s.nextInt();
            double y = s.nextInt();
            
            if((!binary(Math.abs(x))&&!binary(Math.abs(y)))||(binary(Math.abs(x))&&binary(Math.abs(y)))) {
                System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
                continue;
            }

            ArrayList<Node> queue = new ArrayList<>();
            ArrayList<Point> visited = new ArrayList<>();
            queue.add(new Node(0,0,-1,0,""));

            long start = System.currentTimeMillis();
            int timeout;
            if(x < 500 && y < 500)
                timeout = 1000;
            else if(x <1000 && y<1000)
                timeout = 2000;
            else if(x < 10000 && y < 10000)
                timeout = 2500;
            else
                timeout = 3000;
            while(queue.size()!=0) {
                if(System.currentTimeMillis() - start > timeout) {
                    System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
                    break;
                }
                Node n = queue.remove(0);
                //System.out.println(n.i+" "+n.j);
                if(n.i==x && n.j==y) {
                    System.out.println("Case #"+(t+1)+": "+n.path);
                    break;
                }
                if(visited.contains(n.p))
                    continue;

                visited.add(n.p);
                double jump_length = Math.pow(2,n.jump);
                if(n.from !=0) {
                    queue.add(new Node(n.i-jump_length,n.j,1,n.jump+1,n.path+"W"));
                }
                if(n.from !=1) {
                    queue.add(new Node(n.i+jump_length,n.j,0,n.jump+1,n.path+"E"));
                }
                if(n.from !=2) {
                    queue.add(new Node(n.i,n.j+jump_length,3,n.jump+1,n.path+"N"));
                }
                if(n.from !=3) {
                    queue.add(new Node(n.i,n.j-jump_length,2,n.jump+1,n.path+"S"));
                }

            }
        }
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}
