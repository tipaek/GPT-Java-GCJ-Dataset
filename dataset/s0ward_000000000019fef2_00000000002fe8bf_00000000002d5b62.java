import java.util.*;
import java.lang.Math;

class Solution{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(int i=1; i<=t; i++){
      int X = in.nextInt();
      int Y = in.nextInt();
      System.out.println("Case #"+i+": "+solve(X,Y));
    }
  }

    private static String solve(int X, int Y){
      if((X%2+Y%2)%2 == 0) return "IMPOSSIBLE";
      else{
        String res = "";
        int highestPowerOfTwo=log2(Math.abs(X)+Math.abs(Y));
        while(X!=0 || Y!=0){
          int powerOfTwo = (int) Math.pow(2,highestPowerOfTwo);
          if(Math.abs(X) > Math.abs(Y)){
            if(X<0){
              X += powerOfTwo;
              res += "W";
            }
            else{
              X -= powerOfTwo;
              res += "E";
            }
          }
          else{
            if(Y<0){
              Y += powerOfTwo;
              res += "S";
            }
            else{
              Y -= powerOfTwo;
              res += "N";
            }
          }
          highestPowerOfTwo -= 1;
          // System.out.println(highestPowerOfTwo);
        }
        return new StringBuilder(res).reverse().toString();
      }
    }

    private static int log2(int N){
      int result = (int)(Math.log(N) / Math.log(2));
      return result;
    }
}
