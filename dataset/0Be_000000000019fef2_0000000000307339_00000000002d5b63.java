import java.util.*;
import java.io.*;

class Solution {

  public static void main(String[] args) throws Exception {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);

    String[] input = in.readLine().split("\\s+");
    int TT = Integer.parseInt(input[0]);
    int A = Integer.parseInt(input[1]);
    int B = Integer.parseInt(input[2]);
    int currTT = 0;
    int step = (1000000000 - A) / 2;

    while (currTT++ < TT) {
      int iStep = step;
      int jStep = step;
      
      boolean solved = false;
      int i = 0, j = 0, tries = 0;
      while (tries++ < 300 && !solved) {
        out.println(i + " " + j);
        out.flush();
        String ans = in.readLine();
        
        if (ans.equals("CENTER")) {
            break;
        }
        
        if (ans.equals("MISS")) {
            out.println((i + step) + " " + (j + step));
            out.flush();
            
            ans = in.readLine();
            if (!ans.equals("MISS")) {
                i += step;
                j += step;
            }
            tries++;
        }
        
        if (ans.equals("MISS")) {
            out.println((i + step) + " " + (j - step));
            out.flush();
            
            ans = in.readLine();
            if (!ans.equals("MISS")) {
                i += step;
                j -= step;
                jStep = -step;
            }
            tries++;
        }
        
        if (ans.equals("MISS")) {
            out.println((i - step) + " " + (j + step));
            out.flush();
            
            ans = in.readLine();
            if (!ans.equals("MISS")) {
                i -= step;
                j += step;
                iStep = -step;
            }
            tries++;
        }
        
        if (ans.equals("MISS")) {
            out.println((i - step) + " " + (j - step));
            out.flush();
            
            ans = in.readLine();
            if (!ans.equals("MISS")) {
                i -= step;
                j -= step;
                iStep = -step;
                jStep = -step;
            }
            tries++;
        }
        
        solved = ans.equals("CENTER");
        iStep /= 2;
        jStep /= 2;
        i += iStep;
        j += jStep;
      }
    }

    out.print(output);

    in.close();
    out.close();
  }

}