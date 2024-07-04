import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Solution{

     public static void main(String []args) {
         
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        for (int i=0; i<T; i++) {
            
            // Map<Integer,Integer> p = new TreeMap<Integer,Integer>();
            Map<Integer,Integer> p = new LinkedHashMap<Integer,Integer>();
            Map<String,String> po = new LinkedHashMap<String,String>();
                        
            int A = input.nextInt();
            String out = "";
            // int ct = 0;
            // int jt = 0;
            int cs = 0, ce = 0, js = 0, je = 0;
            
            for (int j=0; j<A; j++) {
                int x = input.nextInt();
                int y = input.nextInt();
                p.put(x,y);
                // po.put(String.valueOf(x) + String.valueOf(y),"");
            }
            
            for (Map.Entry<Integer, Integer> entry : p.entrySet()) {
                
                int ts = entry.getKey();
                int te = entry.getValue();
                
                if (ts >= ce || te <= cs) {
                    //C can do it
                    out = out + "C";
                    cs = ts;
                    ce = te;
               
                } else if (ts >= je || te <= js) {
                    //J can do it
                    out = out + "J";
                    js = ts;
                    je = te;
                    
                } else {
                    //Impossible
                     out = "IMPOSSIBLE";
                    break;
                }
                
            }
            
            System.out.println("Case #" + (i+1) + ": " + out);
            
            
            
            
            // for (Map.Entry<Integer, Integer> entry : p.entrySet()) {
            //     // System.out.println("Key = " + entry.getKey() +  ", Value = " + entry.getValue()); 
            //     if (entry.getKey() >= ct) {
            //         ct = entry.getValue();
            //         po.replace(String.valueOf(entry.getKey()) + String.valueOf(entry.getValue()), "C");
            //         out = out + "C";
            //     } else if (entry.getKey() >= jt) {
            //         jt = entry.getValue();
            //         po.replace(String.valueOf(entry.getKey()) + String.valueOf(entry.getValue()), "J");
            //         out = out + "J";
            //     } else {
            //         out = "IMPOSSIBLE";
            //         break;
            //     }
            // }
           
            // if (out == "IMPOSSIBLE") {
            //     System.out.println("Case #" + (i+1) + ": " + out);
            // } else {
            //      String op = "";
            //     for (Map.Entry<String, String> entry : po.entrySet()) {
            //       op = op + entry.getValue();
            //     }
            //     System.out.println("Case #" + (i+1) + ": " + op);
            // }
            
        }
        
     }
}