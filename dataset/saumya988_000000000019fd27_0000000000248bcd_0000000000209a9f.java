import java.util.*;
import java.lang.Math;

class Solution{
    
    public static String balance(String s){
        int n = s.length();
        String str;
        Stack<Character> stack = new Stack<>();
        int same, parStack=0, num, diff;
        for(int i=0; i<n; i++){
            num = Integer.parseInt(String.valueOf(s.charAt(i)));
            if(num>parStack){
                diff = num - parStack;
                for(int j =0; j<diff; j++){
                    stack.push('(');
                }
                parStack += diff;
            }
            else if(num<parStack){
                diff = parStack - num;
                for(int j =0; j<diff; j++){
                    stack.push(')');
                }
                parStack -= diff;
            }
            stack.push(s.charAt(i));
        }
        for(int i=0; i<parStack; i++){
            stack.push(')');
        }
        str = "";
        for(int i=0; i<stack.size(); i++){
            str += String.valueOf(stack.get(i));
        }
        //System.out.println(str);
        return str;
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int cur_case = 1;
        String n, str;
        while(cur_case<=t){
            n = sc.next();
            //System.out.println(balance(n));
            System.out.println("Case #"+cur_case+": "+balance(n));
            cur_case++;
        }
    }
}