import java.util.*;
import java.util.ArrayList;
class Solution{
    
    public static void nestingDepth(String s, int t){
        ArrayList<Character> set = new ArrayList<Character>();
        
        
        int count = Character.getNumericValue(s.charAt(0));
        while(count > 0){
            set.add('(');
        }
        set.add(s.charAt(0));
        
        for(int i=1;i<s.length();i++){
            int prev = s.charAt(i-1) - '0';
            int curr = s.charAt(i) - '0';
            
            if(prev < curr){
                count = curr - prev;
                while(count > 0){
                    set.add('(');
                }
                set.add(s.charAt(i));
            }
            
            else if(prev > curr){
                count = prev - curr;
                while(count > 0){
                    set.add(')');
                }
                set.add(s.charAt(i));
            }
            
            else
                set.add(s.charAt(i));
        }
        
        System.out.print("Case #" + t +": ");
        for(int i=0;i<set.size();i++)
            System.out.print(set.get(i));
        
    }
    
    public static void main(String args[]) throws Exception{
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int t=1;t<=T;t++){
            String s = scan.next();
            nestingDepth(s,t);
            System.out.println();
        }
    }
}