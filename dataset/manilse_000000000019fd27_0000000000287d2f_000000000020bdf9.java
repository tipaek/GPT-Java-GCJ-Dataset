import java.util.*;  

public class Solution {
  public static void solve(int[] s, int[] e, int ks) {
    int n = s.length, c = 0, j = 0;
    String res = "C";
    char[] assigned = new char[n];
    assigned[0] = 'C';
    for(int i=1; i < n; i++){
        if(s[i] >= e[i-1]){
            assigned[i] = assigned[i-1];
            res += assigned[i-1];
            if(assigned[i] == 'C'){
                c = e[i];
            } else {
                j = e[i];
            }
        } else if(assigned[i] == 'C' && s[i] >= c){
            assigned[i] = 'C';
        } else if(assigned[i] == 'J' && s[i] >= j){
            assigned[i] = 'J';
        } else {
    System.out.println("Case #"+ks+": "+"IMPOSSIBLE");
    return;
        }
    }
     
System.out.println("Case #"+ks+": "+res);
  }

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      int n = input.nextInt();
      int[] start = new int[n];
      int[] end = new int[n];
      for(int i=0; i < n; i++){
        start[i] = input.nextInt();
        end[i] = input.nextInt();
      }
      Arrays.sort(start);
      Arrays.sort(end);
      solve(start, end, ks);
    }
  }
}
