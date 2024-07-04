import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    // cases = Integer.parseInt(in.nextLine());
    int cases = in.nextInt();

    for (int c = 1; c <= cases; c++) {
      out.println("Case #" + c + ": ");

      int n = in.nextInt();
      Position pos = new Position(1,1);
      if (n < 30){
        for (; n > 0; n--,pos.nextRow()) {
          out.println(pos);
        }
      } else {
        n -=30;
        int extras = 0;
        for (int i = 0; i < 30; i++, n = n>>1) {
          if((n&1)==1 ){
            extras++;
            if(pos.y==1){
              for (; pos.y < pos.x ; pos.y++) {
                out.println(pos);
              }
            } else if(pos.y==pos.x){
              for (; pos.y > 1 ; pos.y--) {
                out.println(pos);
              }
            }
          }
          out.println(pos);
          pos.nextRow();
        }
        for (int i = 0; i < extras; i++) {
          out.println(pos);
          pos.nextRow();
        }
      }
    }

    in.close();
    out.close();
  }

  static class Position{
    int x,y;
    Position(int x,int y){
      this.x = x;
      this.y = y;
    }

    //
    public void nextRow(){
      if(y==1) x++;
      else if(x==y) { x++; y++;}
      else System.exit(1);
    }

    @Override
    public String toString() {
      return  x+" "+y;
    }
  }
}