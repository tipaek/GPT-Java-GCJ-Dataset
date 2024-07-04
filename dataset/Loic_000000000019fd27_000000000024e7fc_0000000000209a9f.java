import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        //int h = Integer.parseInt(args[0]);
        //System.out.println(h);
          Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int h = in.nextInt();
        System.out.println(t);
        for (int i = 1; i < h ; i++) {
             boolean parO = false;
             String p = "Case #"+i+": ";
             String line = in.nextLine();
            for (int j = 0; j < line.length(); j++) {
                String cc = line.charAt(j) +"";
                if (!parO) {
                    if ( "1".equals(cc)) {
                        parO = true;
                        p += "(1";
                    } else {
                        p += cc;
                    }
                } else {
                    if ( "1".equals(cc)) {
                        p += "1";
                    } else {
                        p += ")"+cc;
                        parO = false;
                    }
                }
            }
            if(parO){
                p+=")";
            }
            System.out.println(p);

        }
        
    }

}

