import java.io.*;
import java.util.*;

/**
 *
 * @author QGSF
 */
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
            
            //output
            System.out.print("Case #" + tcase + ": ");
            
//            for(int i = 0; i < 50; i++) System.out.print(ctimes[i] + " ");
//            System.out.println("");
//            for(int i = 0; i < 50; i++) System.out.print(jtimes[i] + " ");
//            System.out.println("");
            
            int at1 = 1, at2 = 1, find = 1;
            
            while(ctimes[at1] == 0) at1++;
            while(jtimes[at2] == 0) at2++;
            
            while(find <= nlines){ 
                if(at1 <= 1440 && ctimes[at1] == find){
                    System.out.print("C");
                    while(at1 <= 1440 && (ctimes[at1] == find || ctimes[at1] == 0) ) at1++;
                    find++;
                }
                if(at2 <= 1440 && jtimes[at2] == find){
                    System.out.print("J");
                    while(at2 <= 1440 && (jtimes[at2] == find || jtimes[at2] == 0) ) at2++;
                    find++;
                }
            }
            
            System.out.println("");
        }
    }
    
}
