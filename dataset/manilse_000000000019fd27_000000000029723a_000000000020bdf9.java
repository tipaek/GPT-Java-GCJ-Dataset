import java.util.*;  

public class Solution {
  public static void solve(int[][] e,int ks) {
    int n = e.length, cmin = 0, cmax= 0, jmin = 0, jmax = 0;
    String res = "";
    String out = "";
    for(int i=0; i < n; i++){
        char temp;
        int s = e[i][0];
        int f = e[i][1];
        if(s <= cmin || cmax <= s){
            temp = 'C';
            cmin = s;
            cmax = f;
        } else if(s <= jmin || jmax <= s) {
            temp = 'J';
            jmin = s;
            jmax = f;
        } else {
            System.out.println("Case #"+ks+": "+"IMPOSSIBLE");
            return;
        }
        res += temp;
    }
    for(int i=0; i <n; i++){
        out += res.charAt(e[i][2]);
    }

    System.out.println("Case #"+ks+": "+out);
  }

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      int n = input.nextInt();
      int[][] time = new int[n][3];
      for(int i=0; i < n; i++){
        time[i][0] = input.nextInt();
        time[i][1] = input.nextInt();
        time[i][2] = i;
      }
      Arrays.sort(time,(a,b)->{
                return a[0] - b[0];
        });
      solve(time, ks);
    }
  }
}
