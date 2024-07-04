import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner scn=new Scanner(System.in);
        int t=scn.nextInt();
        while(t-->0){
            String str=scn.nextLine();
            nestingDepth(str);
        }
    }
    static int count=1;
    public static void nestingDepth(String str){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<str.length();++i){
            char ch=str.charAt(i);
            int num=ch-'0';
            if(stack.empty()){
                int tnum1=num;
                int tnum2=num;
                while(tnum1-->0){
                    stack.push('(');
                }
                stack.push(ch);
                while(tnum2-->0){
                    stack.push(')');
                }
                while(!stack.empty()){
                    System.out.print(stack.pop());
                }
                System.out.println();
            }else{
                int tnum3=num;
                int tnum4=num;
                while(tnum3-->0&&stack.peek()==')'){
                    stack.pop();
                    
                }
                while(tnum3-->0){
                    stack.push('(');
                }
                stack.push(ch);
                while(tnum4-->0){
                    stack.push(')');
                }
                
                while(!stack.empty()){
                    System.out.print(stack.pop());
                }
                System.out.println();
                
            }
            
        }
         Stack<Character> stack2=new Stack<>();
            while(!stack.empty()){
                stack2.push(stack.pop());
            }
            System.out.print("Case #"+count+": ");
            while(!stack2.empty()){
                System.out.print(stack2.pop());
            }
            System.out.println();
            count++;
    }
}