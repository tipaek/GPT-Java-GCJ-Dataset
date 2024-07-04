import java.util.Scanner;
class Solution{
  public static int[] arrayify(int x, int y, String s){
    Position p = new Position(x,y);
    int length = s.length();
    int[] res = new int[length + 1];
    res[0] = p.dist;
    for(int i = 1;i < length + 1;i++){
      p.move(s.charAt(i - 1));
      res[i] = p.dist;
    }
    return res;
  }
  static String sol(int[] arr){
    int size = arr.length;
    for(int i = 0;i < size;i++){
      if(arr[i] <= i){
    
          return String.valueOf(i);
    
      }
    }
    return "IMPOSSIBLE";
  }
  public static void main(String[] arg){
    Scanner in = new Scanner(System.in);
    int testCase = in.nextInt();
    int x;
    int y;
    String s;
    for(int i = 0;i < testCase;i++){
      x = in.nextInt();
      y = in.nextInt();
      s = in.next();
      System.out.println("Case #" + (i + 1) +": " + sol(arrayify(x,y,s)));
    
    
    }
  in.close();
  }

}
class Position{
public int x;
public int y;
public int dist;
Position(int ix,int iy){
  x = ix;
  y = iy;
  dist = x + y;
}
void move(char s){
  if(s == 'N'){
    y++;
    dist = Math.abs(x) + Math.abs(y);
  }else if(s == 'S'){
  y--;
    dist = Math.abs(x) + Math.abs(y);
  }else if(s == 'E'){
    x++;
     dist = Math.abs(x) + Math.abs(y);
  }else if(s == 'W'){
    x--;
    dist = Math.abs(x) + Math.abs(y);
  }
}

}