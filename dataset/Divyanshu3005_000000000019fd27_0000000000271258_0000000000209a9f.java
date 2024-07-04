import java.io.*;
import java.util.*;

class Solution{
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int c = 1; c <= t; c++){
            String str = sc.next();
            //System.out.println(str);
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for(int i = 0; i < str.length(); i++){
                int val = Integer.parseInt(Character.toString(str.charAt(i)));
                //System.out.println(val);
                if(i == 0){
                    count += val;
                    sb = build(sb, count, '(');
                } else {
                    
                    int x = val - count;
                    if(x > 0){
                        count += x;
                        sb = build(sb, x, '(');
                    } else {
                        count -= Math.abs(x);
                        sb = build(sb, Math.abs(x), ')');
                        //System.out.println(count);
                    }
                    
                    //sb = build(sb, count, '(');
                    
                }
                
                sb.append(str.charAt(i));
                
            }
            
            sb = build(sb, count, ')');
            System.out.println("Case #" + c + ": " + sb.toString());
            
        
        }
    }
    
    public static StringBuilder build(StringBuilder sb, int count, char ch){
       
        while(count-->0){
            sb.append(ch);
        }
        
        return sb;
        
    }
}