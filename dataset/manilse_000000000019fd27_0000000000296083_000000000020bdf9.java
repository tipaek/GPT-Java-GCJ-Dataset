import java.util.*;  

public class Solution {
  public static void solve(int[][] e,int ks) {
    int n = e.length, c = e[0][1], j = 0;
    String res = "C";
    String out = "";
    for(int i=1; i < n; i++){
        char temp;
        if(e[i][0] >= c){
            temp = 'C';
            c = e[i][1];
        } else if(e[i][0] >= j) {
            temp = 'J';
            j = e[i][1];
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
