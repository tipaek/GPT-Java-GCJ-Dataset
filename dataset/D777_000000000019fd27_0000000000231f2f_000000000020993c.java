import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    String T = in.nextLine(); 
    int t = Integer.parseInt(T);
    
    for (int i = 1; i <= t; ++i) {
      String N = in.nextLine();
            int sizeP = Integer.parseInt(N);
            
            String inp[] = new String[sizeP]; 
            
            String rm[] = new String[sizeP];
            
            int mm[][] = new int[sizeP][sizeP];
            
            int dupR = 0;
            int dupC = 0;
            int kr = 0;
        
            
            for (int r = 0 ; r < sizeP; r++){
                inp[r] = in.nextLine();
                
                rm = inp[r].split(" ");
                
                for (int c=0; c < sizeP; c++){
                    mm[r][c] = Integer.parseInt(rm[c]);
                }
            }

            for (int tr=0; tr < sizeP; tr++){
                kr += mm[tr][tr];
            }

            for (int rc=0; rc < sizeP; rc++){
                
                for (int cc=0; cc < sizeP; cc++){
                    for (int rr= cc + 1; rr < sizeP; rr++){
                        if (mm[rc][cc] == mm[rc][rr]){
                            dupR += 1;
                            break;
                        }
                    }
                }
            }

            for (int cr=0; cr < sizeP; cr++){
                
                for (int ll=0; ll < sizeP; ll++){
                    for (int bb = ll + 1; bb < sizeP; bb++){
                        if (mm[ll][cr] == mm[bb][cr]){
                            dupC += 1;
                            break;
                        }
                    }
                }
            }
      

      System.out.println("Case #" + i + ": " + kr + " " + dupR + " " + dupC);
    }
  }
}