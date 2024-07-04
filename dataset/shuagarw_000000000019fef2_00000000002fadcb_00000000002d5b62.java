import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class Solution {
  public static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
  public static String[] ch = {"N","S","E","W"};

  private static class Node{
    public int x;
    public int y;
    public String str;

    public Node(int x, int y, String str) {
      this.x = x;
      this.y = y;
      this.str = str;
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    int cases = Integer.parseInt(in.nextLine());
    for(int  i = 1; i<=cases;i++){
      String[] str = in.nextLine().split(" ");
      int x = Integer.parseInt(str[0]);
      int y = Integer.parseInt(str[1]);

      System.out.println("Case #"+i+": " + navigate(x,y));

    }
  }

  public static String navigate(int x, int y){
    Queue<Node> queue = new LinkedList<>();

    queue.add(new Node(0,0, ""));
    int  i = 1;
    while(!queue.isEmpty()){
      int size = queue.size();

      for(int j=0; j< size;j++){
        Node curr = queue.poll();
        if(curr.x == x && curr.y==y){
          return curr.str;
        }

        for(int k = 0; k<4;k++){
          int newX = curr.x + dir[k][0]*i;
          int newy = curr.y + dir[k][1]*i;
          if(Math.abs(newX )> Math.abs(x) || Math.abs(newy)>Math.abs(y)){
            continue;
          }else{
            queue.add(new Node(newX, newy, curr.str+ch[k]));
          }
        }
      }
      i = i*2;
    }

    return "IMPOSSIBLE";
  }


}
