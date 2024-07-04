import java.util.*;

public class Solution{

  String s;
  int x; //E
  int y; //N

  public Solution(int x, int y){
    this.x = x;
    this.y = y;
    s = "";
  }

  public int mod(int a, int b){
    if (a < 0) return (b - (-a) % b) % b;
    return a % b;
  }

  public void calculate(){
    if (x == 0 && y == 0) return;
    if (x == 0){
      if (y == 1){
        s += "N";
        return;
      }else if (y == -1){
        s += "S";
        return;
      }
    }else if (y == 0){
      if (x == 1){
        s += "E";
        return;
      }else if (x == -1){
        s += "W";
        return;
      }
    }
    if (mod(y,2) == 1 && mod(x,2) == 0){
      //Must be N or S
      if (mod(x,4) == 0){
        if (mod(y,4) == 1){
          s += "S";
          y ++;
          x = x/2;
          y = y/2;
          calculate();
        }else{
          s += "N";
          y --;
          x = x/2;
          y = y/2;
          calculate();
        }
      }else{
        if (mod(y,4) == 1){
          s += "N";
          y --;
          x = x/2;
          y = y/2;
          calculate();
        }else{
          s += "S";
          y ++;
          x = x/2;
          y = y/2;
          calculate();
        }
      }
    }else if (mod(x,2) == 1 && mod(y,2) == 0){
      if (mod(y,4) == 0){
        if (mod(x,4) == 1){
          s += "W";
          x ++;
          x = x/2;
          y = y/2;
          calculate();
        }else{
          s += "E";
          x --;
          x = x/2;
          y = y/2;
          calculate();
        }
      }else{
        if (mod(x,4) == 1){
          s += "E";
          x --;
          x = x/2;
          y = y/2;
          calculate();
        }else{
          s += "W";
          x ++;
          x = x/2;
          y = y/2;
          calculate();
        }
      }
    }else{
      s = "IMPOSSIBLE";
      return;
    }
  }

  public static void main(String args[]){
    Scanner sc1 = new Scanner(System.in);
    int cases = sc1.nextInt();
    for (int c = 1; c < cases+1; c ++){
      int x = sc1.nextInt();
      int y = sc1.nextInt();
      Solution b = new Solution(x,y);
      b.calculate();
      System.out.println("Case #" + c + ": " + b.s);
    }
  }
}
