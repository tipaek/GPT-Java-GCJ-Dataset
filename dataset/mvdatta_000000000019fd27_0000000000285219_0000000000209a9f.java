import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        
        for(int i=1;i<=T;i++){
            System.out.println("Case #"+i+": "+nestingDepth(in.nextLine()));
        }
    }
    
    public static String nestingDepth(String s){
        return helper(new StringBuilder(),s,0,0);
    }
    
    public static String helper(StringBuilder sb,String s,int pos,int paren){
        if(pos >= s.length()){
            for(int i=0;i<paren;i++){
                sb.append(")");
            }
            return sb.toString();
        }
        
        char ch = s.charAt(pos);
        int d = ch - '0';
        if(paren > d){
            int remove = paren - d;
            for(int i=0;i<remove;i++){
                sb.append(")");
            }
        }else if(paren < d){
            int add = d - paren;
            for(int i=0;i<add;i++){
                sb.append("(");
            }
        }
        
        paren = d;
        sb.append(ch);
        
        return helper(sb,s,pos+1,paren);
    }
}