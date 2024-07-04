import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int c = 1; c <= t; ++c) {
      class Node{
        long x,y;
        String dir, path;
        Node(long x, long y, String dir, String path){
          this.x = x;
          this.y = y;
          this.dir = dir;
          this.path = path;
        }
        List<Node> getAdj(Node goal, long i){
            long unit = (long) Math.pow(2, i-1);
            Node north = new Node(x, y + unit, "N", this.path + "N");
            Node south = new Node(x, y - unit, "S", this.path + "S");
            Node east = new Node(x + unit, y, "E", this.path + "E");
            Node west = new Node(x - unit, y, "W", this.path + "W");
            List<Node> res = new ArrayList<>();
            res.add(north);
            res.add(south);
            res.add(east);
            res.add(west);
            Collections.shuffle(res);
            return res;
        }

        Node tryToReach(Node goal, long i, Node sol){
          if(sol != null && sol.path.length() < i) return null;
          long dx = Math.abs(goal.x - this.x);
          long dy = Math.abs(goal.y - this.y);
          long unit = (long) Math.pow(2, i-1);
          boolean stop = (unit > dx && dx !=0) || (unit > dy && dy!=0);
          if(stop) return null;
          List<Node> adj = getAdj(goal, i);
          TreeSet<Node> sols = new TreeSet<>((o1, o2) -> o1.path.length() - o2.path.length());
          for(Node next: adj){
            if(next.x == goal.x && next.y == goal.y){
              return next;
            }
            Node finalNode = next.tryToReach(goal, i +1, sols.isEmpty() ? null : sols.first());
            if(finalNode != null){
              sols.add(finalNode);
            }
          }
          return sols.isEmpty() ? null : sols.first();
        }

        public String toString() {
          return this.x +","+this.y;
        }
      }
      Node goal = new Node(in.nextLong(), in.nextLong(), null, "");
      Node res = new Node(0,0, null, "").tryToReach(goal, 1, null);
      System.out.println(String.format("Case #%d: %s", c, res == null ? "IMPOSSIBLE" : res.path));
    }
  }

}