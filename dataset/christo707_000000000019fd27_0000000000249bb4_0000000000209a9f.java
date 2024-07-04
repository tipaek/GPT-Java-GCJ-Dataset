import java.io.*; 
import java.util.*; 
  
public class Solution {

    public static void main(String arg[]){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 1; i <= t; i++){
            String input = scanner.next();
            Stack<Character> stack = new Stack<Character>();
            Stack<Character> temp = new Stack<Character>();
            int depth = 0;
            for(int l = 0 ; l < input.length(); l++){
                Character a = input.charAt(l);
                int ab = Character.getNumericValue(a);
                if(ab > depth){
                   
                    for(int k = 0; k < (ab - depth); k++){
                        stack.push('(');
                    }
                    
                    stack.push(a);
                    
                    for(int k = 0; k < (ab - depth); k++){
                        stack.push(')');
                    }
                    
                    
                } else {
                    
                    for(int k = 0; k < ab; k++){
                        stack.pop();
                    }
                    
                    stack.push(a);
                    
                    for(int k = 0; k < ab; k++){
                        stack.push(')');
                    }
                    
                }
                depth = ab;
            }
            Object arr[] = stack.toArray();
            System.out.print("Case #" + i + ": ");
            for(Object a : arr){
                System.out.print(a);
            }
            System.out.println();
        }
        
        
        
    }

} 