// https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd74/00000000002b3034
// TIME - 

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(buf.readLine());

        for(int test = 1; test <= t; test++ ) {

            int n = Integer.parseInt(buf.readLine());
            String common = "", s = "";
            int lenS = -1, lenCommon = -1;

            for(int i = 0; i < n; i++) {
                System.out.println("common - " + common);
                s = buf.readLine();
                lenS = s.length();
                if(i != 0) {
                    if(lenS > lenCommon + 1) { // COMMON SHORTER
                        System.out.println("comparing - " + s.substring(lenS - lenCommon, lenS) + " v/s " + common);
                        if(!s.substring(lenS - lenCommon, lenS).equals(common)) { // MISMATCH
                            common = "*";
                            break;
                        }
                        else { // MATCH
                            common = s.substring(1, lenS);
                            lenCommon = common.length();
                        }
                    }
                    else { // COMMON LONGER
                        System.out.println("comparing - " + common.substring(lenCommon - lenS, lenCommon) + " v/s " + s.substring(1, lenS));
                        if(!common.substring(lenCommon + 1 - lenS, lenCommon).equals(s.substring(1, lenS))) { // MISMATCH
                            common = "*";
                            break;
                        }
                    }
                }
                else {
                    common = s.substring(1, s.length());
                    lenCommon = common.length();
                }
            }
           
            System.out.println("Case #" + test + ": " + common);
        }
    }
}