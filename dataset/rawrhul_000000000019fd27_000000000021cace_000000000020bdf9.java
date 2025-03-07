import java.util.*;
class Solution {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    int cases = 1;
    while(t-->0) {
      int n = scan.nextInt();
      int arr [][] = new int[n][2];
      String res = "";
      for(int i = 0; i<n; i++) {
        for(int j = 0; j<2; j++) {
          arr[i][j] = scan.nextInt();
        }
      }
      ArrayList<Integer> camStart = new ArrayList<Integer>();
      ArrayList<Integer> jamieStart = new ArrayList<Integer>();
      ArrayList<Integer> camEnd = new ArrayList<Integer>();
      ArrayList<Integer> jamieEnd = new ArrayList<Integer>();
      boolean imp = false;
 o:   for(int i = 0; i<n; i++) {
          if(i == 0) {
            res += 'C';
            camStart.add(arr[i][0]);
            camEnd.add(arr[i][1]);
            continue o;
          }
          else {
            if(arr[i][0] >= Collections.max(camEnd) || arr[i][1] <= Collections.min(camStart)) {
              res += 'C';
              camStart.add(arr[i][0]);
              camEnd.add(arr[i][1]);
              continue o;
            }
            else if(jamieEnd.size() == 0 || arr[i][0] >= Collections.max(jamieEnd) || arr[i][1] <= Collections.min(jamieStart)) {
              res += 'J';
              jamieStart.add(arr[i][0]);
              jamieEnd.add(arr[i][1]);
              continue o;
            }
            else {
              imp = true;
              continue o;
            }
          }
      }
      if(!imp) {
        System.out.println("Case #" + cases + ": " + res);
      }
      else {
        System.out.println("Case #" + cases + ": " + "IMPOSSIBLE");
      }
      cases++;
    }
  }
}