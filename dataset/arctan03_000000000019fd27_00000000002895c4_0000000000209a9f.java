import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(f.readLine());

        for(int t = 1; t <= T; t++){

            String s = f.readLine();
            int len = s.length();

            StringBuilder sprime = new StringBuilder();
            int cval = 0;
            for(int i = 0; i < len; i++){

                int x = Integer.parseInt(s.substring(i, i+1));
                if (x > cval){
                    sprime.append(openpar(x-cval));
                    cval = x;
                } else if (x < cval){
                    sprime.append(closepar(cval-x));
                    cval = x;
                }
                sprime.append(x);

                if(i == len-1){
                    sprime.append(closepar(cval));
                }
            }

            System.out.println("Case #" + t + ": " + sprime.toString());

        }
    }

    private static String openpar(int x){
        StringBuilder sb = new StringBuilder();
        while(x > 0){
            sb.append("(");
            x--;
        }
        return sb.toString();
    }

    private static String closepar(int x){
        StringBuilder sb = new StringBuilder();
        while(x > 0){
            sb.append(")");
            x--;
        }
        return sb.toString();
    }
}
