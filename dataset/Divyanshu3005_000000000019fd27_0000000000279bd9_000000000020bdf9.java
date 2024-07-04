import java.io.*;
import java.util.*;

class Solution{
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int c = 1; c <= t; c++){
            int n = sc.nextInt();
            boolean flag = true;
            StringBuilder sb = new StringBuilder();
            HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(); 
            for(int i = 0; i < n; i++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                map.put(start, end);
            }
            int je = 0;
            int ce = 0;
            int js = 0;
            int cs = 0;
            for(Map.Entry m:map.entrySet()){  
                int start = (Integer)m.getKey();
                int end = (Integer)m.getValue();
                if((start < js && end < js) || start >= je){
                    js = start;
                    je = end;
                    sb.append('J');
                    continue;
                }else if((start < cs && end < cs) || start >= ce){
                    cs = start;
                    ce = end;
                    sb.append('C');
                    continue;
                }
                flag = false;
                //System.out.println("IMPOSSIBLE")
             }  //System.out.println(m.getKey()+" "+m.getValue());    
            
            if(flag)
                System.out.println("Case #" + c + ": " + sb.toString());
            else 
                System.out.println("Case #" + c + ": " + "IMPOSSIBLE");
            
        
        }
    }
    
    
}