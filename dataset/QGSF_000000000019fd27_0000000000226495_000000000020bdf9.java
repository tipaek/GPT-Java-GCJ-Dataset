import java.io.*;
import java.util.*;

public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int tcase = 1; tcase <= t; tcase++) {
          
            boolean impossible = false;
            
            int nlines = in.nextInt();
            int[] ctimes = new int[1441], jtimes = new int[1441];
            
            for(int line = 1; line <= nlines && !impossible; line++){
                int start = in.nextInt();
                int end = in.nextInt();
                
                boolean ccan = true;
                for(int i = start; i < end; i++){
                    if(ctimes[i] != 0){
                        ccan = false;
                        break;
                    }
                }
                
                if(ccan){
                    for(int i = start; i < end; i++){ 
                        ctimes[i] = line;
                    }
                    continue;
                }
                
                boolean jcan = true;
                for(int i = start; i < end; i++){ 
                    if(jtimes[i] != 0){
                        System.out.println("Case #" + tcase + ": " + "IMPOSSIBLE");
                        impossible = true;
                        break;
                    }
                }
                
                for(int i = start; i < end; i++){ 
                    jtimes[i] = line;
                }
            }
            
            if(impossible) continue;
            //output
            System.out.print("Case #" + tcase + ": ");
            
            boolean[] jwork = new boolean[nlines + 1];
            for(int i = 0; i <= 1440; i++){
                jwork[ctimes[i]] = true;
            }
           
            for(int i = 1; i <= nlines; i++){
                if(!jwork[i]) System.out.print("C");
                else System.out.print("J");
            }
            System.out.println("");
        }
    }
    
}
