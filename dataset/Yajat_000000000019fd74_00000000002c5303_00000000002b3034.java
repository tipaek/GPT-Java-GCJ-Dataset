import java.util.Scanner;
import java.io.*;

public class Solution {
  
  public static void main(String[] args) {
    try {
    Scanner in =  new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    
    int testCases = in.nextInt();
    String[] ans = new String[2];
    for (int i=0; i<testCases; i++) {
      ans[i] = "*";
      int patterns = in.nextInt();
      
      String [] cases = new String[patterns];
      for (int j=0; j<patterns; j++) {
        cases[j] = in.next();
      }
        
      for (int j=0; j<patterns; j++) {
            String n = cases[j];
            
            int rep = -1;
            for (int k=0; k<patterns; k++) {
              if (j==k) continue;
              String n1 = cases[k];
              
              if (test1(cases)) { 
                String a = n.substring(1);
                String b = n1.substring(1);
                if(a.length() > ans[i].length() || b.length() > ans[i].length()) {   
                  if (a.contains(b) || b.contains(a)) {
                    rep = a.contains(b) ? 0 : 1;
                    
                  } else
                    break;
                 
                  if (k==patterns-1 && rep>-1) {
                    if (rep == 0)
                      ans[i] = a;
                    else 
                      ans[i] = b;
                  }
                }
              }
              
              if (k==patterns-1)
                rep = -1;
            }
            
            if (test1(cases) && !confirm1(ans[i],cases))
                  ans[i] = "*";
      }
    System.out.println("Case #" + (i+1) + ": " + ans[i]);
      
    }

    } catch (Exception e) {
      e.printStackTrace();
    }
}

  private static boolean test1 (String[] s) {
    boolean res = false;
    for (String x:s) {
      if (asterisks(x) == 1 && aPos(x) == 0)
        res = true;
      else
        res = false;
    }
    return res;
  }
  
  private static boolean confirm1(String a, String[] s) {
    if (a.equals("*")) return true;
    boolean res = false;
    for (String x:s) {
      if (a.contains(x.substring(1))) {
        String a1 = x.substring(1);
        String a2 = a.substring(a.length() -a1.length(),a.length());
        if (a1.equals(a2))
          res = true;
        else
          return false;
      } else
        return false;
    }
    return res;
  }
  
  private static int aPos(String n) {
     for (int c=0; c<n.length(); c++) {
       char ch = n.charAt(c);
       return c;
     }
     return -1;
  }
  
  private static int asterisks(String s) {
    int a = 0;
    for (int c=0; c<s.length(); c++) {
      char ch = s.charAt(c);
      if (ch == '*') 
        a++;
    }
    return a;
  }
  
}
