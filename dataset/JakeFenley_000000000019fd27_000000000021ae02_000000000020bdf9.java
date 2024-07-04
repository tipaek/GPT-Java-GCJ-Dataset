import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    int t = scnr.nextInt(); 
 
    for (int i = 0; i < t; i++) {
      
//      ArrayList<int[]> C = new ArrayList<int[]>();
//      ArrayList<int[]> J = new ArrayList<int[]>();
      int Cend = -1;
      int Jend = -1;

      int n = scnr.nextInt();
      int s = -1;
      int e = -1;
 
      String status = "";
      
      int[][] times = new int[n][2];

      for (int j = 0; j < n; ++j) {
        s = scnr.nextInt();
        e = scnr.nextInt();
        
        times[j] = new int[] {s, e};
      }
      
      java.util.Arrays.sort(times, java.util.Comparator.<int[]>comparingInt(a -> a[0]).thenComparingInt(a -> a[1]));

      for (int j = 0; j < n; ++j) {
        if (Cend == -1) {
          Cend = times[j][1];
          status = status.concat("C");
        } else if (Jend == -1) {
          Jend = times[j][1];
          status = status.concat("J");
        } else if (times[j][0] < Cend && times[j][0] < Jend) {
          status = "IMPOSSIBLE";
          break;
        } else if (times[j][0] < Cend) {
          Jend = times[j][1];
          status = status.concat("J");
        } else {
          Cend = times[j][1];
          status = status.concat("C");

        }
      }
      
      System.out.println("Case #" + (i + 1) + ": " + status);
      }
    }
  }
        
//        if(C.size() == 0) {
//          C.add(new int[] {s, e});
//          status = status.concat("C");
//          continue;
//        }
//        
//        for (int[] times: C) {
//          if((s >= times[1]) ||  (e <= times[0])) {
//            C.add(new int[]{s, e});
//            status = status.concat("C");
//            continue label;
//          }
//        }
//       
//        if(J.size() == 0) {
//          J.add(new int[] {s, e});
//          status = status.concat("J");
//          continue;
//        }
//        for (int[] times: J) {
//           if((s >= times[1]) ||  (e <= times[0])) {
//             J.add(new int[]{s, e});
//             status = status.concat("J");
//             continue label;
//           }
//        }
//       status = "IMPOSSIBLE";
//       break;
//      }
//    System.out.println("Case #" + (i + 1) + ": " + status);
//    }
//  }
//}


