import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    int t = scnr.nextInt(); 
 
    for (int i = 0; i < t; i++) {
      ArrayList<int[]> C = new ArrayList<int[]>();
      ArrayList<int[]> J = new ArrayList<int[]>();

      int n = scnr.nextInt();
      int s = -1;
      int e = -1;
 
      String status = "";
      
      label: for (int j = 0; j < n; ++j) {
        s = scnr.nextInt();
        e = scnr.nextInt();
        
        if(C.size() == 0) {
          C.add(new int[] {s, e});
          status = status.concat("C");
          continue;
        }
        for (int[] times: C) {
          if((s >= times[1]) ||  (e <= times[0])) {
            C.add(new int[]{s, e});
            status = status.concat("C");
            continue label;
          }
        }
       
        if(J.size() == 0) {
          J.add(new int[] {s, e});
          status = status.concat("J");
          continue;
        }
        for (int[] times: J) {
           if((s >= times[1]) ||  (e <= times[0])) {
             J.add(new int[]{s, e});
             status = status.concat("J");
             continue label;
           }
        }
       status = "IMPOSSIBLE";
       break;
      }
    System.out.println("Case #" + (i + 1) + ": " + status);
    }
  }
}


