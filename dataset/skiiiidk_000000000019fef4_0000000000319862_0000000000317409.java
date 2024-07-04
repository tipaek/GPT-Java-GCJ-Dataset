import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        //log.write() //log.flush()
        int t = scan.nextInt();
        int count = 1;
        while(t-- >0){
            int sx = scan.nextInt();
            int sy = scan.nextInt();
            String seq = scan.next();
            String result = "IMPOSSIBLE";
            if(sx == 0 && sy == 0){
                result = "0";
            }
            else {
                for (int i = 0; i < seq.length(); i++) {
                    if (seq.charAt(i) == 'N') {
                        sy++;
                    }
                    ;
                    if (seq.charAt(i) == 'S') {
                        sy--;
                    }
                    ;
                    if (seq.charAt(i) == 'E') {
                        sx++;
                    }
                    ;
                    if (seq.charAt(i) == 'W') {
                        sx--;
                    }
                    ;

                    if (Math.abs(sx) + Math.abs(sy) <= i + 1) {
                        result = "" + (i + 1);
                        break;
                    }
                }
            }

            log.write("Case #" + (count) + ": " + result + "\n");
            //System.out.println(colRep);
            count++;
        }
        log.flush();





    }
}