import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int d = in.nextInt();
      long[] arr = new long[n];
      Set<Long> set = new HashSet<>();
      for(int j=0;j<n;j++) {
        arr[j]=in.nextLong();
        set.add(arr[j]);
      }
      int cut=n-(set.size()+d)+1;
      if(cut!=0){
        Arrays.sort(arr);
        for(int j=1;j<n;j++){
          for(int k=0;k<n;k++){
            if(arr[j]==2*arr[k]){
              cut=1;
              break;
            }
          }
        }
        if(cut<0)
          cut=2;
      }
      System.out.println("Case #" + i + ": " + cut);
    }
  }
}