import java.util.*;

public class Solution {
  public static void solve(int x,int y,String path,int ks) {
    int time = 0;
    int distance = x+y;
    
    for(int i=0; i<path.length(); i++){
        if(path.charAt(i) == 'N'){
            y += 1;
        } else if(path.charAt(i) == 'E'){
            x += 1;
        } else if(path.charAt(i) == 'W'){
            x -= 1;
        } else if(path.charAt(i) == 'S'){
            y -= 1;
        }
        time++;
        distance = Math.abs(x) + Math.abs(y);
        if(distance <= time){
            System.out.println("Case #"+ks+": "+time);
            return;
        }
    }
    System.out.println("Case #"+ks+": "+"IMPOSSIBLE");
  }
    
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      int x = input.nextInt();
      int y = input.nextInt();
      String path = input.nextLine().trim();
      solve(x,y,path,ks);
    }
  }
}
