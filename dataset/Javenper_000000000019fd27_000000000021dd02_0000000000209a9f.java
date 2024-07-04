import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int i = 0; i < t; i++){
            String line = sc.next();
            String answ = "";
            int depth = 0;
            
            for(int j = 0; j < line.length(); j++){
                int n = Character.digit(line.charAt(j), 10);
                
                if(n > depth){
                    depth = n - depth;
                    //System.out.println("n >: "+depth);
                    answ = open(answ,depth);
                    answ += Integer.toString(n);
                    depth = n;
                } else if(n < depth){
                    depth -= n;
                    answ = close(answ,depth);
                    answ += Integer.toString(n);
                    depth = n;
                } else {
                    answ  += Integer.toString(n);
                }
                
            }
            if(depth > 0)
                answ = close(answ,depth);
            System.out.println("Case #"+(i+1)+": "+answ);
        }
    }
    
    private static String open(String s, int n){
        for(int i = 0; i < n; i++){
            s += "(";
            
        }
        return s;
    }
    
    private static String close(String s, int n){
        for(int i = 0; i < n; i++){
            s += ")";
        }
        return s;
    }
}
