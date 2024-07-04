import java.io.*;
import java.util.*;
class Solution {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    int cases = 1;
    while(t-->0) {
      int n = scan.nextInt();
      HashMap<HashMap<Integer, Integer>, String> h1 = new HashMap<HashMap<Integer, Integer>, String>();
      boolean imp = false;
      int [][] arr = new int[n][2];
      int org [][] = new int[n][2];
      for(int i = 0; i<n; i++) {
        int s = scan.nextInt();
        int e = scan.nextInt();
        arr[i][0] = s;
        arr[i][1] = e;
        org[i][0] = s;
        org[i][1] = e;
      }
      Arrays.sort(arr, (a, b) -> Double.compare(a[0], b[0]));
      int camEnd = -1;
      int jamieEnd = -1;
      for(int i = 0; i<n; i++) {
        if(arr[i][0] < camEnd && arr[i][0] < jamieEnd) {
          imp = true;
          break;
        }
        else if(arr[i][0] >= camEnd) {
          HashMap<Integer, Integer> k = new HashMap<Integer, Integer>();
          k.put(arr[i][0], arr[i][1]);
          h1.put(k, "C");
          camEnd = arr[i][1];
        }
        else {
          HashMap<Integer, Integer> k = new HashMap<Integer, Integer>();
          k.put(arr[i][0], arr[i][1]);
          h1.put(k, "J");
          jamieEnd = arr[i][1];
        }
      }
      if(imp) {
        System.out.println("Case #" + cases + ": " + "IMPOSSIBLE");
      }
      else {
        String res = "";
        for(int i = 0; i<n; i++) {
          HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
          h.put(org[i][0], org[i][1]);
          res += h1.get(h);
        }
        System.out.println("Case #" + cases + ": " + res);
      }
      cases++;
    }
  }
}