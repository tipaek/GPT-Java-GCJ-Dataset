import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int ts = 0; ts < t; ts++) {
            String st = in.next();
            String out = "";
            int count = 0;
            
            for(int i = 0; i < st.length(); i++){
                int x = Integer.parseInt(String.valueOf(st.charAt(i)));
                
                if(x > count) {
                    int diff = x - count;
                    
                    for(int k = 0; k < diff; k++)
                        out += "(";
                        
                    out += String.valueOf(x);
                    count = x;
                }
                else if(x < count) {
                    int diff = count - x;
                    
                    for(int k = 0; k < diff; k++)
                        out += ")";
                        
                    out += String.valueOf(x);
                    count = x;
                }
                else {
                    out += String.valueOf(x);
                }
            }
            
            for (int k = 0; k < count; k++) {
                out += ")";
            }
            
            System.out.println("Case #" + (ts + 1) + ": " + (out));
        }
    }
}