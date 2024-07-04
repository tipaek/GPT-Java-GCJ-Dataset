import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Solution{

     public static void main(String []args) {
         
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        for (int i=0; i<T; i++) {
            
            String S = input.next();
            int bc = 0;
            String out = "";
            
            for (int j=0; j<S.length(); j++) {
                int x = Integer.parseInt(String.valueOf(S.charAt(j)));
                if (x > bc) {
                    int diff = x - bc;
                    StringBuilder sb = new StringBuilder();
                    for(int k = 0; k < diff; k++){
                        sb.append("(");
                    }
                    bc = bc + diff;
                    out = out + sb.toString() + String.valueOf(x);
                    
                } else if (x < bc) {
                    int diff = bc - x;
                    StringBuilder sb = new StringBuilder();
                    for(int k = 0; k < diff; k++){
                        sb.append(")");
                    }
                    bc = bc - diff;
                    out = out + sb.toString() + String.valueOf(x);
                
                } else {
                    out = out + String.valueOf(x);
                }
            }
            
            if (bc != 0) {
                StringBuilder sb = new StringBuilder();
                    for(int k = 0; k < bc; k++){
                        sb.append(")");
                    }
                out = out + sb.toString();
            }
            
            System.out.println("Case #" + (i+1) + ": " + out);
            
        }
        
     }
}