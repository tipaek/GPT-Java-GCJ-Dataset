import java.util.*;
public class Solution{

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int k = 1; k<=t; k++){
            String str = sc.next();
            System.out.println("Case #"+ k + ": " + nestString(str));
        }
        
    }
 
    public static String nestString(String str){
        
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack();
        int size = 0;
        for(char ch : str.toCharArray()){
            int x = ch - '0';
            if(x==size){
                sb.append(x);
            }
            else if(x<size){
                while(size!=x){
                    sb.append(stack.pop());
                    size--;
                }
                sb.append(x);
            }
            else{
                while(size!=x){
                    sb.append('(');
                    stack.push(')');
                    size++;
                }
                sb.append(x);
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
        
    }
    
}