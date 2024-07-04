import java.util.Scanner;
import java.io.*;

public class Solution {
  
  public static void main(String[] args) {
    try {
    Scanner in =  new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    FileWriter f = new FileWriter(args[0]);
    BufferedWriter b = new BufferedWriter(f);
    PrintWriter p = new PrintWriter(b);
    
    int cases = in.nextInt();
    for (int i=0; i<cases; i++) {
        int num = in.nextInt();
        
        int[] s = new int[num];
        int[] e = new int[num];
        
        int si = 0;
        int ei = 0;
        
        for (int j=0; j<num*2; j++) {
            int n = in.nextInt();
            if (j%2==0) {
              s[si] = n;
              si++;
            } else {
              e[ei] = n;
              ei++;
            }
        }
        String ans = evaluate(s, e, i);
        System.out.println(ans);
        p.println(ans);
    }
    p.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  private static String evaluate(int[] start, int[] end, int no) {
    String r = "Case #";
    r+= (no+1) + ": ";
    
    r+= "C";
    
    for (int i = 0; i < end.length; i++) {
      int s = start[i];
      int e = end[i];
      int intersection = 0;
      for (int j = 0; j < end.length; j++) {
        if (i==j)
          break;
        
        int s1 = start[j];
        int e1 = end[j];
        
        if (s >= s1 && e <= e1)
          intersection++;
        
        if (s1 >= e) {
          r += "C";
          break;
        } else {
          if (s >= e1) {
            r += "C";
            break;
          } else {
            if (intersection > 0) {
              return "Case #" + no + ": " + "IMPOSSIBLE";
            }
            r += "J";
            break;
          }
        }
      }
    }
    
    return r;
  }
  
}
