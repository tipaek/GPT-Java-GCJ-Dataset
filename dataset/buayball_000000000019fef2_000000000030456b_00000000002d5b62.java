import java.util.*;
import java.io.*;
import java.lang.Math;
public class Solution {

  private static Queue<String> discovered = new LinkedList<String>();
  private static Map<String, Node> node = new HashMap<String, Node>();

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();

    for (int case_t = 1; case_t <= t; case_t++) {
      
      int x = in.nextInt();
      int y = in.nextInt();

      discovered.clear();
      node.clear();

      discovered.add("");
      node.put("",new Node("",0,0,0));
      node.put("N",new Node("N",0,1,0));
      node.put("E",new Node("E",1,0,0));
      node.put("S",new Node("S",0,-1,0));
      node.put("W",new Node("W",-1,0,0));

      if((Math.abs(x%2)==1 && Math.abs(y%2)==1) || (Math.abs(x%2)==0 && Math.abs(y%2)==0)){
        System.out.println("Case #" + case_t + ": IMPOSSIBLE");  
      } else {

        String out = BFS(x,y);

        System.out.println("Case #" + case_t + ": " + out);
      }      
    }
  }

  public static String BFS(int x, int y) {
    String out = "";

    while(!discovered.isEmpty()) {
      String u = discovered.poll();

      for(String v : node.get(u).adjNode) {
        if(node.get(v).status == 0) {
          node.get(v).status = 1;
          int current_x = node.get(v).x;
          int current_y = node.get(v).y;
          int current_dis = node.get(v).distance;
          String current_path = node.get(v).name;
          int step = (int)Math.pow(2, current_dis + 1);
          
          if(current_x == x && current_y == y){
            return current_path;
          }

          node.put(current_path + "N",new Node(current_path + "N", current_x + 0, current_y + step, current_dis + 1));

          node.put(current_path + "E",new Node(current_path + "E", current_x + step, current_y + 0, current_dis + 1));

          node.put(current_path + "S",new Node(current_path + "S", current_x + 0, current_y - step, current_dis + 1));

          node.put(current_path + "W",new Node(current_path + "W", current_x - step, current_y + 0, current_dis + 1));

          discovered.add(v);

          //System.out.println("add discover : " + v);
        }
      }
      node.get(u).status = 2;
    }

    return out;
  }
}

class Node {
  public String name;
  public int status; // 0 = undiscovered, 1 = discovered, 2 = explored
  public int x;
  public int y;
  public int distance;
  public ArrayList<String> adjNode; // represent edges to other vertices
  public Node(String name, int x, int y, int distance) {
    this.name = name;
    this.x = x;
    this.y = y;
    this.status = 0;
    this.distance = distance;
    adjNode = new ArrayList<String>();
    adjNode.add(name + "N");
    adjNode.add(name + "E");
    adjNode.add(name + "S");
    adjNode.add(name + "W");
  }
}