
import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(br.readLine());

        for(int x = 1; x <= cases; x++) {
            String s = br.readLine();
            StringBuilder b = new StringBuilder("");
            //b.append(s.charAt(0));
            // Init prev as zero
            int prev = 0;
            for(int i = 0; i < s.length(); i++) {
                int curr = Integer.parseInt(String.valueOf(s.charAt(i)));
            
            
                if(curr > prev) {
                    int diff = curr - prev;
                    for(int j = 0; j < diff; j++) {
                        b.append("(");
                    }
                
                } else if (curr < prev) {
                    int diff = prev - curr;
                    for(int j = 0; j < diff; j++) {
                        b.append(")");
                    }
                
                } 
                b.append(s.charAt(i));

                if (i == s.length() - 1) {
                    int diff = curr;
                    for(int j = 0; j < diff; j++) {
                        b.append(")");
                    }
                }

                prev = curr;
            }
            System.out.println("Case #" + x + ": " + b.toString());
        }

    }

    
}