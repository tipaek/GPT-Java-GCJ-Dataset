/**
 * @author Finn Lidbetter
 */
import java.util.*;
import java.io.*;
import java.awt.geom.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
  
    int nTests = Integer.parseInt(br.readLine());
    for (int test=0; test<nTests; test++) {
      String s = br.readLine();
      int n = s.length();
      int[] arr = new int[n];
      for (int i=0; i<n; i++) {
        arr[i] = s.charAt(i)-'0';
      }
      StringBuilder testAns = new StringBuilder();
      int res = 0;
      for (int i=0; i<n; i++) {
        if (arr[i]>res) {
          for (int j=0; j<arr[i]-res; j++) {
            testAns.append('(');
          }
        } else if (arr[i]<res) {
          for (int j=0; j<res-arr[i]; j++) {
            testAns.append(')');
          }
        }
        testAns.append(arr[i]);
        res = arr[i];
      }
      for (int i=0; i<res; i++) {
        testAns.append(')');
      }
      sb.append(String.format("Case #%d: %s\n", test+1, testAns.toString()));
    }
    System.out.print(sb);
  }
}
