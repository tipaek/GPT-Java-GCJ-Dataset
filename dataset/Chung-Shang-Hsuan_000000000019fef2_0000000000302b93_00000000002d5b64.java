import java.util.*;

public class Solution{

  public void print2(int r,int s){
    int k,times;
    k = s*r-r-1;
    times = 0;
    while (times < s-1){
      System.out.println(r + " " + k);
      k --;
      times ++;
    }
  }

  public Solution(int c, int r, int s){
    int k,times;
    System.out.println("Case #" + c + ": " + (s-1)*(r-1));
    for (int i = r; i >= 2; i --){
      print2(i,s);
    }
  }

  public static void main(String args[]){
    Scanner sc1 = new Scanner(System.in);
    int cases = sc1.nextInt();
    for (int c = 1; c < cases+1; c ++){
      int r = sc1.nextInt();
      int s = sc1.nextInt();
      Solution b = new Solution(c,r,s);
    }
  }
}
