import java.util.*;
class Solution{
public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t=sc.nextInt();
    for(int in=0;in<t;in++){
        Stack<Character>stack = new Stack();
        String s=sc.next();
        String res="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int v = Character.getNumericValue(c);
            if(i==0){
                if(v>0&&v<=9){
                    int x=v;
                    while(x!=0){
                        res+="(";
                        stack.push(')');
                        x--;
                    }
                    res+=c;
                }
            }
            else{
                int v1=Character.getNumericValue(s.charAt(i-1));
                if(v<v1){
                    int x=v1-v;
                    while(x>0){
                        res+=stack.pop();
                        x--;
                    }
                    res+=c;
                }
                else if(v>v1){
                    int x=v-v1;
                    while(x>0){
                        res+="(";
                        stack.push(')');
                        x--;
                    }
                    res+=c;
                }
                else{
                    res+=c;
                }
            }
        }
        while(stack.size()!=0){
            res+=stack.pop();
        }
    
        System.out.println("Case #"+(in+1)+": "+res);
    }
}
}