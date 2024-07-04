import static java.lang.Math.pow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

  static int[] R ={0,1,-1,0};
  static int C[]={1,0,0,-1};
  static char PP[]={'N','E','W','S'};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int testCases;
    testCases = Integer.parseInt(sc.next());
    for (int i = 1; i <= testCases; i++) {
      int goalI = sc.nextInt();
      int goalJ = sc.nextInt();
      pos result = solve(new pos(goalI, goalJ));
      if(result != null) {
        System.out.println("Case #"+i +": " + result.path);
      } else {
        System.out.println("Case #"+i +": IMPOSSIBLE");
      }
    }
  }

  private static pos solve(pos s) {
    Queue<pos> Q = new LinkedList<>();
    pos k = new pos();
    k.i=0;
    k.j=0;
    k.Z=1;
    Q.add(k);
    Map<Integer, Integer> v= new HashMap<>();
    v.put(0,0);//[0][0]=true;
    while(!Q.isEmpty()){
      pos c=Q.peek();Q.poll();
      int Z=c.Z;
      v.put(c.i, c.j);
      if (c.i==s.i && c.j==s.j) {
        return c;
      }
      int i=0;
      while(i<4){
        pos n = new pos();
        n.i=c.i+(R[i]*Z);
        n.j=c.j+(C[i]*Z);
        n.path = c.path + PP[i];
        //System.out.println(n.i + " " + n.j);
        if(n.i>=-100&&n.i<=100&& n.j>=-100&&n.j<=100){
          if(!(v.containsKey(n.i) && v.get(n.i) == n.j)){
            v.put(c.i, c.j);
            n.Z = (int) pow(2,Z);
            Q.add(n);
          }
        }
        i++;
      }
    }
    return null;
  }

}




class pos {
    int i,j,Z;
    String path = "";
    pos(int i, int j) {
      this.i=i;
      this.j=j;
    }
    pos(){

    }
};