import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Solution{

     public static void main(String []args) {
         
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        for (int i=0; i<T; i++) {
            
            Map<Integer,Integer> p = new TreeMap<Integer,Integer>();
            int A = input.nextInt();
            String out = "";
            int ct = 0;
            int jt = 0;
            
            for (int j=0; j<A; j++) {
                int x = input.nextInt();
                int y = input.nextInt();
                p.put(x,y);
            }
            
            for (Map.Entry<Integer, Integer> entry : p.entrySet()) {
                // System.out.println("Key = " + entry.getKey() +  ", Value = " + entry.getValue()); 
                if (entry.getKey() >= ct) {
                    ct = entry.getValue();
                    out = out + "C";
                } else if (entry.getKey() >= jt) {
                    jt = entry.getValue();
                    out = out + "J";
                } else {
                    out = "IMPOSSIBLE";
                    break;
                }
            }
           
   
            System.out.println("Case #" + (i+1) + ": " + out);
            
        }
        
     }
}