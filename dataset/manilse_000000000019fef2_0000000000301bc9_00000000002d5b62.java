import java.util.*;

public class Solution {
  public static void solve(int x,int y, int ks) {
    int sum = 1;
    int i = 0;
    int pow = 1;
    int[] powers = new int[31];
    powers[0] = 1;
    int dist = Math.abs(x)+Math.abs(y);
    if(dist % 2 == 0){
        System.out.println("Case #"+ks+": "+"IMPOSSIBLE");
        return;
    }
    while(sum < dist){
        pow *= 2;
        sum += pow;
        i++;
        powers[i] = pow;
    }
    StringBuilder sb = new StringBuilder();
    while(i > -1){
        if(Math.abs(x) >= Math.abs(y)){
            if(Math.abs(x+powers[i]) < Math.abs(x-powers[i])){
                x = x+powers[i];
                sb.insert(0,"W");
            } else {
                x = x-powers[i];
                sb.insert(0,"E");
            }
        } else {
            if(Math.abs(y+powers[i]) < Math.abs(y-powers[i])){
                y = y+powers[i];
                sb.insert(0,"S");
            } else {
                y = y-powers[i];
                sb.insert(0,"N");
            }          
        }
        i--;
    }
    System.out.println("Case #"+ks+": "+sb.toString());
  }
    
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      int x = input.nextInt();
      int y = input.nextInt();
      solve(x,y,ks);
    }
  }
}
