import java.io.*;
import java.util.*;
class Solution {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    int cases = 1;
    while(t-->0) {
      int n = scan.nextInt();
      HashMap<HashMap<Integer, Integer>, Character> h1 = new HashMap<HashMap<Integer, Integer>, Character>();
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
      int start = -1;
      int end = -1;
 o:     for(int i = 0; i<n; i++) {
        if(i == 0) {
          HashMap<Integer, Integer> key = new HashMap<Integer, Integer>();
          key.put(arr[i][0], arr[i][1]);
          h1.put(key, 'C');
          start = arr[i][0];
          end = arr[i][1];
        }
        else {
          for(int j = 1; j<n; j++) {
            if(arr[j][0] >= end || arr[j][1] <= start) {
              HashMap<Integer, Integer> key = new HashMap<Integer, Integer>();
              key.put(arr[j][0], arr[j][1]);
              h1.put(key, 'C');
              start = arr[j][0];
              end = arr[j][1];
            }
            if(j == n-1) {
              break o;
            }
          }
        }
      }
      boolean once = true;
      start = -1;
      end = -1;
      for(int i = 0; i<n; i++) {
        HashMap<Integer, Integer> key = new HashMap<Integer, Integer>();
        key.put(arr[i][0], arr[i][1]);
        if(h1.containsKey(key)) {
          continue;
        }
        else {
          if(once) {
            HashMap<Integer, Integer> k = new HashMap<Integer, Integer>();
            k.put(arr[i][0], arr[i][1]);
            h1.put(k, 'J');
            start = arr[i][0];
            end = arr[i][1];
            once = false;
          }
          else {
            if(arr[i][0] >= end || arr[i][1] <= start) {
              HashMap<Integer, Integer> k = new HashMap<Integer, Integer>();
              k.put(arr[i][0], arr[i][1]);
              h1.put(k, 'J');
              start = arr[i][0];
              end = arr[i][1];
            }
            else {
              imp = true;
            }
          }
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