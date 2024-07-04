/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author EliteBook
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {

        new Solution().getResult();
    }
    class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" + "x=" + x + ", y=" + y + '}';
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 31 * hash + this.x;
            hash = 31 * hash + this.y;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Point other = (Point) obj;
            if (this.x != other.x) {
                return false;
            }
            if (this.y != other.y) {
                return false;
            }
            return true;
        }
        
    }

    public void getResult() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= tc; t++) {
            String[] ip = br.readLine().trim().split(" ");
            int x = Integer.parseInt(ip[0]);
            int y = Integer.parseInt(ip[1]);
            List<Point> points=new ArrayList<>();
            points.add(new Point(x, y));
            for(char c:ip[2].toCharArray()){
                switch (c){
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                    default:
                        break;
                        
                }
                points.add(new Point(x,y));
            }
//            System.out.println(points);
            int res = bfs(new Point(0,0),points, ip[2], 0, 0);
            //System.out.println(meet);
           // System.out.println(res);

            System.out.print("Case #" + t + ": ");

            if (res == Integer.MAX_VALUE) {
                System.out.print("IMPOSSIBLE");
            } else {
                System.out.print(res);
            }
            System.out.println();
//            

        }

    }
    boolean found = false;
    Set<Integer> meet=new HashSet<>();

    public int bfs(Point p, List<Point> points, String dir, int steps, int ind) {
        //System.out.println(mx+" "+ my+" " +" "+tx+" "+ ty+" "+" "+" "+  steps+" "+ ind);

        if (points.contains(p)) {
            //System.out.println("me"+p);
            //System.out.println("target"+points.get(steps));
            
            if(p.equals(points.get(steps))){
                 found = true;
                 return steps;
            }
            
           
            //  System.out.println(steps);
//            meet.add(steps);
            
            
            
            
        }


        if (steps >= dir.length()) {
            return Integer.MAX_VALUE;
        }
        int m1=bfs(new Point(p.x,p.y), points, dir, steps+1, ind);
        int m2=bfs(new Point(p.x+1,p.y), points, dir, steps+1, ind);
        int m3=bfs(new Point(p.x,p.y+1), points, dir, steps+1, ind);
        int m4=bfs(new Point(p.x-1,p.y), points, dir, steps+1, ind);
        int m5=bfs(new Point(p.x,p.y-1), points, dir, steps+1, ind);
        
        
        
        return Math.min(m1, Math.min(m2, Math.min(m3, Math.min(m4, m5))));

    }

}
