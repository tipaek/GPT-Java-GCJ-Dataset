import java.util.*;

public class Solution{

  public Solution(int c, int r, int s){
    int k,times;
    if (r == 2){
      System.out.println("Case #" + c + ": " + (s-1));
      k = s*2-3;
      times = 0;
      while (times < s-1){
        System.out.println("2 " + k);
        k --;
        times ++;
      }
    }else if (r == 3){
      System.out.println("Case #" + c + ": " + (s*2-2));
      k = s*3-4;
      times = 0;
      while (times < s-1){
        System.out.println("3 " + k);
        k --;
        times ++;
      }
      times = 0;
      k = s*2-3;
      while (times < s-1){
        System.out.println("2 " + k);
        k --;
        times ++;
      }
    }else if (r == 4){
      if (s == 2){
        System.out.println("Case #" + c + ": " + 3);
        System.out.println("4 3");
        System.out.println("3 2");
        System.out.println("2 1");
      }else if (s == 3){
        System.out.println("Case #" + c + ": " + 6);
        System.out.println("4 7");
        System.out.println("4 6");
        System.out.println("3 5");
        System.out.println("3 4");
        System.out.println("2 3");
        System.out.println("2 2");
      }
    }else{
      System.out.println("Case #" + c + ": " + 4);
      System.out.println("5 4");
      System.out.println("4 3");
      System.out.println("3 2");
      System.out.println("2 1");
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
