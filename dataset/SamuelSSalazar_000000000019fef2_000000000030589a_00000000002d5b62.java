import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int c = 1; c <= t; ++c) {
      class Node{
        long x,y, i;
        String path;
        Node(long x, long y, long i, String path){
          this.x = x;
          this.y = y;
          this.i = i;
          this.path = path;
        }
        List<Node> getAdj(Node goal, long i){
            long unit = (long) Math.pow(2, i-1);
            Node north = new Node(x, y + unit, i + 1, this.path + "N");
            Node south = new Node(x, y - unit, i +1, this.path + "S");
            Node east = new Node(x + unit, y, i+1, this.path + "E");
            Node west = new Node(x - unit, y, i+1,this.path + "W");
            List<Node> res = new ArrayList<>();
            res.add(north);
            res.add(south);
            res.add(east);
            res.add(west);
            Collections.shuffle(res);
            return res;
        }

        Node tryToReach(Node goal){

          TreeSet<Node> sols = new TreeSet<>(Comparator.comparingInt(o -> o.path.length()));
          Stack<Node> stack = new Stack<>();

            stack.push(this);

            while(!stack.empty())
            {
              Node curr = stack.pop();
              if(!sols.isEmpty() && sols.first().path.length() < curr.i) continue;
              long dx = Math.abs(goal.x - curr.x);
              long dy = Math.abs(goal.y - curr.y);
              long unit = (long) Math.pow(2, curr.i-1);
              boolean stop = (unit > dx && dx !=0) || (unit > dy && dy!=0);
              if(stop) continue;
              List<Node> adj = curr.getAdj(goal, curr.i);
              for(Node next: adj){
                if(next.x == goal.x && next.y == goal.y){
                  sols.add(next);
                }
                stack.push(next);
              }
              i++;
            }

          return sols.isEmpty() ? null : sols.first();
        }

        public String toString() {
          return this.x +","+this.y;
        }
      }
      Node goal = new Node(in.nextLong(), in.nextLong(), 0, "");
      Node res = new Node(0,0, 1, "").tryToReach(goal);
      System.out.println(String.format("Case #%d: %s", c, res == null ? "IMPOSSIBLE" : res.path));
    }
  }

}