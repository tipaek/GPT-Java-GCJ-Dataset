import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Bohdan
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= test; ++t) {
            int x = in.nextInt();
            int y = in.nextInt();
            int[] path = new int[20];
            String result = "IMPOSSIBLE";
            String dir = "NWSE";
            int pathlen = 0;
            boolean hit = false;
            for (int i = 0; i<100000; i++){
                int k = i;
                int len = 0;
                while (k>0){
                    path[len] = k%4;
                    len++;
                    k = k/4;
                }
               
                int testx = 0;
                int testy = 0;
                int jump = 1;
                for (int j = 0; j<len; j++){
                    if (path[j] == 0){
                        testy+=jump;
                    }
                    if (path[j] == 1){
                        testx-=jump;
                    }
                    if (path[j] == 2){
                        testy-=jump;
                    }
                    if (path[j] == 3){
                        testx+=jump;
                    }
                    if ((testx == x)&&(testy == y)){
                        hit = true;
                        pathlen = j;
                        break;
                    }
                    jump = jump*2;
                    
                }
                if (hit){
                    char[] resultC = new char[pathlen+1];
                    for (int j = 0; j<pathlen+1; j++){
                        resultC[j] = dir.charAt(path[j]); 
                    }
                    result = new String(resultC);
                    break;
                }
            }
            
            if (hit){
                System.out.println("Case #" + t + ": " + result);
            }
            else{
                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
            }
        } 
        
        
    }
    
}
